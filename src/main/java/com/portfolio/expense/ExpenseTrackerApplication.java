package com.portfolio.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@OpenAPIDefinition( info = @Info(title = "Expense Tracker REST API DOCUMENTATION",
description = "Expense Tracker REST API DOCUMENTATION",
version = "v1.0",
contact = @Contact(
	name = "Leroy",
	email = "leroytantingen@gmail.com",
	url = "tbc"
),
license = @License(
	name = "Apache 2.0",
	url = "tbc"
)
))
@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

}
