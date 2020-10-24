package com.erp.store.config;

public class StoreExcelData {
	
	private String unitname;
	private boolean status;
	private String discription;
	private String type;
	private double conversionid;
	private String conversionValue;
	
	
	
	
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getConversionid() {
		return conversionid;
	}
	public void setConversionid(double conversionid) {
		this.conversionid = conversionid;
	}
	public String getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(String conversionValue) {
		this.conversionValue = conversionValue;
	}

	public int hashCode() {
	    return 31 + type.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreExcelData other = (StoreExcelData) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StoreExcelData [unitname=" + unitname + ", status=" + status + ", discription=" + discription
				+ ", type=" + type + ", conversionid=" + conversionid + ", conversionValue=" + conversionValue + "]";
	}
	
	
	

}
