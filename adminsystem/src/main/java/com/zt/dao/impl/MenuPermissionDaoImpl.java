/**
 * name:MenuPermissionDaoImpl.java
 * author:zot
 * version:1.0
 * date:2013/11/5
 */
package com.zt.dao.impl;

import org.springframework.stereotype.Repository;
import com.zt.dao.MenuPermissionDao;
import com.zt.domain.TsMenuPermission;

@Repository(value = "menuPermissionDao")
public class MenuPermissionDaoImpl extends
		BaseDaoImpl<TsMenuPermission, String> implements MenuPermissionDao {

}
