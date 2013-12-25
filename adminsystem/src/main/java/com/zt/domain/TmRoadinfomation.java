/*
 * Name:TmRoadinfomation.java
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
@Table(name = "TM_ROADINFOMATION", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_ROADINFOMATION SET ISDELETE = '1' WHERE ROAD_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmRoadinfomation extends BaseEntity implements
		java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROAD_ID", unique = true, nullable = false)
	private String roadId;
	@Column(name = "CHINESENAME")
	private String chinesename;
	@Column(name = "ENGLISHNAME")
	private String englishname;
	@Column(name = "LEVEL_ID")
	private String levelId;
	@Column(name = "PARENTROAD_ID")
	private String parentroadId;
	@Column(name = "SAFERULES_ID")
	private String saferulesId;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ISSAMECAR")
	private String issamecar;
	@Column(name = "CARCOUNTS")
	private String carcounts;
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
	public TmRoadinfomation() {
	}

	/** full constructor */
	public TmRoadinfomation(String chinesename, String englishname,
			String levelId, String parentroadId, String saferulesId,
			String status, String issamecar, String carcounts, String creator,
			Timestamp createtime, Integer version, Boolean isdelete) {
		this.chinesename = chinesename;
		this.englishname = englishname;
		this.levelId = levelId;
		this.parentroadId = parentroadId;
		this.saferulesId = saferulesId;
		this.status = status;
		this.issamecar = issamecar;
		this.carcounts = carcounts;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getParentroadId() {
		return parentroadId;
	}

	public void setParentroadId(String parentroadId) {
		this.parentroadId = parentroadId;
	}

	public String getSaferulesId() {
		return saferulesId;
	}

	public void setSaferulesId(String saferulesId) {
		this.saferulesId = saferulesId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIssamecar() {
		return issamecar;
	}

	public void setIssamecar(String issamecar) {
		this.issamecar = issamecar;
	}

	public String getCarcounts() {
		return carcounts;
	}

	public void setCarcounts(String carcounts) {
		this.carcounts = carcounts;
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