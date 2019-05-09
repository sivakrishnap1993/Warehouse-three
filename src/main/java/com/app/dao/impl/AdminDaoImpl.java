package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IAdminDao;
import com.app.model.Admin;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveAdmin(Admin a) {
		return (Integer) ht.save(a);
	}

	@Override
	public void updateAdmin(Admin a) {
		ht.update(a);
	}

	@Override
	public void deleteAdmin(Integer id) {
		Admin a = new Admin();
		a.setAdmId(id);
		ht.delete(a);
	}

	@Override
	public Admin getAdminById(Integer id) {
		Admin aa = ht.get(Admin.class, id);
		return aa;
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> la = ht.loadAll(Admin.class);
		return la;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAdminCountByDeptMode() {
		
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(Admin.class)
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("admType"))
						.add(Projections.count("admType"))));
		/*
		 * String hql = " select admType,count(admType)" + " from " +
		 * Admin.class.getName() + " group by  admType ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> list =
		 * (List<Object[]>) ht.find(hql);
		 */
		return list;
	}

}
