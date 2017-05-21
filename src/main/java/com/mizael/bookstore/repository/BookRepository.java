package com.mizael.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mizael.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("select b from Book b where title like :title%")
	public List<Book> findTilte(@Param("title") String title);
	
}
