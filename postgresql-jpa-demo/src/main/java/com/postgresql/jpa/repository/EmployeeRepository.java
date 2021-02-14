package com.postgresql.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postgresql.jpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,  Integer> {

	@Query("SELECT AVG(salary) from Employee")
	Long getAverageSalary();

}
