package com.itel.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;
import com.itel.domain.SamDevice;
import com.itel.service.ISamDeviceService;
import com.itel.tools.ControllerSupport;
import com.sencha.gxt.widget.core.client.form.DualListField.Mode;

/**
 * 设备信息控制类
 * 
 * @author yangxuan
 * 
 */
@Controller
@RequestMapping("/samDeviceController")
public class SamDeviceController extends ControllerSupport<SamDevice> {

	private final static Logger log = Logger
			.getLogger(SamDeviceController.class);

	@Autowired
	private ISamDeviceService iSamDeviceService;

	/**
	 * 添加摄像头-配置设备
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public ModelAndView addDevice(SamDevice entity) {
		GridResult gridResult = iSamDeviceService.saveSamDevice(entity);
		return new ModelAndView("jsonView", gridResult);

	}

	/**
	 * 设备解除绑定
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteDevice", method = RequestMethod.POST)
	public ModelAndView deleteDevice(SamDevice samDevice) {
		GridResult gridResult = iSamDeviceService.deleteSamDevice(samDevice);
		return new ModelAndView("jsonView", gridResult);
	}

	/**
	 * 添加摄像头-添加已有设备
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/addExistDevice", method = RequestMethod.POST)
	public ModelAndView addExitsDevice(SamDevice entity) {
		log.info("------>"+entity.getVarPitel());
		log.info("------>"+entity.getVarTitle());
		log.info("------>"+entity.getVarPassWord());
		GridResult gridResult = iSamDeviceService.saveExitsDevice(entity);
		return new ModelAndView("jsonView", gridResult);
	}

	/**
	 * 我的设备列表
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOwerDevice", method = RequestMethod.GET)
	public ModelAndView getOwerDevice(QueryCondition queryCondition) {
		GridResult<SamDevice> gridResult = iSamDeviceService
				.getOwerDevice(queryCondition);
		return new ModelAndView("jsonView", gridResult);
	}

	/**
	 * 我的监控列表修改设备别名
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateTitle", method = RequestMethod.POST)
	public ModelAndView updateTitle(SamDevice samDevice) {
		GridResult gridResult = iSamDeviceService.updateTitle(samDevice);
		return new ModelAndView("jsonView", gridResult);
	}

	/**
	 * 设置摄像头公开
	 * 
	 * @return
	 */
	@RequestMapping(value = "/setDeviceShare", method = RequestMethod.POST)
	public ModelAndView setDeviceShare(SamDevice samDevice) {
		GridResult gridResult = iSamDeviceService.updateDeviceShare(samDevice);
		return new ModelAndView("jsonView", gridResult);
	}

	/**
	 * 设置允许所有人绑定
	 * 
	 * @param samDevice
	 * @return
	 */
	@RequestMapping(value = "/setAllUserBind", method = RequestMethod.POST)
	public ModelAndView setAllUserBind(SamDevice samDevice) {
		GridResult gridResult = iSamDeviceService.updateAllUserBind(samDevice);
		return new ModelAndView("jsonView", gridResult);
	}
	
	
	@RequestMapping(value = "/querySamDeviceUitel", method = RequestMethod.POST)
	public ModelAndView querySamDeviceUitel(SamDevice samDevice) {
		GridResult gridResult = iSamDeviceService.querySamDeviceUitel(samDevice);
		return new ModelAndView("jsonView", gridResult);
	}
	
	@RequestMapping(value = "/queryShareDeviceByLike", method = RequestMethod.GET)
	public ModelAndView queryDeviceByLike(QueryCondition queryCondition) {
		queryCondition.setTableName("SamDevice");
		String[] likeFields = {"varPitel","varTitle"};
		queryCondition.setLikeFields(likeFields);
		GridResult gridResult = iSamDeviceService.queryDeviceByLike(queryCondition,"Y");
		return new ModelAndView("jsonView", gridResult);
	}
	
	/*@RequestMapping(value = "/queryOweDeviceByLike", method = RequestMethod.GET)
	public ModelAndView queryDeviceByLike(QueryCondition queryCondition) {
		queryCondition.setTableName("SamDevice");
		String[] likeFields = {"varPitel","varTitle"};
		queryCondition.setLikeFields(likeFields);
		GridResult gridResult = iSamDeviceService.queryDeviceByLike(queryCondition,"Y");
		return new ModelAndView("jsonView", gridResult);
	}*/
	
	/**
	 * 手机端解绑之后删除数据，采集需要轮询扫描自己的设备号，如果不存在，则说明解绑，然后初始化文件重启
	 */
	@RequestMapping(value="/queryDevice/{pitel}",method=RequestMethod.GET)
	public ModelAndView queryDeviceById(@PathVariable("pitel")String id,ModelMap modelMap){
		modelMap.clear();
		SamDevice samDevice = this.iSamDeviceService.querySamDeviceById(id);
		int i = 0;
		if(samDevice!=null){
			i = 1;
		}
		modelMap.put("exist", i);
		return  new ModelAndView("jsonView", modelMap);
	}
	


}
