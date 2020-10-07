package com.wog.eag.administracion.aplicaciones.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ToolbarDTO {

	private BigDecimal sequence;
	private String name;
	private String screenType;
	private BigDecimal adToolbarbuttonId;
	private String description;
	private String action;
	private String displayLogic;
	private String isactive;
	private BigDecimal adTabToolbarId;
	private BigDecimal adTabId;
	private BigDecimal adClientId;
	private BigDecimal adOrgId;

//Auditoria
	private Timestamp created;
	private BigDecimal createdby;
	private Timestamp updated;
	private BigDecimal updatedby;

	public BigDecimal getSequence() {
		return sequence;
	}
	public void setSequence(BigDecimal sequence) {
		this.sequence = sequence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public BigDecimal getAdToolbarbuttonId() {
		return adToolbarbuttonId;
	}
	public void setAdToolbarbuttonId(BigDecimal adToolbarbuttonId) {
		this.adToolbarbuttonId = adToolbarbuttonId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDisplayLogic() {
		return displayLogic;
	}
	public void setDisplayLogic(String displayLogic) {
		this.displayLogic = displayLogic;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public BigDecimal getAdTabToolbarId() {
		return adTabToolbarId;
	}
	public void setAdTabToolbarId(BigDecimal adTabToolbarId) {
		this.adTabToolbarId = adTabToolbarId;
	}
	public BigDecimal getAdTabId() {
		return adTabId;
	}
	public void setAdTabId(BigDecimal adTabId) {
		this.adTabId = adTabId;
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