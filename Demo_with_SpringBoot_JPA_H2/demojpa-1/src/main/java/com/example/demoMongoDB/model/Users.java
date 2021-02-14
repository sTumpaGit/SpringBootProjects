package com.example.demoMongoDB.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;



@Entity
@Table
public class Users {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String teamName;
	private Integer salary;
	
	public Users() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
}


/*
 * 
org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'entityManagerFactory' defined in class 
path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation 
of init method failed; nested exception is org.hibernate.AnnotationException: No identifier 
specified for entity: com.example.demoMongoDB.model.Users
 * 
 * */
