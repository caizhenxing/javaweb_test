package com.book.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.book.domain.Book;
import com.book.domain.CutInput;
import com.book.general.LocalOperationService;
import com.book.general.TxtOpreation;
import com.book.service.BookService;

@Transactional
public class BookServiceImpl implements BookService {

	@Resource
	private SessionFactory sessionFactory;
	private boolean update;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Book> bookList(CutInput pageInfo) {
		Session s = sessionFactory.getCurrentSession();
		Query qCount = s.createQuery("select count(*) from Book");
		Query q = s.createQuery("from Book");
		List<Long> counts = qCount.list();
		Long count = counts.get(0);
		q.setFirstResult(pageInfo.getOff());
		q.setMaxResults(pageInfo.getLen());
		
		System.out.println("总数:"+count);
		List<Book> books = q.list();
		
		return books;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Book getBook(Integer bookid) {
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book where bookid=:bookId");
		q.setInteger("bookId", bookid);
		List<Book> books = q.list();
		if (books.size() > 0) {
			return books.get(0);
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Book getBook(String contentId) {

		return null;
	}

	public void updateBook(Book book) {

	}

	public void updateBookShelf() {

		if (this.update) {
			return;
		}
		this.update = true;
		new Thread(new Runnable() {
			public void run() {

				System.out.println("开始更新");
				File rootFolder = new File("F:/data/ebook");
				File[] subFiles = rootFolder.listFiles();
				for (int i = 0; i < subFiles.length; i++) {
					File subFile = subFiles[i];
					if (subFile.isFile()) {
						Book newBook = new Book();

						newBook.setName(subFile.getName());
						newBook.setSize(subFile.length());
						newBook.setPath(subFile.getPath());
						String md5 = "";
						try {
							md5 = LocalOperationService.getMd5ByFile(subFile);
						} catch (FileNotFoundException e) {
							System.out.println("文件不存在");
						}
						newBook.setMd5(md5);
						newBook.setAuthor("n/a");
						newBook.setCarrier("admin");
//						newBook.setLastChangeDate(new Date());
//						newBook.setUploadDate(new Date());
						String introduction = TxtOpreation.txt2String(subFile, new CutInput(0, 4));
						if (introduction.length() > 200) {
							introduction = introduction.substring(0, 200);
						}
//						newBook.setIntroduction(introduction);
						
						System.out.println("文件名 : " + newBook.getName() + " md5 : " + newBook.getMd5());
						
						BookServiceImpl.this.addBook(newBook);
					}
				}
				System.out.println("结束更新");
			}
		}).run();
	}

	public void addBook(Book book) {
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(book);
	}

}
