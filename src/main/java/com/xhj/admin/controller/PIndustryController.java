package com.xhj.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.user.entity.Parent_industry;
import com.xhj.user.service.Parent_industry_service;

@Controller
public class PIndustryController {
	
	@Autowired
	Parent_industry_service pis;
	
	// 更新一级行业信息
	@RequestMapping("/updatePIndustry")
	public String updatePIndustry(Parent_industry pi, Map<String, Object> map) {
		map.put("status", pis.updatePIndustry(pi));
		return "getPIndustry?page=1&size=4";
	}

	// 通过id来查询一级行业信息
	@RequestMapping("/getPIndustryByID")
	public String getPIndustryByID(int p_industry_id, Map<String, Object> map) {
		map.put("pIndustry", pis.selectById(p_industry_id));
		return "admin/pIndustry/update";
	}
	
	// 添加一级行业信息
	@RequestMapping("/addPIndustry")
	public String addPIndustry(String p_industry_name,Map<String,Object> map) {
		
		boolean status=pis.addPIndustry(p_industry_name);
		
		map.put("status", status);
		
		return "addPIndustryFtl";
	}
	
	// 调转到添加页面
	@RequestMapping("/addPIndustryFtl")
	public String addPIndustryFtl() {
		return "admin/pIndustry/add";
	}
	
	// 查询所有一级行业信息
	@RequestMapping("/getPIndustry")
	public String getPIndustry(int page, int size, Map<String, Object> map) {
		map.put("pageInfos", pis.getPIndustry(page, size));
		map.put("hrefs", "getPIndustry");
		return "admin/pIndustry/find";

	}
	
	// 删除一级行业信息
	@RequestMapping("/deletePIndustry")
	public String deletePIndustry(int p_industry_id, Map<String, Object> map) {
		map.put("status",pis.deletePIndustry(p_industry_id));
		return "getPIndustry?page=1&size=4";
	}
}
