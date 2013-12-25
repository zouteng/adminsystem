/*
 * Name:TmTestspecification.java
 * Version:1.0
 * Author:zot
 * Date:2013/10/30
 */
package com.zt.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "TM_TESTSPECIFICATION", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_TESTSPECIFICATION SET ISDELETE = '1' WHERE SPECIFICATION_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmTestspecification extends BaseEntity implements
		java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SPECIFICATION_ID", unique = true, nullable = false)
	private String specificationId;
	@Column(name = "SPECIFICATIONNAME")
	private String specificationname;
	@Column(name = "SCOPE")
	private String scope;
	@Column(name = "ROAD_ID")
	private String roadId;
	@Column(name = "LENGTH")
	private String length;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "ROADSTATUS_ID")
	private String roadstatusId;
	@Column(name = "CREATOR", length = 24)
	private String creator;
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;
	@Column(name = "VERSION")
	private Integer version;
	@Column(name = "ISDELETE")
	private Boolean isdelete;
	
	@Column(name = "APPLYUNIT")
	private String applyunit;
	@Column(name = "APPLYDEPARTMENT")
	private String applydepartment;
	@Column(name = "EVALUATERESULT")
	private String evaluateresult;
	@Column(name = "SECURITYLEVEL")
	private String securitylevel;
	@Column(name = "SPECIFICATIONCATAGORY")
	private String specificationcategory;
	@Column(name = "SPECIFICATIONSTATUS")
	private String specificationstatus;

	// Constructors
	/** default constructor */
	public TmTestspecification() {
	}

	/** full constructor */
	public TmTestspecification(String specificationname, String scope,
			String roadId, String length, String content, String roadstatusId,
			String creator, Timestamp createtime, Integer version,
			Boolean isdelete) {
		this.specificationname = specificationname;
		this.scope = scope;
		this.roadId = roadId;
		this.length = length;
		this.content = content;
		this.roadstatusId = roadstatusId;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(String specificationId) {
		this.specificationId = specificationId;
	}

	public String getSpecificationname() {
		return specificationname;
	}

	public void setSpecificationname(String specificationname) {
		this.specificationname = specificationname;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRoadstatusId() {
		return roadstatusId;
	}

	public void setRoadstatusId(String roadstatusId) {
		this.roadstatusId = roadstatusId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public String getApplyunit() {
		return applyunit;
	}

	public void setApplyunit(String applyunit) {
		this.applyunit = applyunit;
	}

	public String getApplydepartment() {
		return applydepartment;
	}

	public void setApplydepartment(String applydepartment) {
		this.applydepartment = applydepartment;
	}

	public String getEvaluateresult() {
		return evaluateresult;
	}

	public void setEvaluateresult(String evaluateresult) {
		this.evaluateresult = evaluateresult;
	}

	public String getSecuritylevel() {
		return securitylevel;
	}

	public void setSecuritylevel(String securitylevel) {
		this.securitylevel = securitylevel;
	}

	public String getSpecificationcategory() {
		return specificationcategory;
	}

	public void setSpecificationcatagory(String specificationcategory) {
		this.specificationcategory = specificationcategory;
	}

	public String getSpecificationstatus() {
		return specificationstatus;
	}

	public void setSpecificationstatus(String specificationstatus) {
		this.specificationstatus = specificationstatus;
	}
	
	
}