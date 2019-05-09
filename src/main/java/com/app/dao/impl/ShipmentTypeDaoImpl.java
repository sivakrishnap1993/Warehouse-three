package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer saveShipmentType(ShipmentType s) {

		return (Integer) ht.save(s);
	}

	public void updateShipementType(ShipmentType s) {
		ht.update(s);

	}

	public void deleteShipmentType(Integer id) {
		ShipmentType s = new ShipmentType();
		s.setShipmentId(id);
		ht.delete(s);
	}

	public ShipmentType getShipmentById(Integer id) {
		ShipmentType ss = ht.get(ShipmentType.class, id);
		return ss;
	}

	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType> sl = ht.loadAll(ShipmentType.class);
		return sl;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getShipmentCountByMode() {
		
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(ShipmentType.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("shipmentMode"))
				.add(Projections.count("shipmentMode"))
				));


		/*
		 * String hql=" select shipmentMode,count(shipmentMode) " +"  from " +
		 * ShipmentType.class.getName() +"  group by shipmentMode ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]>
		 * list=(List<Object[]>)ht.find(hql);
		 */
		
		return list;
	}

}
