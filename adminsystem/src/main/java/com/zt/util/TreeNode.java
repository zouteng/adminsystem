/*
 * Name:TreeNode.java
 * Version:1.0
 * Author:zot
 * Date:2013/11/14
 */
package com.zt.util;

import java.util.List;

public class TreeNode {
	private String id; // 要显示的子节点的ID
	private String text; // 要显示的子节点的 Text
	private String iconCls; // 节点的图标
	private String parentId; // 父节点的ID
	private List<TreeNode> children; // 孩子节点的List
	private String state;// 状态
	private boolean checked;

	public TreeNode() {
	}

	public TreeNode(String id, String text, String iconCls, String parentId,
			List<TreeNode> children, String state) {
		super();
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.parentId = parentId;
		this.children = children;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
