package com.postgresql.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping(value = "/insert")
	public void insertAndSave(@RequestBody final Employee emp) {
		emprepository.save(emp);
	}
	
	@GetMapping(value = "/averageSalary")
	public Long avgSalary(){
		//return emprepository.getAverageSalary();
		List<Employee> list = new ArrayList<Employee>();
		list = emprepository.findAll();
		int entry = list.size();
		Long salary = (long) 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSalary() == null) {
				entry--;
			}else {
				salary += list.get(i).getSalary();
			}
		}		
		return salary/entry;
	}
	
	@PostMapping(value = "/update")
	public Employee updateSalary(@RequestBody final Employee emp) {
		Employee obj = emprepository.save(emp);
		return obj;
	}
}
