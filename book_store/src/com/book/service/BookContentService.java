package com.book.service;

import com.book.domain.CutInput;

public interface BookContentService {

	/// ��ȡ��Ĳ���
	public String getContentPart(CutInput input, Integer bookId);
}
