package com.AJL.travelnest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TravelnestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelnestApplication.class, args);
	}

}
