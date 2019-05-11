package com.xhj.user.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Relation;
import com.xhj.user.entity.Score;
import com.xhj.user.entity.User;
import com.xhj.user.entity.UserDetailDisplay;
import com.xhj.user.mapper.CindustryMapper;
import com.xhj.user.mapper.Parent_industryMapper;
import com.xhj.user.mapper.RelationMapper;
import com.xhj.user.mapper.UserMapper;

@Service
public class RelationService {
		
	@Autowired
	RelationMapper rm;

	@Autowired
	UserMapper um;
	
	@Autowired
	Parent_industryMapper pim;
	
	@Autowired
	CindustryMapper cim;
	
	//智能推荐好友
	public List<Score> recommendFriends(int u_id){
		
		//获取所有用户id
		List<Integer> ids=um.getAllID();
		
		//用来存放用户及其好友id
		List<Integer> selfFriendId;
		
		//用来存放所有用户及其好友id
		List<List<Integer>> allSelfFriendIds = new ArrayList<List<Integer>>();
		
		//存放用户id以及好友的数量
    	Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		//将ids拆开，每个都放入一个list里面
		for(Integer id : ids){
			
			//首先申请空间
			selfFriendId=new ArrayList<Integer>();
			
			//先把自己的id放入list
			selfFriendId.add(id);
			
			//然后把好友的id放入list
			selfFriendId.addAll(rm.getAllFriendIds(id));
			
			//最后放入一个总的list里面
			allSelfFriendIds.add(selfFriendId);
			
			//记录用户id以及好友的数量
			map.put(id,selfFriendId.size()-1);
			
		}
		
		//记录所有的分数情况
		List<Score> scores=new ArrayList<Score>();
		
		for(int j=1;j<allSelfFriendIds.size();j++){
            Score score = calculate(allSelfFriendIds.get(0), allSelfFriendIds.get(j));
            if(score!=null){
                List<Integer> l1 = score.getL();
                double wscore=0.0;
                for(int c:l1){
                    double sqrt = Math.sqrt(map.get(c));
                    double v = 1 / sqrt;
                    wscore=(wscore+v)*100;
                }
                double v = wscore / score.getUnion();//得出加权的分数
                score.setWscore(v);
                scores.add(score);
             }
        }
		
		//暂存用户的个人信息
		UserDetailDisplay udd;
		
		User user;
		
		//获取每个score里B的用户信息
        for(Score score:scores){
        	udd=new UserDetailDisplay();
        	user=um.selectUserByID(score.getB());
        	udd.setUser(user);
        	udd.setPi(pim.select_parent_industry(user.getP_industry_id()));
        	udd.setCi(cim.select_child_industry(user.getC_industry_id()));
        	score.setUdd(udd);
        }
        
        //对于scores按照wsocre进行降序排序
        List<Score> newList = scores.stream().sorted(Comparator.comparing(Score::getWscore).reversed())
                .collect(Collectors.toList());
        
		return newList;
	}
	
	//此方法得出两个用户之间的关系类
    public static Score calculate(List<Integer> a,List<Integer> b){
        int x=a.get(0);
        //直接好友返回null
        for(int y:b){
            if(x==y){
                return null;
            }
        }
        //用来存公共的好友
        List<Integer> l=new ArrayList<Integer>();
 
        for(int i=1;i<a.size();i++){
            for(int j=1;j<b.size();j++){
                if(a.get(i)==b.get(j)){
                    l.add(a.get(i));
                }
            }
        }
        if(l.size()==0){
            return null;//没有共同好友返回null
        }
        Score score = new Score();
        score.setL(l);
        score.setA(a.get(0));
        score.setB(b.get(0));
        score.setUnion(a.size()+b.size()-l.size()-2);
        score.setIntersection(l.size());
        return score;
    }
	
	//插入好友信息
	public boolean insertRelation(Relation relation){
		//联系是双向的，所以插入的时候，两个人互换着插，总共往数据库提交了两次
		rm.insertRelation(relation);
		
		//用户1和用户2颠倒
		int user_id1=relation.getUser_id2();
		relation.setUser_id2(relation.getUser_id1());
		relation.setUser_id1(user_id1);
		
		rm.insertRelation(relation);
		
		return true;
	}
	
	//获取当前用户所有的好友信息
	public List<User> getFriends(int u_id){
		//获取当前用户的好友id
		List<Integer> ids=rm.getAllFriendIds(u_id);
		
		List<User> users=new ArrayList<User>();

		User user;
		
		//获取好友的详细信息添加到list里面
		for(int id : ids){
			user=um.selectUserByID(id);
			users.add(user);
		}
		
		return users;
	}
}
