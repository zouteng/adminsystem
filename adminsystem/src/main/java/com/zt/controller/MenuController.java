package com.zt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zt.domain.TmMenu;
import com.zt.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	MenuService menuService;

	@RequestMapping("menu/listAll")
	@ResponseBody
	public List<TmMenu> getAll() {
		return menuService.listAll();
	}
	
	
	@RequestMapping("menu/tree")
	@ResponseBody
	public Map<String, Object> getAccessControlSettings(Map<String, Object> map) {
	
		List<TmMenu> menulist = menuService.listAll();
		map.put("menus", menulist); // rows
		return map;
	}
}
