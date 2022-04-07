package com.example.MongoDB.SpringMongoDBApplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.MongoDB.SpringMongoDBApplication.Security.EncryptionDecryptionAES;
import com.example.MongoDB.SpringMongoDBApplication.exception.ResourceNotFoundException;
import com.example.MongoDB.SpringMongoDBApplication.model.Paganition;
import com.example.MongoDB.SpringMongoDBApplication.model.Product;
import com.example.MongoDB.SpringMongoDBApplication.repository.ProductRepository;
import com.example.MongoDB.SpringMongoDBApplication.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional < Product > productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }


    	
    @Override
    public Product getProductById(long productId) {

        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            this.productRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }
	@Override
	public Page<Product> getProduct(Paganition paganition) {
		
			 Sort sort =Sort.by(paganition.getSortDirection(),paganition.getSortBY());
			 Pageable pageable=PageRequest.of(paganition.getPageNumber(),
					 paganition.getPageSize(),sort); 
			return  productRepository.findAll(pageable);
	}

	@Override
	public List<Product> getAllProduct() {
		List< Product> productList =   productRepository.findAll();
		productList.forEach(product -> {
			try {
				product.setPassword(EncryptionDecryptionAES.decrypt(product.getPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		});
		return productList;

	}
}
	

