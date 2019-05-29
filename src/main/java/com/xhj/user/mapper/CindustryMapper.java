package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.user.entity.Cindustry;

@Mapper
public interface CindustryMapper {
	
	// 更新二级行业信息
	@Update("update t_child_industry set p_industry_id=#{p_industry_id},c_industry_name=#{c_industry_name} where c_industry_id=#{c_industry_id}")
	boolean updateCIndustry(Cindustry ci);
	
	// 删除二级行业信息
	@Delete("delete from t_child_industry where c_industry_id=#{c_industry_id}")
	boolean deleteCIdustry(int c_industry_id);
	
	// 查询所有二级行业信息
	@Select("select * from `t_child_industry`")
	List<Cindustry> selectCIndustrys();
	
	// 通过id查找
	@Select("select * from `t_child_industry` where c_industry_id = #{c_industry_id}")
	Cindustry select_child_industry(int c_industry_id);
	
	// 通过p_industry_id查询child
	@Select("select * from `t_child_industry` where p_industry_id=#{p_industry_id}")
	List<Cindustry> selectChilds(int p_industry_id);
	
	// 插入二级行业信息
	@Insert("insert into t_child_industry (p_industry_id,c_industry_name) values(#{p_industry_id},#{c_industry_name})")
	boolean addCIndustry(Cindustry ci);
}
