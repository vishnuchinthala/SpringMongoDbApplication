package com.example.MongoDB.SpringMongoDBApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoDB.SpringMongoDBApplication.model.Product;


public interface ProductRepository extends MongoRepository < Product, Long > {

}
