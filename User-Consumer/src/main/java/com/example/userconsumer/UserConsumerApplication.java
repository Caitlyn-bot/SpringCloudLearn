package com.example.userconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 张志伟
 */
@SpringBootApplication
@EnableFeignClients
public class UserConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApplication.class, args);
	}

}
