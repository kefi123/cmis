package com.xhj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.user.entity.Cindustry;
import com.xhj.user.mapper.CindustryMapper;

@Service
public class CindustryService {
	@Autowired
	CindustryMapper cIndustryMapper;
	
	// 更新二级行业信息
	public boolean updateCIndustry(Cindustry ci) {
		return cIndustryMapper.updateCIndustry(ci);
	}
	
	// 删除二级行业信息
	public boolean deleteCIndustry(int c_industry_id) {
		return cIndustryMapper.deleteCIdustry(c_industry_id);
	}
	
	// 分页查询二级行业信息
	public PageInfo<Cindustry> getCIndustry(int page, int size) {
		
		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		
		//获取数据
		List<Cindustry> cIndustrys = cIndustryMapper.selectCIndustrys();
		
		// 封装分页之后的数据
		PageInfo<Cindustry> pageInfoCIndustry = new PageInfo<Cindustry>(cIndustrys);
		
		return pageInfoCIndustry;
	}
	
	// 添加二级行业信息
	public boolean addCIndustry(Cindustry ci) {
		boolean result = cIndustryMapper.addCIndustry(ci);
		return result;
	}
	
	//根据id返回结果
	public Cindustry selectById(int id){
		return cIndustryMapper.select_child_industry(id);
	}
	

	// 查询child
	public List<Cindustry> getChilds(int p_industry_id) {
		return cIndustryMapper.selectChilds(p_industry_id);
	}
}
