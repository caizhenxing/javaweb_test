package com.itel.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.itel.dao.utils.BaseDao;
import com.itel.tools.Page;


public class BaseService {

	@Autowired
	protected BaseDao baseDao;
	

	/***
	 * 取得数据库时间
	 * 
	 * @return 返回Date类时间
	 * @throws SQLException 
	 */
	public Date getServerDate() throws SQLException {
		List list = baseDao.findBySqlNameQuery("getServerDatetime", null);
		Map DateMap=(Map) list.get(0);
		Date serverDate = new Date(((Date) DateMap.get("SERVERTIME")).getTime());
		return serverDate;
	}

	/***
	 * 根据HQL查询获取分页数据
	 * 
	 * @param hql
	 *            ：HQL语句
	 * @param values
	 *            ：参数值
	 * @param pageIndex
	 *            ：当前页码
	 * @param pageMax
	 *            ：每条显示记录数
	 */
	public Page findPageByHql(String hql, Object[] values, int pageIndex,
			int pageMax) throws Exception {
		int totalCount = 0;
		String tmp = StringUtils.isNotEmpty(hql) ? hql.trim().toLowerCase()
				: null;
		if (StringUtils.isNotEmpty(tmp) && hql.startsWith("select")) {
			int begin01 = hql.indexOf("from");
			int begin02 = hql.indexOf("FROM");
			int begin = 0;
			if (begin01 > -1 && begin02 > -1)
				begin = begin01 < begin02 ? begin01 : begin02;
			else if (begin01 > -1 && begin02 == -1)
				begin = begin01;
			else if (begin02 > -1 && begin01 == -1)
				begin = begin02;
			String countHql = hql.substring(begin);
			totalCount = baseDao.countByHql(countHql, values);
		} else
			totalCount = baseDao.countByHql(hql, values);
		List results = baseDao.findByHql(hql, values, pageIndex, pageMax);
		return new Page(pageIndex, totalCount, pageMax, results);
	}

	/***
	 * 根据HQL查询获取分页数据
	 * 
	 * @param hql
	 *            ：HQL语句
	 * @param values
	 *            ：参数值
	 * @param pageSort
	 *            ：排序字段
	 * @param pageIndex
	 *            ：当前页码
	 * @param pageMax
	 *            ：每条显示记录数
	 */
	public Page findPageByHql(String hql, Object[] values, String pageSort,
			int pageIndex, int pageMax) throws Exception {
		int totalCount = 0;
		String tmp = StringUtils.isNotEmpty(hql) ? hql.trim().toLowerCase()
				: null;
		if (StringUtils.isNotEmpty(tmp) && hql.startsWith("select")) {
			int begin01 = hql.indexOf("from");
			int begin02 = hql.indexOf("FROM");
			int begin = 0;
			if (begin01 > -1 && begin02 > -1)
				begin = begin01 < begin02 ? begin01 : begin02;
			else if (begin01 > -1 && begin02 == -1)
				begin = begin01;
			else if (begin02 > -1 && begin01 == -1)
				begin = begin02;
			String countHql = hql.substring(begin);
			totalCount = baseDao.countByHql(countHql, values);
		} else
			totalCount = baseDao.countByHql(hql, values);
		if (StringUtils.isNotEmpty(pageSort))
			hql += " order by " + pageSort;
		List results = baseDao.findByHql(hql, values, pageIndex, pageMax);
		return new Page(pageIndex, totalCount, pageMax, results);
	}

	/***
	 * 根据SQL查询获取分页数据
	 * 
	 * @param sql
	 *            ：SQL语句
	 * @param values
	 *            ：参数值
	 * @param pageIndex
	 *            ：当前页码
	 * @param pageMax
	 *            ：每条显示记录数
	 */
	public Page findPageBySql(String sql, Object[] values, int pageIndex,
			int pageMax) throws Exception {
		int totalCount = baseDao.countBySql(sql, values);
		List results = baseDao.findBySql(sql, values, pageIndex, pageMax);
		return new Page(pageIndex, totalCount, pageMax, results);
	}

	/***
	 * 根据SQL查询获取分页数据
	 * 
	 * @param sql
	 *            ：SQL语句
	 * @param values
	 *            ：参数值
	 * @param pageSort
	 *            ：排序字段
	 * @param pageIndex
	 *            ：当前页码
	 * @param pageMax
	 *            ：每条显示记录数
	 */
	public Page findPageBySql(String sql, Object[] values, String pageSort,
			int pageIndex, int pageMax) throws Exception {
		int totalCount = baseDao.countBySql(sql, values);
		if (StringUtils.isNotEmpty(pageSort))
			sql += " order by " + pageSort;
		List results = baseDao.findBySql(sql, values, pageIndex, pageMax);
		return new Page(pageIndex, totalCount, pageMax, results);
	}

	/***
	 * 导出成EXCEL
	 * 
	 * @param beans
	 *            和模板对应的元素
	 * @param is
	 *            输出流
	 * @param os
	 *            输出流
	 * @throws Exception
	 * @throws Exception
	 */
	public void outputToExcel(Map beans, InputStream is, OutputStream os) {
		HSSFWorkbook book = null;
		XLSTransformer transformer = new XLSTransformer();
		try {
			book = (HSSFWorkbook) transformer.transformXLS(is, beans);
			book.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Long getSequence(String sequence) throws Exception{
		String sql=new StringBuffer("select ").append(sequence).append(".nextval seq from dual").toString();
		return Long.valueOf(((Map)baseDao.findBySql(sql).get(0)).get("SEQ").toString());
	}
	
	public void saveList(List list) throws Exception{
		baseDao.saveOrUpdateList(list);
	}
	
	public List findByHql(String hql) throws Exception{
		return baseDao.findByHql(hql);
	}
	
	public List findByHql(String hql,Object[] values) throws Exception{
		return baseDao.findByHql(hql,values);
	}
	
	public Object findById(Class tableClass,Serializable primaryKey) throws Exception{
		return baseDao.findById(tableClass, primaryKey);
	}
	
	public void saveOrUpdate (Object object) throws Exception {
		baseDao.saveOrUpdate(object);
	}
	
	public void delete (Object object) throws Exception {
		baseDao.delete(object);
	}
}
