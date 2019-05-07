package com.xhj.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Relation;
import com.xhj.user.mapper.RelationMapper;

@Service
public class RelationService {
		
	@Autowired
	RelationMapper rm;

	
	//插入好友信息
	public boolean insertRelation(Relation relation){
		
		rm.insertRelation(relation);
		
		return true;
	}
}
