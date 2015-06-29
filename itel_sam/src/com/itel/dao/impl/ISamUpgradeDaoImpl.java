package com.itel.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.itel.dao.ISamUpgradeDao;
import com.itel.dao.utils.BaseDao;
import com.itel.dao.utils.QueryCondition;
import com.itel.domain.SamUpgrade;
import com.itel.domain.Version;
/**
 * 版本更新持久层实现类
 * @author Administrator
 *
 */
@Repository
public class ISamUpgradeDaoImpl implements ISamUpgradeDao {
	private final Logger logger = Logger.getLogger(ISamUpgradeDaoImpl.class);
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 获取最新版本
	 */
	@Override
	public List<SamUpgrade> getLastVersion(final SamUpgrade samUpgrade) {
		final String hql = " from SamUpgrade where platform=? order by pubtime desc limit 0,1";
		List list = this.baseDao.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(final Session session)
							throws HibernateException, SQLException {
						final Query query = session.createQuery(hql);
						query.setString(0, samUpgrade.getPlatform());
						query.setFirstResult(0);
						query.setMaxResults(1);
						return query.list();
					}
				});

		return list;
	}
	
	/**
	 * 保存版本信息
	 */
	@Override
	public void saveSamUpgrade(SamUpgrade samUpgrade) {
		this.baseDao.save(samUpgrade);

	}
	
	/**
	 * 获取所有版本信息
	 */
	@Override
	public List<SamUpgrade> getVersionAll(QueryCondition queryCondition) {
		queryCondition.setTableName("SamUpgrade");
		/*
		 * String sql = " select * from itel_sam_upgrade order by pubtime asc";
		 * List<SamUpgrade> samUpgrades = null; try { samUpgrades =
		 * this.baseDao.findBySql(sql, new Object[]{}); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		List<SamUpgrade> samUpgrades = this.baseDao
				.queryForWhereAnd(queryCondition);
		return samUpgrades;
	}
	
	/**
	 * 通过平台获取版本号
	 */
	@Override
	public List<Version> getVersionAllByType(String type) {
		String sql = " select distinct version from itel_sam_upgrade where platform = ?";
		List<Map> list = null;
		List<Version> versionList = new ArrayList<Version>();
		try {
			list = this.baseDao.findBySql(sql, new Object[] { type });
			for (Map map : list) {
				Version version = new Version("" + map.get("version"));
				versionList.add(version);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return versionList;
	}
	
	/**
	 * 修改版本信息
	 */
	@Override
	public void updateSamUpgrade(SamUpgrade samUpgrade) {
		String sql = " update itel_sam_upgrade set url=?,decription=?,required=?,version=? where upgradeId=?";
		this.baseDao.execBySql(sql, new Object[] { samUpgrade.getUrl(),
				samUpgrade.getDecription(), samUpgrade.getRequired(),
				samUpgrade.getVersion(), samUpgrade.getUpgradeId() });

	}

}