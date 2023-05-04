package com.infy.projecttaskcrud.app.serviceiImpl;









import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.projecttaskcrud.app.exception.ProductNotFoundException;
import com.infy.projecttaskcrud.app.model.Product;
import com.infy.projecttaskcrud.app.repositry.ProductRepositry;
import com.infy.projecttaskcrud.app.servicei.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepositry prorepo;

	@Override
	public Product addproduct(Product product) {
		
		return prorepo.save(product);
	}

	@Override
	public Iterable<Product> getproduct() {
		
		return prorepo.findAll();
	}

	@Override
	public Product updateproduct(int productid, Product product) {
			Optional<Product>optional=prorepo.findById(productid);
			
			if(optional.isPresent()) {
				Product pro=optional.get();
				product.setProductid(pro.getProductid());
				
//				if(product.getProductname()!=null) {									
//					pro.setProductname(product.getProductname());
//				}
//				if(product.getProductprise()!=null) {									
//					pro.setProductprise(product.getProductprise());
//				}
				return prorepo.save(product);
				
			}
			else {
				
				return null;
			}

	}

	@Override
	public void deleteproduct(int productid) {
		prorepo.deleteById(productid);
		
	}

//	@Override
//	public Iterable<Product> findbyname(String productname) {
//		
//		/*
//		 * List<Product> list=prorepo.findAll();
//		 * 
//		 * List<Product>
//		 * collect=list.stream().filter(p->p.getProductname().equals(productname)).
//		 * collect(Collectors.toList());
//		 */
//		
//		
//		if(collect!=null) {
//			
//			return collect;
//			
//		}
//		else
//		{
//			throw new ProductNotFoundException("Product Not Found");
//		}
//		
//	}

	@Override
	public List<Product> getProductsByIds(List<Integer> productIds) {
			List<Product> listid=prorepo.findAllById(productIds);

		return listid;
	}

	@Override
	public Product findByProductName(String productname) {
	Product pro	=prorepo.findByProductname(productname);
	
	if(pro!=null) {
		return pro;
		
	}
	else {
		throw new ProductNotFoundException("Product Not Found");
	}
	}

	@Override
	public Iterable<Product> findbyname(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
