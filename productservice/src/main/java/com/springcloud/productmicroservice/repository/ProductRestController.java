package com.springcloud.productmicroservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.productmicroservice.dto.Coupon;
import com.springcloud.productmicroservice.model.Product;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponsservice.url}")
	private String couponsserviceURL;
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product){
		Coupon coupon = restTemplate.getForObject(couponsserviceURL+product.getCouponCode(),Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repository.save(product);
	}
	
	
}
