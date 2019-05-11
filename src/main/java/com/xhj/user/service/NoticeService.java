package com.xhj.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.Notice;
import com.xhj.user.entity.NoticeDisplay;
import com.xhj.user.mapper.NoticeMapper;
import com.xhj.user.mapper.UserMapper;

@Service
public class NoticeService {
	
	@Autowired
	NoticeMapper nm;
	
	@Autowired
	UserMapper um;
	
	//添加通知信息
	public boolean addNotice(Notice notice){
		
		nm.insertNotice(notice);
		
		return true;
	}
	
	//查询当前用户所有的通知
	public List<NoticeDisplay> getNotices(int u_id){
		List<NoticeDisplay> nds=new ArrayList<NoticeDisplay>();
		
		List<Notice> notices= nm.selectNoticeByID(u_id);
		
		NoticeDisplay nd;
		
		for(Notice notice : notices){
			nd=new NoticeDisplay();
			nd.setNotice(notice);
			nd.setUser(um.selectUserByID(notice.getSenduser_id()));
			nds.add(nd);
		}
		return nds;
	}
	
	//更改通知的状态
	public boolean updateNotice(Notice notice){
		nm.updateNotice(notice);
		return true;
	}
}
