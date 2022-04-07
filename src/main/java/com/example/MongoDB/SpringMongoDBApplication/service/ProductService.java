package com.example.MongoDB.SpringMongoDBApplication.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.MongoDB.SpringMongoDBApplication.model.Paganition;
import com.example.MongoDB.SpringMongoDBApplication.model.Product;



public interface ProductService {
	
   public  Product createProduct(Product product);

   public Product updateProduct(Product product);

   public List < Product > getAllProduct();

    public Product getProductById(long productId);

    public void deleteProduct(long id);
    

	 public Page<Product> getProduct(Paganition paganition);

}
