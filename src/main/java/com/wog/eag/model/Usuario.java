package com.wog.eag.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Table(name= "AD_USER")
@Entity(name = "Usuario")
public class Usuario {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AD_USER_ID", columnDefinition="decimal", precision=10, scale=0)
	private BigDecimal adUserId;
	
	
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
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;

//	   SUPERVISOR_ID decimal(10,0),
//	   PA_GOAL_ID decimal(10,0),
//	   PA_GOALPRIVATE_ID decimal(10,0),
//	   C_BPARTNER_ID decimal(10,0),
//	   PROCESSING char(1),
//	   EMAILUSER varchar(20),
//	   EMAILUSERPW varchar(40),
//	   C_BPARTNER_LOCATION_ID decimal(10,0),
//	   C_GREETING_ID decimal(10,0),
//	   TITLE varchar(40),
//	   COMMENTS varchar(2000),
//	   PHONE varchar(40),
//	   PHONE2 varchar(40),
//	   FAX varchar(40),
//	   LASTCONTACT timestamp,
//	   LASTRESULT varchar(255),
//	   BIRTHDAY timestamp,
//	   AD_ORGTRX_ID decimal(10,0),
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="USERNAME")
	private String username;
	
//	    varchar(60),
//	    varchar(60),
//	    varchar(60),
	
//	   DEFAULT_AD_CLIENT_ID decimal(10,0),
//	   DEFAULT_AD_LANGUAGE varchar(6),
//	   DEFAULT_AD_ORG_ID decimal(10,0),
//	   DEFAULT_AD_ROLE_ID decimal(10,0),
//	   DEFAULT_M_WAREHOUSE_ID decimal(10,0),
//	   CHANGEPASS_REQUIRED char(1) DEFAULT 'N' NOT NULL,
//	   STATUS char(3),
//	   C_CURRENCY_ID decimal(10,0),
//	   NUMBER_BADLOGIN decimal(2,0),
//	   DEFAULT_MAXREG_XPAGE char(3),
//	   LASTLOGIN timestamp,
//	   LAST_PASS_UPDATED timestamp,
//	   AMTAPPROVAL decimal(18,2),
//	   BPARTNER_TYPE char(3),
//	   INTERNAL_USER char(1) DEFAULT 'N' NOT NULL,
//	   MOBILE decimal(15,0),
//	   CU_CUSTUMERMASTER_ID decimal(10,0),
//	   IDENTIFICATION_TYPE decimal(10,0),
//	   DATE_END date,
//	   DOCUMENT_EXPEDITION date,
//	   GENDER char(1),
//	   IS_SYSTEMUSER char(1) DEFAULT 'N' NOT NULL,
//	   IDENTIFICATION varchar(30),
//	   REGISTER_REQUIRED char(1) DEFAULT 'N' NOT NULL,
//	   SAFETY_PHRASE varchar(250),
//	   SAFETY_IMAGE varchar(120),
//	   ENTRY_START_TIME char(5),
//	   ENTRY_END_TIME char(5),
//	   ENTRY_SCHEDULE_TYPE char(2)
	
	public BigDecimal getAdUserId() {
		return adUserId;
	}

	public void setAdUserId(BigDecimal adUserId) {
		this.adUserId = adUserId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	   
	   

	
}
