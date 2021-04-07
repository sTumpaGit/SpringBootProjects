package com.postgresql.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.jpa.model.Employee;
import com.postgresql.jpa.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository emprepository;
	
	@GetMapping(value = "/show")
	public List<Employee> showAll(){
		return emprepository.findAll();
	}
	
	@GetMapping(value = "/getEmpById/{empId}")
	public Optional<Employee> findById(@PathVariable(value = "empId") Integer id){
		return emprepository.findById(id);
	}
	
	@PostMapping(value = "/insert")
	public void insertAndSave(@RequestBody final Employee emp) {
		emprepository.save(emp);
	}
	
	@GetMapping(value = "/averageSalary")
	public Long avgSalary(){
		
		int entry = (int) emprepository.count();
		Long salary = (long) 0;
		for(Employee emp : emprepository.findAll()) {
			if(emp.getSalary() == null) {
				entry--;
			}else {
				salary += emp.getSalary();
			}
		}		
		return salary/entry;
	}
	
	@PostMapping(value = "/update")
	public Employee updateSalary(@RequestBody final Employee emp) {
		Employee obj = emprepository.save(emp);
		return obj;
	}

	@GetMapping(value = "/delete/{empId}")
	public void deleteById(@PathVariable(value = "empId") Integer id){
		emprepository.deleteById(id);
	}
}
