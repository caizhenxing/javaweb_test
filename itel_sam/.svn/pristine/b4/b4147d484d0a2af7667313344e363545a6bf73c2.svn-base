package com.itel.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamHelpCenter;
import com.itel.service.ISamHelpCenterService;
import com.itel.tools.ControllerSupport;

/**
 * 帮助中心控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/samHelpCenterController")
public class SamHelpCenterController extends ControllerSupport<SamHelpCenter>{
	
	@Autowired
	private ISamHelpCenterService iSamHelpCenterService;

	@Override
	public ModelAndView add(SamHelpCenter entity) {
		return super.add(entity);
	}
	
	
	@RequestMapping(value="/deleteSamHelpCenters",method=RequestMethod.POST)
	public ModelAndView deleteSamHelpCenters(String[] ids){
		for(String id : ids){
			System.out.println(id);
		}
		GridResult gridResult = iSamHelpCenterService.deleteSamHelpCenters(ids);
		return new ModelAndView("jsonView",gridResult);
	}
	
	
	@RequestMapping(value="/SamHelpCenter",method=RequestMethod.GET)
	public String deleteSamHelpCenters(QueryCondition<SamHelpCenter> queryCondition,ModelMap modelMap){
		queryCondition.setTableName("com.itel.domain.SamHelpCenter");
		List<SamHelpCenter> list = this.baseDao.queryForWhereAnd(queryCondition);
		modelMap.put("list", list);
		return "help";
	}
	

}
