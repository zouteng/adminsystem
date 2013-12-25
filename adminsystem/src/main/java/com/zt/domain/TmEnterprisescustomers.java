/*
 * Name:TmEnterprisescustomers.java
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
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.Where;
@Entity
@Table(name = "TM_ENTERPRISESCUSTOMERS", schema = "dbo", catalog = "AdminSystem")
// Override the default hibernate delete and set the deleted flag rather than
// deleting the record from the db.
@SQLDelete(sql = "UPDATE TM_ENTERPRISESCUSTOMERS SET ISDELETE = '1' WHERE ENTERPRISES_ID = ?")
// Filter added to retrieve only records that have not been soft deleted.
@Where(clause = "ISDELETE <> '1'")
public class TmEnterprisescustomers extends BaseEntity implements
		java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ENTERPRISES_ID", unique = true, nullable = false)
	private String enterprisesId;
	
	@Version
	@Column(name = "VERSION")
	private Integer version;
	
	@Column(name = "CHINESENAME")
	private String chinesename;
	@Column(name = "ENGLISHNAME")
	private String englishname;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ZIPCODE")
	private String zipcode;
	@Column(name = "TEL")
	private String tel;
	@Column(name = "FAX")
	private String fax;
	@Column(name = "DEPOSITBANK")
	private String depositbank;
	@Column(name = "ACCOUNTS")
	private String accounts;
	@Column(name = "TYPE_ID")
	private String typeId;
	@Column(name = "RELATION_ID")
	private String relationId;
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "CREATOR", length = 24)
	private String creator;
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;

	

	@Column(name = "ISDELETE")
	private Boolean isdelete;

	// Constructors
	/** default constructor */
	public TmEnterprisescustomers() {
	}

	/** full constructor */
	public TmEnterprisescustomers(String chinesename, String englishname,
			String address, String country, String zipcode, String tel,
			String fax, String depositbank, String accounts, String typeId,
			String relationId, String number, String creator,
			Timestamp createtime, Integer version, Boolean isdelete) {
		this.chinesename = chinesename;
		this.englishname = englishname;
		this.address = address;
		this.country = country;
		this.zipcode = zipcode;
		this.tel = tel;
		this.fax = fax;
		this.depositbank = depositbank;
		this.accounts = accounts;
		this.typeId = typeId;
		this.relationId = relationId;
		this.number = number;
		this.creator = creator;
		this.createtime = createtime;
		this.version = version;
		this.isdelete = isdelete;
	}

	// Property accessors
	public String getEnterprisesId() {
		return this.enterprisesId;
	}

	public void setEnterprisesId(String enterprisesId) {
		this.enterprisesId = enterprisesId;
	}

	public String getChinesename() {
		return this.chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getEnglishname() {
		return this.englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDepositbank() {
		return this.depositbank;
	}

	public void setDepositbank(String depositbank) {
		this.depositbank = depositbank;
	}

	public String getAccounts() {
		return this.accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getRelationId() {
		return this.relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
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