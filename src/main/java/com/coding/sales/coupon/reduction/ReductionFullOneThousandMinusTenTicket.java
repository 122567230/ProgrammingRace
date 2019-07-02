 package com.coding.sales.coupon.reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.ReductionBase;
import com.coding.sales.coupon.action.IReduction;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class ReductionFullOneThousandMinusTenTicket extends ReductionBase implements IReduction {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        BigDecimal totalPrice = metalProduct.getUnit().getPrice().multiply(new BigDecimal(metalProductNum));
        if(totalPrice.compareTo(new BigDecimal("1000")) >= 0) {
            return new BigDecimal("10");
        }
        return new BigDecimal("0");
        
    }

}
