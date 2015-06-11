package com.book.test;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.book.domain.CutInput;
import com.book.service.BookContentService;
import com.book.service.BookService;

public class Test {

	private static BookService bookService;
	private static BookContentService contentService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"config/beans.xml");
			bookService = (BookService) context.getBean("bookService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@org.junit.Test
	public void testGetBook() {
		List l = bookService.bookList(new CutInput(0, 20));
		System.out.println(""+l);
	}
	
	@org.junit.Test
	public void testGetBookContent() {
		CutInput input = null;
		Integer bookId = null;
		String l = contentService.getContentPart(input, bookId);
		System.out.println(""+l);
	}
}
