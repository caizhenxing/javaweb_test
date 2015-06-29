package com.itel.dao.utils;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CacheDao extends HibernateDaoSupport {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	/**
	 * 根据主键查询记录
	 * @param tableName：Pojo类的类名，例如：com.zhongkai.model.Demo
	 * @param primaryKey：主键（任意封装数据类型，例如Integer、String）
	 * @author 何挺
	 * **/
	public Object findById(String tableName,Serializable primaryKey) {
		log.debug("getting "+tableName+" instance with primaryKey: " + primaryKey);
		try {
			getHibernateTemplate().setCacheQueries(true);
			Object instance = (Object) getHibernateTemplate().get(tableName, primaryKey);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据主键查询记录
	 * @param tableName：Pojo类的class，例如：Demo
	 * @param primaryKey：主键（任意封装数据类型，例如Integer、String）
	 * @author 何挺
	 * **/
	public Object findById(Class<?> tableClass,Serializable primaryKey) {
		log.debug("getting "+tableClass.getClass().getName()+" instance with primaryKey: " + primaryKey);
		try {
			getHibernateTemplate().setCacheQueries(true);
			Object instance = (Object) getHibernateTemplate().get(tableClass, primaryKey);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

}
