 package com.coding.sales.coupon.Reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.Coupon;
import com.coding.sales.coupon.action.ICoupon;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Reduction_Foul_Free_Ticket extends Coupon implements ICoupon {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        if(metalProductNum >= 4) {
            return metalProduct.getUnit().getPrice();
        }
        return new BigDecimal("0");
    }

}
