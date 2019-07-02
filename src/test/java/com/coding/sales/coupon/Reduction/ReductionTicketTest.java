package com.coding.sales.coupon.Reduction;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.coding.sales.metal.MetalProduct;

public class ReductionTicketTest {


	@Test
	public void should_return_metal_product_price_when_purchase_more_than_4_uinit() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002001);
		Reduction_Foul_Free_Ticket reduction_Foul_Free_Ticket=new Reduction_Foul_Free_Ticket();
		
		BigDecimal coupon = reduction_Foul_Free_Ticket.coupon(metalProduct, 4);
		
	    assertEquals(metalProduct.getUnit().getPrice(),coupon);

	}
	
	@Test
	public void should_return_10_when_purchase_more_than_1000_yuan() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002002);
		Reduction_Full_1000_Minus_10_Ticket reduction_Full_1000_Minus_10_Ticket=new Reduction_Full_1000_Minus_10_Ticket();
		
		BigDecimal coupon = reduction_Full_1000_Minus_10_Ticket.coupon(metalProduct, 2);
		
	    assertEquals(new BigDecimal(10),coupon);

	}
}
