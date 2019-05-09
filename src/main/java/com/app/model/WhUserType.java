package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WhUserType {

	@Id
	@GeneratedValue
	private Integer urdId;
	private String userOneType;
	private String usrCode;
	private String usrFor;
	private String usrEmail;
	private String usrContact;
	private String userType;
	private String usrNum;

	public WhUserType() {
		super();
	}

	public WhUserType(Integer urdId) {
		super();
		this.urdId = urdId;
	}

	public WhUserType(Integer urdId, String userOneType, String usrCode, String usrFor, String usrEmail,
			String usrContact, String userType, String usrNum) {
		super();
		this.urdId = urdId;
		this.userOneType = userOneType;
		this.usrCode = usrCode;
		this.usrFor = usrFor;
		this.usrEmail = usrEmail;
		this.usrContact = usrContact;
		this.userType = userType;
		this.usrNum = usrNum;
	}

	public Integer getUrdId() {
		return urdId;
	}

	public void setUrdId(Integer urdId) {
		this.urdId = urdId;
	}

	public String getUserOneType() {
		return userOneType;
	}

	public void setUserOneType(String userOneType) {
		this.userOneType = userOneType;
	}

	public String getUsrCode() {
		return usrCode;
	}

	public void setUsrCode(String usrCode) {
		this.usrCode = usrCode;
	}

	public String getUsrFor() {
		return usrFor;
	}

	public void setUsrFor(String usrFor) {
		this.usrFor = usrFor;
	}

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public String getUsrContact() {
		return usrContact;
	}

	public void setUsrContact(String usrContact) {
		this.usrContact = usrContact;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsrNum() {
		return usrNum;
	}

	public void setUsrNum(String usrNum) {
		this.usrNum = usrNum;
	}

	@Override
	public String toString() {
		return "WhUserType [urdId=" + urdId + ", userOneType=" + userOneType + ", usrCode=" + usrCode + ", usrFor="
				+ usrFor + ", usrEmail=" + usrEmail + ", usrContact=" + usrContact + ", userType=" + userType
				+ ", usrNum=" + usrNum + "]";
	}

}
