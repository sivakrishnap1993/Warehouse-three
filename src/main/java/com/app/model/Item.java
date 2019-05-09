package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue

	private Integer itemId;

	private String itmCode;

	private Double itmWidth;

	private Double itemHeight;

	private Double itemLength;

	private String baseCost;

	private String baseCurrency;

	private String note;

	@ManyToOne
	@JoinColumn(name = "uomIdFK")
	private Uom uom = new Uom();

	@ManyToOne
	@JoinColumn(name = "ordMIdFK")
	private OrderMethod om = new OrderMethod();

	@ManyToOne
	@JoinColumn(name = "urdIdFK")
	private WhUserType wuven = new WhUserType();

	@ManyToOne
	@JoinColumn(name = "urdIdFK1")
	private WhUserType wucust = new WhUserType();

	public Item() {
		super();
	}

	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}

	public Item(Integer itemId, String itmCode, Double itmWidth, Double itemHeight, Double itemLength, String baseCost,
			String baseCurrency, String note, Uom uom, OrderMethod om, WhUserType wuven, WhUserType wucust) {
		super();
		this.itemId = itemId;
		this.itmCode = itmCode;
		this.itmWidth = itmWidth;
		this.itemHeight = itemHeight;
		this.itemLength = itemLength;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.note = note;
		this.uom = uom;
		this.om = om;
		this.wuven = wuven;
		this.wucust = wucust;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItmCode() {
		return itmCode;
	}

	public void setItmCode(String itmCode) {
		this.itmCode = itmCode;
	}

	public Double getItmWidth() {
		return itmWidth;
	}

	public void setItmWidth(Double itmWidth) {
		this.itmWidth = itmWidth;
	}

	public Double getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(Double itemHeight) {
		this.itemHeight = itemHeight;
	}

	public Double getItemLength() {
		return itemLength;
	}

	public void setItemLength(Double itemLength) {
		this.itemLength = itemLength;
	}

	public String getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(String baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getOm() {
		return om;
	}

	public void setOm(OrderMethod om) {
		this.om = om;
	}

	public WhUserType getWuven() {
		return wuven;
	}

	public void setWuven(WhUserType wuven) {
		this.wuven = wuven;
	}

	public WhUserType getWucust() {
		return wucust;
	}

	public void setWucust(WhUserType wucust) {
		this.wucust = wucust;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itmCode=" + itmCode + ", itmWidth=" + itmWidth + ", itemHeight="
				+ itemHeight + ", itemLength=" + itemLength + ", baseCost=" + baseCost + ", baseCurrency="
				+ baseCurrency + ", note=" + note + ", uom=" + uom + ", om=" + om + ", wuven=" + wuven + ", wucust="
				+ wucust + "]";
	}

}
