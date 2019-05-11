package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Purchase {

	@Id
	@GeneratedValue
	private Integer ordId;
	private String ordCode;
	private String shipMode;
	private String refNo;
	private String qtyCk;
	private String ordSts;
	private String node;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipmentIdFK")
	private ShipmentType ship = new ShipmentType();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "urdIdFK")
	private WhUserType venwhuser = new WhUserType();

	// child items data
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id_fk")
	private List<PurchaseDtl> details = new ArrayList<>(0);

	public Purchase() {
		super();
	}

	public Purchase(Integer ordId) {
		super();
		this.ordId = ordId;
	}

	public Purchase(Integer ordId, String ordCode, String shipMode, String refNo, String qtyCk, String ordSts,
			String node, ShipmentType ship, WhUserType venwhuser, List<PurchaseDtl> details) {
		super();
		this.ordId = ordId;
		this.ordCode = ordCode;
		this.shipMode = shipMode;
		this.refNo = refNo;
		this.qtyCk = qtyCk;
		this.ordSts = ordSts;
		this.node = node;
		this.ship = ship;
		this.venwhuser = venwhuser;
		this.details = details;
	}

	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getQtyCk() {
		return qtyCk;
	}

	public void setQtyCk(String qtyCk) {
		this.qtyCk = qtyCk;
	}

	public String getOrdSts() {
		return ordSts;
	}

	public void setOrdSts(String ordSts) {
		this.ordSts = ordSts;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public ShipmentType getShip() {
		return ship;
	}

	public void setShip(ShipmentType ship) {
		this.ship = ship;
	}

	public WhUserType getVenwhuser() {
		return venwhuser;
	}

	public void setVenwhuser(WhUserType venwhuser) {
		this.venwhuser = venwhuser;
	}

	public List<PurchaseDtl> getDetails() {
		return details;
	}

	public void setDetails(List<PurchaseDtl> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Purchase [ordId=" + ordId + ", ordCode=" + ordCode + ", shipMode=" + shipMode + ", refNo=" + refNo
				+ ", qtyCk=" + qtyCk + ", ordSts=" + ordSts + ", node=" + node + ", ship=" + ship + ", venwhuser="
				+ venwhuser + ", details=" + details + "]";
	}

}
