package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Uom {

	@Id
	@GeneratedValue
	private Integer uomId;
	private String uonType;
	private String uomCode;
	private String uomEnable;
	private String metaCode;
	private String adjst;
	private String note;

	public Uom() {
		super();
	}

	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}

	public Uom(Integer uomId, String uonType, String uomCode, String uomEnable, String metaCode, String adjst,
			String note) {
		super();
		this.uomId = uomId;
		this.uonType = uonType;
		this.uomCode = uomCode;
		this.uomEnable = uomEnable;
		this.metaCode = metaCode;
		this.adjst = adjst;
		this.note = note;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUonType() {
		return uonType;
	}

	public void setUonType(String uonType) {
		this.uonType = uonType;
	}

	public String getUomCode() {
		return uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getUomEnable() {
		return uomEnable;
	}

	public void setUomEnable(String uomEnable) {
		this.uomEnable = uomEnable;
	}

	public String getMetaCode() {
		return metaCode;
	}

	public void setMetaCode(String metaCode) {
		this.metaCode = metaCode;
	}

	public String getAdjst() {
		return adjst;
	}

	public void setAdjst(String adjst) {
		this.adjst = adjst;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uonType=" + uonType + ", uomCode=" + uomCode + ", uomEnable=" + uomEnable
				+ ", metaCode=" + metaCode + ", adjst=" + adjst + ", note=" + note + "]";
	}

}
