package com.zt.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import com.zt.domain.BaseEntity;
import com.zt.dao.IBaseDao;
import com.zt.util.DataFilter;

public class BaseDaoImpl<T extends BaseEntity, PK extends Serializable>
		implements IBaseDao<T, PK> {
	private final Class<T> entityClass;
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;
	private final String HQL_OPTIMIZE_PRE_LIST_ALL;
	private final String HQL_OPTIMIZE_NEXT_LIST_ALL;
	private String pkName = null;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("this.entityClass为：" + this.entityClass);
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Id.class)) {
				this.pkName = f.getName();
			}
		}
		System.out.println("pkName的值为：" + pkName);
		Assert.notNull(pkName);
		// TODO @Entity name not null
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName();
		// + " order by " + pkName + " desc";
		HQL_OPTIMIZE_PRE_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " where " + pkName + " > ? order by " + pkName + " asc";
		HQL_OPTIMIZE_NEXT_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " where " + pkName + " < ? order by " + pkName + " desc";
		HQL_COUNT_ALL = " select count(*) from "
				+ this.entityClass.getSimpleName();
	}

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(T model) {
		Transaction ts = null;
		Session session = null;
		try {
			// TODO Auto-generated method stub
			session = getSession();
			ts = session.beginTransaction();
			session.save(model);
			session.flush();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null)
				ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void saveOrUpdate(T model) {
		Transaction ts = null;
		Session session = null;
		try {
			// TODO Auto-generated method stub
			session = getSession();
			ts = session.beginTransaction();
			session.saveOrUpdate(model);
			session.flush();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null)
				ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void update(T model) {
		getSession().update(model);
	}

	@Override
	public void merge(T model) {
		getSession().merge(model);
	}

	@Override
	public void delete(PK id) {
		getSession().delete(this.get(id));
	}

	@Override
	public void deleteObject(T model) {
		getSession().delete(model);
	}

	@Override
	public boolean exists(PK id) {
		return get(id) != null;
	}

	@Override
	public T get(PK id) {
		return (T) getSession().get(this.entityClass, id);
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery(HQL_LIST_ALL).list();
	}

	@Override
	public int countAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(HQL_COUNT_ALL);
		int result = (new Integer(query.uniqueResult().toString())).intValue();
		return result;
	}

	@Override
	public void delete(Class<T> entityClass, PK id) {
		// TODO Auto-generated method stub
	
		Transaction ts = null;
		Session session = null;
		try {
			// TODO Auto-generated method stub
			session = getSession();
			ts = session.beginTransaction();
			session.delete(get(id));
		    session.flush();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null)
				ts.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<T> listPage(int page, int size) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(HQL_LIST_ALL)
				.setFirstResult((page - 1) * size).setMaxResults(size);
		return query.list();
	}

	@Override
	public List<T> listByhql(String hql) {
		// TODO Auto-generated method stub
		return getSession().createQuery(hql).list();
	}

	@Override
	public int countAll(Class<T> entityClass, List list) {
		// TODO Auto-generated method stub
		String strFilter = this.GetHqlstrByFilter(list, "a");
		String hql = HQL_COUNT_ALL + " as a "
				+ (isNotNullOrEmpty(strFilter) ? " where " + strFilter : "");
		Query query = getSession().createQuery(hql);
		int result = (new Integer(query.uniqueResult().toString())).intValue();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listPage(int page, int size, List list) {
		// TODO Auto-generated method stub
		String strFilter = this.GetHqlstrByFilter(list, "a");
		String hql = HQL_LIST_ALL + " as a "
				+ (isNotNullOrEmpty(strFilter) ? " where " + strFilter : "");
		return getSession().createQuery(hql).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	public String GetHqlstrByFilter(List<DataFilter> filters, String a) {
		if (filters == null || filters.isEmpty())
			return null;
		StringBuilder result = new StringBuilder();
		// type=String
		for (DataFilter df : filters) {
			if (df.type.equals("String") && isNotNullOrEmpty(df.value)) {
				result.append(a + "." + df.field + " like " + "'%" + df.value
						+ "%'" + " and ");
			}
			if (df.type.equals("boolean") && isNotNullOrEmpty(df.value)) {
				result.append(a + "." + df.field + "=" + df.value + " and ");
			}
			if (df.type.equals("numeric") && isNotNullOrEmpty(df.value)) {
				result.append(a + "." + df.field + GetComparison(df.comparison)
						+ df.value + " and ");
			}
			if ((df.type.equals("date")) && isNotNullOrEmpty(df.value)) {
				result.append(a + "." + df.field + GetComparison(df.comparison)
						+ "=CONVERT(varchar(10),'" + df.value + "', 120)"
						+ " and ");
			}
			if (df.type.equals("list") && isNotNullOrEmpty(df.value)) {
				result.append(a
						+ "."
						+ df.field
						+ " in "
						+ df.value.replace("[", "( ").replace("]", " )")
								.replace("\"", "'") + " and ");
			}
		}
		return (isNotNullOrEmpty(result.toString()) ? result.toString()
				.substring(0, result.length() - 4) : "");
	}

	private String GetComparison(String comparison) {
		String res = "";
		if (comparison.equals("lt")) {
			res = "<";
		}
		if (comparison.equals("gt")) {
			res = ">";
		}
		if (comparison.equals("eq")) {
			res = "=";
		}
		return res;
	}

	public static boolean isNotNullOrEmpty(String param) {
		if ((param == null) || param.trim().length() == 0) {
			return false;
		}
		return true;
	}

}
