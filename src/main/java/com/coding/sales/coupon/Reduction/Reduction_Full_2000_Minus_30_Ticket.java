 package com.coding.sales.coupon.Reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.ReductionBase;
import com.coding.sales.coupon.action.IReduction;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Reduction_Full_2000_Minus_30_Ticket extends ReductionBase implements IReduction {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        BigDecimal totalPrice = metalProduct.getUnit().getPrice().multiply(new BigDecimal(metalProductNum));
        if(totalPrice.compareTo(new BigDecimal("2000")) >= 0) {
            return new BigDecimal("30");
        }
        return new BigDecimal("0");
        
    }

}
