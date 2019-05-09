package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private String cmpLoc;
	private String empPwd;
	private String empGen;
	private String empAddr;

	public Employee() {
		super();
	}

	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public Employee(Integer empId, String empName, String cmpLoc, String empPwd, String empGen, String empAddr) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.cmpLoc = cmpLoc;
		this.empPwd = empPwd;
		this.empGen = empGen;
		this.empAddr = empAddr;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCmpLoc() {
		return cmpLoc;
	}

	public void setCmpLoc(String cmpLoc) {
		this.cmpLoc = cmpLoc;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpGen() {
		return empGen;
	}

	public void setEmpGen(String empGen) {
		this.empGen = empGen;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", cmpLoc=" + cmpLoc + ", empPwd=" + empPwd
				+ ", empGen=" + empGen + ", empAddr=" + empAddr + "]";
	}

}
