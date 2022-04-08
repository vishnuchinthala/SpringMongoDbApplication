package com.example.MongoDB.SpringMongoDBApplication.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ProductDB")
public class Product {

    @Id
    private long id;


    @Indexed(unique = true)
    private String name;
    private String description;
  private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="product_id",referencedColumnName ="id")
	 private List<EmployeeInfo> employeeinfo = new ArrayList<>();
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<EmployeeInfo> getEmployeeinfo() {
		return employeeinfo;
	}


	public void setEmployeeinfo(List<EmployeeInfo> employeeinfo) {
		this.employeeinfo = employeeinfo;
	}
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

