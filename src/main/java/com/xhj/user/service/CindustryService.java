package com.xhj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Cindustry;
import com.xhj.user.mapper.CindustryMapper;

@Service
public class CindustryService {
	@Autowired
	CindustryMapper cIndustryMapper;
	
	//根据id返回结果
	public Cindustry selectById(int id){
		return cIndustryMapper.select_child_industry(id);
	}
	

	// 查询child
	public List<Cindustry> getChilds(int p_industry_id) {
		return cIndustryMapper.selectChilds(p_industry_id);
	}
}
