package com.wog.eag.administracion.aplicaciones.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AD_MODULE")
public class Modulos {

	@Id
	@Column(name="AD_MODULE_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adModuleId;
	
	@Column(name="AD_APPLICATION_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adApplicationId;
	
	@Column(name="AD_CLIENT_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adClientId;
	
	@Column(name="AD_ORG_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adOrgId;
	
	@Column(name="ISACTIVE", columnDefinition="char")
	private String isactive;
	
	@Column(name="CREATED")
	private Timestamp created;
	
	@Column(name="CREATEDBY", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal createdby;
	
	@Column(name="UPDATED")
	private Timestamp updated;
	
	@Column(name="UPDATEDBY", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal updatedby;

	@Column(name="NAME")
	private String name;

	@Column(name="ADDTABLES", columnDefinition="char")
	private String addtables;
	
	@Column(name="PACKAGE_ROOT")
	private String packageRoot;

	public BigDecimal getAdModuleId() {
		return adModuleId;
	}

	public void setAdModuleId(BigDecimal adModuleId) {
		this.adModuleId = adModuleId;
	}

	public BigDecimal getAdApplicationId() {
		return adApplicationId;
	}

	public void setAdApplicationId(BigDecimal adApplicationId) {
		this.adApplicationId = adApplicationId;
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