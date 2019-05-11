package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shipping {

	@Id
	@GeneratedValue

	private Integer shipId;
	private String shipCode;
	private String shipRefNum;
	private String courRefNum;
	private String couCountdtls;
	private String shipDesc;
	private String billAddr;
	private String shipAddr;

	@ManyToOne
	@JoinColumn(name = "saleOrderIdFK")
	private SaleOrder saleOrder;

	public Shipping() {
		super();
	}

	public Shipping(Integer shipId) {
		super();
		this.shipId = shipId;
	}

	public Shipping(Integer shipId, String shipCode, String shipRefNum, String courRefNum, String couCountdtls,
			String shipDesc, String billAddr, String shipAddr, SaleOrder saleOrder) {
		super();
		this.shipId = shipId;
		this.shipCode = shipCode;
		this.shipRefNum = shipRefNum;
		this.courRefNum = courRefNum;
		this.couCountdtls = couCountdtls;
		this.shipDesc = shipDesc;
		this.billAddr = billAddr;
		this.shipAddr = shipAddr;
		this.saleOrder = saleOrder;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public String getShipRefNum() {
		return shipRefNum;
	}

	public void setShipRefNum(String shipRefNum) {
		this.shipRefNum = shipRefNum;
	}

	public String getCourRefNum() {
		return courRefNum;
	}

	public void setCourRefNum(String courRefNum) {
		this.courRefNum = courRefNum;
	}

	public String getCouCountdtls() {
		return couCountdtls;
	}

	public void setCouCountdtls(String couCountdtls) {
		this.couCountdtls = couCountdtls;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}

	public String getBillAddr() {
		return billAddr;
	}

	public void setBillAddr(String billAddr) {
		this.billAddr = billAddr;
	}

	public String getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(String shipAddr) {
		this.shipAddr = shipAddr;
	}

	public SaleOrder getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	@Override
	public String toString() {
		return "Shipping [shipId=" + shipId + ", shipCode=" + shipCode + ", shipRefNum=" + shipRefNum + ", courRefNum="
				+ courRefNum + ", couCountdtls=" + couCountdtls + ", shipDesc=" + shipDesc + ", billAddr=" + billAddr
				+ ", shipAddr=" + shipAddr + ", saleOrder=" + saleOrder + "]";
	}

}
