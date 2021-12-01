package com.ssadhukhanv2.thymeleafpoc;

import com.ssadhukhanv2.thymeleafpoc.model.User;
import com.ssadhukhanv2.thymeleafpoc.repositories.NodeRepository;
import com.ssadhukhanv2.thymeleafpoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ThymeleafPocApplication implements CommandLineRunner {


	@Autowired
	UserRepository userRepository;

	@Autowired
	NodeRepository nodeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafPocApplication.class, args);
	}


	@Transactional
	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setUserEmail("ssadhukhanv2.0@gmail.com");
		user.setUserName("ssadhukhanv2");
		user.setUserPassword("ssadhukhanv2");
		userRepository.save(user);
	}
}
