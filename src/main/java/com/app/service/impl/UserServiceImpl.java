package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Transactional
	public Integer saveUser(User user) {

		// read pwd
		String pwd = user.getUsrPwd();
		// encode pwd
		String encPwd = pwdEncoder.encode(pwd);
		// set back enc Pwd to user
		user.setUsrPwd(encPwd);
		return dao.saveUser(user);
	}

	@Transactional(readOnly = true)
	public User findUserByEmail(String email) {
		return dao.findUserByEmail(email);
	}

	@Transactional
	public void updateUser(User u) {
		dao.updateUser(u);
	}

	@Transactional
	public void deleteUser(Integer id) {
		dao.deleteUser(id);
	}

	@Transactional(readOnly = true)
	public User getUserById(Integer id) {

		return dao.getUserById(id);
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getUserCountByMode() {
		return dao.getUserCountByMode();
	}
	
	@Transactional(readOnly=true)
	public boolean isEmailOrMobileExist(String type, String userEmailOrmobile) {
		return dao.isEmailOrMobileExist(type, userEmailOrmobile);
	}

}
