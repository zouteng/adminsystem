package com.zt.service;

import java.io.Serializable;
import java.util.List;

import com.zt.domain.BaseEntity;

public interface IBaseService<T extends BaseEntity, PK extends Serializable> {
	public T save(T model);

	public void saveOrUpdate(T model);

	public void update(T model);

	public void delete(Class<T> entityClass, PK id);

	public void deleteObject(T model);

	public T get(Class<T> entityClass, PK id);

	public int countAll(Class<T> entityClass);
	
	public int countAll(Class<T> entityClass,List list);

	public List<T> listAll();

	public List<T> listPage(int page, int size);

	public List<T> listByhql(String hql);

	public List<T> listPage(int page, int size, List list);
}
