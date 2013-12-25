/*
 * Name:TmPricemanage.java
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
@Table(name = "TM_PRICEMANAGE", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TM_PRICEMANAGE SET ISDELETE = '1' WHERE PRICE_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TmPricemanage extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PRICE_ID", unique = true, nullable = false)
	private String priceId;
	@Column(name = "PRICEPROJECT_ID")
	private String priceprojectId;
	@Column(name = "PRICEPROJECTSUBCLASS_ID")
	private String priceprojectsubclassId;
	@Column(name = "CUSTOMTYPE_ID")
	private String customtypeId;
	@Column(name = "WBSNUMBER")
	private String wbsnumber;
	@Column(name = "ACTIVITYTYPE")
	private String activitytype;
	@Column(name = "PRICEUNIT")
	private String priceunit;
	@Column(name = "PRICE")
	private String price;
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
	public TmPricemanage() {
	}

	/** full constructor */
	public TmPricemanage(String priceprojectId, String priceprojectsubclassId,
			String customtypeId, String wbsnumber, String activitytype,
			String priceunit, String price, String creator,
			Timestamp createtime, Integer version, Boolean isdelete) {
		this.priceprojectId = priceprojectId;
		this.priceprojectsubclassId = priceprojectsubclassId;
		this.customtypeId = customtypeId;
		this.wbsnumber = wbsnumber;
		this.activitytype = activitytype;
		this.priceunit = priceunit;
		this.price = price;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getPriceId() {
		return this.priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getPriceprojectId() {
		return this.priceprojectId;
	}

	public void setPriceprojectId(String priceprojectId) {
		this.priceprojectId = priceprojectId;
	}

	public String getPriceprojectsubclassId() {
		return this.priceprojectsubclassId;
	}

	public void setPriceprojectsubclassId(String priceprojectsubclassId) {
		this.priceprojectsubclassId = priceprojectsubclassId;
	}

	public String getCustomtypeId() {
		return this.customtypeId;
	}

	public void setCustomtypeId(String customtypeId) {
		this.customtypeId = customtypeId;
	}

	public String getWbsnumber() {
		return this.wbsnumber;
	}

	public void setWbsnumber(String wbsnumber) {
		this.wbsnumber = wbsnumber;
	}

	public String getActivitytype() {
		return this.activitytype;
	}

	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}

	public String getPriceunit() {
		return this.priceunit;
	}

	public void setPriceunit(String priceunit) {
		this.priceunit = priceunit;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
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