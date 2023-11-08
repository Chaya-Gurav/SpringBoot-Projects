package com.springboot.onetoone.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.onetoone.entity.User;
import com.springboot.onetoone.entity.UserProfile;
import com.springboot.onetoone.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories("com.springboot.onetoone.repository")
@EntityScan("com.springboot.onetoone.entity")
public class SpringBootOneToOneMappingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToOneMappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setName("Chaya");
		user.setEmail("chaya@gmail.com");
		
		UserProfile up = new UserProfile();
		up.setAddress("Bangalore");
		up.setGender("F");
		up.setPhoneNumber("1234567890");
		
		user.setUserProfile(up);
		up.setUser(user);
		
		userRepository.save(user);
	}
}
