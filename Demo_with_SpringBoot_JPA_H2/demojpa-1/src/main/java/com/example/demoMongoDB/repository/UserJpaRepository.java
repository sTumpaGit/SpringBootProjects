package com.example.demoMongoDB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demoMongoDB.model.Users;

@Repository
public interface UserJpaRepository extends JpaRepository<Users , Long> {

	Users findByName(String name);
	
}
