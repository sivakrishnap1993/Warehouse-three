package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleOrder {

	@Id
	@GeneratedValue

	private Integer salId;

	private String shpCode;

	private String refUser;

	private String stockMode;

	private String stockSource;

	private String defaultStatus;

	private String note;

	@ManyToOne
	@JoinColumn(name = "urdIdFK")
	private WhUserType custuser = new WhUserType();

	public SaleOrder() {
		super();
	}

	public SaleOrder(Integer salId) {
		super();
		this.salId = salId;
	}

	public SaleOrder(Integer salId, String shpCode, String refUser, String stockMode, String stockSource,
			String defaultStatus, String note, WhUserType custuser) {
		super();
		this.salId = salId;
		this.shpCode = shpCode;
		this.refUser = refUser;
		this.stockMode = stockMode;
		this.stockSource = stockSource;
		this.defaultStatus = defaultStatus;
		this.note = note;
		this.custuser = custuser;
	}

	public Integer getSalId() {
		return salId;
	}

	public void setSalId(Integer salId) {
		this.salId = salId;
	}

	public String getShpCode() {
		return shpCode;
	}

	public void setShpCode(String shpCode) {
		this.shpCode = shpCode;
	}

	public String getRefUser() {
		return refUser;
	}

	public void setRefUser(String refUser) {
		this.refUser = refUser;
	}

	public String getStockMode() {
		return stockMode;
	}

	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}

	public String getStockSource() {
		return stockSource;
	}

	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public WhUserType getCustuser() {
		return custuser;
	}

	public void setCustuser(WhUserType custuser) {
		this.custuser = custuser;
	}

	@Override
	public String toString() {
		return "SaleOrder [salId=" + salId + ", shpCode=" + shpCode + ", refUser=" + refUser + ", stockMode="
				+ stockMode + ", stockSource=" + stockSource + ", defaultStatus=" + defaultStatus + ", note=" + note
				+ ", custuser=" + custuser + "]";
	}

}