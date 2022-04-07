package com.example.MongoDB.SpringMongoDBApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoDB.SpringMongoDBApplication.model.EmployeeInfo;

public interface EmployeeRepository extends MongoRepository<EmployeeInfo, Integer> {

	void deleteByEid(EmployeeInfo employeeInfo);

}
