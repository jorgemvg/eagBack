package com.wog.eag.administracion.aplicaciones.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AD_WINDOW")
public class Window {

	@Id
	@Column(name="AD_WINDOW_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adWindowId;
	
	@Column(name="AD_MODULE_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adModuleId;
	
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

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="HELP")
	private String help;

	@Column(name="WINDOWTYPE")
	private String windowtype;
	
	@Column(name="ISSOTRX")
	private String issotrx;
	
	@Column(name="ENTITYTYPE")
	private String entitytype;
	
	@Column(name="PROCESSING")
	private String processing;
	
	@Column(name="AD_IMAGE_ID")
	private BigDecimal adImageId;
	
	@Column(name="AD_COLOR_ID")
	private BigDecimal adColorId;
	
	@Column(name="ISDEFAULT")
	private String isdefault;
	
	@Column(name="NUMTABS")
	private BigDecimal numtabs;

	public BigDecimal getAdWindowId() {
		return adWindowId;
	}

	public void setAdWindowId(BigDecimal adWindowId) {
		this.adWindowId = adWindowId;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getWindowtype() {
		return windowtype;
	}

	public void setWindowtype(String windowtype) {
		this.windowtype = windowtype;
	}

	public String getIssotrx() {
		return issotrx;
	}

	public void setIssotrx(String issotrx) {
		this.issotrx = issotrx;
	}

	public String getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}

	public String getProcessing() {
		return processing;
	}

	public void setProcessing(String processing) {
		this.processing = processing;
	}

	public BigDecimal getAdImageId() {
		return adImageId;
	}

	public void setAdImageId(BigDecimal adImageId) {
		this.adImageId = adImageId;
	}

	public BigDecimal getAdColorId() {
		return adColorId;
	}

	public void setAdColorId(BigDecimal adColorId) {
		this.adColorId = adColorId;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public BigDecimal getNumtabs() {
		return numtabs;
	}

	public void setNumtabs(BigDecimal numtabs) {
		this.numtabs = numtabs;
	}	
	
}