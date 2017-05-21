package com.mizael.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mizael.bookstore.entity.Book;
import com.mizael.bookstore.service.BookService;
import com.mizael.bookstore.utils.Map;
import com.mizael.bookstore.utils.Path;

@Controller
@RequestMapping(path = Path.BOOK_PATH)
public class BookController implements Map{

	@Autowired BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks(){
		
		return new ResponseEntity<List<Book>>(bookService.getBooks() ,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Book> save(@RequestBody Book book){
		
		return new ResponseEntity<Book>(bookService.save(book), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable Long id){
		
		return new ResponseEntity<Book>(bookService.getBook(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Book> delete(@RequestBody Book book){
		
		return new ResponseEntity<Book>(bookService.delete(book), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/list")
	public ResponseEntity<Page<Book>> getPagination(Pageable pageable) {

		return new ResponseEntity<Page<Book>>(bookService.getBookPagination(pageable), HttpStatus.OK);
	}
}
