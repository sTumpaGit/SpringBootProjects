package com.multidatasource.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidatasource.jpa.model.BookEntity;

@Repository
public interface BookEntityJpaRepository extends JpaRepository<BookEntity, Integer>{

}
