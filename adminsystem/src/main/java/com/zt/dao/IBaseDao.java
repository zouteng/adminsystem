package com.zt.dao;

import java.io.Serializable;
import java.util.List;
import com.zt.domain.BaseEntity;


public interface IBaseDao<T extends BaseEntity, PK extends Serializable> {

	public void save(T model);

	public void saveOrUpdate(T model);

	public void update(T model);

	public void merge(T model);

	public void delete(PK id);

	public void delete(Class<T> entityClass, PK id);
	
	public void deleteObject(T model);

	public T get(PK id);

	boolean exists(PK id);

	public List<T> listAll();
	
	public int countAll(Class<T> entityClass);
	
	public int countAll(Class<T> entityClass,List list);
	
   public List<T> listPage(int page, int size);
    
    public List<T> listByhql(String hql);
    
    public List<T> listPage(int page, int size,List list);
	
}
