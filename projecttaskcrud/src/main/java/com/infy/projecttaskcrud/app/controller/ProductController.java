package com.infy.projecttaskcrud.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.projecttaskcrud.app.model.Product;
import com.infy.projecttaskcrud.app.response.BaseResponse;
import com.infy.projecttaskcrud.app.servicei.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	Date date=new Date();
	@PostMapping("/addproduct")
	public ResponseEntity<BaseResponse<Product>> addproduct(@RequestBody Product product)
	{
		Product pr=productService.addproduct(product);
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200,date,"data is Added Sucessfully", pr);
		ResponseEntity<BaseResponse<Product>> entity=new ResponseEntity<BaseResponse<Product>>(baseResponse, HttpStatus.OK);
		
		return entity;
		
	}
	
	@GetMapping("/getproduct")
	public ResponseEntity<BaseResponse<Iterable<Product>>> getproduct(){
		Iterable<Product> iterable=productService.getproduct();
		BaseResponse<Iterable<Product>> baseResponse=new BaseResponse<Iterable<Product>>(200, date, "Data IS Gate Sucessfully", iterable);
		ResponseEntity<BaseResponse<Iterable<Product>>> entity=new ResponseEntity<BaseResponse<Iterable<Product>>>(baseResponse, HttpStatus.OK);
		return entity;		
		
	}

	@PutMapping("/updateproduct/{productid}")
	public ResponseEntity<BaseResponse<Product>> updateproduct(@PathVariable int productid, @RequestBody Product product){
		Product updateproduct=productService.updateproduct(productid,product);
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200, date, "Data Updated Sucessfully", updateproduct);
		ResponseEntity<BaseResponse<Product>> entity=new ResponseEntity<BaseResponse<Product>>(baseResponse, HttpStatus.OK);
		
		return entity;	
		
	}
	@DeleteMapping("/deleteproduct/{productid}")
	public String deleteproduct(@PathVariable int productid )
	{
		productService.deleteproduct(productid);
	
	
		
		
		return "Data IS Deleted";		
		
	}
	
	@GetMapping("/getproduct/{productname}")
	public ResponseEntity<BaseResponse<Product>> getProductbyproductname(@PathVariable String productname){
		
		
//		Iterable<Product> productbyname=productService.findbyname(productname);
//		BaseResponse<Iterable<Product>> baseResponse=new BaseResponse<Iterable<Product>>(200, date, "Product is Filter", productbyname);
//		ResponseEntity<BaseResponse<Iterable<Product>>> responseEntity=new ResponseEntity<BaseResponse<Iterable<Product>>>(baseResponse, HttpStatus.OK);
//		
		System.out.println("project to be Filter");
		Product product=productService.findByProductName(productname);
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200, date, "Product Filter", product);
		ResponseEntity<BaseResponse<Product>> responseEntity=new ResponseEntity<BaseResponse<Product>>(baseResponse, HttpStatus.OK);
		
		
		return responseEntity;	
		
	}
	
}
