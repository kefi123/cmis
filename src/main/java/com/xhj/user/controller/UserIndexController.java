package com.xhj.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.user.service.Parent_industry_service;

@Controller
public class UserIndexController {
	
	@Autowired
	Parent_industry_service pis;

	@RequestMapping("/user_index")
	public String user_index() {
		return "user/index/index";
	}

	@RequestMapping("/user_left")
	public String user_left() {
		return "user/index/left";
	}

	@RequestMapping("/user_head")
	public String user_head() {
		return "user/index/head";
	}
	
	@RequestMapping("/edit_userinfo")
	public String edit_userinfo(Map<String, Object> map) {
		map.put("pIndustrys",pis.getPIndustrys());
		return "user/edit_userinfo";
	}
}
