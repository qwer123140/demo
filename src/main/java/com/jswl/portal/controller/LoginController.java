package com.jswl.portal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jswl.portal.common.util.ResultUtil;
import com.jswl.portal.dto.MenuTreeNodeDto;
import com.jswl.portal.dto.ResultDto;
import com.jswl.portal.entity.User;
import com.jswl.portal.service.MenuService;
import com.jswl.portal.service.UserService;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@RequestMapping("/login")
	public String toLOginPage() {
		return "admin/login";
	}
	 @RequestMapping("/doLogin")
	 @ResponseBody
	public ResultDto<String> doLogin(String userCode,String password,HttpSession session){
		//接受参数
		User user = userService.loginUser(userCode, password);
		if (user!=null) {
			session.setAttribute("user", user);
			return ResultUtil.success("登录成功");
		}
		return ResultUtil.fail("登录失败");
		
	}
	@RequestMapping("/index")
	public String index() {
		return "admin/index";
	}
	@RequestMapping("/header")
	public String header() {
		return "admin/header";
	}
	@RequestMapping("/left")
	public String left() {
		return "admin/left";
	}
	@RequestMapping("/main")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("/getMenuByUserId")
	@ResponseBody
	public ResultDto<MenuTreeNodeDto> getMenuByUserId(HttpSession session){
		User user = (User)session.getAttribute("user");
		
		if(user!=null) {
			MenuTreeNodeDto menusInfo = menuService.findMenusInfo(user.getId());
			return ResultUtil.success(menusInfo);
		}
		//如果用户未登录，则返回异常信息
		return ResultUtil.fail();
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//销毁session
		session.invalidate();
		
		return "redirect:/admin/login";
	}
	
	
	
	
	
	
	
	
	
	


}
