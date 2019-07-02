 package com.coding.sales.coupon.Reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.Coupon;
import com.coding.sales.coupon.action.ICoupon;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Reduction_Full_3000_Minus_350_Ticket extends Coupon implements ICoupon {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        BigDecimal totalPrice = metalProduct.getUnit().getPrice().multiply(new BigDecimal(metalProductNum));
        if(totalPrice.compareTo(new BigDecimal("3000")) >= 0) {
            return new BigDecimal("350");
        }
        return new BigDecimal("0");
        
    }

}
