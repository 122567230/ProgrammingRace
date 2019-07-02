 package com.coding.sales.coupon.reduction;

import java.math.BigDecimal;

import com.coding.sales.coupon.ReductionBase;
import com.coding.sales.coupon.action.IReduction;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public class ReductionFoulFreeTicket extends ReductionBase implements IReduction {

    @Override
    public BigDecimal coupon(MetalProduct metalProduct, int metalProductNum) {
        if(metalProductNum >= 4) {
            return metalProduct.getUnit().getPrice();
        }
        return new BigDecimal("0");
    }

}
