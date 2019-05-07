package com.xhj.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.xhj.user.entity.Relation;

@Mapper
public interface RelationMapper {
	
	//向数据库插入好友关系的信息
	@Insert("insert into t_relation (user_id1,user_id2,relation_time) values (#{user_id1},#{user_id2},now())")
	public boolean insertRelation(Relation relation);
	
}
