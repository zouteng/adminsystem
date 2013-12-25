/*
 * Name:TsActionLogs.java
 * Version:1.0
 * Author:zot
 * Date:2013/10/30
 */
package com.zt.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TS_ACTION_LOGS", schema = "dbo", catalog = "AdminSystem")
public class TsActionLogs extends BaseEntity implements java.io.Serializable {
	// Fields
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "CONTROLLER")
	private String controller;
	@Column(name = "ACTION_NAME")
	private String actionName;
	@Column(name = "TERMIN_ID")
	private String terminId;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATE_TIME", length = 23)
	private Timestamp createTime;
	@Column(name = "VERSION")
	private Integer version;
	@Column(name = "CREATOR")
	private String creator;
	@Column(name = "ISDELETE")
	private Boolean isdelete;

	// Constructors
	/** default constructor */
	public TsActionLogs() {
	}

	/** full constructor */
	public TsActionLogs(String username, String controller, String actionName,
			String terminId, String description, Timestamp createTime,
			Integer version, String creator, Boolean isdelete) {
		this.username = username;
		this.controller = controller;
		this.actionName = actionName;
		this.terminId = terminId;
		this.description = description;
		this.createTime = createTime;
		this.version = version;
		this.creator = creator;
		this.isdelete = isdelete;
	}

	// Property accessors
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getTerminId() {
		return terminId;
	}

	public void setTerminId(String terminId) {
		this.terminId = terminId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}
}