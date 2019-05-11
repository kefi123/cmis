package com.xhj.user.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xhj.user.entity.Relation;

@Mapper
public interface RelationMapper {
	
	//向数据库插入好友关系的信息
	@Insert("insert into t_relation (user_id1,user_id2,relation_time) values (#{user_id1},#{user_id2},now())")
	public boolean insertRelation(Relation relation);
	
	//根据id获取其所有好友id
	@Select("select user_id2 from t_relation where user_id1=#{u_id}")
	public List<Integer> getAllFriendIds(int u_id);
}
