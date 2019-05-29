package com.xhj.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhj.user.entity.Cindustry;
import com.xhj.user.service.CindustryService;
import com.xhj.user.service.Parent_industry_service;

@Controller
public class CIndustryController {
	
	@Autowired
	Parent_industry_service pis;
	
	@Autowired
	CindustryService cis;
	
	// 更新二级行业信息
	@RequestMapping("/updateCIndustry")
	public String updateCIndustry(Cindustry ci, Map<String, Object> map) {
		map.put("status", cis.updateCIndustry(ci));
		return "getCIndustry?page=1&size=4";
	}
	
	//调转到修改页面
	@RequestMapping("/updateCIndustryFtl")
	public String updateCIndustryFtl(int c_industry_id,Map<String, Object> map) {
		//进入编辑页面时首先获取父类行业名称
		map.put("pIndustrys",pis.getPIndustrys());
		map.put("cIndustry",cis.selectById(c_industry_id));
		return "admin/cIndustry/update";
	}
	
	// 删除二级行业信息
	@RequestMapping("/deleteCIndustry")
	public String deleteCIndustry(int c_industry_id, Map<String, Object> map) {
		map.put("status",cis.deleteCIndustry(c_industry_id));
		return "getCIndustry?page=1&size=4";
	}
	
	// 查询所有一级行业信息
	@RequestMapping("/getCIndustry")
	public String getPIndustry(int page, int size, Map<String, Object> map) {
		map.put("pageInfos", cis.getCIndustry(page, size));
		map.put("hrefs", "getCIndustry");
		return "admin/cIndustry/find";

	}
	
	// 添加二级行业信息
	@RequestMapping("/addCIndustry")
	public String addCIndustry(Cindustry ci,Map<String,Object> map) {
		
		boolean status=cis.addCIndustry(ci);
		
		map.put("status", status);
		
		return "addCIndustryFtl";
	}
	
	//调转到添加页面
	@RequestMapping("/addCIndustryFtl")
	public String addCIndustry(Map<String, Object> map) {
		//进入编辑页面时首先获取父类行业名称
		map.put("pIndustrys",pis.getPIndustrys());
		return "admin/cIndustry/add";
	}
	
}
