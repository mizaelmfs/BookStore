package com.mizael.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.entity.Book;
import com.mizael.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired BookRepository bookRepository;
	
	public Book save(Book book){
		
		return bookRepository.save(book);
	}
	
	public Book getBook(Long id){
		
		Book book = bookRepository.getOne(id);
		
		return book;
	}
	
	public List<Book> getBooks(){
		
		return bookRepository.findAll();
	}
	
	public Book delete(Book book){
		Book bookReturn = this.getBook(book.getId());
		if(bookReturn != null) bookRepository.delete(bookReturn);
		
		return bookReturn;
	}
	
	public List<Book> getBookTilte(String title){
		return this.bookRepository.findTilte(title);
	}
	
	public  Page<Book> getBookPagination(Pageable pageable){
		
		return this.bookRepository.findAll(pageable);
	}
	
}
