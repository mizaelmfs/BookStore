package com.mizael.bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mizael.bookstore.entity.Permission;
import com.mizael.bookstore.entity.User;
import com.mizael.bookstore.repository.UserRepository;

@Component
public class UserDetail implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User with email \"" + email + "\" was not found");
		}

		LoginDetailBean login = new LoginDetailBean(user.getPerson().getName(), user.getEmail(), user.getPassword());

		for (Permission permission : user.getPermissions()) {
			login.addRole(permission.getRole());
		}

		return login;
	}

}
