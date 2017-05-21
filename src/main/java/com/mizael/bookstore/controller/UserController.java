package com.mizael.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mizael.bookstore.entity.User;
import com.mizael.bookstore.security.CurrentUser;
import com.mizael.bookstore.service.UserService;
import com.mizael.bookstore.utils.Map;
import com.mizael.bookstore.utils.Path;


@Controller
@RequestMapping(path = Path.USER_PATH)
public class UserController implements Map{

	@Autowired UserService userService;
	
	@Autowired
	private CurrentUser currentUser;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> getUser(){
		
		User user  = this.userService.findByEmail(currentUser.getActiveUser().getEmail());
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user){
		
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
	
}
