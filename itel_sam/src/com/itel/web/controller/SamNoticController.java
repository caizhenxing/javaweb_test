package com.itel.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itel.data.GridResult;
import com.itel.domain.SamDevice;
import com.itel.domain.SamNotic;
import com.itel.service.ISamNoticService;
import com.itel.tools.ControllerSupport;


@Controller
@RequestMapping("/samNoticController")
public class SamNoticController extends ControllerSupport<SamNotic>{
	
	@Autowired
	private ISamNoticService iSamNoticService;
	

	@Override
	public ModelAndView add(SamNotic entity) {
		entity.setUid(UUID.randomUUID().toString());
		return super.add(entity);
	}
	
	@RequestMapping(value="/deleteNotics",method=RequestMethod.POST)
	public ModelAndView deleteNotics(String[] ids){
		for(String id : ids){
			System.out.println(id);
		}
		GridResult gridResult = iSamNoticService.deleteSamNotics(ids);
		return new ModelAndView("jsonView",gridResult);
	}
	
	

}
