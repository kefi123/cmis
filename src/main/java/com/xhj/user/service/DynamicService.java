package com.xhj.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Dynamic;
import com.xhj.user.entity.DynamicPic;
import com.xhj.user.mapper.DynamicMapper;

@Service
//动态的业务逻辑处理类
public class DynamicService {

	//先获得Mapper类
	@Autowired
	DynamicMapper dm;
	
	//调用方法把动态内容写入数据库并且获得插入记录的id
	public int storageDynamic(Dynamic dynamic){
		//插入一条记录并且获取到记录的id
		dm.insert(dynamic);
		return dynamic.getDynamic_id();
	}
	
	//将动态图片放入数据库
	public boolean storageDynamicPic(DynamicPic dynamicPic){
		dm.insertPic(dynamicPic);
		return true;
	}
}
