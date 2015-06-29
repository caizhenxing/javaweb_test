package com.itel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itel.dao.ISamNoticDao;
import com.itel.data.GridResult;
import com.itel.domain.SamNotic;
import com.itel.service.ISamNoticService;

/**
 * 通知消息服务类接口实现类
 * @author yangxuan
 *
 */
@Service
public class ISamNoticServiceImpl implements ISamNoticService {

	@Autowired
	private ISamNoticDao iSamNoticDao;

	@Override
	public void insertSamNotic(SamNotic samNotic) {
		iSamNoticDao.insertSamNotic(samNotic);
	}

	@Override
	public GridResult deleteSamNotics(String[] ids) {
		GridResult gridResult = new GridResult();
		try {
			for (String id : ids) {
				iSamNoticDao.deleteSamNotic(id);
			}
		} catch (Exception e) {
			gridResult.setMsg("对不起,系统异常");
			gridResult.setSuccess(false);
			return gridResult;
		}
		return gridResult;
	}

}
