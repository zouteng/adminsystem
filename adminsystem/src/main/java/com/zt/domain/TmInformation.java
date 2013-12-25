/*
 * Name:TmInformation.java
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
@Table(name = "TM_INFORMATION", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_INFORMATION SET ISDELETE = '1' WHERE INFORMATION_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmInformation extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "INFORMATION_ID", unique = true, nullable = false)
	private String informationId;
	@Column(name = "LEVEL")
	private Boolean level;
	@Column(name = "TARGET")
	private String target;
	@Column(name = "SCREEN")
	private Boolean screen;
	@Column(name = "PERIODOFVALIDAITY")
	private String periodofvalidaity;
	@Column(name = "UNIT_ID")
	private String unitId;
	@Column(name = "ISSUER")
	private String issuer;
	@Column(name = "ISSUTIME", length = 23)
	private Timestamp issutime;
	@Column(name = "CONTENT")
	private String content;
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
	public TmInformation() {
	}

	/** full constructor */
	public TmInformation(Boolean level, String target, Boolean screen,
			String periodofvalidaity, String unitId, String issuer,
			Timestamp issutime, String content, String creator,
			Timestamp createtime, Integer version, Boolean isdelete) {
		this.level = level;
		this.target = target;
		this.screen = screen;
		this.periodofvalidaity = periodofvalidaity;
		this.unitId = unitId;
		this.issuer = issuer;
		this.issutime = issutime;
		this.content = content;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getInformationId() {
		return this.informationId;
	}

	public void setInformationId(String informationId) {
		this.informationId = informationId;
	}

	public Boolean getLevel() {
		return this.level;
	}

	public void setLevel(Boolean level) {
		this.level = level;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Boolean getScreen() {
		return this.screen;
	}

	public void setScreen(Boolean screen) {
		this.screen = screen;
	}

	public String getPeriodofvalidaity() {
		return this.periodofvalidaity;
	}

	public void setPeriodofvalidaity(String periodofvalidaity) {
		this.periodofvalidaity = periodofvalidaity;
	}

	public String getUnitId() {
		return this.unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getIssuer() {
		return this.issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Timestamp getIssutime() {
		return this.issutime;
	}

	public void setIssutime(Timestamp issutime) {
		this.issutime = issutime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}
}