 package com.coding.sales.coupon.discount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.coding.sales.coupon.DiscountBase;
import com.coding.sales.coupon.action.IDiscount;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class DiscountTicket extends DiscountBase implements IDiscount{

    private static final String NINETY_FIVE_FOLDS_TICKET = "95折券";
    private static final String NINE_FOLDS_TICKET = "9折券";
    private BigDecimal ratio;
    public static Map<String,IDiscount> discountTickets = new HashMap<String,IDiscount>();
    static {
        discountTickets.put(NINE_FOLDS_TICKET, new DiscountTicket(NINE_FOLDS_TICKET,new BigDecimal("0.90")));
        discountTickets.put(NINETY_FIVE_FOLDS_TICKET, new DiscountTicket(NINETY_FIVE_FOLDS_TICKET,new BigDecimal("0.95")));
    }
    public DiscountTicket() {
        
    }
    public DiscountTicket(String cardname,BigDecimal ratio) {
        this.ratio = ratio;
        super.setCardname(cardname);
    }
    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        BigDecimal totalPrice = metalProduct.getUnit().getPrice().multiply(new BigDecimal(metalProductNum));
        return totalPrice.multiply(this.ratio).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

}
