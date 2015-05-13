package com.y0.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.y0.bean.User;
import com.y0.service.UserService;


//@Controller
public class UserAction extends Action {

	@Resource UserService userService;
//	@RequestMapping("userList")
//	public ModelAndView name(HttpServletRequest req, HttpServletResponse rsp) {
//		
//		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
//		
//		UserService userService = (UserService) ctx.getBean("userService");
//		User user[] = {userService.query(3)};
//		req.setAttribute("user", user);
//		return new ModelAndView("user");
//	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// WebApplicationContext ctx =
		// WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//		
		// UserService userService = (UserService) ctx.getBean("userService");
		User user[] = {userService.query(3)};
		request.setAttribute("user", user);
		System.out.println(""+user.length);
		return mapping.findForward("user");
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// WebApplicationContext ctx =
		// WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//		
		// UserService userService = (UserService) ctx.getBean("userService");
		User user[] = {userService.query(3)};
		request.setAttribute("user", user);
		System.out.println(""+user.length);
		return mapping.findForward("user");
	}
}
