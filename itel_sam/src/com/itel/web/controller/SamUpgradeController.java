package com.itel.web.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamUpgrade;
import com.itel.service.ISamUpgradeService;
import com.itel.tools.ControllerSupport;
import com.itel.utils.Constants;

/**
 * 版本更新控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/samUpgradeController")
public class SamUpgradeController extends ControllerSupport<SamUpgrade> {
	private final String ANDROID = Constants.PlatForm_Android;
	private final String IOS = Constants.PlatForm_IOS;
	
	@Autowired
	private ISamUpgradeService iSamUpgradeService;

	/**
	 * 获取最新版本
	 * @param samUpgrade
	 * @return
	 */
	@RequestMapping(value = "/getLastVersion", method = RequestMethod.GET)
	public ModelAndView getLastVersion(SamUpgrade samUpgrade) {
		GridResult<SamUpgrade> gridResult = iSamUpgradeService.getLastVersion(samUpgrade);
		return new ModelAndView("jsonView",gridResult);
	}
	
	/**
	 * 获取所有发布版本信息
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value="/getVersionAll",method=RequestMethod.GET)
	public ModelAndView getVersionAll(QueryCondition queryCondition){
		GridResult gridResult = iSamUpgradeService.getVersionAll(queryCondition);
		return new ModelAndView("jsonView",gridResult);
	}
	/**
	 * 版本发布
	 * @return
	 */
	@RequestMapping(value="/pubVersion",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView pubVersion(SamUpgrade samUpgrade,@RequestParam("file") MultipartFile uploadfile,
			HttpServletRequest request,HttpServletResponse response){
		String platForm = samUpgrade.getPlatform();
		if(ANDROID.equals(platForm)){//Android平台
			String fileName = upload(uploadfile,request);
			samUpgrade.setUrl(fileName);
			
		}else if(IOS.equals(platForm)){//IOS平台
			samUpgrade.setUrl(samUpgrade.getIosurl());
		}
		GridResult gridResult = iSamUpgradeService.saveSamUpgrade(samUpgrade);
		return new ModelAndView("jsonView",gridResult);
	}
	
	/**
	 * 上传文件
	 * @param uploadfile
	 * @param request
	 */
	private String upload(MultipartFile uploadfile,HttpServletRequest request){
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "upload"+File.separator;
		String fileName = System.currentTimeMillis()+uploadfile.getOriginalFilename();
		File file = new File(ctxPath + fileName);
		try {
			uploadfile.transferTo(file); // 保存上传的文件
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	@RequestMapping(value="/pubVersion/pubVersionByIOS",method=RequestMethod.POST)
	public ModelAndView pubVersionByIOS(SamUpgrade samUpgrade){
		samUpgrade.setUrl(samUpgrade.getIosurl());
		GridResult gridResult = iSamUpgradeService.saveSamUpgrade(samUpgrade);
		return new ModelAndView("jsonView",gridResult);
	}
	
	@RequestMapping(value="/getVersionAllByType/{type}")
	public ModelAndView getVersionAllByType(@PathVariable("type")String type){
		GridResult gridResult = iSamUpgradeService.getVersionAllByType(type);
		return new ModelAndView("jsonView",gridResult);
	}
	
	@RequestMapping(value="/updateSamUpgrade",method=RequestMethod.POST)
	public ModelAndView updateSamUpgrade(SamUpgrade samUpgrade){
		GridResult gridResult = iSamUpgradeService.updateSamUpgrade(samUpgrade);
		return new ModelAndView("jsonView",gridResult);
	}

}
