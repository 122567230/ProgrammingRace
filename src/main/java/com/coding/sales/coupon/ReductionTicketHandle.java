 package com.coding.sales.coupon;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.sales.coupon.Reduction.Reduction_Foul_Free_Ticket;
import com.coding.sales.coupon.Reduction.Reduction_Full_1000_Minus_10_Ticket;
import com.coding.sales.coupon.Reduction.Reduction_Full_2000_Minus_30_Ticket;
import com.coding.sales.coupon.Reduction.Reduction_Full_3000_Minus_350_Ticket;
import com.coding.sales.coupon.Reduction.Reduction_Third_Half_Ticket;
import com.coding.sales.coupon.action.IReduction;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class ReductionTicketHandle {

    private static final String REDUCTION_FOUL_FREE_TICKET ="满3送1";
    private static final String REDUCTION_THIRD_HALF_TICKET ="第3件半价";
    private static final String REDUCTION_FULL_3000_MINUS_350_TICKET ="每满3000元减350";
    private static final String REDUCTION_FULL_2000_MINUS_30_TICKET ="每满2000元减30";
    private static final String REDUCTION_FULL_1000_MINUS_10_TICKET ="每满1000元减10";
    public static Map<String,IReduction> reductionTickets = new HashMap<String,IReduction>();
    static {
        reductionTickets.put(REDUCTION_FOUL_FREE_TICKET, new Reduction_Foul_Free_Ticket());
        reductionTickets.put(REDUCTION_THIRD_HALF_TICKET, new Reduction_Third_Half_Ticket());
        reductionTickets.put(REDUCTION_FULL_3000_MINUS_350_TICKET, new Reduction_Full_3000_Minus_350_Ticket());
        reductionTickets.put(REDUCTION_FULL_2000_MINUS_30_TICKET, new Reduction_Full_2000_Minus_30_Ticket());
        reductionTickets.put(REDUCTION_FULL_1000_MINUS_10_TICKET, new Reduction_Full_1000_Minus_10_Ticket());
    }
    
    public static BigDecimal handelPrivilege(MetalProduct metalProduct, int metalProductNum) {
        List<String> reductionTicketList = metalProduct.getAllowsReductionTickets();
        BigDecimal preferentialAmount = BigDecimal.ZERO;
        for(String ticketName:reductionTicketList) {
            IReduction reduction = reductionTickets.get(ticketName);
            BigDecimal preferentialAmountTemp = reduction.execuCoupon(metalProduct, metalProductNum);
            if(preferentialAmount.compareTo(preferentialAmountTemp) < 0) {
                metalProduct.setUsedReductionTickets(reduction);
            }
        }
        return preferentialAmount;
    }

}
