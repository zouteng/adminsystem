/*
 * Name:TsMenuPermission.java
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "TS_MENU_PERMISSION", schema = "dbo", catalog = "AdminSystem")
@SQLDelete(sql="UPDATE TS_MENU_PERMISSION SET ISDELETE = '1' WHERE MENU_PERMISSION_ID = ?")
@Where(clause="ISDELETE <> '1'")
public class TsMenuPermission extends BaseEntity implements
		java.io.Serializable {
	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MENU_PERMISSION_ID", unique = true, nullable = false)
	private String menuPermissionId;
	@Column(name = "ACTION_NAME")
	private String actionName;
	@Column(name = "CONTROLLER_NAME")
	private String controllerName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ICON1")
	private String icon1;
	@Column(name = "ICON2")
	private String icon2;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PARENT_ID")
	private String _parentId;
	@Column(name = "TREE_CODE")
	private String treeCode;
	@Column(name = "LEAF")
	private Boolean leaf;
	@Column(name = "URL")
	private String url;
	@Column(name = "ISEXTPAGE")
	private Boolean isextpage;
	@Column(name = "INDEX_FIELD")
	private Integer indexField;
	@Column(name = "CREATETIME", length = 23)
	private Timestamp createtime;
	@Column(name = "ISDELETE")
	private Boolean isdelete;
	@Column(name = "VERSION")
	private Integer version;
	@Column(name = "NODE_LEVEL")
	private Integer nodeLevel;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "tsMenuPermissions")
	@Where(clause="ISDELETE <> '1'")
	private Set<TsRole> tsRoles = new HashSet<TsRole>(0);

	// Constructors
	/** default constructor */
	public TsMenuPermission() {
	}

	/** full constructor */
	public TsMenuPermission(String actionName, String controllerName,
			String description, String icon1, String icon2, String name,
			String _parentId, String treeCode, Boolean leaf, String url,
			Boolean isextpage, Integer indexField, Timestamp createtime,
			Boolean isdelete, Integer version, Integer nodeLevel,
			Set<TsRole> tsRoles) {
		this.actionName = actionName;
		this.controllerName = controllerName;
		this.description = description;
		this.icon1 = icon1;
		this.icon2 = icon2;
		this.name = name;
		this._parentId = _parentId;
		this.treeCode = treeCode;
		this.leaf = leaf;
		this.url = url;
		this.isextpage = isextpage;
		this.indexField = indexField;
		this.createtime = createtime;
		this.isdelete = isdelete;
		this.version = version;
		this.nodeLevel = nodeLevel;
		this.tsRoles = tsRoles;
	}

	// Property accessors
	public String getMenuPermissionId() {
		return menuPermissionId;
	}

	public void setMenuPermissionId(String menuPermissionId) {
		this.menuPermissionId = menuPermissionId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon1() {
		return icon1;
	}

	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}

	public String getIcon2() {
		return icon2;
	}

	public void setIcon2(String icon2) {
		this.icon2 = icon2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String get_parentId() {
		return _parentId;
	}

	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}

	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsextpage() {
		return isextpage;
	}

	public void setIsextpage(Boolean isextpage) {
		this.isextpage = isextpage;
	}

	public Integer getIndexField() {
		return indexField;
	}

	public void setIndexField(Integer indexField) {
		this.indexField = indexField;
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

	public Set<TsRole> getTsRoles() {
		return tsRoles;
	}

	public void setTsRoles(Set<TsRole> tsRoles) {
		this.tsRoles = tsRoles;
	}
}