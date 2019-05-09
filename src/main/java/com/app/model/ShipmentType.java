package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipmenttab")
public class ShipmentType {

	@Id
	@GeneratedValue
	@Column(name = "sid")
	private Integer shipmentId;
	@Column(name = "smode")
	private String shipmentMode;
	@Column(name = "scode")
	private String shipmentCode;
	@Column(name = "senable")
	private String enableShipment;
	@Column(name = "sgrade")
	private String shipmentGrade;
	@Column(name = "snote")
	private String note;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer shipmentId) {
		super();
		this.shipmentId = shipmentId;
	}
	public ShipmentType(Integer shipmentId, String shipmentMode, String shipmentCode, String enableShipment,
			String shipmentGrade, String note) {
		super();
		this.shipmentId = shipmentId;
		this.shipmentMode = shipmentMode;
		this.shipmentCode = shipmentCode;
		this.enableShipment = enableShipment;
		this.shipmentGrade = shipmentGrade;
		this.note = note;
	}
	public Integer getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(Integer shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getEnableShipment() {
		return enableShipment;
	}
	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "ShipmentType [shipmentId=" + shipmentId + ", shipmentMode=" + shipmentMode + ", shipmentCode="
				+ shipmentCode + ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade + ", note="
				+ note + "]";
	}

	
	
}
