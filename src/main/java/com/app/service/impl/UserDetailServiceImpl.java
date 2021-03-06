package com.app.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private IUserDao dao; 

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=dao.findByUserName(username);
		Set<GrantedAuthority> grantedauthorities=new HashSet<>();
		for(String role:user.getRoles()) {
			grantedauthorities.add(new SimpleGrantedAuthority(role));
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPwd(), grantedauthorities);
	}

}
