package com.itel.service.impl;

import oracle.net.aso.r;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itel.dao.ISamHelpCenterDao;
import com.itel.data.GridResult;
import com.itel.service.ISamHelpCenterService;

/**
 * 帮助中心服务接口
 * 
 * @author yangxuan
 * 
 */
@Service
public class ISamHelpCenterServiceImpl implements ISamHelpCenterService {

	@Autowired
	private ISamHelpCenterDao iSamHelpCenterDao;
	
	/**
	 * 删除帮助中心信息
	 */
	@Override
	public GridResult deleteSamHelpCenters(String[] ids) {
		GridResult gridResult = new GridResult();
		try {
			for (String id : ids) {
				iSamHelpCenterDao.deleteSamHelpCenter(id);
			}
		} catch (Exception e) {
			gridResult.setSuccess(false);
			gridResult.setMsg("对不起,系统异常");
		}
		return gridResult;
	}
}
