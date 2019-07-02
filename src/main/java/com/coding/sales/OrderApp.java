package com.coding.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.coding.sales.coupon.ReductionTicketHandle;
import com.coding.sales.coupon.action.IDiscount;
import com.coding.sales.coupon.discount.DiscountTicket;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.metal.MetalProduct;
import com.coding.sales.metal.MetalUnit;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;

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
        BigDecimal totalAmount = BigDecimal.ZERO;
        MetalProduct metalProduct;
        OrderItemRepresentation orderItemRepresentation;
        List<OrderItemRepresentation> orderItemRepresentationList = new ArrayList<OrderItemRepresentation>();
        for(OrderItemCommand itemCommand:command.getItems()) {
            metalProduct = MetalProduct.metalProducts.get(itemCommand.getProduct());
            MetalUnit metalUnit = metalProduct.getUnit();
            BigDecimal metalTotalAmount = metalUnit.getPrice().multiply(itemCommand.getAmount());
            totalAmount = totalAmount.add(metalTotalAmount);
            orderItemRepresentation = new OrderItemRepresentation(metalProduct.getProductNo(), metalProduct.getProductName(),
                metalUnit.getPrice(), itemCommand.getAmount(), metalTotalAmount);
            //进行打折卷处理
            for(String discountStr:discounts) {
                if(metalProduct.getAllowsDiscountTickets().contains(discountStr)) {
                    IDiscount discount = DiscountTicket.discountTickets.get(discountStr);
                    discount.execuCoupon(metalProduct, itemCommand.getAmount().intValue());
                    break;
                }
            }
            
            //进行满减卷处理
            ReductionTicketHandle.handelPrivilege(metalProduct, itemCommand.getAmount().intValue());
            
            //当前产品使用的打折卷和满减卷只能使用一个
            if(metalProduct.getUsedDiscountTickets() != null && metalProduct.getUsedReductionTickets() != null) {
                BigDecimal discountPreferentialAmount = metalProduct.getUsedDiscountTickets().getPreferentialAmount();
                BigDecimal reductionPreferentialAmount = metalProduct.getUsedReductionTickets().getPreferentialAmount();
                if(discountPreferentialAmount.compareTo(reductionPreferentialAmount) >= 0) {
                    metalProduct.setUsedReductionTickets(null);
                }
            }
            
            
        }
        //处理会员信息
        
        //TODO: 请完成需求指定的功能
//        result = OrderRepresentation(command.getOrderId(),command.getCreateTime(),command.);
        return result;
    }
}
