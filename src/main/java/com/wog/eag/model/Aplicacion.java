package com.wog.eag.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AD_APPLICATION")
public class Aplicacion {

	@Id
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
	
	@Column(name="CODE_APPLICATION")
	private String codeApplication;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="DRIVERCLASS")
	private String driverclass;
	
	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DATABASENAME")
	private String databasename;
	
	@Column(name="PACKAGE_ROOT")
	private String packageRoot;
	
	@Column(name="CONTEXT_ROOT")
	private String contextRoot;
	
	@Column(name="DATABASE_TYPE")
	private String databaseType;
	
	@Column(name="ISPUBLIC")
	private String ispublic;
	
	
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
	public String getCodeApplication() {
		return codeApplication;
	}
	public void setCodeApplication(String codeApplication) {
		this.codeApplication = codeApplication;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriverclass() {
		return driverclass;
	}
	public void setDriverclass(String driverclass) {
		this.driverclass = driverclass;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabasename() {
		return databasename;
	}
	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}
	public String getPackageRoot() {
		return packageRoot;
	}
	public void setPackageRoot(String packageRoot) {
		this.packageRoot = packageRoot;
	}
	public String getContextRoot() {
		return contextRoot;
	}
	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}
	public String getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	public String getIspublic() {
		return ispublic;
	}
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}

}
