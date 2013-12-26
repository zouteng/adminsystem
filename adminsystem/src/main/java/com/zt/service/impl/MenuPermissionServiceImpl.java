/**
 * name:MenuPermissionServiceImpl.java
 * author:zot
 * version:1.0
 * date:2013/11/5
 */
package com.zt.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zt.dao.IBaseDao;
import com.zt.domain.TsMenuPermission;
import com.zt.service.MenuPermissionService;

@Service(value = "menuPermissionService")
public class MenuPermissionServiceImpl extends
		BaseServiceImpl<TsMenuPermission, String> implements
		MenuPermissionService {
	@Resource(name = "menuPermissionDao")
	@Override
	public void setBaseDao(IBaseDao<TsMenuPermission, String> baseDao) {
		// TODO Auto-generated method stub
		super.setBaseDao(baseDao);
	}
}
