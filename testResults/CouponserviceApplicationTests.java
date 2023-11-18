package com.springcloud.couponmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcloud.couponmicroservice.controller.CouponRestController;
import com.springcloud.couponmicroservice.model.Coupon;
import com.springcloud.couponmicroservice.repository.CouponRepository;

@SpringBootTest
class CouponserviceApplicationTests {
	
	private static final String SUPERSALE = "SUPERSALE";

	@Mock
	private CouponRepository repository;

	@InjectMocks
	private CouponRestController couponRestController;

	@Test
	public void testCreate() {
		Coupon coupon = new Coupon();
		coupon.setCode(SUPERSALE);
		when(repository.save(coupon)).thenReturn(coupon);
		Coupon createCoupon = couponRestController.createCoupon(coupon);
		verify(repository).save(coupon);
		assertNotNull(createCoupon);
		assertEquals(SUPERSALE, coupon.getCode());
		
	}
	
	public void whenCouponIsNullThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {couponRestController.createCoupon(null);});
				
	}
	@Test
	public void testGetCoupon() {
		
		Coupon coupon = new Coupon();
		coupon.setId(123l);
		coupon.setCode(SUPERSALE);
		coupon.setDiscount(new BigDecimal(10));
		when(repository.findByCode(SUPERSALE)).thenReturn(coupon);
		Coupon couponResponse = couponRestController.getCoupon(SUPERSALE);
		
		verify(repository).findByCode(SUPERSALE);
		assertNotNull(couponResponse);
		assertEquals(new BigDecimal(10),couponResponse.getDiscount());
	}

}
