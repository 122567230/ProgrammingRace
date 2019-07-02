 package com.coding.sales.coupon.action;

import java.math.BigDecimal;

import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public interface IReduction {
    public BigDecimal execuCoupon(MetalProduct metalProduct, int metalProductNum) ;
    public BigDecimal getPreferentialAmount();
}
