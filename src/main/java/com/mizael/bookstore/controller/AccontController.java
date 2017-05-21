package com.mizael.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mizael.bookstore.entity.User;
import com.mizael.bookstore.service.AccontService;
import com.mizael.bookstore.utils.Path;

@Controller
@RequestMapping(value = Path.ACCONT_PATH)
public class AccontController {
	
	@Autowired AccontService accontService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Boolean> get(String email){
		
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user){
		
		return new ResponseEntity<User>(this.accontService.save(user), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{email}")
	public ResponseEntity<Boolean> getUserByEmail(@PathVariable String email){
		
		return new ResponseEntity<Boolean>(this.accontService.getUserByEmail(email), HttpStatus.OK);
	}
}
