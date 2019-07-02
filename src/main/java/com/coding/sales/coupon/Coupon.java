 package com.coding.sales.coupon;

import java.math.BigDecimal;

import com.coding.sales.coupon.action.ICoupon;
import com.coding.sales.metal.MetalProduct;

/**
 * @author hy
 * @date 2019/07/02
 */
public abstract class Coupon implements ICoupon{
    String cardname ;
    public abstract BigDecimal coupon(MetalProduct metalProduct, int metalProductNum);
    public BigDecimal execuCoupon(MetalProduct metalProduct, int metalProductNum) {
        checkCouponQualification(metalProduct);
        return coupon(metalProduct,metalProductNum);
    }
    private void checkCouponQualification(MetalProduct metalProduct) {
        for(String couponCardName:metalProduct.getAllowsDiscountTickets()) {
            if(!this.getCardname().equals(couponCardName)){
                throw new RuntimeException("["+metalProduct.getProductName()+"]商品不支持此打折卷"+this.cardname);
            }
        }
    }
    public String getCardname() {
        return cardname;
    }
    public void setCardname(String cardname) {
        this.cardname = cardname;
    }
    
}
