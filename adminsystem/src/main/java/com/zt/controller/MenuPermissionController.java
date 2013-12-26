/*
 * Name:MenuPermissionController.java
 * Version:1.0
 * Author:zot
 * Date:2013/11/7
 */
package com.zt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zt.util.MenuNode;
import com.zt.domain.TmMenu;
import com.zt.domain.TsMenuPermission;
import com.zt.service.MenuPermissionService;

@Controller
public class MenuPermissionController {
	@Autowired
	MenuPermissionService menuPermissionService;

	@RequestMapping("menuPermission/menutree")
	@ResponseBody
	public Map<String, Object> getTreeMenu(Map<String, Object> map) {
		List<TsMenuPermission> menupermissionlist = menuPermissionService
				.listAll();
		// 获取总记录数
		int totalRows = menuPermissionService.countAll(TsMenuPermission.class);
		map.put("total", totalRows); // total
		map.put("rows", menupermissionlist); // rows
		return map;
	}

	// jQuery easyui tree
	@RequestMapping("roleManage/menutree")
	@ResponseBody
	public Map<String, Object> getMenuTree(Map<String, Object> map) {
		
		List<MenuNode> menulist =this.generateTree();
		map.put("menus", menulist); // rows
		return map;
	}
	
	
	
	
	
	public List<MenuNode> generateTree() {
		String hql = "from TsMenuPermission where _parentId='' ";
		ArrayList<MenuNode> treeAry = new ArrayList<MenuNode>();
		List<TsMenuPermission> tsp = menuPermissionService.listByhql(hql);
		for (TsMenuPermission ts : tsp) {
			MenuNode tn = new MenuNode();
			tn.setMenuid(ts.getMenuPermissionId());
			tn.setMenuname(ts.getName());
			tn.setIcon(ts.getIcon1());
			tn.setUrl(ts.getUrl());
			tn.setMenus(this.getChildren(ts.getMenuPermissionId()));
			treeAry.add(tn);
		}
		return treeAry;
	}

	// 递归得到某个节点的子节点 
	private ArrayList<MenuNode> getChildren(String id) {

		String hql = "from TsMenuPermission where _parentId='" + id + "'";
		ArrayList<MenuNode> treeAry = new ArrayList<MenuNode>();
		List<TsMenuPermission> tsp = menuPermissionService.listByhql(hql);
		for (TsMenuPermission ts : tsp) {
			MenuNode tn = new MenuNode();
			tn.setMenuid(ts.getMenuPermissionId());
			tn.setMenuname(ts.getName());
			tn.setIcon(ts.getIcon1());
			tn.setUrl(ts.getUrl());
			// tn.setChildren(this.getChildren(ts.getMenuPermissionId()));
			treeAry.add(tn);
		}
		return treeAry;
	}

}
