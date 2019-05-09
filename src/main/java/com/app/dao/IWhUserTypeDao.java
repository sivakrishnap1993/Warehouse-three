package com.app.dao;

import java.util.List;
import java.util.Map;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {

	public Integer saveWhUserType(WhUserType wh);

	public void updateWhUserType(WhUserType wh);

	public void deleteWhUserType(Integer id);

	public WhUserType getWhUserTypeById(Integer id);

	public List<WhUserType> getAllWhUserTypes();

	public List<Object[]> getWhUserTypeCountByMode();

	public List<WhUserType> getWhUsersBasedonType(String type);

	public boolean isWhUserCodeExist(String userCode);

	public boolean isEmailOrMobileExist(String type, String userEmailOrmobile);

	public Map<Integer, String> getAllWhUserByType(String userType);
}
