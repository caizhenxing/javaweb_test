package com.book.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.book.domain.CutInput;
import com.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookManagerAction {
	
	@Resource private BookService bookService;
	@SuppressWarnings("unchecked")
	@RequestMapping("/books")
	public String books(CutInput input, HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirect) {
		
		List books = bookService.bookList(input);

		JSONObject json = new JSONObject();
		json.put("books", books);
		json.put("page", input);
		req.setAttribute("json", json.toString());
		System.out.println(json.toString());
		return "WEB-INF/page/jsonView";
	}
	
	@RequestMapping("/update")
	public String updateBooks(HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirect) {
		
		bookService.updateBookShelf();
		return "WEB-INF/page/msg";
	}
	
	@RequestMapping("/bookview")
	public String booksView(CutInput input, HttpServletRequest req, HttpServletResponse resp) {
		
		return "WEB-INF/page/book/book_list";
	}
}
