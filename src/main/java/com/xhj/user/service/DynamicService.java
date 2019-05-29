package com.xhj.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Comment;
import com.xhj.user.entity.CommentDisplay;
import com.xhj.user.entity.Dynamic;
import com.xhj.user.entity.DynamicDisplay;
import com.xhj.user.entity.DynamicPic;
import com.xhj.user.entity.User;
import com.xhj.user.mapper.CindustryMapper;
import com.xhj.user.mapper.DynamicMapper;
import com.xhj.user.mapper.Parent_industryMapper;
import com.xhj.user.mapper.UserMapper;

@Service
//动态的业务逻辑处理类
public class DynamicService {

	//先获得动态Mapper类
	@Autowired
	DynamicMapper dm;
	
	//用户Mapper类
	@Autowired
	UserMapper um;
	
	@Autowired
	Parent_industryMapper pim;
	
	@Autowired
	CindustryMapper cim;
	
	//点赞
	public boolean like(int dynamic_id){
		dm.addLikeNum(dynamic_id);
		return true;
	}
	
	//取消点赞
	public boolean unLike(int dynamic_id){
		dm.deleteLikeNum(dynamic_id);
		return true;
	}
	
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
	
	//将动态评论放入数据库,并且增加该动态评论的数量
	public boolean storageDynamicComment(Comment comment){
		dm.insertComment(comment);
		dm.updateDynamicCommentNum(comment.getDynamic_id());
		return true;
	}
	
	//整合单个动态的完整信息（包括评论）
	public DynamicDisplay dynamicDetail(int dynamic_id){
		
		//常见一个展示动态的对象
		DynamicDisplay dd=new DynamicDisplay();
		
		//首先获取动态信息
		Dynamic dynamic=dm.selectSingleByDID(dynamic_id);
		
		//设置动态信息
		dd.setDynamic(dynamic);
		
		//读取用户信息并且设置
		User user=um.selectUserByID(dynamic.getDynamic_user_id());
		dd.setUser(user);
		
		//读取动态图片信息并设置
		List<DynamicPic> pics=dm.selectPic(dynamic.getDynamic_id());
		dd.setDynamicPic(pics);
		
		//设置评论信息
		List<Comment> cmts=dm.selectComment(dynamic.getDynamic_id());

		List<CommentDisplay> cds=new ArrayList<CommentDisplay>();
		
		CommentDisplay cd;
		
		for(Comment cm : cmts){
			cd=new CommentDisplay();
			cd.setComment(cm);
			cd.setUser(um.selectUserByID(cm.getComment_user_id()));
			cds.add(cd);
		}
		
		dd.setCds(cds);
		
		return dd;
	}
	
	//整合前台展示的动态信息
	public List<DynamicDisplay> dynamicDisplay(){
		
		List<DynamicDisplay> dds=new ArrayList<DynamicDisplay>();
		
		//常见一个展示动态的对象
		DynamicDisplay dd;
		
		//用户
		User user;
		
		//动态图片
		List<DynamicPic> pics;
		
		//首先获取所有的动态信息
		List<Dynamic> dynamics=dm.selectAll();
		
		for(Dynamic dynamic:dynamics){
			//获取空间
			dd=new DynamicDisplay();
			
			//设置动态信息
			dd.setDynamic(dynamic);
			
			//读取用户信息并且设置
			user=um.selectUserByID(dynamic.getDynamic_user_id());
			dd.setUser(user);
			
			//读取动态图片信息并设置
			pics=dm.selectPic(dynamic.getDynamic_id());
			dd.setDynamicPic(pics);
			
			dds.add(dd);
		}
		return dds;
	}
	
}
