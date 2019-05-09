package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer saveItem(Item i) {
		return (Integer) ht.save(i);
	}

	public void updateItem(Item i) {
		ht.update(i);
	}

	public void deleteItem(Integer id) {
		/*
		 * Item ii = new Item(); ii.setItemId(id);
		 */
		Item item=getItemById(id);
		
		ht.delete(item);
	}

	public Item getItemById(Integer id) {
		Item in = ht.get(Item.class, id);
		return in;
	}

	public List<Item> getAllItems() {
		List<Item> li = ht.loadAll(Item.class);
		return li;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getCountByMode() {
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("baseCurrency"))
				.add(Projections.count("baseCurrency"))
				));
		
		/*
		 * String hql = " select baseCurrency,count(baseCurrency) " + " from " +
		 * Item.class.getName() + " group by baseCurrency ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> list =
		 * (List<Object[]>) ht.find(hql);
		 */
		return list;
	}

}
