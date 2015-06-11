package com.book.service;

import java.util.List;

import com.book.domain.Book;
import com.book.domain.CutInput;

public interface BookService {

	///���б�
	public List<Book> bookList(CutInput pageInfo);
	
	/// �������
	public void updateBookShelf();
	
	/// ������
	public void updateBook(Book book);
	
	/// �����
	public void addBook(Book book);
	
	/// ����bookid��ȡһ����
	public Book getBook(Integer bookid);
	
	/// ����contentid ��ȡһ����
	public Book getBook(String contentId);
}
