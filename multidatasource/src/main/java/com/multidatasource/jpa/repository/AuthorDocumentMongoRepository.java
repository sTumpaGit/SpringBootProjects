package com.multidatasource.jpa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multidatasource.jpa.model.AuthorDocument;

@Repository
public interface AuthorDocumentMongoRepository extends MongoRepository<AuthorDocument , String> {

}
