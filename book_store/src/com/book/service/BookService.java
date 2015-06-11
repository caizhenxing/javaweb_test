package com.book.service;

import java.util.List;

import com.book.domain.Book;
import com.book.domain.CutInput;

public interface BookService {

	///书列表
	public List<Book> bookList(CutInput pageInfo);
	
	/// 更新书库
	public void updateBookShelf();
	
	/// 更新书
	public void updateBook(Book book);
	
	/// 添加书
	public void addBook(Book book);
	
	/// 根据bookid获取一本书
	public Book getBook(Integer bookid);
	
	/// 根据contentid 获取一本书
	public Book getBook(String contentId);
}
