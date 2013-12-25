/*
 * Name:TsDiccategoryd.java
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TS_DICCATEGORYD", schema = "dbo", catalog = "AdminSystem")
public class TsDiccategoryd extends BaseEntity implements java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DICCATEGORY_ID", unique = true, nullable = false, length = 36)
	private String diccategoryId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TREE_CODE")
	private String treeCode;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PARENT_ID", length = 36)
	private String parentId;
	@Column(name = "LEAF")
	private Boolean leaf;
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;
	@Column(name = "ISDELETE")
	private Boolean isdelete;
	@Column(name = "VERSION")
	private Integer version;
	@Column(name = "NODE_LEVEL")
	private Integer nodeLevel;
	@Column(name = "INDEX_FIELD")
	private Integer indexField;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsDiccategoryd")
	private Set<TsDictionary> tsDictionaries = new HashSet<TsDictionary>(0);

	// Constructors
	/** default constructor */
	public TsDiccategoryd() {
	}

	/** full constructor */
	public TsDiccategoryd(String name, String treeCode, String description,
			String parentId, Boolean leaf, Timestamp createtime,
			Boolean isdelete, Integer version, Integer nodeLevel,
			Integer indexField, Set<TsDictionary> tsDictionaries) {
		this.name = name;
		this.treeCode = treeCode;
		this.description = description;
		this.parentId = parentId;
		this.leaf = leaf;
		this.createtime = createtime;
		this.isdelete = isdelete;
		this.version = version;
		this.nodeLevel = nodeLevel;
		this.indexField = indexField;
		this.tsDictionaries = tsDictionaries;
	}

	// Property accessors
	public String getDiccategoryId() {
		return diccategoryId;
	}

	public void setDiccategoryId(String diccategoryId) {
		this.diccategoryId = diccategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getNodeLevel() {
		return nodeLevel;
	}

	public void setNodeLevel(Integer nodeLevel) {
		this.nodeLevel = nodeLevel;
	}

	public Integer getIndexField() {
		return indexField;
	}

	public void setIndexField(Integer indexField) {
		this.indexField = indexField;
	}

	public Set<TsDictionary> getTsDictionaries() {
		return tsDictionaries;
	}

	public void setTsDictionaries(Set<TsDictionary> tsDictionaries) {
		this.tsDictionaries = tsDictionaries;
	}
}