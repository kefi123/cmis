package com.xhj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "index/index";
	}

	@RequestMapping("/left")
	public String left() {
		return "index/left";
	}

	@RequestMapping("/head")
	public String head() {
		return "index/head";
	}

	@RequestMapping("/began")
	public String began() {
		return "index/began";
	}
}
