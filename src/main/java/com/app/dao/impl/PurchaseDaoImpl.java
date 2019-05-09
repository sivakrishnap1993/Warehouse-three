package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;

@Repository
public class PurchaseDaoImpl implements IPurchaseDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchase(Purchase p) {
		return (Integer) ht.save(p);

	}

	@Override
	public void updatePurchase(Purchase p) {
		ht.update(p);
	}

	@Override
	public void deletePurchase(Integer id) {
			ht.delete(ht.get(Purchase.class, id));
	}

	@Override
	public Purchase getPurchaseById(Integer id) {
		Purchase pm = ht.get(Purchase.class, id);
		return pm;
	}

	@Override
	public List<Purchase> getAllPurchases() {
		List<Purchase> pl = ht.loadAll(Purchase.class);
		return pl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPurchaseCountByQtyCheck() {
		
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(Purchase.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("qtyCk"))
				.add(Projections.count("qtyCk"))
				));
		
		/*
		 * String hql = " select qtyCk,count(qtyCk)" + " from " +
		 * Purchase.class.getName() + " group by  qtyCk ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> list =
		 * (List<Object[]>) ht.find(hql);
		 */
		return list;
	}

}
