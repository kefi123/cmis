package com.xhj.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xhj.user.entity.MailFriend;
import com.xhj.user.entity.User;
import com.xhj.user.service.MailService;

@Controller
public class UserMailController {
	
	@Autowired
	MailService ms;
	
	
	
	//调转到联系图页面
	@RequestMapping("/toMFGraph")
	public String toMFGraph(){
		return "user/mail/MFGraph";
	}
	
	//获取已导入邮箱好友的json数据
	@ResponseBody
	@RequestMapping("/getMfJson")
	public List<MailFriend> getMfJson(HttpSession session){
		
		//获取当前用户
		User user = (User) session.getAttribute("ulogined");
		
		//获取所有原始的邮箱好友数据
		return ms.getMf(user.getU_id());
	}
	
	//获取已导入的邮箱好友数据
	@RequestMapping("/getMf")
	public String getMf(HttpSession session){
		
		//获取当前用户
		User user = (User) session.getAttribute("ulogined");
		
		//获取已导入的邮箱好友数据
		List<MailFriend> mfs=ms.getMf(user.getU_id());
		
		//存入session中
		session.setAttribute("mfs", mfs);
		
		return "user/mail/myMailFriends";
	}
	
	//获取原始邮箱好友数据
	@RequestMapping("/getMailFriends")
	public String getMailFriends(HttpSession session){
		
		//获取当前用户
		User user = (User) session.getAttribute("ulogined");
		
		//获取所有原始的邮箱好友数据
		List<MailFriend> mfs=ms.getMailFriends(user.getU_id());
		
		//存入session中
		session.setAttribute("mfs", mfs);
		
		return "user/mail/getMailFriends";
	}
	
	//把选中的原始数据更改其状态，变为邮箱好友
	@RequestMapping("/addMailFriends")
	public String addMailFriends(String mf_mail){
		
		MailFriend mf;
		//把选中的邮箱切割出来，修改其数据库里的状态
		for(String str : mf_mail.split(",")){
			mf=new MailFriend();
			mf.setMf_mail(str);
			mf.setMf_delete(1);
			ms.updateStatus(mf);
		}
		
		return "getMf";
	}
}
