package com.itel.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.itel.data.GridResult;
import com.itel.domain.SamAuthor;
import com.itel.service.ISamAuthorService;
import com.itel.tools.ControllerSupport;


/**
 * 设备授权控制类
 * @author yangxuan
 *
 */
@Controller
@RequestMapping("/samAuthorController")
public class SamAuthorController extends ControllerSupport<SamAuthor>{
	private final static Logger log = Logger.getLogger(SamAuthorController.class);
	
	@Autowired
	private ISamAuthorService iSamAuthorService;
	
	/**
	 * 添加授权用户
	 */
	@RequestMapping(value="/addSamAuthor",method=RequestMethod.POST)
	public ModelAndView addSamAuthor(SamAuthor entity) {
		GridResult grid = iSamAuthorService.saveSamAuthor(entity);
		return new ModelAndView("jsonView",grid);
	}
	
	/**
	 * 设备itel下的授权用户信息列表
	 * @param samAuthor
	 * @return
	 */
	@RequestMapping(value="/getSamAuthorByPitel",method=RequestMethod.GET)
	public ModelAndView getSamAuthorByPitel(SamAuthor samAuthor){
		GridResult<SamAuthor> grid = iSamAuthorService.getAuthorListByPitel(samAuthor);
		return new ModelAndView("jsonView",grid);
	}
	
	/**
	 * 修改绑定用户信息
	 * @return
	 */
	@RequestMapping(value="/updateSamAuthor",method=RequestMethod.POST)
	public ModelAndView updateSamAuthor(SamAuthor samAuthor){
		GridResult grid = iSamAuthorService.updateSamAuthor(samAuthor);
		return new ModelAndView("jsonView",grid);
	}
	
	
	/**
	 * 删除绑定用户
	 * @return
	 */
	@RequestMapping(value="/deleteSamAuthor",method=RequestMethod.POST)
	public ModelAndView deleteSamAuthor(SamAuthor samAuthor){
		GridResult grid = iSamAuthorService.deleteSamAuthor(samAuthor);
		return new ModelAndView("jsonView",grid);
	}
}
