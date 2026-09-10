package com.deekshant.churn_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChurnDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurnDashboardApplication.class, args);
	}

}
