package com.itel.tools;

import java.util.List;

/**
 * 分页对象
 * @author 何挺
 * @date 2013-1-19
 */
public class Page {

	/**
	 * 默认每页显示记录数
	 */
	public final static int DEFAULT_PAGE_SIZE = 20;
	
	/**
	 * 当前页数
	 */
	private int pageIndex = 1;
	
	/**
	 * 每页显示记录数
	 */
	private int pageMax = DEFAULT_PAGE_SIZE;
	
	/**
	 * 总记录数
	 */
	private int totalRecord;
	
	/**
	 * 查询结果集
	 */
	private List<?> result;

	/**
	 * 构造方法
	 * @param pageIndex
	 * @param totalRecord
	 * @param result
	 */
	public Page(int pageIndex, int totalRecord, List<?> result){
		this.pageIndex = pageIndex;
		this.totalRecord = totalRecord;
		this.result = result;
	}
	
	/**
	 * 构造方法
	 * @param pageIndex
	 * @param totalRecord
	 * @param pageMax
	 * @param result
	 */
	public Page(int pageIndex, int totalRecord, int pageMax, List result){
		this.pageIndex = pageIndex;
		this.totalRecord = totalRecord;
		this.pageMax = pageMax;
		this.result = result;
	}
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageMax() {
		return pageMax;
	}

	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
		if(pageMax < 1){
			this.pageMax = 1;
		}
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}
	
}
