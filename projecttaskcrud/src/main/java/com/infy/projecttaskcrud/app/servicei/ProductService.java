package com.infy.projecttaskcrud.app.servicei;

import java.util.List;

import com.infy.projecttaskcrud.app.model.Product;

public interface ProductService {

	public Product addproduct(Product product);

	public Iterable<Product> getproduct();

	public Product updateproduct(int productid, Product product);

	public void deleteproduct(int productid);

	public Iterable<Product> findbyname(String productname);

	public List<Product> getProductsByIds(List<Integer> productIds);

	public Product findByProductName(String productname);
	

}
