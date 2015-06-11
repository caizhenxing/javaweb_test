package com.book.service;

import com.book.domain.CutInput;

public interface BookContentService {

	/// 获取书的部分
	public String getContentPart(CutInput input, Integer bookId);
}
