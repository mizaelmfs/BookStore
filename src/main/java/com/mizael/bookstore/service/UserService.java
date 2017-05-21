package com.mizael.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.entity.User;
import com.mizael.bookstore.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User getUser(Long id) {

		User user = userRepository.getOne(id);

		return user;
	}

	public List<User> getUsers() {

		return userRepository.findAll();
	}

	public User delete(User user) {
		User userReturn = this.getUser(user.getId());
		if (userReturn != null)
			userRepository.delete(userReturn);

		return userReturn;
	}

	public User findByEmail(String email) {
		
		return this.userRepository.findByEmail(email);
		
	}
}
