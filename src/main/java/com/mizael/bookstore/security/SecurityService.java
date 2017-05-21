package com.mizael.bookstore.security;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mizael.bookstore.utils.Map;
import com.mizael.bookstore.utils.Path;

@RestController
@RequestMapping(Path.LOGIN_PATH)
public class SecurityService implements Map {

	@RequestMapping(method = { RequestMethod.GET })
	public Principal user(Principal user) {
		return user;
	}

}
