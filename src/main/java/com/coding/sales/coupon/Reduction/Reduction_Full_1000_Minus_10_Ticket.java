 package com.coding.sales.coupon.Reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.Coupon;
import com.coding.sales.coupon.action.ICoupon;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Reduction_Full_1000_Minus_10_Ticket extends Coupon implements ICoupon {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        BigDecimal totalPrice = metalProduct.getUnit().getPrice().multiply(new BigDecimal(metalProductNum));
        if(totalPrice.compareTo(new BigDecimal("1000")) >= 0) {
            return new BigDecimal("10");
        }
        return new BigDecimal("0");
        
    }

}
