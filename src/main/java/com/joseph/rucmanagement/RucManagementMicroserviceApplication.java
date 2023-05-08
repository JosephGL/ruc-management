package com.joseph.rucmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RucManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RucManagementMicroserviceApplication.class, args);
	}

}
