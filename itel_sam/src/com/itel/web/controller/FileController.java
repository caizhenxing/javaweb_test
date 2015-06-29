package com.itel.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.itel.domain.SamUpgrade;

/**
 * 文件上传下载控制类
 * @author yangxuan
 *
 */
@Controller
@RequestMapping("/fileController")
public class FileController {

	/**
	 * 文件上传
	 * @param samUpgrade
	 * @param uploadfile
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(SamUpgrade samUpgrade,@RequestParam("file") MultipartFile uploadfile,
			HttpServletRequest request) throws IOException {

		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "\\" + "upload\\";
		System.out.println("路径：" + ctxPath);
		File file = new File(ctxPath + "/" + uploadfile.getOriginalFilename());
		try {
			uploadfile.transferTo(file); // 保存上传的文件
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
	
	/**
	 * 文件下载{fileName:.*} 必须增加.*,否则文件名*.apk会被过滤掉.apk
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/download/{fileName:.*}")
	public ModelAndView download(@PathVariable("fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ File.separator + "upload"+File.separator;
		String downLoadPath = ctxPath + fileName;
		System.out.println(downLoadPath);
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

}
