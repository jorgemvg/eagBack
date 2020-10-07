package com.wog.eag.administracion.aplicaciones.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
@Entity
@IdClass(ToolbarPk.class)
@Table(name="AD_TAB_TOOLBAR")
public class ToolbarEntity {

	@Column(name="SEQUENCE")
	private BigDecimal sequence;

	@Column(name="NAME")
	private String name;

	@Column(name="SCREEN_TYPE")
	private String screenType;

	@Id
	@Column(name="AD_TOOLBARBUTTON_ID")
	private BigDecimal adToolbarbuttonId;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="ACTION")
	private String action;

	@Column(name="DISPLAY_LOGIC")
	private String displayLogic;

	@Column(name="ISACTIVE")
	private String isactive;

	@Id
	@Column(name="AD_TAB_TOOLBAR_ID")
	private BigDecimal adTabToolbarId;

	@Column(name="AD_TAB_ID")
	private BigDecimal adTabId;

	@Column(name="AD_CLIENT_ID")
	private BigDecimal adClientId;

	@Column(name="AD_ORG_ID")
	private BigDecimal adOrgId;


//Auditoria
	@Column(name="CREATED")
	private Timestamp created;
	
	@Column(name="CREATEDBY", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal createdby;
	
	@Column(name="UPDATED")
	private Timestamp updated;
	
	@Column(name="UPDATEDBY", columnDefinition="decimal", precision=10, scale=0)
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