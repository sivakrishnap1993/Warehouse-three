package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;

	
	@Transactional
	public Integer saveShipmentType(ShipmentType s) {

		return dao.saveShipmentType(s);
	}

	
	@Transactional
	public void updateShipementType(ShipmentType s) {
		dao.updateShipementType(s);

	}

	
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}

	
	@Transactional(readOnly=true)
	public ShipmentType getShipmentById(Integer id) {

		return dao.getShipmentById(id);
	}

	
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {

		return dao.getAllShipmentTypes();
	}
	
	@Transactional(readOnly=true)
	public List<Object[]> getShipmentCountByMode() {
		return dao.getShipmentCountByMode();
	}

}
