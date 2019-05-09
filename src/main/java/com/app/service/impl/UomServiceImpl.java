package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;

	@Override
	@Transactional
	public Integer saveUom(Uom o) {
		return dao.saveUom(o);
	}

	@Override
	@Transactional
	public void updateUom(Uom o) {
		dao.updateUom(o);
	}

	@Override
	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Uom getUomById(Integer id) {
		return dao.getUomById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Uom> getAllUoms() {
		return dao.getAllUoms();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getUomCountByType() {
		return  dao.getUomCountByType();
	}

}
