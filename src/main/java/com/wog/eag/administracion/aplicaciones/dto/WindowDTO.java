package com.wog.eag.administracion.aplicaciones.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class WindowDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String help;
	private BigDecimal numtabs;
	private String isactive;
	private BigDecimal adWindowId;
	private String windowtype;
	private BigDecimal adClientId;
	private BigDecimal adOrgId;
	private String processing;
	private BigDecimal adColorId;
	private BigDecimal adImageId;
	private String issotrx;
	private String isdefault;
	private BigDecimal adModuleId;
	private String entitytype;

//Auditoria
	private Timestamp created;
	private BigDecimal createdby;
	private Timestamp updated;
	private BigDecimal updatedby;

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
	public BigDecimal getNumtabs() {
		return numtabs;
	}
	public void setNumtabs(BigDecimal numtabs) {
		this.numtabs = numtabs;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public BigDecimal getAdWindowId() {
		return adWindowId;
	}
	public void setAdWindowId(BigDecimal adWindowId) {
		this.adWindowId = adWindowId;
	}
	public String getWindowtype() {
		return windowtype;
	}
	public void setWindowtype(String windowtype) {
		this.windowtype = windowtype;
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
	public String getProcessing() {
		return processing;
	}
	public void setProcessing(String processing) {
		this.processing = processing;
	}
	public BigDecimal getAdColorId() {
		return adColorId;
	}
	public void setAdColorId(BigDecimal adColorId) {
		this.adColorId = adColorId;
	}
	public BigDecimal getAdImageId() {
		return adImageId;
	}
	public void setAdImageId(BigDecimal adImageId) {
		this.adImageId = adImageId;
	}
	public String getIssotrx() {
		return issotrx;
	}
	public void setIssotrx(String issotrx) {
		this.issotrx = issotrx;
	}
	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	public BigDecimal getAdModuleId() {
		return adModuleId;
	}
	public void setAdModuleId(BigDecimal adModuleId) {
		this.adModuleId = adModuleId;
	}
	public String getEntitytype() {
		return entitytype;
	}
	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
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
}