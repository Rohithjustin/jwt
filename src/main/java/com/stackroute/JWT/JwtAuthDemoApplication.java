package com.stackroute.JWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JwtAuthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthDemoApplication.class, args);
	}

}
