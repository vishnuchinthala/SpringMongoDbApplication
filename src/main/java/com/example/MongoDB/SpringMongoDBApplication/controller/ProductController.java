package com.example.MongoDB.SpringMongoDBApplication.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoDB.SpringMongoDBApplication.Security.EncryptionDecryptionAES;
import com.example.MongoDB.SpringMongoDBApplication.model.Paganition;
import com.example.MongoDB.SpringMongoDBApplication.model.Product;
import com.example.MongoDB.SpringMongoDBApplication.model.PushNotificationRequest;
import com.example.MongoDB.SpringMongoDBApplication.model.PushNotificationResponse;
import com.example.MongoDB.SpringMongoDBApplication.service.EmployeeService;
import com.example.MongoDB.SpringMongoDBApplication.service.ProductService;
import com.example.MongoDB.SpringMongoDBApplication.serviceimpl.ProductServiceImpl;
import com.example.MongoDB.SpringMongoDBApplication.serviceimpl.PushNotificationService;



@RestController
public class ProductController {
// 	private static final Logger Logger=LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    

    
    @GetMapping("/products")
    public ResponseEntity < List < Product >> getAllProduct() {
    	system.out.println("method executed");
        return ResponseEntity.ok().body(productService.getAllProduct());
        
    }

    @GetMapping(value="Paganition")
    public ResponseEntity<Page<Product>>getProduct(Paganition paganition){
    system.out.println("method executed and output should be display");
  	  return new ResponseEntity<>(productService.getProduct(paganition),HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity < Product > getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
    
   
    
    @PostMapping("/products")
    public ResponseEntity < Product > createProduct(@RequestBody Product product) {
    	product.getEmployeeinfo();
    	 try {
    	    	String encoderPassword = EncryptionDecryptionAES.encrypt(product.getPassword());
    	    	 product.setPassword(encoderPassword);
    	    } catch (Exception e) {
    	    	// TODO Auto-generated catch block
    	    	e.printStackTrace();
    	    }
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products")
    public HttpStatus deleteProduct(@RequestParam long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
