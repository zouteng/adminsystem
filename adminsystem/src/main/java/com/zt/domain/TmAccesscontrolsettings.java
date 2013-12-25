/*
 * Name:TmAccesscontrolsettings.java
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
@Table(name = "TM_ACCESSCONTROLSETTINGS", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_ACCESSCONTROLSETTINGS SET ISDELETE = '1' WHERE SETTINGS_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmAccesscontrolsettings extends BaseEntity implements
		java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SETTINGS_ID", unique = true, nullable = false)
	private String settingsId;
	@Column(name = "AREA")
	private String area;
	@Column(name = "CONTROLNUMBER")
	private String controlnumber;
	@Column(name = "CONTROLSTATUS_ID")
	private String controlstatusId;
	@Column(name = "ISSAMECARIN")
	private Boolean issamecarin;
	@Column(name = "CARCOUNT")
	private Integer carcount;
	@Column(name = "DEFAULTROAD_ID")
	private String defaultroadId;
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
	public TmAccesscontrolsettings() {
	}

	/** full constructor */
	public TmAccesscontrolsettings(String area, String controlnumber,
			String controlstatusId, Boolean issamecarin, Integer carcount,
			String defaultroadId, String creator, Timestamp createtime,
			Integer version, Boolean isdelete) {
		this.area = area;
		this.controlnumber = controlnumber;
		this.controlstatusId = controlstatusId;
		this.issamecarin = issamecarin;
		this.carcount = carcount;
		this.defaultroadId = defaultroadId;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getSettingsId() {
		return this.settingsId;
	}

	public void setSettingsId(String settingsId) {
		this.settingsId = settingsId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getControlnumber() {
		return this.controlnumber;
	}

	public void setControlnumber(String controlnumber) {
		this.controlnumber = controlnumber;
	}

	public String getControlstatusId() {
		return this.controlstatusId;
	}

	public void setControlstatusId(String controlstatusId) {
		this.controlstatusId = controlstatusId;
	}

	public Boolean getIssamecarin() {
		return this.issamecarin;
	}

	public void setIssamecarin(Boolean issamecarin) {
		this.issamecarin = issamecarin;
	}

	public Integer getCarcount() {
		return this.carcount;
	}

	public void setCarcount(Integer carcount) {
		this.carcount = carcount;
	}

	public String getDefaultroadId() {
		return this.defaultroadId;
	}

	public void setDefaultroadId(String defaultroadId) {
		this.defaultroadId = defaultroadId;
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