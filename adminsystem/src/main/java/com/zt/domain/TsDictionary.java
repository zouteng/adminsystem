/*
 * Name:TsDictionary.java
 * Version:1.0
 * Author:zot
 * Date:2013/10/30
 */
package com.zt.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TS_DICTIONARY", schema = "dbo", catalog = "AdminSystem")
public class TsDictionary extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DICTIONARY_ID", unique = true, nullable = false, length = 36)
	private String dictionaryId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DICCATEGORY_ID")
	private TsDiccategoryd tsDiccategoryd;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CODE")
	private String code;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "INPUT_CODE2")
	private String inputCode2;
	@Column(name = "INPUT_CODE1")
	private String inputCode1;
	@Column(name = "INPUT_CODE3")
	private String inputCode3;
	@Column(name = "INDEX_FIELD")
	private Integer indexField;
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;
	@Column(name = "ISDELETE")
	private Boolean isdelete;
	@Column(name = "VERSION")
	private Integer version;

	// Constructors
	/** default constructor */
	public TsDictionary() {
	}

	/** full constructor */
	public TsDictionary(TsDiccategoryd tsDiccategoryd, String name,
			String code, String description, String inputCode2,
			String inputCode1, String inputCode3, Integer indexField,
			Timestamp createtime, Boolean isdelete, Integer version) {
		this.tsDiccategoryd = tsDiccategoryd;
		this.name = name;
		this.code = code;
		this.description = description;
		this.inputCode2 = inputCode2;
		this.inputCode1 = inputCode1;
		this.inputCode3 = inputCode3;
		this.indexField = indexField;
		this.createtime = createtime;
		this.isdelete = isdelete;
		this.version = version;
	}

	// Property accessors
	public String getDictionaryId() {
		return this.dictionaryId;
	}

	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public TsDiccategoryd getTsDiccategoryd() {
		return this.tsDiccategoryd;
	}

	public void setTsDiccategoryd(TsDiccategoryd tsDiccategoryd) {
		this.tsDiccategoryd = tsDiccategoryd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInputCode2() {
		return this.inputCode2;
	}

	public void setInputCode2(String inputCode2) {
		this.inputCode2 = inputCode2;
	}

	public String getInputCode1() {
		return this.inputCode1;
	}

	public void setInputCode1(String inputCode1) {
		this.inputCode1 = inputCode1;
	}

	public String getInputCode3() {
		return this.inputCode3;
	}

	public void setInputCode3(String inputCode3) {
		this.inputCode3 = inputCode3;
	}

	public Integer getIndexField() {
		return this.indexField;
	}

	public void setIndexField(Integer indexField) {
		this.indexField = indexField;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}