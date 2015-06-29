package com.itel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.itel.dao.ISamDeviceDao;
import com.itel.dao.utils.BaseDao;
import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamDevice;

/**
 * 设备持久层实现类
 * @author Administrator
 *
 */
@Repository
public class ISamDeviceDaoImpl implements ISamDeviceDao {

	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 新增设备信息
	 */
	@Override
	public void saveSamDevice(SamDevice samDevice) {
		baseDao.save(samDevice);
	}
	
	/**
	 * 修改设备信息
	 */
	@Override
	public void updateSamDevice(SamDevice samDevice) {
		baseDao.saveOrUpdate(samDevice);
	}
	
	/**
	 *  解除绑定
	 */
	@Override
	public boolean deleteSamDevice(SamDevice samDevice) {
		SamDevice queryDevice = getSamDeviceById(samDevice);
		String sql = "";
		if (queryDevice.getVarUiTel().equals(samDevice.getVarUiTel())) {
			sql = " delete from  itel_sam_device where var_pitel=? and var_uitel=?";
		} else {
			sql = " delete from itel_sam_author where var_pitel=? and var_uitel=?";
		}
		int state = this.baseDao.execBySql(sql, new Object[] {
				samDevice.getVarPitel(), samDevice.getVarUiTel() });
		if (state == 0)
			return false;
		return true;
	}
	
	/**
	 * 通过主键获取设备信息
	 */
	@Override
	public SamDevice querySamDevice(SamDevice samDevice) {
		return (SamDevice) baseDao.findByExample(samDevice);
	}

	/**
	 * 通过主键获取设备信息
	 */
	@Override
	public SamDevice querySamDeviceById(String id) {
		return (SamDevice) baseDao.findById(SamDevice.class, id);
	}
	
	/**
	 * 查询所有设备列表集合
	 */
	@Override
	public List<SamDevice> queryAllSamDevice() {
		return baseDao.findAll("SamDevice");
	}
	
	/**
	 * 通过Pitel查询对象
	 */
	@Override
	public SamDevice getSamDeviceById(SamDevice samDevice) {
		SamDevice queryDevice = (SamDevice) this.baseDao.findById(
				SamDevice.class, samDevice.getVarPitel());
		return queryDevice;
	}
	
	/**
	 * 查询我的设备集合
	 */
	@Override
	public List<SamDevice> getOwerDevice(QueryCondition queryCondition) {
		Map<String, Object> fields = queryCondition.getFields();
		final String uItel = fields.get("varUiTel") + "";
		final StringBuffer sql = new StringBuffer(
				"   SELECT DISTINCT d.var_pitel,d.var_type,d.var_title,d.var_deviceid,d.var_password,d.date_regtime,d.var_uitel,"
						+ " d.var_remark,d.flag_share,d.flag_isdel,NULL AS var_devicename,d.userbind FROM itel_sam_device AS d "
						+ " WHERE d.`var_uitel`=? UNION ALL  "
						+ " SELECT DISTINCT d.var_pitel,d.var_type,d.var_title,d.var_deviceid,d.var_password,d.date_regtime,d.var_uitel,"
						+ " d.var_remark,d.flag_share,d.flag_isdel,a.var_devicename,d.userbind "
						+ " FROM itel_sam_device AS d  LEFT JOIN itel_sam_author AS a ON d.`var_pitel`=a.`var_pitel` WHERE a.`var_uitel`=?");
		if (queryCondition.getPageIndex() != null) {
			sql.append(" limit " + queryCondition.getPageIndex()
					* queryCondition.getPageMax());
		}
		if (queryCondition.getPageMax() != null) {
			sql.append(" , " + queryCondition.getPageMax());
		}
		List<SamDevice> list = this.baseDao.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Connection con = session.connection();
						PreparedStatement ps = con.prepareStatement(sql
								.toString());
						ps.setString(1, uItel);
						ps.setString(2, uItel);
						ResultSet rs = ps.executeQuery();
						List<SamDevice> list = new ArrayList<SamDevice>();
						while (rs.next()) {
							SamDevice samDevice = new SamDevice();
							String pitel = rs.getString(1);
							samDevice.setVarPitel(pitel);
							String type = rs.getString(2);
							samDevice.setVarType(type);
							String title = rs.getString(11);
							if (title != null && !"".equals(title)) {
								samDevice.setVarTitle(title);
							} else {
								title = rs.getString(3);
								samDevice.setVarTitle(title);
							}
							String deviceId = rs.getString(4);
							samDevice.setVarDeviceId(deviceId);
							String password = rs.getString(5);
							samDevice.setVarPassWord(password);
							String regtime = rs.getString(6);
							samDevice.setDateRegTime(regtime);
							String uitel = rs.getString(7);
							samDevice.setVarUiTel(uitel);
							String remark = rs.getString(8);
							samDevice.setVarRemark(remark);
							String share = rs.getString(9);
							samDevice.setFlagShare(share);
							String isdel = rs.getString(10);
							samDevice.setFlagIsDel(isdel);
							String userbind = rs.getString(12);
							samDevice.setUserbind(userbind);
							list.add(samDevice);
						}
						return list;
					}
				});
		return list;
	}
	
	/**
	 * 设置设备备注名(标题)
	 */
	@Override
	public void updateTitle(SamDevice queryDevice, SamDevice samDevice) {
		String sql = "";
		if (queryDevice.getVarUiTel().equals(samDevice.getVarUiTel())) {
			sql = " update itel_sam_device set var_title=? where var_pitel=? and var_uitel=?";
		} else {
			sql = " update itel_sam_author set var_devicename=? where var_pitel=? and var_uitel=?";
		}
		this.baseDao.execBySql(sql, new Object[] {
				samDevice.getVarTitle(), samDevice.getVarPitel(),
				samDevice.getVarUiTel() });
	}
	/**
	 * 设置设备公开
	 */
	@Override
	public void updateDeviceShare(SamDevice samDevice) {
		String sql = " update itel_sam_device set flag_share=? where var_pitel=?";
		this.baseDao.execBySql(sql, new Object[] {
				samDevice.getFlagShare(), samDevice.getVarPitel() });
	}
	
	/**
	 * 通过产品itel号以及设备itel号查询设备信息
	 */
	@Override
	public SamDevice querySamDeviceByPitel2Uitel(SamDevice samDevice) {
		String hql = " from SamDevice where varPitel=? and varUiTel=? ";
		List list = this.baseDao.findByHql(hql, new Object[]{samDevice.getVarPitel(),samDevice.getVarUiTel()});
		if(list!=null&&list.size()>0){
			return (SamDevice) list.get(0);
		}
		return null;
	}
	
	/**
	 * 修改是否允许所有人绑定字段
	 */
	@Override
	public void updateAllUserBind(SamDevice samDevice) {
			String updatesql = " update itel_sam_device set userbind=? where var_pitel=? ";
			this.baseDao.execBySql(updatesql, new Object[]{samDevice.getUserbind(),samDevice.getVarPitel()});
	}
	
	/**
	 * 查询本地Uitel号是否存在
	 */
	@Override
	public SamDevice querySamDeviceUitel(SamDevice samDevice) {
		String hql = " from SamDevice where varUiTel=? ";
		List list = this.baseDao.findByHql(hql, new Object[]{samDevice.getVarUiTel()});
		if(list!=null&&list.size()>0){
			return (SamDevice) list.get(0);
		}
		return null;
	}
	
	 
	/**
	 * 模糊查询
	 * @param queryCondition 查询条件
	 * @param 是否为公开摄像头
	 */
	@Override
	public List<SamDevice> queryDeviceByLike(final QueryCondition queryCondition,String flagShare) {
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
				whereBuffer.append(" " + key + " like '%" + values + "%' or");
			}
			whereBuffer = whereBuffer.delete(whereBuffer.length() - 2,
					whereBuffer.length());
			if(flagShare!=null){
				whereBuffer = whereBuffer.append(" and flagShare='"+flagShare+"'");
			}
		}
		
		sqlBuffer.append(whereBuffer);
		final String hql = sqlBuffer.toString();
		return this.baseDao.getHibernateTemplate().executeFind(new HibernateCallback() {
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
