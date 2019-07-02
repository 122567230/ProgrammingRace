package com.coding.sales.coupon.discount;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.coding.sales.coupon.action.IDiscount;
import com.coding.sales.metal.MetalProduct;

public class DiscountTicketTest {

	@Test
	public void should_return_9_discount_metal_product_price_when_product_has_9_discount_ticket() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P001002);
		DiscountTicket discountTicket=new DiscountTicket("9折券", new BigDecimal("0.90"));
		
		BigDecimal coupon = discountTicket.coupon(metalProduct, 1);
		
	    assertEquals(metalProduct.getUnit().getPrice().multiply(new BigDecimal("0.1")).setScale(2,BigDecimal.ROUND_HALF_DOWN),coupon);

	}
	@Test
	public void should_return_95_discount_metal_product_price_when_product_has_95_discount_ticket() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P003001);
		DiscountTicket discountTicket=new DiscountTicket("95折券", new BigDecimal("0.95"));
		
		BigDecimal coupon = discountTicket.coupon(metalProduct, 1);
		
		assertEquals(metalProduct.getUnit().getPrice().multiply(new BigDecimal("0.05")).setScale(2,BigDecimal.ROUND_HALF_DOWN),coupon);
		
	}
}
