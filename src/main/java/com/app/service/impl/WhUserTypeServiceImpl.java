package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType wh) {
		return dao.saveWhUserType(wh);
	}

	@Transactional
	public void updateWhUserType(WhUserType wh) {
		dao.updateWhUserType(wh);
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}

	@Transactional(readOnly = true)
	public WhUserType getWhUserTypeById(Integer id) {
		return dao.getWhUserTypeById(id);
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUserTypes() {
		return dao.getAllWhUserTypes();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getWhUserTypeCountByMode() {
		return dao.getWhUserTypeCountByMode();
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getWhUsersBasedonType(String type) {
		// TODO Auto-generated method stub
		return dao.getWhUsersBasedonType(type);
	}

	@Transactional(readOnly = true)
	public boolean isWhUserCodeExist(String userCode) {
		return dao.isWhUserCodeExist(userCode);
	}

	@Transactional(readOnly = true)
	public Map<Integer, String> getAllWhUserByType(String userType) {
		return dao.getAllWhUserByType(userType);
	}

	@Transactional(readOnly = true)
	public boolean isEmailOrMobileExist(String type, String userEmailOrmobile) {
		return dao.isEmailOrMobileExist(type, userEmailOrmobile);
	}

}
