package com.passport.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.passport.bean.Account;
import com.passport.bean.LevelInfo;
import com.passport.bean.RegInfo;
import com.passport.service.UserProvService;

@Controller
@RequestMapping("/prov")
public class UserProvController {

	@Resource private UserProvService provService;
	//redirect/forward:url
	@RequestMapping("/login")
	public String login(Account user, HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirect) {
		
		Account u = provService.login_general(user.getUserName(), user.getPassword());
		if (u != null)
		{
			///用户登陆成功
			System.out.println("登陆成功");
			req.setAttribute("user", u);
			return "forward:detail.do";
		}
		System.out.println("登陆失败");
		return "redirect:loginView.do";
	}
	
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/reg")
	public String reg (Account user, HttpServletRequest req, HttpServletResponse resp)
	{
		RegInfo regInfo = new RegInfo();
		LevelInfo levelInfo = new LevelInfo();
		
		regInfo.setRegip(req.getRemoteHost());
		regInfo.setRegtime(new Date());
		
		regInfo.setAccount(user);
		user.setRegInfo(regInfo);

		levelInfo.setAccount(user);
		user.setLevelInfo(levelInfo);
		
		user.setLevelInfo(levelInfo );
		
		boolean ret = false;
		try {
			ret = this.provService.reg(user);
			req.setAttribute("msg", "结果 : "+ret);
		} catch (DataIntegrityViolationException e) {

			req.setAttribute("msg", "结果 : "+ret);
			return "redirect:regView.do";
		}
		return "WEB-INF/page/msg";
	}
	
	///////////////////////// View ///////////////////////
	@RequestMapping("/regView")
	public String regView (Account user, HttpServletRequest req, HttpServletResponse resp)
	{
		return "WEB-INF/page/reg";
	}
	@RequestMapping("/loginView")
	public String loginView (Account user, HttpServletRequest req, HttpServletResponse resp)
	{
		return "WEB-INF/page/login";
	}
	@RequestMapping("/detail")
	public String userDetail (Account user, HttpServletRequest req, HttpServletResponse resp)
	{
		return "WEB-INF/page/user_detail";
	}
}
