package com.itel.service.impl;

import java.util.List;
import java.util.UUID;

import oracle.net.aso.g;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itel.dao.ISamUpgradeDao;
import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamAuthor;
import com.itel.domain.SamUpgrade;
import com.itel.domain.Version;
import com.itel.service.ISamAuthorService;
import com.itel.service.ISamUpgradeService;

@Service
public class ISamUpgradeServiceImpl implements ISamUpgradeService {

	@Autowired
	private ISamUpgradeDao iSamUpgradeDao;

	@Override
	public GridResult<SamUpgrade> getLastVersion(SamUpgrade samUpgrade) {
		GridResult<SamUpgrade> gridResult = new GridResult<SamUpgrade>();
		List<SamUpgrade> list = iSamUpgradeDao.getLastVersion(samUpgrade);
		gridResult.setResults(list);
		gridResult.setTotalCount(list.size());
		return gridResult;
	}

	@Override
	public GridResult saveSamUpgrade(SamUpgrade samUpgrade) {
		GridResult gridResult = new GridResult();
		try{
			samUpgrade.setUpgradeId(UUID.randomUUID().toString());
			iSamUpgradeDao.saveSamUpgrade(samUpgrade);
		}catch(Exception e){
			gridResult.setSuccess(false);
			gridResult.setMsg("对不起,系统异常");
		}
		return gridResult;
	}

	@Override
	public GridResult<SamUpgrade> getVersionAll(QueryCondition queryCondition) {
		List<SamUpgrade> list = iSamUpgradeDao.getVersionAll(queryCondition);
		return new GridResult<SamUpgrade>(list, list.size());
	}

	@Override
	public GridResult<Version> getVersionAllByType(String type) {
		List<Version> list = iSamUpgradeDao.getVersionAllByType(type);
		return new GridResult(list,list.size());
	}

	@Override
	public GridResult updateSamUpgrade(SamUpgrade samUpgrade) {
		GridResult gridResult = new GridResult();
		try{
			iSamUpgradeDao.updateSamUpgrade(samUpgrade);
		}catch(Exception e){
			gridResult.setSuccess(false);
			gridResult.setMsg("对不起,系统异常");
		}
		return gridResult;
	}

}
