package com.infy.projecttaskcrud.app.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.projecttaskcrud.app.model.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer> {

	public Product findByProductname(String productname);


	
	

}
