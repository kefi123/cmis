package com.xhj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Parent_industry;
import com.xhj.user.mapper.Parent_industryMapper;

@Service
public class Parent_industry_service {
	@Autowired
	Parent_industryMapper parentIndustryMapper;
	
	//根据id返回结果
	public Parent_industry selectById(int id){
		return parentIndustryMapper.select_parent_industry(id);
	}
	
	// 查询父类行业名称
	public List<Parent_industry> getPIndustrys() {
		return parentIndustryMapper.selectPIndustrys();
	}
}
