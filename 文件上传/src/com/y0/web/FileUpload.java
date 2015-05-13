package com.y0.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUpload {

	@RequestMapping("/uploadpage")
	public ModelAndView test(HttpServletRequest req, HttpServletResponse rsp) {
		System.out.println("到达上传界面");
		return new ModelAndView("upload");
	}
	
	
	@RequestMapping("/uploadfile")
	public ModelAndView upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req, HttpServletResponse rsp) {

		/**
		 * 存贮方式一
		 */
//		String name = file.getOriginalFilename();
//		System.out.println("文件的名字"+name);
//		
//		try {
//			FileInputStream in = (FileInputStream) file.getInputStream();
//			
//			File f = new File("E:/test");
//			if (!f.exists()) {
//				f.mkdir();
//			}
//			FileOutputStream os = new FileOutputStream(f.getPath()+"/"+name);
//			int i = 0;
//			while ((i = in.read())!=-1) {
//				
//				os.write(i);
//			}
//			os.flush();
//			os.close();
//			in.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		/**
		 * 存贮方式二
		 */
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getSession().getServletContext());
		
		if (resolver.isMultipart(req)) {
			
			MultipartHttpServletRequest multipartreq = (MultipartHttpServletRequest)req;
			Iterator<String> iterator = multipartreq.getFileNames();
			
			while (iterator.hasNext()) {
				
				MultipartFile currentFile = multipartreq.getFile(iterator.next());
				
				File f = new File("E:/测试--"+currentFile.getOriginalFilename());
				try {
					currentFile.transferTo(f);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return new ModelAndView("index");
	}
	
}
