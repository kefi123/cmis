package com.xhj.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.admin.entity.Admin;
import com.xhj.admin.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService as;
	
	//登录
	@RequestMapping("/adminLogin")
	public String adminLogin (Admin admin, HttpSession session){
		
		//管理员登录界面
		Admin newAdmin = as.adminLogin(admin);
		if (newAdmin!=null) {
			// 把用户信息存到session里
			session.setAttribute("newAdmin", newAdmin);
		}
		return "admin/index/index";
	}
	
	//调转到登录界面
	@RequestMapping("/adminLoginFtl")
	public String adminLoginFtl (){
		return "admin/login/admin_login";
	}
	
	//头部页面的显示
	@RequestMapping("/admin_head")
	public String admin_head (){
		return "admin/index/head";
	}
	
	//左侧菜单栏的显示
	@RequestMapping("/admin_left")
	public String admin_left(){
		return "admin/index/left";
	}
}
