package com.example.final_work.controller.backend;


import com.example.final_work.pojo.BackendUser;
import com.example.final_work.service.backend.BackendUserService;
import com.example.final_work.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/manager2")
public class UserLoginController {
	private Logger logger = Logger.getLogger(UserLoginController.class);
	public static int user_id;
	@Resource
	private BackendUserService backendUserService;
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppInfoSystem backend==================");
		return "backendlogin";
	}
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request, HttpSession session) throws Exception {
		logger.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		BackendUser user = null;
		try {
			user = backendUserService.login(userCode,userPassword);
			user_id=user.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user){
            session.setAttribute("backinfo", backendUserService.login(userCode,userPassword));
            session.setAttribute("backuserid",user_id);
            System.out.println(user);
            return "/backend/main";
		}else{
			session.setAttribute("error", "用户名或密码不正确");
			return "backendlogin";
		}
	}
	
	@RequestMapping(value="/backend/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.USER_SESSION) == null){
			return "redirect:/manager2/login";
		}
		return "backend/main";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		//清除session
		session.removeAttribute(Constants.USER_SESSION);
		return "login";
	}
}
