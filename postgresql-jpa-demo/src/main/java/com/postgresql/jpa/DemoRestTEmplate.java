package com.postgresql.jpa;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.postgresql.jpa.model.Employee;

public class DemoRestTEmplate {
	
	public static String url_for_getAllUser = "http://localhost:9090/employee/show";
	public static String url_for_getUserBy_Id = "http://localhost:9090/employee/getEmpById/{id}";
	public static String url_for_insertData = "http://localhost:9090/employee/insert";
	public static String url_for_update = "http://localhost:9090/employee/update";
	public static String url_for_delete = "http://localhost:9090/employee/delete/{id}";
	
	
	static RestTemplate rest = new RestTemplate();
	static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		callForGetAllUser();
		//callForUserById();
		//callForInsertion();
		//callForUpdate();
		//callForDelete();
				
	}

	private static void callForUpdate() {
		Employee emp = new Employee();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("id", 2);
		
		emp = rest.getForObject(url_for_getUserBy_Id, Employee.class, map);
		emp.setEmpName("");
		emp.setPhone((long)23789798);
		emp.setEmail("");
		emp.setSalary((long)2345000);
		
		rest.postForEntity(url_for_update, emp, Employee.class);
	}
	
	private static void callForDelete() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("id", 2);
		
		rest.getForObject(url_for_delete, Employee.class, map);
	}

	private static void callForInsertion() {
		// TODO Auto-generated method stub
		
		String name = null, email = null;
		Long phone, salary;
		System.out.println("Enter name - ");
		name = scan.next();
		System.out.println("Enter email - ");
		email = scan.next();
		System.out.println("Enter phone number - ");
		phone = scan.nextLong();
		System.out.println("Enter salary - ");
		salary = scan.nextLong();
		Employee obj = new Employee(name,(long)phone, email, (long)salary);
		System.out.println("----------------New insertion is here--------------");
		rest.postForEntity(url_for_insertData, obj, Employee.class);
		System.out.println("----------------Now current set of data--------------");
		callForGetAllUser();
		
	}

	private static void callForUserById() {
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("id", 3);
		Employee obj = rest.getForObject(url_for_getUserBy_Id, Employee.class, map);
		System.out.println("----------------Data according to id-------------");
		System.out.println(obj.getEmpName());
		System.out.println(obj.getEmail());
		System.out.println(obj.getPhone());
		System.out.println(obj.getSalary());
		
	}

	private static void callForGetAllUser() {
		ResponseEntity<String> entity = rest.getForEntity(url_for_getAllUser,String.class);
		System.out.println("----------------Data of all employees-------------");
		System.out.println(entity.getBody());
	}

}
