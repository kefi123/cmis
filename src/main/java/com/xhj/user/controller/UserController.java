package com.xhj.user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.user.entity.User;
import com.xhj.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// 跳转到登录页面
	@RequestMapping("/loginFtl")
	public String loginFtl() {
		return "user/login/login";
	}

	// 登录
	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		String result = userService.login(user);
		if (result.equals("登录成功")) {
			// 把用户信息存到session里
			session.setAttribute("ulogined", user);
			return "index/index";
		}
		return "user/login/login";
	}

	// 退出登录
	@RequestMapping("/dlogin")
	public String dlogin(HttpSession session) {
		session.removeAttribute("ulogined");
		return "login/login";
	}

	// 跳转到注册页面
	@RequestMapping("/registerFtl")
	public String registerFtl() {
		return "login/register";
	}

	/*
	// 注册
	@RequestMapping("/register")
	public String register(User user, Map<String, Object> map) {
		boolean result = userService.register(user);
		if (result == true)
			return "login/login";
		return "login/register";
	}
	*/
}
