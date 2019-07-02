package com.coding.sales;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coding.sales.coupon.ReductionTicketHandle;
import com.coding.sales.coupon.action.IDiscount;
import com.coding.sales.coupon.discount.DiscountTicket;
import com.coding.sales.domain.Member;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.metal.MetalProduct;
import com.coding.sales.metal.MetalUnit;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);
        
        return result.toString();
    }

    OrderRepresentation checkout(OrderCommand command) {
        OrderRepresentation result = null;
        //打折卷
        List<String> discounts = command.getDiscounts();
        //计算订单总金额
        BigDecimal totalPrice = BigDecimal.ZERO;
        //应收金额
        BigDecimal receivables = BigDecimal.ZERO;
        //优惠合计
        BigDecimal totalDiscountPrice = BigDecimal.ZERO;
        MetalProduct metalProduct;
        OrderItemRepresentation orderItemRepresentation;
        Member member = Member.members.get(command.getMemberId());
        List<OrderItemRepresentation> orderItemRepresentationList = new ArrayList<OrderItemRepresentation>();
        List<DiscountItemRepresentation> discountItemRepresentations = new ArrayList<DiscountItemRepresentation>(); 
        List<String> discountCards = new ArrayList<String>();
        for(OrderItemCommand itemCommand:command.getItems()) {
            metalProduct = MetalProduct.metalProducts.get(itemCommand.getProduct());
            MetalUnit metalUnit = metalProduct.getUnit();
            BigDecimal metalTotalAmount = metalUnit.getPrice().multiply(itemCommand.getAmount());
            totalPrice = totalPrice.add(metalTotalAmount);
            handleDiscount(metalProduct,itemCommand,discounts);
            handleReduction(metalProduct, itemCommand);
            if(isHasPreferential(metalProduct)) {
                totalDiscountPrice = preferentialActivities(totalDiscountPrice, metalProduct,
                    discountItemRepresentations, discountCards);
            }
            orderItemRepresentation = new OrderItemRepresentation(metalProduct.getProductNo(), metalProduct.getProductName(),
                metalUnit.getPrice(), itemCommand.getAmount(), metalTotalAmount);
            orderItemRepresentationList.add(orderItemRepresentation);
        }
        receivables = totalPrice.subtract(totalDiscountPrice);
        //处理会员信息
        member.getMemberCard().increasePoint(receivables.setScale(0, BigDecimal.ROUND_HALF_DOWN).intValue());
        SimpleDateFormat dateFromate = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        List<PaymentRepresentation> payments = new ArrayList<PaymentRepresentation>();
        PaymentRepresentation paymentRepresentation = null;
        for(PaymentCommand paymentCommand:command.getPayments()) {
            paymentRepresentation = new PaymentRepresentation(paymentCommand.getType(),paymentCommand.getAmount());
            payments.add(paymentRepresentation);
        }
        Date createTime = null;
        try {
            createTime = dateFromate.parse(command.getCreateTime());
        } catch (ParseException e) {
             e.printStackTrace();
        }
        result = new OrderRepresentation(command.getOrderId(),
            createTime,
            command.getMemberId(),
            member.getName(),
            member.getMemberCard().getOldMemberLevel().getLevelName(),
            member.getMemberCard().getMemberLevel().getLevelName(),
            member.getMemberCard().getPoint()-member.getMemberCard().getOldPoint(),
            member.getMemberCard().getPoint(),
            orderItemRepresentationList,
            totalPrice,
            discountItemRepresentations,
            totalDiscountPrice,
            receivables,
            payments,
            discountCards);
        return result;
    }

    private boolean isHasPreferential(MetalProduct metalProduct) {
        return metalProduct.getUsedDiscountTickets() != null || metalProduct.getUsedReductionTickets() != null;
    }

    private BigDecimal preferentialActivities(BigDecimal totalDiscountPrice, MetalProduct metalProduct,
        List<DiscountItemRepresentation> discountItemRepresentations, List<String> discountCards) {
        String discountStr = "";
        DiscountItemRepresentation discountItemRepresentation;
        BigDecimal preferentialAmount = BigDecimal.ZERO;
        BigDecimal discountPreferentialAmount;
        BigDecimal reductionPreferentialAmount;
        if(metalProduct.getUsedDiscountTickets() != null && metalProduct.getUsedReductionTickets() != null) {
            discountPreferentialAmount = metalProduct.getUsedDiscountTickets().getPreferentialAmount();
            reductionPreferentialAmount = metalProduct.getUsedReductionTickets().getPreferentialAmount();
            if(discountPreferentialAmount.compareTo(reductionPreferentialAmount) >= 0) {
                metalProduct.setUsedReductionTickets(null);
                discountStr = metalProduct.getUsedDiscountTickets().getCardname();
                preferentialAmount = discountPreferentialAmount;
            }else {
                preferentialAmount = reductionPreferentialAmount;
            }
        }else{
            if(metalProduct.getUsedDiscountTickets() != null) {
                preferentialAmount = metalProduct.getUsedDiscountTickets().getPreferentialAmount();
                discountStr = metalProduct.getUsedDiscountTickets().getCardname();
            }else {
                preferentialAmount = metalProduct.getUsedReductionTickets().getPreferentialAmount();
            }
        }
        if(!"".equals(discountStr)) {
            discountCards.add(discountStr);
        }
        totalDiscountPrice = totalDiscountPrice.add(preferentialAmount);
        discountItemRepresentation = new DiscountItemRepresentation(metalProduct.getProductNo(), metalProduct.getProductName(),preferentialAmount);
        discountItemRepresentations.add(discountItemRepresentation);
        return totalDiscountPrice;
    }
    
    private void handleReduction(MetalProduct metalProduct, OrderItemCommand itemCommand) {
        ReductionTicketHandle.handelPrivilege(metalProduct, itemCommand.getAmount().intValue());
    }

    public void handleDiscount(MetalProduct metalProduct,OrderItemCommand itemCommand,List<String> discounts) {
        for(String discountStr:discounts) {
            if(metalProduct.getAllowsDiscountTickets().contains(discountStr)) {
                IDiscount discount = DiscountTicket.discountTickets.get(discountStr);
                discount.execuCoupon(metalProduct, itemCommand.getAmount().intValue());
                break;
            }
        }
    }
}
