 package com.coding.sales.coupon.reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.ReductionBase;
import com.coding.sales.coupon.action.IReduction;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class Reduction_Third_Half_Ticket extends ReductionBase implements IReduction {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        if(metalProductNum >= 3) {
            BigDecimal radio = new BigDecimal("0.5");
            return metalProduct.getUnit().getPrice().multiply(radio).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        }
        return new BigDecimal("0");
        
    }

}
