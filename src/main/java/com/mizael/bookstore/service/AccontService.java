package com.mizael.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.entity.Permission;
import com.mizael.bookstore.entity.User;
import com.mizael.bookstore.repository.PermissionRepository;
import com.mizael.bookstore.repository.UserRepository;

@Service
public class AccontService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired PermissionRepository permissionRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save(User user) {
		List<Permission> permission = new ArrayList<>();
		
		permission.add(this.permissionRepository.findOne(new Long(2)));
		
		user.setPermissions(permission);
		
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User getUser(Long id) {

		User user = userRepository.getOne(id);

		return user;
	}
	
	public boolean getUserByEmail(String email){
		if(this.userRepository.findEmail(email) != null){
			return true;
		}
		return false;
	}
}
