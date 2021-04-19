package com.multidatasource.jpa.model;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private String name;
	private String city;
}
