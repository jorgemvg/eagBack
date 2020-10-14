package com.wog.eag.administracion.aplicaciones.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class TabDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String label;
	private String description;
	private String help;
	private BigDecimal adTableId;
	private String entitytype;
	private BigDecimal seqno;
	private BigDecimal tablevel;
	private String issinglerow;
	private String isreadonly;
	private String hastree;
	private String whereclause;
	private String orderbyclause;
	private String displayLogic;
	private String canCopyEntity;
	private String hasfile;
	private String hasDynamicFields;
	private String adDynEntityType;
	private String adDynEntityRef;
	private BigDecimal adDinamicTabId;
	private String importfields;
	private String isactive;
	private String showpagelist;
	private String showpageview;
	private BigDecimal adWindowId;
	private BigDecimal adClientId;
	private String istranslationtab;
	private BigDecimal adOrgId;
	private BigDecimal adColumnId;
	private String commitwarning;
	private BigDecimal adProcessId;
	private String processing;
	private String issorttab;
	private BigDecimal adColumnsortorderId;
	private BigDecimal adImageId;
	private BigDecimal includedTabId;
	private String filterclause;
	private BigDecimal editreference;
	private String hasAuditory;
	private String isinfotab;
	private String showpageedit;
	private BigDecimal adTabId;
	private BigDecimal adColumnsortyesnoId;
	private String confSaveMobile;
	private String dinamicTable;
	private String fileTable;

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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public BigDecimal getAdTableId() {
		return adTableId;
	}
	public void setAdTableId(BigDecimal adTableId) {
		this.adTableId = adTableId;
	}
	public String getEntitytype() {
		return entitytype;
	}
	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}
	public BigDecimal getSeqno() {
		return seqno;
	}
	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
	}
	public BigDecimal getTablevel() {
		return tablevel;
	}
	public void setTablevel(BigDecimal tablevel) {
		this.tablevel = tablevel;
	}
	public String getIssinglerow() {
		return issinglerow;
	}
	public void setIssinglerow(String issinglerow) {
		this.issinglerow = issinglerow;
	}
	public String getIsreadonly() {
		return isreadonly;
	}
	public void setIsreadonly(String isreadonly) {
		this.isreadonly = isreadonly;
	}
	public String getHastree() {
		return hastree;
	}
	public void setHastree(String hastree) {
		this.hastree = hastree;
	}
	public String getWhereclause() {
		return whereclause;
	}
	public void setWhereclause(String whereclause) {
		this.whereclause = whereclause;
	}
	public String getOrderbyclause() {
		return orderbyclause;
	}
	public void setOrderbyclause(String orderbyclause) {
		this.orderbyclause = orderbyclause;
	}
	public String getDisplayLogic() {
		return displayLogic;
	}
	public void setDisplayLogic(String displayLogic) {
		this.displayLogic = displayLogic;
	}
	public String getCanCopyEntity() {
		return canCopyEntity;
	}
	public void setCanCopyEntity(String canCopyEntity) {
		this.canCopyEntity = canCopyEntity;
	}
	public String getHasfile() {
		return hasfile;
	}
	public void setHasfile(String hasfile) {
		this.hasfile = hasfile;
	}
	public String getHasDynamicFields() {
		return hasDynamicFields;
	}
	public void setHasDynamicFields(String hasDynamicFields) {
		this.hasDynamicFields = hasDynamicFields;
	}
	public String getAdDynEntityType() {
		return adDynEntityType;
	}
	public void setAdDynEntityType(String adDynEntityType) {
		this.adDynEntityType = adDynEntityType;
	}
	public String getAdDynEntityRef() {
		return adDynEntityRef;
	}
	public void setAdDynEntityRef(String adDynEntityRef) {
		this.adDynEntityRef = adDynEntityRef;
	}
	public BigDecimal getAdDinamicTabId() {
		return adDinamicTabId;
	}
	public void setAdDinamicTabId(BigDecimal adDinamicTabId) {
		this.adDinamicTabId = adDinamicTabId;
	}
	public String getImportfields() {
		return importfields;
	}
	public void setImportfields(String importfields) {
		this.importfields = importfields;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getShowpagelist() {
		return showpagelist;
	}
	public void setShowpagelist(String showpagelist) {
		this.showpagelist = showpagelist;
	}
	public String getShowpageview() {
		return showpageview;
	}
	public void setShowpageview(String showpageview) {
		this.showpageview = showpageview;
	}
	public BigDecimal getAdWindowId() {
		return adWindowId;
	}
	public void setAdWindowId(BigDecimal adWindowId) {
		this.adWindowId = adWindowId;
	}
	public BigDecimal getAdClientId() {
		return adClientId;
	}
	public void setAdClientId(BigDecimal adClientId) {
		this.adClientId = adClientId;
	}
	public String getIstranslationtab() {
		return istranslationtab;
	}
	public void setIstranslationtab(String istranslationtab) {
		this.istranslationtab = istranslationtab;
	}
	public BigDecimal getAdOrgId() {
		return adOrgId;
	}
	public void setAdOrgId(BigDecimal adOrgId) {
		this.adOrgId = adOrgId;
	}
	public BigDecimal getAdColumnId() {
		return adColumnId;
	}
	public void setAdColumnId(BigDecimal adColumnId) {
		this.adColumnId = adColumnId;
	}
	public String getCommitwarning() {
		return commitwarning;
	}
	public void setCommitwarning(String commitwarning) {
		this.commitwarning = commitwarning;
	}
	public BigDecimal getAdProcessId() {
		return adProcessId;
	}
	public void setAdProcessId(BigDecimal adProcessId) {
		this.adProcessId = adProcessId;
	}
	public String getProcessing() {
		return processing;
	}
	public void setProcessing(String processing) {
		this.processing = processing;
	}
	public String getIssorttab() {
		return issorttab;
	}
	public void setIssorttab(String issorttab) {
		this.issorttab = issorttab;
	}
	public BigDecimal getAdColumnsortorderId() {
		return adColumnsortorderId;
	}
	public void setAdColumnsortorderId(BigDecimal adColumnsortorderId) {
		this.adColumnsortorderId = adColumnsortorderId;
	}
	public BigDecimal getAdImageId() {
		return adImageId;
	}
	public void setAdImageId(BigDecimal adImageId) {
		this.adImageId = adImageId;
	}
	public BigDecimal getIncludedTabId() {
		return includedTabId;
	}
	public void setIncludedTabId(BigDecimal includedTabId) {
		this.includedTabId = includedTabId;
	}
	public String getFilterclause() {
		return filterclause;
	}
	public void setFilterclause(String filterclause) {
		this.filterclause = filterclause;
	}
	public BigDecimal getEditreference() {
		return editreference;
	}
	public void setEditreference(BigDecimal editreference) {
		this.editreference = editreference;
	}
	public String getHasAuditory() {
		return hasAuditory;
	}
	public void setHasAuditory(String hasAuditory) {
		this.hasAuditory = hasAuditory;
	}
	public String getIsinfotab() {
		return isinfotab;
	}
	public void setIsinfotab(String isinfotab) {
		this.isinfotab = isinfotab;
	}
	public String getShowpageedit() {
		return showpageedit;
	}
	public void setShowpageedit(String showpageedit) {
		this.showpageedit = showpageedit;
	}
	public BigDecimal getAdTabId() {
		return adTabId;
	}
	public void setAdTabId(BigDecimal adTabId) {
		this.adTabId = adTabId;
	}
	public BigDecimal getAdColumnsortyesnoId() {
		return adColumnsortyesnoId;
	}
	public void setAdColumnsortyesnoId(BigDecimal adColumnsortyesnoId) {
		this.adColumnsortyesnoId = adColumnsortyesnoId;
	}
	public String getConfSaveMobile() {
		return confSaveMobile;
	}
	public void setConfSaveMobile(String confSaveMobile) {
		this.confSaveMobile = confSaveMobile;
	}
	public String getDinamicTable() {
		return dinamicTable;
	}
	public void setDinamicTable(String dinamicTable) {
		this.dinamicTable = dinamicTable;
	}
	public String getFileTable() {
		return fileTable;
	}
	public void setFileTable(String fileTable) {
		this.fileTable = fileTable;
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