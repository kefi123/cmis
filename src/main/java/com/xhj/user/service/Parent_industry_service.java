package com.xhj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.user.entity.Parent_industry;
import com.xhj.user.mapper.Parent_industryMapper;

@Service
public class Parent_industry_service {
	@Autowired
	Parent_industryMapper parentIndustryMapper;
	
	// 更新一级行业信息
	public boolean updatePIndustry(Parent_industry pi) {
		return parentIndustryMapper.updatePIndustry(pi);
	}
	
	// 删除一级行业信息
	public boolean deletePIndustry(int p_industry_id) {
		return parentIndustryMapper.deletePIdustry(p_industry_id);
	}
	
	//根据id返回结果
	public Parent_industry selectById(int id){
		return parentIndustryMapper.select_parent_industry(id);
	}
	
	// 查询父类行业名称
	public List<Parent_industry> getPIndustrys() {
		return parentIndustryMapper.selectPIndustrys();
	}
	
	// 分页查询一级行业信息
	public PageInfo<Parent_industry> getPIndustry(int page, int size) {
		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		
		//获取数据
		List<Parent_industry> pIndustrys = parentIndustryMapper.selectPIndustrys();
		
		// 封装分页之后的数据
		PageInfo<Parent_industry> pageInfoPIndustry = new PageInfo<Parent_industry>(pIndustrys);
		
		return pageInfoPIndustry;
	}
	
	// 添加一级行业信息
	public boolean addPIndustry(String p_industry_name) {
		boolean result = parentIndustryMapper.addPIndustry(p_industry_name);
		return result;
	}
}
