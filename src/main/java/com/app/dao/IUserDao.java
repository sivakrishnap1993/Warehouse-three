package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDao {

	public Integer saveUser(User u);

	public void updateUser(User u);

	public void deleteUser(Integer id);

	public User getUserById(Integer id);

	public List<User> getAllUsers();
	
	public List<Object[]> getUserCountByMode();
	
	public boolean isEmailOrMobileExist(String type,String userEmailOrmobile);
	
	public User findUserByEmail(String email);
}
