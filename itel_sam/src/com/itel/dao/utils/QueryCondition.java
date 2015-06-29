package com.itel.dao.utils;

import java.io.Serializable;
import java.util.Map;
/**
 * 条件查询实体Bean
 * @author yangxuan
 *
 * @param <E>
 */
public class QueryCondition<E> implements Serializable{

	private static final long serialVersionUID = 4172744373824160768L;
	private String sql;
	private Object[] obj;
	private Map<String,Object> fields;//字段名称
	private Integer pageIndex;//当前页数
	private Integer pageMax;//每页条数
	private String tableName;//表名
	
	private String[] likeFields;//模糊查询
	private String likeValue;
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
 
	public Object[] getObj() {
		return obj;
	}
	public void setObj(Object[] obj) {
		this.obj = obj;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageMax() {
		return pageMax;
	}
	public void setPageMax(Integer pageMax) {
		this.pageMax = pageMax;
	}
	public Map<String, Object> getFields() {
		return fields;
	}
	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}
	public String[] getLikeFields() {
		return likeFields;
	}
	public void setLikeFields(String[] likeFields) {
		this.likeFields = likeFields;
	}
	public String getLikeValue() {
		return likeValue;
	}
	public void setLikeValue(String likeValue) {
		this.likeValue = likeValue;
	}
	 
 
	
	
}
