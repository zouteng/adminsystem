/*
 * Name:TmDevicemanagement.java
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
@Table(name = "TM_DEVICEMANAGEMENT", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_DEVICEMANAGEMENT SET ISDELETE = '1' WHERE DEVICE_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmDevicemanagement extends BaseEntity implements
		java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DEVICE_ID", unique = true, nullable = false)
	private String deviceId;
	@Column(name = "DEVICETYPE_ID")
	private String devicetypeId;
	@Column(name = "DEVICESTATUS_ID")
	private String devicestatusId;
	@Column(name = "INOUTTYPE")
	private Boolean inouttype;
	@Column(name = "INUSECARID")
	private String inusecarid;
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
	public TmDevicemanagement() {
	}

	/** full constructor */
	public TmDevicemanagement(String devicetypeId, String devicestatusId,
			Boolean inouttype, String inusecarid, String creator,
			Timestamp createtime, Integer version, Boolean isdelete) {
		this.devicetypeId = devicetypeId;
		this.devicestatusId = devicestatusId;
		this.inouttype = inouttype;
		this.inusecarid = inusecarid;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDevicetypeId() {
		return this.devicetypeId;
	}

	public void setDevicetypeId(String devicetypeId) {
		this.devicetypeId = devicetypeId;
	}

	public String getDevicestatusId() {
		return this.devicestatusId;
	}

	public void setDevicestatusId(String devicestatusId) {
		this.devicestatusId = devicestatusId;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Boolean getInouttype() {
		return inouttype;
	}

	public void setInouttype(Boolean inouttype) {
		this.inouttype = inouttype;
	}

	public String getInusecarid() {
		return inusecarid;
	}

	public void setInusecarid(String inusecarid) {
		this.inusecarid = inusecarid;
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
}