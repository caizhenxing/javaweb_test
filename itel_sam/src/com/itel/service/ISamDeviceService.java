package com.itel.service;

import java.util.List;

import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamDevice;

/**
 * 设备信息服务接口
 * @author yangxuan
 *
 */
public interface ISamDeviceService {
	/**
	 * 添加摄像头-配置设备
	 * @param samDevice
	 * @return
	 */
	public GridResult saveSamDevice(SamDevice samDevice);
	
	/**
	 * 添加摄像头-添加已有设备
	 * @param samDevice
	 * @return
	 */
	GridResult saveExitsDevice(SamDevice samDevice);
	
	/**
	 * 设备列表-解除绑定
	 * @param samDevice
	 * @return
	 */
	public GridResult deleteSamDevice(SamDevice samDevice);
	
	/**
	 * 修改设备信息
	 * @param samDevice
	 */
	public void updateSamDevice(SamDevice samDevice);

	/**
	 * 查询设备信息
	 * @param samDevice
	 * @return
	 */
	public SamDevice querySamDevice(SamDevice samDevice);

	/**
	 * 通过主键(产品itel号)查询设备信息
	 * @param id
	 * @return
	 */
	public SamDevice querySamDeviceById(String id);

	/**
	 * 查询所有设备信息
	 * @return
	 */
	public List<SamDevice> queryAllSamDevice();
	
	/**
	 * 查询我的设备列表
	 * @param queryCondition
	 * @return
	 */
	public GridResult<SamDevice> getOwerDevice(QueryCondition queryCondition);
	
	/**
	 * 修改设备标题
	 * @param samDevice
	 * @return
	 */
	public GridResult updateTitle(SamDevice samDevice) ;
	
	/**
	 * 修改设备是否公开
	 * @param samDevice
	 * @return
	 */
	public GridResult updateDeviceShare(SamDevice samDevice);
	
	/**
	 * 修改设备是否允许所有人绑定
	 * @param samDevice
	 * @return
	 */
	public GridResult updateAllUserBind(SamDevice samDevice);
	
	/**
	 * 通过 itel号查询设备(用于校验用户合法性)
	 * @param samDevice
	 * @return
	 */
	public GridResult querySamDeviceUitel(SamDevice samDevice);
	
	/**
	 * 模糊搜索
	 * @param queryCondition
	 * @return
	 */
	public GridResult queryDeviceByLike(QueryCondition queryCondition,String flagShare);

}