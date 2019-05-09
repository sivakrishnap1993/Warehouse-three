package com.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Admin {

	@Id
	@GeneratedValue

	private Integer admId;
	private String admName;
	private String admType;
	private String admSalary;
	private String dept;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> admModes;

	public Admin() {
		super();
	}

	public Admin(Integer admId) {
		super();
		this.admId = admId;
	}

	public Admin(Integer admId, String admName, String admType, String admSalary, String dept, List<String> admModes) {
		super();
		this.admId = admId;
		this.admName = admName;
		this.admType = admType;
		this.admSalary = admSalary;
		this.dept = dept;
		this.admModes = admModes;
	}

	public Integer getAdmId() {
		return admId;
	}

	public void setAdmId(Integer admId) {
		this.admId = admId;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmType() {
		return admType;
	}

	public void setAdmType(String admType) {
		this.admType = admType;
	}

	public String getAdmSalary() {
		return admSalary;
	}

	public void setAdmSalary(String admSalary) {
		this.admSalary = admSalary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<String> getAdmModes() {
		return admModes;
	}

	public void setAdmModes(List<String> admModes) {
		this.admModes = admModes;
	}

	@Override
	public String toString() {
		return "Admin [admId=" + admId + ", admName=" + admName + ", admType=" + admType + ", admSalary=" + admSalary
				+ ", dept=" + dept + ", admModes=" + admModes + "]";
	}

}
