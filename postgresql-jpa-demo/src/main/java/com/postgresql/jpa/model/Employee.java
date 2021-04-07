package com.postgresql.jpa.model;

import javax.persistence.*;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer empId;
	 String empName;
	 Long phone;
	 String email;
	 Long salary;
	
	public Employee() {
		
	}

	public Employee(String empName, Long phone, String email, Long salary) {
		super();
		
		this.empName = empName;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
