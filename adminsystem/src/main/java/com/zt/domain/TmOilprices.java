/*
 * Name:TmOilprices.java
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
@Table(name = "TM_OILPRICES", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_OILPRICES SET ISDELETE = '1' WHERE OIL_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmOilprices extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "OIL_ID", unique = true, nullable = false)
	private String oilId;
	@Column(name = "OILTYPE_ID")
	private String oiltypeId;
	@Column(name = "OILPRICE")
	private String oilprice;
	@Column(name = "CUTDAY", length = 23)
	private Timestamp cutday;
	@Column(name = "CUTTIME", length = 23)
	private Timestamp cuttime;
	@Column(name = "UPDATERPEOPLE_ID")
	private String updaterpeopleId;
	@Column(name = "UPDATETIME", length = 23)
	private Timestamp updatetime;
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
	public TmOilprices() {
	}

	/** full constructor */
	public TmOilprices(String oiltypeId, String oilprice, Timestamp cutday,
			Timestamp cuttime, String updaterpeopleId, Timestamp updatetime,
			String creator, Timestamp createtime, Integer version,
			Boolean isdelete) {
		this.oiltypeId = oiltypeId;
		this.oilprice = oilprice;
		this.cutday = cutday;
		this.cuttime = cuttime;
		this.updaterpeopleId = updaterpeopleId;
		this.updatetime = updatetime;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getOilId() {
		return this.oilId;
	}

	public void setOilId(String oilId) {
		this.oilId = oilId;
	}

	public String getOiltypeId() {
		return this.oiltypeId;
	}

	public void setOiltypeId(String oiltypeId) {
		this.oiltypeId = oiltypeId;
	}

	public String getOilprice() {
		return this.oilprice;
	}

	public void setOilprice(String oilprice) {
		this.oilprice = oilprice;
	}

	public Timestamp getCutday() {
		return this.cutday;
	}

	public void setCutday(Timestamp cutday) {
		this.cutday = cutday;
	}

	public Timestamp getCuttime() {
		return this.cuttime;
	}

	public void setCuttime(Timestamp cuttime) {
		this.cuttime = cuttime;
	}

	public String getUpdaterpeopleId() {
		return this.updaterpeopleId;
	}

	public void setUpdaterpeopleId(String updaterpeopleId) {
		this.updaterpeopleId = updaterpeopleId;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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