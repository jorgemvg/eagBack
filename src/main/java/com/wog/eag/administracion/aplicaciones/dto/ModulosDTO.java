package com.wog.eag.administracion.aplicaciones.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


public class ModulosDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigDecimal adModuleId;
	private BigDecimal adClientId;
	private BigDecimal adOrgId;
	private String isactive;
	private Timestamp created;
	private BigDecimal createdby;
	private Timestamp updated;
	private BigDecimal updatedby;
	private String name;
	private BigDecimal adApplicationId;
	private String addtables;
	private String packageRoot;
	
	public BigDecimal getAdModuleId() {
		return adModuleId;
	}
	public void setAdModuleId(BigDecimal adModuleId) {
		this.adModuleId = adModuleId;
	}
	public BigDecimal getAdClientId() {
		return adClientId;
	}
	public void setAdClientId(BigDecimal adClientId) {
		this.adClientId = adClientId;
	}
	public BigDecimal getAdOrgId() {
		return adOrgId;
	}
	public void setAdOrgId(BigDecimal adOrgId) {
		this.adOrgId = adOrgId;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public BigDecimal getCreatedby() {
		return createdby;
	}
	public void setCreatedby(BigDecimal createdby) {
		this.createdby = createdby;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public BigDecimal getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(BigDecimal updatedby) {
		this.updatedby = updatedby;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAdApplicationId() {
		return adApplicationId;
	}
	public void setAdApplicationId(BigDecimal adApplicationId) {
		this.adApplicationId = adApplicationId;
	}
	public String getAddtables() {
		return addtables;
	}
	public void setAddtables(String addtables) {
		this.addtables = addtables;
	}
	public String getPackageRoot() {
		return packageRoot;
	}
	public void setPackageRoot(String packageRoot) {
		this.packageRoot = packageRoot;
	}

}