package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer saveUser(User u) {
		return (Integer) ht.save(u);
	}

	public void updateUser(User u) {
		ht.update(u);
	}

	public void deleteUser(Integer id) {
		User uu = new User();
		uu.setUseId(id);
		ht.delete(uu);
	}

	public User getUserById(Integer id) {
		User u = ht.get(User.class, id);
		return u;
	}

	public List<User> getAllUsers() {
		List<User> u = ht.loadAll(User.class);
		return u;
	}

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getUserCountByMode() {

		String hql =   "select gender,count(gender) from "
				+User.class.getCanonicalName()
				+" group by gender";

		List<Object[]> users = (List<Object[]>) ht.find(hql);

		return users;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean isEmailOrMobileExist(String type, String userEmailOrmobile) {

		long count=0;

		String hql="select count("+type+") from "+User.class.getName()+" where "+type+"=?";

		List<Long> whUserType=(List<Long>) ht.find(hql, userEmailOrmobile);

		if (whUserType!=null && !whUserType.isEmpty()) {
			count=whUserType.get(0);
		}
		return count>0?true:false;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public User findUserByEmail(String username) {

		User user=null; 
		
		//select * from usertab where email=?
		List<User> userList=
				(List<User>) ht.findByCriteria(
						DetachedCriteria.forClass(User.class)
						.add(Restrictions.eq("usrMail", username))
						);
		if(userList!=null && !userList.isEmpty()) {
			user=userList.get(0);
		}
		
		return user;
	}
}
