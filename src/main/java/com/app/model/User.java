package com.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue

	private Integer useId;
	private String usrName;
	private String gender;
	private String usrMail;
	private String userMobile;
	private String usrPwd;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> usrRoles;

	public User() {
		super();
	}

	public User(Integer useId) {
		super();
		this.useId = useId;
	}

	public User(Integer useId, String usrName, String gender, String usrMail, String userMobile, String usrPwd,
			List<String> usrRoles) {
		super();
		this.useId = useId;
		this.usrName = usrName;
		this.gender = gender;
		this.usrMail = usrMail;
		this.userMobile = userMobile;
		this.usrPwd = usrPwd;
		this.usrRoles = usrRoles;
	}

	public Integer getUseId() {
		return useId;
	}

	public void setUseId(Integer useId) {
		this.useId = useId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsrMail() {
		return usrMail;
	}

	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	public List<String> getUsrRoles() {
		return usrRoles;
	}

	public void setUsrRoles(List<String> usrRoles) {
		this.usrRoles = usrRoles;
	}

	@Override
	public String toString() {
		return "User [useId=" + useId + ", usrName=" + usrName + ", gender=" + gender + ", usrMail=" + usrMail
				+ ", userMobile=" + userMobile + ", usrPwd=" + usrPwd + ", usrRoles=" + usrRoles + "]";
	}

}
