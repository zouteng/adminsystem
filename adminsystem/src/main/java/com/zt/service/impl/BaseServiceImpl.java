package com.zt.service.impl;

import java.io.Serializable;
import java.util.List;

import com.zt.domain.BaseEntity;
import com.zt.dao.IBaseDao;
import com.zt.service.IBaseService;

public class BaseServiceImpl<T extends BaseEntity, PK extends Serializable>
		implements IBaseService<T, PK> {
	protected IBaseDao<T, PK> baseDao;

	public void setBaseDao(IBaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T save(T model) {
		baseDao.save(model);
		return model;
	}

	@Override
	public void saveOrUpdate(T model) {
		baseDao.saveOrUpdate(model);
	}

	@Override
	public void update(T model) {
		baseDao.update(model);
	}

	@Override
	public void deleteObject(T model) {
		baseDao.deleteObject(model);
	}

	@Override
	public List<T> listAll() {
		return baseDao.listAll();
	}

	@Override
	public void delete(Class<T> entityClass, PK id) {
		// TODO Auto-generated method stub
		System.out.println("删除BaseService中方法" + id);
		baseDao.delete(entityClass, id);
	}

	@Override
	public T get(Class<T> entityClass, PK id) {
		return baseDao.get(id);
	}

	@Override
	public int countAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return baseDao.countAll(entityClass);
	}

	@Override
	public List<T> listPage(int page, int size) {
		// TODO Auto-generated method stub
		return baseDao.listPage(page, size);
	}

	@Override
	public List<T> listByhql(String hql) {
		// TODO Auto-generated method stub
		return baseDao.listByhql(hql);
	}

	@Override
	public List<T> listPage(int page, int size, List list) {
		// TODO Auto-generated method stub
		System.out.print("page"+page);
		return baseDao.listPage(page, size, list);
	}

	@Override
	public int countAll(Class<T> entityClass, List list) {
		// TODO Auto-generated method stub
		return baseDao.countAll(entityClass, list);
	}
}
