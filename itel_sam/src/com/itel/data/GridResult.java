package com.itel.data;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * 数据协议集,继承LinkedHashMap实现key-value的展示
 * @author yangxuan
 *
 * @param <E>
 */
public class GridResult<E> extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 2539990099370837658L;

	public GridResult() {
		put("success", Boolean.valueOf(true));
	}
	

	public GridResult(Collection<E> results, int totalCount) {
		this();
		setTotalCount(totalCount);
		setResults(results);
	}

	public void setSuccess(boolean success) {
		put("success", Boolean.valueOf(success));
	}
	
	public void setMsg(String msg) {
		put("msg", msg);
	}

	public void setTotalCount(int totalCount) {
		put("totalCount", Integer.valueOf(totalCount));
	}

	public void setResults(Collection<E> results) {
		put("results", results);
	}
}
