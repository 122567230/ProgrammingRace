package com.coding.sales.coupon.reduction;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.coding.sales.coupon.reduction.ReductionFoulFreeTicket;
import com.coding.sales.coupon.reduction.ReductionFullOneThousandMinusTenTicket;
import com.coding.sales.coupon.reduction.ReductionFullThreeThousandMinusThreeHundredFiftyTicket;
import com.coding.sales.coupon.reduction.ReductionFullTwoThousandMinusThirtyTicket;
import com.coding.sales.coupon.reduction.Reduction_Third_Half_Ticket;
import com.coding.sales.metal.MetalProduct;

public class ReductionTicketTest {


	@Test
	public void should_return_metal_product_price_when_purchase_more_than_4_uinit() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002001);
		ReductionFoulFreeTicket reduction_Foul_Free_Ticket=new ReductionFoulFreeTicket();
		
		BigDecimal coupon = reduction_Foul_Free_Ticket.coupon(metalProduct, 4);
		
	    assertEquals(metalProduct.getUnit().getPrice(),coupon);

	}
	
	@Test
	public void should_return_half_metal_product_price_when_purchase_more_than_3_uinit() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002001);
		Reduction_Third_Half_Ticket reduction_Third_Half_Ticket=new Reduction_Third_Half_Ticket();
		
		BigDecimal coupon = reduction_Third_Half_Ticket.coupon(metalProduct, 3);
		 BigDecimal radio = new BigDecimal("0.5");
		 BigDecimal expectCoupon = metalProduct.getUnit().getPrice().multiply(radio).setScale(2, BigDecimal.ROUND_HALF_DOWN);
	    assertEquals(expectCoupon,coupon);

	}
	
	@Test
	public void should_return_10_when_purchase_more_than_1000_yuan() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002002);
		ReductionFullOneThousandMinusTenTicket reduction_Full_1000_Minus_10_Ticket=new ReductionFullOneThousandMinusTenTicket();
		
		BigDecimal coupon = reduction_Full_1000_Minus_10_Ticket.coupon(metalProduct, 2);
		
	    assertEquals(new BigDecimal(10),coupon);

	}
	
	@Test
	public void should_return_30_when_purchase_more_than_2000_yuan() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002002);
		ReductionFullTwoThousandMinusThirtyTicket reduction_Full_2000_Minus_30_Ticket=new ReductionFullTwoThousandMinusThirtyTicket();
		
		BigDecimal coupon = reduction_Full_2000_Minus_30_Ticket.coupon(metalProduct, 5);
		
	    assertEquals(new BigDecimal(30),coupon);

	}
	
	@Test
	public void should_return_350_when_purchase_more_than_3000_yuan() {
		
		MetalProduct metalProduct=MetalProduct.metalProducts.get(MetalProduct.P002002);
		ReductionFullThreeThousandMinusThreeHundredFiftyTicket reduction_Full_3000_Minus_350_Ticket=new ReductionFullThreeThousandMinusThreeHundredFiftyTicket();
		
		BigDecimal coupon = reduction_Full_3000_Minus_350_Ticket.coupon(metalProduct, 5);
		
		assertEquals(new BigDecimal(350),coupon);
		
	}
	
	
}
