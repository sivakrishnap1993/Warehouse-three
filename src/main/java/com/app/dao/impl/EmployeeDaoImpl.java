package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveEmployee(Employee e) {
		return (Integer) ht.save(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		ht.update(e);
	}

	@Override
	public void deleteEmplyee(Integer id) {
		Employee e = new Employee();
		e.setEmpId(id);
		ht.delete(e);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee eee = ht.get(Employee.class, id);
		return eee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> ee = ht.loadAll(Employee.class);
		return ee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getEmployeeCountByGenMode() {
		
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(Employee.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("cmpLoc"))
				.add(Projections.count("cmpLoc"))
				));
		
		/*
		 * String hql = " select cmpLoc,count(cmpLoc)" + " from  " +
		 * Employee.class.getName() + " gorup by cmpLoc ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> list =
		 * (List<Object[]>) ht.find(hql);
		 */
		return list;
	}

}
