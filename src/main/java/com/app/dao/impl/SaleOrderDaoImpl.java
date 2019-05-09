package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleOrderDao;
import com.app.model.SaleOrder;

@Repository
public class SaleOrderDaoImpl implements ISaleOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveSaleOrder(SaleOrder sl) {
		return (Integer) ht.save(sl);
	}

	
	public void updateSaleOrder(SaleOrder sl) {
		ht.update(sl);
	}

	public void deleteSaleOrder(Integer id) {
		ht.delete(ht.get(SaleOrder.class, id));
	}

	
	public SaleOrder getSaleOrderById(Integer id) {
		return ht.get(SaleOrder.class, id);
	}

	
	public List<SaleOrder> getAllSaleOrders() {
		return ht.loadAll(SaleOrder.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Object[]> saleorderCountByMode() {
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(
		DetachedCriteria.forClass(SaleOrder.class).setProjection(Projections.projectionList()
				.add(Projections.property("shpCode"))
				.add(Projections.count("shpCode"))));
		
		return list;
	}

}
