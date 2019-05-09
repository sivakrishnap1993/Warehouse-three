package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod or) {
		return (Integer) ht.save(or);
	}

	@Override
	public void updateOrderMethod(OrderMethod or) {
		ht.update(or);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod o = new OrderMethod();
		o.setOrdMId(id);
		ht.delete(o);
	}

	@Override
	public OrderMethod getOrderMethodById(Integer id) {
		OrderMethod oo = ht.get(OrderMethod.class, id);
		return oo;
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		List<OrderMethod> os = ht.loadAll(OrderMethod.class);
		return os;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getOrderMethodCountByMode() {
		
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("ordMode"))
				.add(Projections.count("ordMode"))));
		
		/*
		String hql = " select ordMode,count(ordMode) " + "  from " + OrderMethod.class.getName()
				+ "  group by ordMode ";

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list = (List<Object[]>) ht.find(hql);*/
		return list;
	}

	
}
