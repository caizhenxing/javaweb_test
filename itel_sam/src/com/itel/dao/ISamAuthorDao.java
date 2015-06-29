package com.itel.dao;

import java.util.List;

import com.itel.domain.SamAuthor;

/**
 * 授权信息Dao
 * @author yangxuan
 *
 */
public interface ISamAuthorDao {
	
	/**
	 * 通过设备itel号以及用户itel查找相关授权信息
	 * @param samAuthor
	 * @return
	 */
	SamAuthor getSamAuthorByPitel2Uitel(SamAuthor samAuthor);
	
	/**
	 * 保存授权信息(主动保存或者被动保存)
	 * @param samAuthor
	 */
	void saveSamAuthor(SamAuthor samAuthor);
	
	/**
	 * 删除授权信息(设备主人在授权列表删除授权用户信息或者用户在我的摄像头列表解除绑定他人设备信息)
	 * @param samAuthor
	 */
	void deleteSamAuthor(SamAuthor samAuthor);
	
	/**
	 * 通过产品itel号查询绑定信息
	 * @param samAuthor
	 */
	List<SamAuthor> getAuthorListByPitel(SamAuthor samAuthor);
	
	/**
	 * 设备拥有者主动绑定用户,该用户可能在之前已经主动添加已存在设备,所以在此只需要修改active字段
	 * @param samAuthor
	 */
	void modifySamAuthorActive(SamAuthor samAuthor);
	
	/**
	 * 修改绑定用户信息
	 * @param samAuthor
	 */
	void updateSamAuthor(SamAuthor samAuthor);
	
	 
}