package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee e);

	public void updateEmployee(Employee e);

	public void deleteEmplyee(Integer id);

	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployees();
	
	public List<Object[]> getEmployeeCountByGenMode();
}
