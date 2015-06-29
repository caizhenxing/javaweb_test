package com.itel.dao;

import java.util.List;

import com.itel.dao.utils.QueryCondition;
import com.itel.domain.SamUpgrade;
import com.itel.domain.Version;

/**
 * 版本更新Dao
 * @author yangxuan
 *
 */
public interface ISamUpgradeDao {
	
	/**
	 * 获取最新版本(通过平台查询Android或IOS)
	 * @param samUpgrade
	 * @return
	 */
	public List<SamUpgrade> getLastVersion(SamUpgrade samUpgrade);
	
	/**
	 * 保存版本信息(发布版本)
	 * @param samUpgrade
	 */
	public void saveSamUpgrade(SamUpgrade samUpgrade);
	
	/**
	 * 查询所有版本信息
	 * @param queryCondition
	 * @return
	 */
	public List<SamUpgrade> getVersionAll(QueryCondition queryCondition);
	
	/**
	 * 通过平台类型(Android或IOS)获取版本集合
	 * @param type
	 * @return
	 */
	public List<Version> getVersionAllByType(String type);
	
	/**
	 * 修改版本信息
	 * @param samUpgrade
	 */
	public void updateSamUpgrade(SamUpgrade samUpgrade);

}
