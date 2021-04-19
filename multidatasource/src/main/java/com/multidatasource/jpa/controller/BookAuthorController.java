package com.multidatasource.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidatasource.jpa.model.AuthorDocument;
import com.multidatasource.jpa.model.BookEntity;
import com.multidatasource.jpa.repository.AuthorDocumentMongoRepository;
import com.multidatasource.jpa.repository.BookEntityJpaRepository;

@RestController
@RequestMapping(value="/multidatasource")
public class BookAuthorController {

	@Autowired
	BookEntityJpaRepository bookrepo;
	
	@Autowired
	AuthorDocumentMongoRepository authorrepo;
	
	@PostMapping(value="/insert/mongo/author")
	public String saveAuthor(@RequestBody final AuthorDocument a) {
		 authorrepo.save(a);
		 return "Data inserted successfully";
	}
	
	@PostMapping(value="/insert/mysql/book")
	public String saveBook(@RequestBody final BookEntity b) {
		 bookrepo.save(b);
		 return "Data inserted successfully";
	}
}
