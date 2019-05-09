package com.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderMethod {

	@Id
	@GeneratedValue
	private Integer ordMId;
	private String ordMode;
	private String ordCode;
	private String ordExType;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> ordAccept;
	private String note;

	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer ordMId) {
		super();
		this.ordMId = ordMId;
	}

	public OrderMethod(Integer ordMId, String ordMode, String ordCode, String ordExType, List<String> ordAccept,
			String note) {
		super();
		this.ordMId = ordMId;
		this.ordMode = ordMode;
		this.ordCode = ordCode;
		this.ordExType = ordExType;
		this.ordAccept = ordAccept;
		this.note = note;
	}

	public Integer getOrdMId() {
		return ordMId;
	}

	public void setOrdMId(Integer ordMId) {
		this.ordMId = ordMId;
	}

	public String getOrdMode() {
		return ordMode;
	}

	public void setOrdMode(String ordMode) {
		this.ordMode = ordMode;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public String getOrdExType() {
		return ordExType;
	}

	public void setOrdExType(String ordExType) {
		this.ordExType = ordExType;
	}

	public List<String> getOrdAccept() {
		return ordAccept;
	}

	public void setOrdAccept(List<String> ordAccept) {
		this.ordAccept = ordAccept;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "OrderMethod [ordMId=" + ordMId + ", ordMode=" + ordMode + ", ordCode=" + ordCode + ", ordExType="
				+ ordExType + ", ordAccept=" + ordAccept + ", note=" + note + "]";
	}

}
