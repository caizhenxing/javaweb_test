package com.itel.dao;

import java.util.List;
import com.itel.dao.utils.QueryCondition;
import com.itel.domain.SamDevice;
/**
 * 设备信息Dao
 * @author yangxuan
 *
 */
public interface ISamDeviceDao {
	
	/**
	 * 通过主键(产品itel)查找设备信息
	 * @param samDevice
	 * @return
	 */
	public SamDevice getSamDeviceById(SamDevice samDevice);
	
	/**
	 * 保存设备信息
	 * @param samDevice
	 */
	public void saveSamDevice(SamDevice samDevice);
	
	/**
	 * 更新设备信息
	 * @param samDevice
	 */
	public void updateSamDevice(SamDevice samDevice);
	
	/**
	 * 删除设备信息
	 * @param samDevice
	 * @return
	 */
	public boolean deleteSamDevice(SamDevice samDevice);
	
	/**
	 * 查找设备
	 * @param samDevice
	 * @return
	 */
	public SamDevice querySamDevice(SamDevice samDevice);
	
	/**
	 * 通过主键(产品itel)查找设备信息
	 * @param samDevice
	 * @return
	 */
	public SamDevice querySamDeviceById(String id);
	
	/**
	 * 查询所有设备集合
	 * @return
	 */
	public List<SamDevice> queryAllSamDevice();
	
	/**
	 * 查询我的设备列表信息(通过拼接sql实现查询以及分页)
	 * @param queryCondition
	 * @return
	 */
	public List<SamDevice> getOwerDevice(QueryCondition queryCondition);
	
	/**
	 * 
	 * @param queryDevice 校验对比数据库查询出来的itel号是否和该操作者的itel号一致
	 * @param samDevice
	 */
	public void updateTitle(SamDevice queryDevice,SamDevice samDevice);
	
	/**
	 * 修改设备公开状态
	 * @param samDevice
	 */
	public void updateDeviceShare(SamDevice samDevice);
	
	/**
	 * 通过产品itel号以及用户itel号查询相关设备信息
	 * @param samDevice
	 * @return
	 */
	public SamDevice querySamDeviceByPitel2Uitel(SamDevice samDevice);
	
	/**
	 * 修改设备允许所有人绑定
	 * @param samDevice
	 */
	public void updateAllUserBind(SamDevice samDevice);
	
	/**
	 * 隐私安全-添加绑定用户-校验账号是否在系统中
	 * @param samDevice
	 * @return
	 */
	public SamDevice querySamDeviceUitel(SamDevice samDevice);
	
	/**
	 * 模糊搜索
	 * @param queryCondition
	 * @return
	 */
	public List<SamDevice> queryDeviceByLike(QueryCondition queryCondition,String flagShare);
	

}
