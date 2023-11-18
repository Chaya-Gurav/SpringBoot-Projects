package com.springcloud.couponmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.couponmicroservice.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{

	Coupon findByCode(String code);

}
