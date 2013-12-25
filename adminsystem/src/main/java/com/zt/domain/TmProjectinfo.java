/*
 * Name:TmProjectinfo.java
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
@Table(name = "TM_PROJECTINFO", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_PROJECTINFO SET ISDELETE = '1' WHERE PROJECT_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmProjectinfo extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROJECT_ID", unique = true, nullable = false)
	private String projectId;
	@Column(name = "OWNEDENTERPRISES_ID")
	private String ownedenterprisesId;
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "MANAGE_NAME")
	private String manageName;
	@Column(name = "BUDGET")
	private String budget;
	@Column(name = "COORDINATOR_NAME")
	private String coordinatorName;
	@Column(name = "COORDINATOR_TEL")
	private String coordinatorTel;
	@Column(name = "COORDINATOR_MAIL")
	private String coordinatorMail;
	@Column(name = "STATUS_ID")
	private String statusId;
	@Column(name = "TYPE_ID")
	private String typeId;
	@Column(name = "AGREEMENTTYPE_ID")
	private String agreementtypeId;
	@Column(name = "STARTTIME", length = 23)
	private Timestamp starttime;
	@Column(name = "ENDTIME", length = 23)
	private Timestamp endtime;
	@Column(name = "CREATOR", length = 24)
	private String creator;
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;
	@Column(name = "VERSION")
	private Integer version;
	@Column(name = "ISDELETE")
	private Boolean isdelete;

	// Constructors
	/** default constructor */
	public TmProjectinfo() {
	}

	/** full constructor */
	public TmProjectinfo(String ownedenterprisesId, String number,
			String manageName, String budget, String coordinatorName,
			String coordinatorTel, String coordinatorMail, String statusId,
			String typeId, String agreementtypeId, Timestamp starttime,
			Timestamp endtime, String creator, Timestamp createtime,
			Integer version, Boolean isdelete) {
		this.ownedenterprisesId = ownedenterprisesId;
		this.number = number;
		this.manageName = manageName;
		this.budget = budget;
		this.coordinatorName = coordinatorName;
		this.coordinatorTel = coordinatorTel;
		this.coordinatorMail = coordinatorMail;
		this.statusId = statusId;
		this.typeId = typeId;
		this.agreementtypeId = agreementtypeId;
		this.starttime = starttime;
		this.endtime = endtime;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getOwnedenterprisesId() {
		return ownedenterprisesId;
	}

	public void setOwnedenterprisesId(String ownedenterprisesId) {
		this.ownedenterprisesId = ownedenterprisesId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getCoordinatorTel() {
		return coordinatorTel;
	}

	public void setCoordinatorTel(String coordinatorTel) {
		this.coordinatorTel = coordinatorTel;
	}

	public String getCoordinatorMail() {
		return coordinatorMail;
	}

	public void setCoordinatorMail(String coordinatorMail) {
		this.coordinatorMail = coordinatorMail;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getAgreementtypeId() {
		return agreementtypeId;
	}

	public void setAgreementtypeId(String agreementtypeId) {
		this.agreementtypeId = agreementtypeId;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
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
}