package com.xhj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("/getDate")
	public String getDate() {
		return "other/date";
	}
	@RequestMapping("/test")
	public String test() {
		return "other/test";
	}
}
