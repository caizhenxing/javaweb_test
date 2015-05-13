package com.y0.action;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.y0.bean.User;
import com.y0.formbean.UserForm;
import com.y0.service.UserService;

public class UserManagerAaction extends Action {

	@Resource UserService userService;

	public ActionForward add(ActionMapping action, ActionForm form,
			ServletRequest req, ServletResponse rsq) throws Exception {
		System.out.println("«Î«ÛµΩ¿¥");
		User user = new User((UserForm)form);
		userService.save(user);
		req.setAttribute("user", user);
		return action.findForward("tip");
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		User user[] = {userService.query(3)};
		request.setAttribute("user", user);
		System.out.println(""+user.length);
		return mapping.findForward("user");
	}
}
