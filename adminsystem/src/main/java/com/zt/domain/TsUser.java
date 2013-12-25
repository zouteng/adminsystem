/*
 * Name:TsUser.java
 * Version:1.0
 * Author:zot
 * Date:2013/10/30
 */
package com.zt.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "TS_USER", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TS_USER SET ISDELETE = '1' WHERE USER_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TsUser extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private String userId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LOGIN_NAME")
	private String loginName;
	@Column(name = "PWD")
	private String pwd;
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
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;
	@Column(name = "ISDELETE")
	private Boolean isdelete;
	@Column(name = "VERSION")
	private Integer version;
	@Column(name = "STATE")
	private Integer state;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Where(clause="ISDELETE <> '1'")
	@JoinTable(name = "TS_DEPARTMENT_USER", schema = "dbo", catalog = "pgms", joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "DEPARTMENT_ID", nullable = false, updatable = false) })
	private Set<TsDepartment> tsDepartments = new HashSet<TsDepartment>(0);
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@Where(clause="ISDELETE <> '1'")
	@JoinTable(name = "TS_ROLE_USER", schema = "dbo", catalog = "pgms", joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	private Set<TsRole> tsRoles = new HashSet<TsRole>(0);

	// Constructors
	/** default constructor */
	public TsUser() {
	}

	/** full constructor */
	public TsUser(String name, String loginName, String pwd, String code,
			String description, String inputCode2, String inputCode1,
			String inputCode3, Timestamp createtime, Boolean isdelete,
			Integer version, Integer state, Set<TsDepartment> tsDepartments,
			Set<TsRole> tsRoles) {
		this.name = name;
		this.loginName = loginName;
		this.pwd = pwd;
		this.code = code;
		this.description = description;
		this.inputCode2 = inputCode2;
		this.inputCode1 = inputCode1;
		this.inputCode3 = inputCode3;
		this.createtime = createtime;
		this.isdelete = isdelete;
		this.version = version;
		this.state = state;
		this.tsDepartments = tsDepartments;
		this.tsRoles = tsRoles;
	}

	// Property accessors
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set<TsDepartment> getTsDepartments() {
		return this.tsDepartments;
	}

	public void setTsDepartments(Set<TsDepartment> tsDepartments) {
		this.tsDepartments = tsDepartments;
	}

	public Set<TsRole> getTsRoles() {
		return this.tsRoles;
	}

	public void setTsRoles(Set<TsRole> tsRoles) {
		this.tsRoles = tsRoles;
	}
}