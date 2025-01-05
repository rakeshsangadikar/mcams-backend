package com.management.mcams.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MCAMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(MCAMSApplication.class, args);
	}

}
