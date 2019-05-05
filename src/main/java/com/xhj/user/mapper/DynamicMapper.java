package com.xhj.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
	
}
