package com.xhj.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.xhj.user.entity.Dynamic;
import com.xhj.user.entity.DynamicPic;

@Mapper
public interface DynamicMapper {
	
	
	//往数据库里插入动态信息
	@Insert("insert into t_dynamics (dynamic_user_id,dynamic_content) values (#{dynamic_user_id},#{dynamic_content})")
	@Options(useGeneratedKeys = true, keyProperty = "dynamic_id", keyColumn = "dynamic_id")
	public int insert(Dynamic dynamic);
	
	//往数据库里插入动态图片信息
	@Insert("insert into t_dynamic_pictures (dynamic_id,dynamic_picture_path) values (#{dynamic_id},#{dynamic_picture_path})")
	public int insertPic(DynamicPic dynamicPic);
	
	//从数据库里读出所有的动态信息
	@Select("select * from t_dynamics")
	public List<Dynamic> selectAll();
	
	//根据动态的id从数据库里读出该动态的图片信息
	@Select("select * from t_dynamic_pictures where dynamic_id = #{dynamic_id}")
	public List<DynamicPic> selectPic(int dynamic_id);
	
}
