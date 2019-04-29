package com.xhj.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserDynamicController {
	
	@RequestMapping("/dynamic")
	public String dynamic() {
		
		//跳转到动态页面
		return "user/dynamic/dynamic";
		
	}
	
	//把动态的图片内容一起存入数据库
	@RequestMapping("storageMassDynamicPic")
	public String storageMassDynamicPic(MultipartFile[] files){
		
		for(MultipartFile file:files){
			System.out.println(file.getOriginalFilename());
		}
		
		return "user/dynamic/dynamic";
	}
	
}
