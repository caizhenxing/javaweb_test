package com.book.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.book.domain.Book;
import com.book.domain.CutInput;
import com.book.general.Base64;
import com.book.general.StringUtils;
import com.book.service.BookContentService;
import com.book.service.BookService;

@Controller
@RequestMapping("/bookContent")
public class BookContentAction {

	@Resource
	private BookContentService contentService;
	@Resource
	private BookService bookService;

	@RequestMapping("/part")
	public String getContent(CutInput input, Integer bookId,
			HttpServletRequest req, HttpServletResponse resp,
			RedirectAttributes redirect) {

		if (input == null) {
			input = new CutInput(0, 300);
		}
		if (input.getLen() == 0) {
			input.setLen(300);
		}
		//System.out.println("要读取的信息: " + input.getOff() + "," + input.getLen());
		Book book = bookService.getBook(bookId);
		String part = contentService.getContentPart(input, bookId);
		//System.out.println("读到的长度 :" + part.length());
		if (part != null) {
			// byte[] bs = part.getBytes();
			// //用新的字符编码生成字符串
			// try {
			// part = new String(bs, "GBK");
			// } catch (UnsupportedEncodingException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			 part = Base64.encode(part);
			 part = StringUtils.replaceBlank(part);
			// System.out.println("编码:\n"+part);
			// System.out.println("反编码:\n"+Base64.decode(part));

			req.setAttribute("part", part);
		}
		req.setAttribute("book", book);
		req.setAttribute("page", input);

		// if (client == 1) {
		JSONObject json = new JSONObject();
		json.put("book", book);
		json.put("page", input);
		json.put("part", part);
		req.setAttribute("json", json.toString());
		System.out.println(json.toString());
		return "WEB-INF/page/jsonView";
		// }
		// return "WEB-INF/page/book/book_content";
	}

	@RequestMapping("/partview")
	public String getContentPage(Integer bookid, HttpServletRequest req,
			HttpServletResponse resp) {
		
		Book book = bookService.getBook(bookid);
		req.setAttribute("book", book);
		req.setAttribute("page", new CutInput(0, 2048));
		return "WEB-INF/page/book/book_content";
	}
}
