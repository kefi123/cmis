package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xhj.user.entity.Parent_industry;

@Mapper
public interface Parent_industryMapper {
	
	// 更新一级行业信息
	@Update("update t_parent_industry set p_industry_name=#{p_industry_name} where p_industry_id=#{p_industry_id}")
	boolean updatePIndustry(Parent_industry pIndustry);
	
	// 删除一级行业信息
	@Delete("delete from t_parent_industry where p_industry_id=#{p_industry_id}")
	boolean deletePIdustry(int p_industry_id);
	
	// 通过id查找
	@Select("select * from `t_parent_industry` where p_industry_id = #{p_industry_id}")
	Parent_industry select_parent_industry(int p_industry_id);
	
	// 查询所有父类行业名称
	@Select("select * from `t_parent_industry`")
	List<Parent_industry> selectPIndustrys();
	
	// 插入一级行业信息
	@Insert("insert into t_parent_industry(p_industry_name) values(#{p_industry_name})")
	boolean addPIndustry(String p_industry_name);
}
