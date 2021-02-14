package com.example.demoMongoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMongoDB.model.Person;
import com.example.demoMongoDB.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personrepository;
	
	public Person create(String firstName, String lastName, int age) {
		return personrepository.save(new Person(firstName, lastName, age));
	}
	
	public List<Person> getAll(){
		return personrepository.findAll();
	}
	
	public Person getByFirstName(String firstName) {
		return personrepository.findByFirstName(firstName);
	}
	
	public Person update(String firstName, String lastName, int age) {
		Person p = personrepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personrepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		personrepository.deleteAll();
	}
	public void delete(String firstName) {
		Person p = personrepository.findByFirstName(firstName);
		personrepository.delete(p);
	}
}
