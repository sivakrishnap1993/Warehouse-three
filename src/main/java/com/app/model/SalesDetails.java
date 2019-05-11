package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class SalesDetails {

	@Id
	@GeneratedValue

	private Integer salesDtlsId;

	private Integer soHoId;

	@Transient
	private int slNo;

	private Long quantity;

	private String shipStatus;

	private Double baseCost;

	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;

	public SalesDetails() {
		super();
	}

	public SalesDetails(Integer salesDtlsId) {
		super();
		this.salesDtlsId = salesDtlsId;
	}

	public SalesDetails(Integer salesDtlsId, Integer soHoId, int slNo, Long quantity, String shipStatus,
			Double baseCost, Item item) {
		super();
		this.salesDtlsId = salesDtlsId;
		this.soHoId = soHoId;
		this.slNo = slNo;
		this.quantity = quantity;
		this.shipStatus = shipStatus;
		this.baseCost = baseCost;
		this.item = item;
	}

	public Integer getSalesDtlsId() {
		return salesDtlsId;
	}

	public void setSalesDtlsId(Integer salesDtlsId) {
		this.salesDtlsId = salesDtlsId;
	}

	public Integer getSoHoId() {
		return soHoId;
	}

	public void setSoHoId(Integer soHoId) {
		this.soHoId = soHoId;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SalesDetails [salesDtlsId=" + salesDtlsId + ", soHoId=" + soHoId + ", slNo=" + slNo + ", quantity="
				+ quantity + ", shipStatus=" + shipStatus + ", baseCost=" + baseCost + ", item=" + item + "]";
	}

}
