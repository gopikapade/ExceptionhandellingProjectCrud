package com.infy.projecttaskcrud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.projecttaskcrud.app.model.Product;

@SpringBootApplication
public class ProjecttaskcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecttaskcrudApplication.class, args);
		
		Product pr=new Product();
		System.out.println(pr.getProductname());
	}

}
