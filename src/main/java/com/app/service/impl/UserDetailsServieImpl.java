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

import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserDetailsServieImpl implements UserDetailsService{
	@Autowired
	private IUserService service;
	
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		//1. get Model class user based on username(email)
		User user=service.findUserByEmail(username);
		
		//2. construct roles
		//->read role from model class user
		Set<GrantedAuthority> auths=new HashSet<>();
		for(String role:user.getUsrRoles()) {
			//convert to SGA and add to Set
			auths.add(new SimpleGrantedAuthority(role));
		}
		//3 return Spring f/w user 		
		return new org.springframework.security.core.userdetails.User(username, user.getUsrPwd(), auths);
	}
} 