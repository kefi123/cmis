package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xhj.user.entity.Parent_industry;

@Mapper
public interface Parent_industryMapper {
	// 通过id查找
	@Select("select * from `t_parent_industry` where p_industry_id = #{p_industry_id}")
	Parent_industry select_parent_industry(int p_industry_id);
	
	// 查询所有父类行业名称
	@Select("select * from `t_parent_industry`")
	List<Parent_industry> selectPIndustrys();
}
