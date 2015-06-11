package com.book.service.impl;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.book.domain.Book;
import com.book.domain.CutInput;
import com.book.general.TxtOpreation;
import com.book.service.BookContentService;
import com.book.service.BookService;

@Transactional
public class BookContentServiceImpl implements BookContentService {
	
	@Resource
	private BookService bookService;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String getContentPart(CutInput input, Integer bookId) {

		Book book = bookService.getBook(bookId);
		File bookFile = new File(book.getPath());

		String content = TxtOpreation.txtCut(bookFile, input);
		return content;

	}
}
