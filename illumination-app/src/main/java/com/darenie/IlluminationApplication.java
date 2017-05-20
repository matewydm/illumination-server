package com.darenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.darenie.database")
public class IlluminationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IlluminationApplication.class, args);
	}
}
