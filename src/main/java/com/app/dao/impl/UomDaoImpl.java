package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom o) {
		return (Integer) ht.save(o);
	}

	@Override
	public void updateUom(Uom o) {
		ht.update(o);
	}

	@Override
	public void deleteUom(Integer id) {
		Uom uu = new Uom();
		uu.setUomId(id);
		ht.delete(uu);
	}

	@Override
	public Uom getUomById(Integer id) {
		Uom u = ht.get(Uom.class, id);
		return u;
	}

	@Override
	public List<Uom> getAllUoms() {
		List<Uom> ls = ht.loadAll(Uom.class);

		return ls;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getUomCountByType() {
		
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("uonType"))
				.add(Projections.count("uonType"))
				));
		
		/*
		 * String hql=" select uonType,count(uonType) " +"  from " + Uom.class.getName()
		 * +"  group by uonType ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> list =
		 * (List<Object[]>) ht.find(hql);
		 */

		return list;
	}
}
