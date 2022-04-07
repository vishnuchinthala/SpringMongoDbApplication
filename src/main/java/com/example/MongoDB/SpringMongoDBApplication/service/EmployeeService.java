package com.example.MongoDB.SpringMongoDBApplication.service;

import java.util.List;

import com.example.MongoDB.SpringMongoDBApplication.model.EmployeeInfo;



public interface EmployeeService {
	
public EmployeeInfo saveEmployee(EmployeeInfo info);
	
	public EmployeeInfo updateEmployee(EmployeeInfo info);
	
	public void deleteEmployee(Integer eid);
	
	public List<EmployeeInfo> findAllEmployees();

}
