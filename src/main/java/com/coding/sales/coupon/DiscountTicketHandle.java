// package com.coding.sales.coupon;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.coding.sales.coupon.Reduction.Reduction_Foul_Free_Ticket;
//import com.coding.sales.coupon.Reduction.Reduction_Full_1000_Minus_10_Ticket;
//import com.coding.sales.coupon.Reduction.Reduction_Full_2000_Minus_30_Ticket;
//import com.coding.sales.coupon.Reduction.Reduction_Full_3000_Minus_350_Ticket;
//import com.coding.sales.coupon.Reduction.Reduction_Third_Half_Ticket;
//import com.coding.sales.coupon.action.ICoupon;
//import com.coding.sales.coupon.discount.DiscountTicket;
//import com.coding.sales.metal.MetalProduct;
//
///**
// * @author hy
// * @date 2019/07/02
// */
//public class DiscountTicketHandle {
//
//    private static final String NINETY_FIVE_FOLDS_TICKET = "95折券";
//    private static final String NINE_FOLDS_TICKET = "9折券";
//    public static Map<String,Coupon> discountTickets = new HashMap<String,Coupon>();
//    static {
//        discountTickets.put(NINE_FOLDS_TICKET, new DiscountTicket());
//        discountTickets.put(NINETY_FIVE_FOLDS_TICKET, new DiscountTicket());
//    }
//    
////    public static BigDecimal handelPrivilege(MetalProduct metalProduct, int metalProductNum) {
////        List<String> reductionTicketList = metalProduct.getAllowsReductionTickets();
////        BigDecimal preferentialAmount = BigDecimal.ZERO;
////        for(String ticketName:reductionTicketList) {
////            BigDecimal preferentialAmountTemp = reductionTickets.get(ticketName).coupon(metalProduct, metalProductNum);
////            if(preferentialAmount.compareTo(preferentialAmountTemp) < 0) {
////                preferentialAmount = preferentialAmountTemp;
////                //UNDO 设置使用的优惠
////            }
////        }
////        return preferentialAmount;
////    }
//
//}
