package com.zt.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zt.dao.IBaseDao;
import com.zt.domain.TmMenu;
import com.zt.service.MenuService;

@Service(value = "menuService")
public class MenuServiceImpl extends BaseServiceImpl<TmMenu, String> implements
		MenuService {
	@Resource(name = "menuDao")
	@Override
	public void setBaseDao(IBaseDao<TmMenu, String> baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}

}
