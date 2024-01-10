package com.luv2code.springcodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.luv2code.springcodedemo",
		"com.luv2code.util"
})
public class SpringcodedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcodedemoApplication.class, args);
	}

}
