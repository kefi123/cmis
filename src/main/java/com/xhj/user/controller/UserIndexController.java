package com.xhj.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserIndexController {

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
	public String edit_userinfo() {
		return "user/edit_userinfo";
	}
}
