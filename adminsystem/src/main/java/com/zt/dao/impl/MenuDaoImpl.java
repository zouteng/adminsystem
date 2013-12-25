package com.zt.dao.impl;

import org.springframework.stereotype.Repository;

import com.zt.dao.MenuDao;
import com.zt.domain.TmMenu;

@Repository(value = "menuDao")
public class MenuDaoImpl extends BaseDaoImpl<TmMenu, String> implements MenuDao {

}
