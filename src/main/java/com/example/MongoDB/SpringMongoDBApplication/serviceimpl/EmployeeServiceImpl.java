package com.example.MongoDB.SpringMongoDBApplication.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MongoDB.SpringMongoDBApplication.model.EmployeeInfo;
import com.example.MongoDB.SpringMongoDBApplication.repository.EmployeeRepository;
import com.example.MongoDB.SpringMongoDBApplication.service.EmployeeService;


@Service
public  class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeInfo saveEmployee(EmployeeInfo info) {
	
		return employeeRepository.save(info);
	}

	@Override
	public EmployeeInfo updateEmployee(EmployeeInfo info) {
		
		Optional < EmployeeInfo > employeeDb = this.employeeRepository.findById(info.getEid());

        if (employeeDb.isPresent()) {
            EmployeeInfo employeeUpdate = employeeDb.get();
            employeeUpdate.setEid(info.getEid());
            employeeUpdate.setSal(info.getSal());
            employeeUpdate.setEins(info.getEins());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }
		return info; 
	}

	@Override
	public void deleteEmployee(Integer eid) {
		Optional< EmployeeInfo > employeeDb = this.employeeRepository.findById(eid);

        if (employeeDb.isPresent()) {
        	 this.employeeRepository.deleteByEid(employeeDb.get());
        } 
		
	}	@Override
	public List<EmployeeInfo> findAllEmployees() {
		
		return (List<EmployeeInfo>)employeeRepository.findAll();
	}
}
