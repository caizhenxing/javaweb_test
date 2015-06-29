package com.itel.service;

import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamUpgrade;
import com.itel.domain.Version;

/**
 * 版本更新服务类
 * @author yangxuan
 *
 */
public interface ISamUpgradeService {
	
	/**
	 * 查询最新版本
	 * @param samUpgrade
	 * @return
	 */
	GridResult<SamUpgrade> getLastVersion(SamUpgrade samUpgrade);
	
	/**
	 * 保存版本更新信息
	 * @param samUpgrade
	 * @return
	 */
	GridResult saveSamUpgrade(SamUpgrade samUpgrade);

	/**
	 * 查询所有版本信息
	 * @param queryCondition
	 * @return
	 */
	GridResult<SamUpgrade> getVersionAll(QueryCondition queryCondition);
	
	/**
	 * 通过平台类型(Android或IOS)获取版本集合
	 * @param type
	 * @return
	 */
	GridResult<Version> getVersionAllByType(String type);
	
	/**
	 * 修改版本信息
	 * @param samUpgrade
	 * @return
	 */
	GridResult updateSamUpgrade(SamUpgrade samUpgrade);
}
