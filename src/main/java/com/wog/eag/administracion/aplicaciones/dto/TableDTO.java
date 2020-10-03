package com.wog.eag.administracion.aplicaciones.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


public class TableDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigDecimal adTableId;
	private BigDecimal adModuleId;
	private BigDecimal adClientId;
	private BigDecimal adOrgId;
	private String isactive;
	private Timestamp created;
	private BigDecimal createdby;
	private Timestamp updated;
	private BigDecimal updatedby;
	private String name;
	private String description;
	private String help;
	private String tablename;
	private String isview;
	private String accesslevel;
	private String entitytype;
	private BigDecimal adWindowId;
	private BigDecimal adValRuleId;
	private BigDecimal loadseq;
	private String issecurityenabled;
	private String isdeleteable;
	private String ishighvolume;
	private String importtable;
	private String ischangelog;
	private String replicationtype;
	private BigDecimal poWindowId;
	private String isdefaultacct;
	private String sqlRecordIdentifier;
	private String developmentstatus;
	private String istableoftable;
	private String tableoftablefield;	
	private String isrelationtable;
	public BigDecimal getAdTableId() {
		return adTableId;
	}
	public void setAdTableId(BigDecimal adTableId) {
		this.adTableId = adTableId;
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
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getIsview() {
		return isview;
	}
	public void setIsview(String isview) {
		this.isview = isview;
	}
	public String getAccesslevel() {
		return accesslevel;
	}
	public void setAccesslevel(String accesslevel) {
		this.accesslevel = accesslevel;
	}
	public String getEntitytype() {
		return entitytype;
	}
	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}
	public BigDecimal getAdWindowId() {
		return adWindowId;
	}
	public void setAdWindowId(BigDecimal adWindowId) {
		this.adWindowId = adWindowId;
	}
	public BigDecimal getAdValRuleId() {
		return adValRuleId;
	}
	public void setAdValRuleId(BigDecimal adValRuleId) {
		this.adValRuleId = adValRuleId;
	}
	public BigDecimal getLoadseq() {
		return loadseq;
	}
	public void setLoadseq(BigDecimal loadseq) {
		this.loadseq = loadseq;
	}
	public String getIssecurityenabled() {
		return issecurityenabled;
	}
	public void setIssecurityenabled(String issecurityenabled) {
		this.issecurityenabled = issecurityenabled;
	}
	public String getIsdeleteable() {
		return isdeleteable;
	}
	public void setIsdeleteable(String isdeleteable) {
		this.isdeleteable = isdeleteable;
	}
	public String getIshighvolume() {
		return ishighvolume;
	}
	public void setIshighvolume(String ishighvolume) {
		this.ishighvolume = ishighvolume;
	}
	public String getImporttable() {
		return importtable;
	}
	public void setImporttable(String importtable) {
		this.importtable = importtable;
	}
	public String getIschangelog() {
		return ischangelog;
	}
	public void setIschangelog(String ischangelog) {
		this.ischangelog = ischangelog;
	}
	public String getReplicationtype() {
		return replicationtype;
	}
	public void setReplicationtype(String replicationtype) {
		this.replicationtype = replicationtype;
	}
	public BigDecimal getPoWindowId() {
		return poWindowId;
	}
	public void setPoWindowId(BigDecimal poWindowId) {
		this.poWindowId = poWindowId;
	}
	public String getIsdefaultacct() {
		return isdefaultacct;
	}
	public void setIsdefaultacct(String isdefaultacct) {
		this.isdefaultacct = isdefaultacct;
	}
	public String getSqlRecordIdentifier() {
		return sqlRecordIdentifier;
	}
	public void setSqlRecordIdentifier(String sqlRecordIdentifier) {
		this.sqlRecordIdentifier = sqlRecordIdentifier;
	}
	public String getDevelopmentstatus() {
		return developmentstatus;
	}
	public void setDevelopmentstatus(String developmentstatus) {
		this.developmentstatus = developmentstatus;
	}
	public String getIstableoftable() {
		return istableoftable;
	}
	public void setIstableoftable(String istableoftable) {
		this.istableoftable = istableoftable;
	}
	public String getTableoftablefield() {
		return tableoftablefield;
	}
	public void setTableoftablefield(String tableoftablefield) {
		this.tableoftablefield = tableoftablefield;
	}
	public String getIsrelationtable() {
		return isrelationtable;
	}
	public void setIsrelationtable(String isrelationtable) {
		this.isrelationtable = isrelationtable;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}