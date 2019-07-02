 package com.coding.sales.coupon.action;

import java.math.BigDecimal;

import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public interface ICoupon {
    public BigDecimal execuCoupon(MetalProduct metalProduct, int metalProductNum) ;
}
