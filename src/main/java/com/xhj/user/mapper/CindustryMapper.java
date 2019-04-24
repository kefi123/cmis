package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xhj.user.entity.Cindustry;

@Mapper
public interface CindustryMapper {
	// 通过id查找
	@Select("select * from `t_child_industry` where c_industry_id = #{c_industry_id}")
	Cindustry select_child_industry(int c_industry_id);
	
	// 通过p_industry_id查询child
	@Select("select * from `t_child_industry` where p_industry_id=#{p_industry_id}")
	List<Cindustry> selectChilds(int p_industry_id);
}
