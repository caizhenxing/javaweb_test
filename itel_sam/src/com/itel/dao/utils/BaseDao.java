package com.itel.dao.utils;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 插入记录
	 * 
	 * @param object
	 *            ：需要保存的对像
	 * @author 何挺
	 * **/
	public void save(Object object) {
		log.debug("saving " + object.getClass().getName() + " instance");
		try {
			getHibernateTemplate().save(object);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/**
	 * 更新记录
	 * 
	 * @param object
	 *            ：需要保存的对像
	 * @author 何挺
	 * **/
	public void update(Object object) {
		log.debug("updating " + object.getClass().getName() + " instance");
		try {
			getHibernateTemplate().update(object);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/**
	 * 插入或者更新记录
	 * 
	 * @param object
	 *            ：需要保存或者更新的对像
	 * @author 何挺
	 * **/
	public void saveOrUpdate(Object object) {
		log.debug("saveOrUpdate " + object.getClass().getName() + " instance");
		try {
			getHibernateTemplate().saveOrUpdate(object);
			log.debug("saveOrUpdate successful");
		} catch (RuntimeException re) {
			log.error("saveOrUpdate failed", re);
			throw re;
		}
	}

	/**
	 * 插入或者更新多条记录的集合
	 * 
	 * @param object
	 *            ：需要保存或者更新的对像
	 * @author 何挺
	 * **/
	public void saveOrUpdateList(List list) {
		log.debug("saveOrUpdateint list instance");
		try {
			getHibernateTemplate().saveOrUpdateAll(list);
			log.debug("saveOrUpdate successful");
		} catch (RuntimeException re) {
			log.error("saveOrUpdate failed", re);
			throw re;
		}
	}

	/**
	 * 删除记录
	 * 
	 * @param object
	 *            ：需要删除的对像
	 * @author 何挺
	 * **/
	public void delete(Object object) {
		log.debug("deleting " + object.getClass().getName() + " instance");
		try {
			getHibernateTemplate().delete(object);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * 删除多条记录集合
	 * 
	 * @param object
	 *            ：需要删除的对像
	 * @author 何挺
	 * **/
	public void deleteList(List list) {
		log.debug("deleting list instance");
		try {
			getHibernateTemplate().deleteAll(list);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * 根据条件删除记录
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param condition
	 *            ：条件
	 * @param value
	 *            ：属性值
	 * **/
	public void deleteByCondition(String tableName, String condition,
			Object[] values) {
		log.debug("deleting " + tableName + " by condition：" + condition);
		try {
			getHibernateTemplate().bulkUpdate(
					"delete from " + tableName + " where " + condition, values);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * 执行HQL语句
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param condition
	 *            ：条件
	 * @param value
	 *            ：属性值
	 * **/
	public void execByHql(String hql) {
		log.debug("exec by hql：" + hql);
		try {
			getHibernateTemplate().bulkUpdate(hql);
			log.debug("exec successful");
		} catch (RuntimeException re) {
			log.error("exec failed", re);
			throw re;
		}
	}

	/**
	 * 根据主键查询记录
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：com.zhongkai.model.Demo
	 * @param primaryKey
	 *            ：主键（任意封装数据类型，例如Integer、String）
	 * @author 何挺
	 * **/
	public Object findById(String tableName, Serializable primaryKey) {
		log.debug("getting " + tableName + " instance with primaryKey: "
				+ primaryKey);
		try {
			Object instance = (Object) getHibernateTemplate().get(tableName,
					primaryKey);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * 根据主键查询记录
	 * 
	 * @param tableName
	 *            ：Pojo类的class，例如：Demo
	 * @param primaryKey
	 *            ：主键（任意封装数据类型，例如Integer、String）
	 * @author 何挺
	 * **/
	public Object findById(Class tableClass, Serializable primaryKey) {
		log.debug("getting " + tableClass.getClass().getName()
				+ " instance with primaryKey: " + primaryKey);
		try {
			Object instance = (Object) getHibernateTemplate().get(tableClass,
					primaryKey);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/**
	 * 根据某条记录查询相同内容的记录
	 * 
	 * @param object
	 *            ：模型记录
	 * @author 何挺
	 * **/
	public List findByExample(Object object) {
		log.debug("finding " + object.getClass().getName()
				+ " instance by example");
		try {
			List results = (List) getHibernateTemplate().findByExample(object);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/**
	 * 根据某字段查询（单字段）
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param propertyName
	 *            ：属性名
	 * @param value
	 *            ：属性值
	 * @author 何挺
	 * **/
	public List findByProperty(String tableName, String propertyName,
			Object value) {
		log.debug("finding " + tableName + " instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from " + tableName + " as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property failed", re);
			throw re;
		}
	}

	/**
	 * 根据条件查询
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param condition
	 *            ：查询条件
	 * @param value
	 *            ：属性值
	 * @author 何挺
	 * **/
	public List findByCondition(String tableName, String condition,
			Object[] values) {
		log.debug("finding " + tableName + " instance with condition: "
				+ condition);
		try {
			String queryString = "from " + tableName + " where " + condition;
			return getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			log.error("find by condition failed", re);
			throw re;
		}
	}

	/**
	 * 根据某字段查询（单字段）
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @author 何挺
	 * **/
	public List findAll(String tableName) {
		log.debug("finding all " + tableName + " instances");
		try {
			String queryString = "from " + tableName;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * 根据自定义HQL语句查询（不可带?号参数）
	 * 
	 * @param queryString
	 *            ：hql语句
	 * @author 何挺
	 * **/
	public List findByHql(String queryString) {
		log.debug("finding by hql：" + queryString);
		try {
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 根据自定义HQL语句查询（可带?号参数）
	 * 
	 * @param queryString
	 *            ：hql语句
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public List findByHql(String queryString, Object[] queryParams) {
		log.debug("finding by hql：" + queryString);
		try {
			return getHibernateTemplate().find(queryString, queryParams);
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 根据条件查询获取第一条记录
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param condition
	 *            ：查询条件
	 * @param value
	 *            ：属性值
	 * @author 何挺
	 * **/
	public Object getFirst(final String tableName, final String condition,
			final Object[] values) {
		log.debug("finding " + tableName + " instance with condition: "
				+ condition);
		try {
			List list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							String queryString = "from " + tableName
									+ " where " + condition;
							Query query = session.createQuery(queryString);
							if (values != null && values.length > 0) {
								for (int i = 0; i < values.length; i++) {
									query.setParameter(i, values[i]);
								}
							}
							query.setFirstResult(0);
							query.setMaxResults(1);
							List results = query.list();
							return results;
						}
					});
			if (list != null && list.size() > 0)
				return list.get(0);
			return null;
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 根据自定义HQL语句查询，获取第一记录（不可带?号参数）
	 * 
	 * @param queryString
	 *            ：hql语句
	 * @author 何挺
	 * **/
	public Object getFirst(final String queryString) {
		log.debug("finding by hql：" + queryString);
		try {
			List list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setFirstResult(0);
							query.setMaxResults(1);
							List results = query.list();
							return results;
						}
					});
			if (list != null && list.size() > 0)
				return list.get(0);
			return null;
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 根据自定义HQL语句查询，获取第一条记录（可带?号参数）
	 * 
	 * @param queryString
	 *            ：hql语句
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public Object getFirst(final String queryString, final Object[] values) {
		log.debug("finding by hql：" + queryString);
		try {
			List list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							if (values != null && values.length > 0) {
								for (int i = 0; i < values.length; i++) {
									query.setParameter(i, values[i]);
								}
							}
							query.setFirstResult(0);
							query.setMaxResults(1);
							List results = query.list();
							return results;
						}
					});
			if (list != null && list.size() > 0)
				return list.get(0);
			return null;
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 根据条件统计记录数
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param condition
	 *            ：查询条件
	 * @param value
	 *            ：属性值
	 * @author 何挺
	 * **/
	public int countByCondition(String tableName, String condition,
			Object[] values) {
		log.debug("counting " + tableName + " instance with condition: "
				+ condition);
		try {

			/*
			 * select count(1) 改为select count(*) 才能正确查询 修改人：冼沛敏 time : 2013.7.5
			 * 17:00
			 */
			String queryString = "select count(*) from " + tableName;
			if (condition != null && !condition.equals(""))
				queryString += " where " + condition;
			List list = getHibernateTemplate().find(queryString, values);
			int count = ((Long) list.get(0)).intValue();
			return count;
		} catch (RuntimeException re) {
			log.error("count by condition failed", re);
			throw re;
		}
	}

	/**
	 * 根据条件统计记录数
	 * 
	 * @param tableName
	 *            ：Pojo类的类名，例如：Demo
	 * @param condition
	 *            ：查询条件
	 * @param value
	 *            ：属性值
	 * @author 何挺
	 * **/
	public int countByHql(String hql, Object[] queryParams) {
		log.debug("counting by hql：" + hql);
		try {
			String queryString = "select count(*) " + hql;
			List list = getHibernateTemplate().find(queryString, queryParams);
			int count = ((Long) list.get(0)).intValue();
			return count;
		} catch (RuntimeException re) {
			log.error("count by condition failed", re);
			throw re;
		}
	}

	// 查询个数.
	public long countByHqlForUnique(final String queryString) {
		Long count = Long.valueOf(0);
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				Long size = (Long) query.uniqueResult();
				// System.out.println("long size = " + size);
				List<Long> sizeList = new ArrayList<Long>();
				sizeList.add(size);
				return sizeList;
			}

		});
		if (list != null) {
			count = (Long) list.get(0);
		}
		return count;
	}

	public List findByHql(final String queryString, final String variableName,
			final List list) {
		List returnList = getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(queryString);
						query.setParameterList(variableName, list);

						return query.list();
					}

				});
		return returnList;
	}

	public List findByHql(final String queryString, final String variableName,
			final List list, final Integer pageIndex, final Integer pageMax) {
		log.debug("finding by hql：" + queryString);
		try {
			List returnList = getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(queryString);
							query.setParameterList(variableName, list);
							query.setFirstResult((pageIndex.intValue() - 1)
									* pageMax.intValue());
							query.setMaxResults(pageMax);
							List results = query.list();
							return results;
						}

					});
			return returnList;
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 根据自定义HQL语句查询（用于分页）
	 * 
	 * @param queryString
	 *            ：hql语句
	 * @param pageIndex
	 *            ：开头
	 * @param pageMax
	 *            ：结尾
	 * @author 何挺
	 * **/
	public List findByHql(final String queryString, final Object[] queryParams,
			final Integer pageIndex, final Integer pageMax) {
		log.debug("finding by hql：" + queryString);
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((pageIndex.intValue() - 1)
							* pageMax.intValue());
					query.setMaxResults(pageMax);

					if (queryParams != null && queryParams.length > 0) {
						for (int i = 0; i < queryParams.length; i++) {
							query.setParameter(i, queryParams[i]);
						}
					}

					List results = query.list();
					return results;
				}
			});
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		}
	}

	/**
	 * 分页列表，当pageIndex或pageMax为-1时不分页
	 * 
	 * @param hql
	 * @param pageIndex
	 * @param pageMax
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	// public Page findPage(final String hql,final int pageIndex,final int
	// pageMax){
	// log.debug("finding by hql："+hql);
	// try {
	// return (Page) getHibernateTemplate().execute(new HibernateCallback() {
	// public Object doInHibernate(Session session) throws HibernateException,
	// SQLException {
	// Query query = session.createQuery(hql);
	// int totalCount = query.list().size();
	//					
	// if(pageIndex != -1 || pageMax != -1)
	// query.setFirstResult((pageIndex - 1) * pageMax).setMaxResults(pageMax);
	// List results = query.list();
	// return new Page(pageIndex, totalCount, results);
	// }
	// });
	// } catch (RuntimeException re) {
	// log.error("find by hql failed", re);
	// throw re;
	// }
	// }

	/**
	 * 根据HQL命名查询（查）
	 * 
	 * @param hqlNameQuery
	 *            ：命名查询实例名
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public List findByHqlNameQuery(String hqlNameQuery, Object[] values) {
		log.debug("finding by hqlNameQuery：" + hqlNameQuery);
		try {
			return getHibernateTemplate()
					.findByNamedQuery(hqlNameQuery, values);
		} catch (RuntimeException re) {
			log.error("find by hqlNameQuery failed", re);
			throw re;
		}
	}

	/**
	 * 根据HQL命名查询（查）
	 * 
	 * @param hqlNameQuery
	 *            ：命名查询实例名
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public int execByHqlNameQuery(String hqlNameQuery, Object[] values) {
		log.debug("exec by hqlNameQuery：" + hqlNameQuery);
		try {
			String hql = getHibernateTemplate().getSessionFactory()
					.openSession().getNamedQuery(hqlNameQuery).getQueryString();
			return getHibernateTemplate().bulkUpdate(hql, values);
		} catch (RuntimeException re) {
			log.error("exec by hqlNameQuery failed", re);
			throw re;
		}
	}

	public static BaseDao getFromApplicationContext(ApplicationContext ctx) {
		return (BaseDao) ctx.getBean("baseDao");
	}

	/**
	 * 执行存储过程
	 * 
	 * @param procedure
	 *            ：存储过程名称
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * @deprecated
	 * @throws SQLException
	 * **/
	@SuppressWarnings("deprecation")
	public Object[] execProcedure(final String procName,
			final Object[] inParams, Object[] outParams, int[] outParamstypes)
			throws SQLException {
		log.debug("Exec by Call Proc：" + procName);
		Connection connection = null;
		try {
			connection = this.getSession().connection();
			CallableStatement call = connection.prepareCall("{call " + procName
					+ "}");
			int inParamsLength = inParams.length;
			int outParamsLength = outParams.length;
			for (int i = 0; i < inParamsLength; i++) {
				call.setObject(i + 1, inParams[i]);
			}
			for (int j = 0; j < outParamsLength; j++) {
				call.registerOutParameter(inParamsLength + j + 1,
						outParamstypes[j]);
			}
			call.executeUpdate();
			Object[] outValues = new Object[outParams.length];
			for (int i = 0; i < outValues.length; i++) {
				outValues[i] = call.getObject(inParamsLength + i + 1);
			}
			return outValues;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	/**
	 * 执行存储过程
	 * 
	 * @param procedure
	 *            ：存储过程名称
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * @deprecated 使用了connection的方法，所以比较危险
	 * @throws SQLException
	 * **/
	@SuppressWarnings("deprecation")
	public List execProcedure(final String procName, final Object[] inParams)
			throws SQLException {
		log.debug("Exec by Call Proc：" + procName);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.createSQLQuery(
							"{call " + procName + "}").setResultTransformer(
							Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("Call Proc：" + sql);
					if (inParams != null && inParams.length > 0) {
						for (int i = 0; i < inParams.length; i++) {
							query.setParameter(i, inParams[i]);
						}
					}
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 缓存查询
	 * **/
	public List findByHqlForCache(final String queryString) throws Exception {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				Query query = s.createQuery(queryString);
				List results = query.setCacheable(true).list();
				return results;
			}
		});
	}

	public void merge(Object object) throws Exception {
		getHibernateTemplate().merge(object);
	}

	/*************************************************************************************************************************************************
	 * SQL 查询总类目 1. SQL的普通方式查询 2. SQL的普通方式查询（MAP方式） 3. SQL命名查询 4. SQL命名查询（MAP方式
	 * ）
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *************************************************************************************************************************************************/
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	// SQL普通查询
	// //
	//
	//
	//
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据SQL查询(自己组合) sql：sql语句
	 * 
	 * @author 何挺
	 *@deprecated 已过期，使用带参数的方法
	 * **/
	public List findBySql(final String sql) throws Exception {
		log.debug("finding by sql：" + sql);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.createSQLQuery(sql)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL查询
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            Object数组型参数（如无参数请用null代替）
	 * @return 返回一个包含Map(字段全大写)的List
	 * @throws Exception
	 * @author 胡宇峰
	 * 
	 */
	public List findBySql(final String sql, final Object[] values)
			throws Exception {
		log.debug("finding by sql：" + sql);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.createSQLQuery(sql)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL查询（可代？参数）
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            Object数组型参数（如无参数请用null代替）
	 * @param pageIndex
	 *            起始位置
	 * @param pageMax
	 *            每页显示最大数
	 * @return 返回一个包含Map(字段全大写)的List
	 * @throws Exception
	 */
	public List findBySql(final String sql, final Object[] values,
			final Integer pageIndex, final Integer pageMax) throws Exception {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.createSQLQuery(sql)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					query.setFirstResult((pageIndex.intValue() - 1)
							* pageMax.intValue());
					query.setMaxResults(pageMax);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL查询总数
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            参数（无参数时可用null代替）
	 * @return 返回一个int类型的总数
	 * @throws Exception
	 */
	public int countBySql(final String sql, final Object[] values)
			throws Exception {
		int count = 0;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					String sqlcount = "select count(1) COUNT from (" + sql
							+ ") as countT";
					Query query = session.createSQLQuery(sqlcount).addScalar(
							"COUNT", Hibernate.INTEGER);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
		if (list != null) {
			count = (Integer) list.get(0);
		}
		return count;
	}

	/**
	 * 根据SQL插入
	 * 
	 * @param hqlNameQuery
	 *            ：命名查询实例名
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public int execBySql(final String sql, final Object[] values) {
		log.debug("exec by sqlNameQuery：" + sql);
		try {
			return (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createSQLQuery(sql);
							if (values != null && values.length > 0) {
								for (int i = 0; i < values.length; i++) {
									query.setParameter(i, values[i]);
								}
							}
							int result = 0;
							try {
								result = query.executeUpdate();
							} catch (RuntimeException e) {
								e.printStackTrace();
							}
							session.close();
							return result;
						}

					});
		} catch (RuntimeException re) {
			log.error("exec by sqlNameQuery failed", re);
			throw re;
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	// SQL普通查询（MAP 方式）
	// //
	//
	//
	//
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 根据SQL查询
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            Object数组型参数（如无参数请用null代替）
	 * @return 返回一个包含Map(字段全大写)的List
	 * @throws Exception
	 * @author 胡宇峰
	 * 
	 */
	public List findBySql(final String sql, final Map values) throws Exception {
		log.debug("finding by sql：" + sql);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.createSQLQuery(sql)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					query.setProperties(values);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL查询（可代？参数）
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            Object数组型参数（如无参数请用null代替）
	 * @param pageIndex
	 *            起始位置
	 * @param pageMax
	 *            每页显示最大数
	 * @return 返回一个包含Map(字段全大写)的List
	 * @throws Exception
	 */
	public List findBySql(final String sql, final Map values,
			final Integer pageIndex, final Integer pageMax) throws Exception {
		log.debug("finding by sql：" + sql);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.createSQLQuery(sql)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					query.setProperties(values);
					query.setFirstResult((pageIndex.intValue() - 1)
							* pageMax.intValue());
					query.setMaxResults(pageMax);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL查询总数
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            参数（无参数时可用null代替）
	 * @return 返回一个int类型的总数
	 * @throws Exception
	 */
	public int countBySql(final String sql, final Map values) throws Exception {
		log.debug("finding by sql：" + sql);
		int count = 0;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					String sqlcount = "select count(1) COUNT from (" + sql
							+ ")";
					Query query = session.createSQLQuery(sqlcount).addScalar(
							"COUNT", Hibernate.INTEGER);
					System.out.println("JDBC：" + sqlcount);
					query.setProperties(values);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sql failed", re);
					throw re;
				}
				return list;
			}
		});
		if (list != null) {
			count = (Integer) list.get(0);
		}
		return count;
	}

	/**
	 * 根据SQL查询总数
	 * 
	 * @param sql
	 *            sql语句
	 * @param variableName
	 *            参数名
	 * @param list
	 *            参数值
	 * @return List
	 * @throws Exception
	 */
	public List findBySql(final String queryString, final String variableName,
			final List list) {
		List returnList = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = (SQLQuery) session.createSQLQuery(
								queryString).setResultTransformer(
								Transformers.ALIAS_TO_ENTITY_MAP);
						query.setParameterList(variableName, list);
						return query.list();
					}

				});
		return returnList;
	}

	/**
	 * 根据SQL插入，更新(MAP方式 )
	 * 
	 * @param hqlNameQuery
	 *            ：命名查询实例名
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public int execBySql(final String sql, final Map values) {
		log.debug("exec by sqlNameQuery：" + sql);
		try {
			return (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							// Transaction tx=session.getTransaction();
							Query query = session.createSQLQuery(sql);
							query.setProperties(values);
							// tx.begin();
							int result = 0;
							try {
								result = query.executeUpdate();
								// tx.commit();
							} catch (RuntimeException e) {
								// tx.rollback();
								e.printStackTrace();
							}
							session.close();
							return result;
						}

					});
		} catch (RuntimeException re) {
			log.error("exec by sqlNameQuery failed", re);
			throw re;
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//	
	//	
	//	
	// //SQL命名查询（？号方式）
	// //
	//	
	//	
	//	
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据SQL命名查询(分页) sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺,胡宇峰
	 * @throws SQLException
	 * **/
	public List findBySqlNameQuery(final String sqlNameQuery,
			final Object[] values, final Integer pageIndex,
			final Integer pageMax) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.getNamedQuery(sqlNameQuery)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					query.setFirstResult((pageIndex.intValue() - 1)
							* pageMax.intValue());
					query.setMaxResults(pageMax);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL命名查询（带？号参数） sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺,胡宇峰
	 * @throws SQLException
	 * **/
	public List findBySqlNameQuery(final String sqlNameQuery,
			final Object[] values) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.getNamedQuery(sqlNameQuery)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL命名查询统计总数（用于分页等） sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺,胡宇峰
	 * @throws SQLException
	 * **/
	public int countBySqlNameQuery(final String sqlNameQuery,
			final Object[] values) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		int count = 0;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					String sql = session.getNamedQuery(sqlNameQuery)
							.getQueryString();
					sql = "select count(1) COUNT from (" + sql + ")";
					Query query = session.createSQLQuery(sql).addScalar(
							"COUNT", Hibernate.INTEGER);
					// Query query =
					// session.getNamedQuery(sqlNameQuery).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
					// String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
		if (list != null) {
			count = (Integer) list.get(0);
		}
		return count;
	}

	/**
	 * 根据SQL命名插入，更新
	 * 
	 * @param hqlNameQuery
	 *            ：命名查询实例名
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public int execBySqlNameQuery(final String sqlNameQuery,
			final Object[] values) {
		log.debug("exec by sqlNameQuery：" + sqlNameQuery);
		try {
			return (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Transaction tx = session.getTransaction();
							Query query = session.getNamedQuery(sqlNameQuery);
							String hql = query.getQueryString();
							if (values != null && values.length > 0) {
								for (int i = 0; i < values.length; i++) {
									query.setParameter(i, values[i]);
								}
							}
							tx.begin();
							int result = 0;
							try {
								result = query.executeUpdate();
								tx.commit();
							} catch (RuntimeException e) {
								tx.rollback();
								e.printStackTrace();
							}
							session.close();
							return result;
						}

					});
		} catch (RuntimeException re) {
			log.error("exec by sqlNameQuery failed", re);
			throw re;
		}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	// //SQL命名查询（MAP方式 ）
	// //
	//
	//
	//
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 根据SQL命名查询（使用MAP，非问号的参数） sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺
	 * @throws SQLException
	 * **/
	public List findBySqlNameQueryForMap(final String sqlNameQuery,
			final Map values) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.getNamedQuery(sqlNameQuery)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					query.setProperties(values);
					list = query.list();
				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL命名分页查询（使用MAP，非问号的参数） sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺
	 * @throws SQLException
	 * **/
	public List findBySqlNameQueryForMap(final String sqlNameQuery,
			final Map values, final Integer pageIndex, final Integer pageMax)
			throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.getNamedQuery(sqlNameQuery)
							.setResultTransformer(
									Transformers.ALIAS_TO_ENTITY_MAP);
					String sql = query.getQueryString();
					query.setProperties(values);
					query.setFirstResult((pageIndex.intValue() - 1)
							* pageMax.intValue());
					query.setMaxResults(pageMax);
					list = query.list();
				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL命名查询统计总数（用于分页等） sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺,胡宇峰
	 * @throws SQLException
	 * **/
	public int countBySqlNameQueryForMap(final String sqlNameQuery,
			final Map values) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		int count = 0;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					String sql = session.getNamedQuery(sqlNameQuery)
							.getQueryString();
					sql = "select count(1) COUNT from (" + sql + ")";
					Query query = session.createSQLQuery(sql).addScalar(
							"COUNT", Hibernate.INTEGER);
					// Query query =
					// session.getNamedQuery(sqlNameQuery).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
					// String sql = query.getQueryString();
					System.out.println("JDBC：" + sql);
					query.setProperties(values);
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
		if (list != null) {
			count = (Integer) list.get(0);
		}
		return count;
	}

	/**
	 * 根据SQL命名插入，更新(MAP方式 )
	 * 
	 * @param hqlNameQuery
	 *            ：命名查询实例名
	 * @param values
	 *            ：参数值
	 * @author 何挺
	 * **/
	public int execBySqlNameQueryForMap(final String sqlNameQuery,
			final Map values) {
		log.debug("exec by sqlNameQuery：" + sqlNameQuery);
		try {
			return (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Transaction tx = session.getTransaction();
							Query query = session.getNamedQuery(sqlNameQuery);
							String hql = query.getQueryString();
							query.setProperties(values);
							tx.begin();
							int result = 0;
							try {
								result = query.executeUpdate();
								tx.commit();
							} catch (RuntimeException e) {
								tx.rollback();
								e.printStackTrace();
							}
							session.close();
							return result;
						}

					});
		} catch (RuntimeException re) {
			log.error("exec by sqlNameQuery failed", re);
			throw re;
		}
	}

	/**
	 * 反向查找命名查询中的语句 特殊用法
	 * 
	 * @param NameQuery
	 *            命名查询实例名
	 * @return xHL语句
	 * @author 胡宇峰
	 */
	public String getNameQuery(String NameQuery) {
		String xql = getHibernateTemplate().getSessionFactory().openSession()
				.getNamedQuery(NameQuery).getQueryString();
		return xql;
	}

	/**
	 * 执行HQL语句
	 * 
	 * @param hql
	 *            ：hql语句
	 * @param variableName
	 *            ：匹配字段名（格式:name）
	 * @param list
	 *            ：匹配字段值
	 * **/
	public int execByHql(final String hql, final String variableName,
			final List list) {
		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setParameterList(variableName, list);
						int result = query.executeUpdate();
						return result;
					}
				});
	}

	/**
	 * 根据SQL命名查询（带？号参数） sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺,胡宇峰
	 * @throws SQLException
	 * @return 返回数据格式的List
	 * **/
	public List findBySqlNameQueryForArray(final String sqlNameQuery,
			final Object[] values) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = null;
				try {
					Query query = session.getNamedQuery(sqlNameQuery);
					String sql = query.getQueryString();
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							query.setParameter(i, values[i]);
						}
					}
					list = query.list();

				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL命名查询 sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺
	 * @throws SQLException
	 * **/
	public List findBySqlForMapString(final String sql, final Object[] values)
			throws SQLException {
		log.debug("finding by sql：" + sql);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection connection = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ArrayList list = null;
				try {
					connection = session.connection();
					pstmt = connection.prepareStatement(sql);
					System.out.println("JDBC：" + sql);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							pstmt.setObject(i + 1, values[i]);
						}
					}
					rs = pstmt.executeQuery();
					ResultSetMetaData meta = rs.getMetaData();
					int mc = meta.getColumnCount();
					list = new ArrayList();
					while (rs.next()) {
						HashMap map = new HashMap();
						String tempValue;
						String columnName;
						for (int i = 1; i <= mc; i++) {
							tempValue = rs.getString(i) == null ? "" : rs
									.getString(i);
							columnName = meta.getColumnName(i);
							columnName = columnName.toUpperCase();
							map.put(columnName, tempValue);
						}
						list.add(map);
					}
				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (connection != null)
						connection.close();
				}
				return list;
			}
		});
	}

	/**
	 * 根据SQL命名查询 sqlNameQuery：命名查询实例名
	 * 
	 * @author 何挺
	 * @throws SQLException
	 * **/
	public List findBySqlNameQueryForMapString(final String sqlNameQuery,
			final Object[] values) throws SQLException {
		log.debug("finding by sqlNameQuery：" + sqlNameQuery);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection connection = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ArrayList list = null;
				try {
					Query query = session.getNamedQuery(sqlNameQuery);
					String sql = query.getQueryString();
					connection = session.connection();
					pstmt = connection.prepareStatement(sql);
					System.out.println("JDBC：" + sql);
					if (values != null && values.length > 0) {
						for (int i = 0; i < values.length; i++) {
							pstmt.setObject(i + 1, values[i]);
						}
					}
					rs = pstmt.executeQuery();
					ResultSetMetaData meta = rs.getMetaData();
					int mc = meta.getColumnCount();
					list = new ArrayList();
					while (rs.next()) {
						HashMap map = new HashMap();
						String tempValue;
						String columnName;
						for (int i = 1; i <= mc; i++) {
							tempValue = rs.getString(i) == null ? "" : rs
									.getString(i);
							columnName = meta.getColumnName(i);
							columnName = columnName.toUpperCase();
							map.put(columnName, tempValue);
						}
						list.add(map);
					}
				} catch (RuntimeException re) {
					log.error("find by sqlNameQuery failed", re);
					throw re;
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (connection != null)
						connection.close();
				}
				return list;
			}
		});
	}

	public List queryForWhereOr(final QueryCondition queryCondition) {
		if(queryCondition.getTableName()==null)
			try {
				throw new Exception("queryCondition-->tableName is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		String tableName = queryCondition.getTableName();
		final StringBuffer sqlBuffer = new StringBuffer(" from "+ tableName);
		StringBuffer whereBuffer = new StringBuffer();
		Map fields = queryCondition.getFields();
		if (fields != null) {
			whereBuffer.append(" where ");
			Set<String> fielsSet = fields.keySet();
			for (String key : fielsSet) {
				Object values = fields.get(key);
				whereBuffer.append(" " + key + "=\'" + values + "\' or");
			}
			whereBuffer = whereBuffer.delete(whereBuffer.length() - 2,
					whereBuffer.length());
		}
		sqlBuffer.append(whereBuffer);
		final String hql = sqlBuffer.toString();
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)
					throws HibernateException, SQLException {
				final Query query = session.createQuery(hql);
				if (queryCondition.getPageMax() != null) {
					query.setMaxResults(queryCondition.getPageMax());
				}
				if (queryCondition.getPageIndex() != null) {
					query.setFirstResult(queryCondition.getPageIndex()*queryCondition.getPageMax());
				}
				return query.list();
			}
		});
	}
	
	public List queryForWhereAnd(final QueryCondition queryCondition) {
		if(queryCondition.getTableName()==null)
			try {
				throw new Exception("queryCondition-->tableName is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		String tableName = queryCondition.getTableName();
		final StringBuffer sqlBuffer = new StringBuffer(" from "+ tableName);
		StringBuffer whereBuffer = new StringBuffer();
		Map fields = queryCondition.getFields();
		if (fields != null) {
			whereBuffer.append(" where ");
			Set<String> fielsSet = fields.keySet();
			for (String key : fielsSet) {
				Object values = fields.get(key);
				whereBuffer.append(" " + key + "=\'" + values + "\' and");
			}
			whereBuffer = whereBuffer.delete(whereBuffer.length() - 3,
					whereBuffer.length());
		}
		sqlBuffer.append(whereBuffer);
		final String hql = sqlBuffer.toString();
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)
					throws HibernateException, SQLException {
				final Query query = session.createQuery(hql);
				if (queryCondition.getPageMax() != null) {
					query.setMaxResults(queryCondition.getPageMax());
				}
				if (queryCondition.getPageIndex() != null) {
					query.setFirstResult(queryCondition.getPageIndex()*queryCondition.getPageMax());
				}
				return query.list();
			}
		});
	}
	
	
	
	public List queryForWhereLike(final QueryCondition queryCondition) {
		if(queryCondition.getTableName()==null)
			try {
				throw new Exception("queryCondition-->tableName is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		String tableName = queryCondition.getTableName();
		final StringBuffer sqlBuffer = new StringBuffer(" from "+ tableName);
		StringBuffer whereBuffer = new StringBuffer();
		String[] fields = queryCondition.getLikeFields();
		if (fields != null) {
			whereBuffer.append(" where ");
			String likeValue = queryCondition.getLikeValue();
			for (String key : fields) {
				Object values = likeValue;
				whereBuffer.append(" " + key + "like '%" + values + "%' or");
			}
			whereBuffer = whereBuffer.delete(whereBuffer.length() - 2,
					whereBuffer.length());
		}
		sqlBuffer.append(whereBuffer);
		final String hql = sqlBuffer.toString();
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)
					throws HibernateException, SQLException {
				final Query query = session.createQuery(hql);
				if (queryCondition.getPageMax() != null) {
					query.setMaxResults(queryCondition.getPageMax());
				}
				if (queryCondition.getPageIndex() != null) {
					query.setFirstResult(queryCondition.getPageIndex()*queryCondition.getPageMax());
				}
				return query.list();
			}
		});
	}
}