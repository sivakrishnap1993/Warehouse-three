package com.app.service;

import java.util.List;

import com.app.model.Admin;

public interface IAdminService {

	public Integer saveAdmin(Admin a);

	public void updateAdmin(Admin a);

	public void deleteAdmin(Integer id);

	public Admin getAdminById(Integer id);

	public List<Admin> getAllAdmins();
	
	public List<Object[]> getAdminCountByDeptMode();

}
