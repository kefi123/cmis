package com.xhj.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xhj.user.entity.Cindustry;
import com.xhj.user.entity.Notice;
import com.xhj.user.entity.NoticeDisplay;
import com.xhj.user.entity.Relation;
import com.xhj.user.entity.Score;
import com.xhj.user.entity.User;
import com.xhj.user.entity.UserDetailDisplay;
import com.xhj.user.service.CindustryService;
import com.xhj.user.service.NoticeService;
import com.xhj.user.service.Parent_industry_service;
import com.xhj.user.service.RelationService;
import com.xhj.user.service.UserService;
import com.xhj.util.UploadImg;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	Parent_industry_service pis;

	@Autowired
	CindustryService cis;
	
	@Autowired
	NoticeService ns;
	
	@Autowired
	RelationService rs;
	
	// 删除用户信息
	@RequestMapping("/deleteUser")
	public String deleteUser(int u_id, Map<String, Object> map) {
		map.put("status",userService.deleteUser(u_id));
		return "getUsers?page=1&size=4";
	}
	
	// 查询所有一级行业信息
	@RequestMapping("/getUsers")
	public String getUsers(int page, int size, Map<String, Object> map) {
		map.put("pageInfos", userService.getUsers(page, size));
		map.put("hrefs", "getUsers");
		return "admin/user/find";

	}
	
	//好友推荐
	@RequestMapping("/recommendFriend")
	public String recommendFriend(HttpSession session){

		//先获取当前用户的id
		User user=(User) session.getAttribute("ulogined");
		
		//获取推荐好友列表
		List<Score> scores=rs.recommendFriends(user.getU_id());
		
		session.setAttribute("scores", scores);
		
		return "user/recommendFriend";
	}
	
	//调转到我的好友页面
	@RequestMapping("/myFriends")
	public String myFriends(HttpSession session){
		//先获取当前用户的id
		User user=(User) session.getAttribute("ulogined");
		
		//获取好友列表
		List<User> users=rs.getFriends(user.getU_id());
		
		//存入session
		session.setAttribute("users", users);
		return "user/friendList";
	}
	
	//查看当前用户的所有通知
	@RequestMapping("/notice")
	public String notice(HttpSession session){
		
		//获取当前用户
		User user=(User) session.getAttribute("ulogined");
		
		List<NoticeDisplay> nds=ns.getNotices(user.getU_id());
		
		//存入session中
		session.setAttribute("nds", nds);
		
		return "user/notice";
	}
	
	//更改通知的状态
	@RequestMapping("/updateNoticeStatus")
	public String updateNoticeStatus(int notice_id,int status,int senduser_id,int receiveuser_id){
		
		Notice notice =new Notice();
		notice.setNotice_id(notice_id);
		notice.setStatus(status);
		
		Relation relation=new Relation();
		relation.setUser_id1(senduser_id);
		relation.setUser_id2(receiveuser_id);
		
		if(status==1){
			//同意申请好友
			//首先更改状态，然后添加好友信息
			ns.updateNotice(notice);
			
			rs.insertRelation(relation);
		}
		
		else if(status==2){
			//更改状态
			ns.updateNotice(notice);
		}
		
		return "notice";
	}
	
	//加好友
	@RequestMapping("/addFriend")
	public String addFriend(int senduser_id,int receiveuser_id){
		
		//分装通知
		Notice notice=new Notice();
		notice.setSenduser_id(senduser_id);
		notice.setReceiveuser_id(receiveuser_id);
		
		ns.addNotice(notice);
		
		return "userDetail?u_id="+receiveuser_id;
	}
	
	
	//头像的存储路径
	@Value("${file.uploadAvatarPath}")
    private String uploadAvatarPath;
	
	//上传头像
	@RequestMapping("/uploadAvatar")
	public String uploadAvatar(MultipartFile file,HttpSession session){
		
		//得到文件的新名字
		String fileName=UploadImg.uploadPic(file, uploadAvatarPath);
		
		//生成虚拟访问地址
		String newFileName="http://localhost:8080/avatars/"+fileName;
		
		//更新到该用户的数据库中
		User user=(User) session.getAttribute("ulogined");
		
		userService.updateAvatar(user.getU_id(),newFileName);
		
		//更新到session里
		user.setU_avatar(newFileName);
		session.setAttribute("ulogined", user);
		
		return "user/edit_userinfo";
	}
	
	//更新用户信息
	@RequestMapping("updateUser")
	public String  updateUser(User user , HttpSession session){
		
		//更新session中用户的信息
		User olduser=(User) session.getAttribute("ulogined");
		olduser.setU_realname(user.getU_realname());
		olduser.setU_sex(user.isU_sex());
		olduser.setU_mail(user.getU_mail());
		olduser.setP_industry_id(user.getP_industry_id());
		olduser.setC_industry_id(user.getC_industry_id());
		olduser.setU_company(user.getU_company());
		olduser.setU_position(user.getU_position());
		session.setAttribute("ulogined", olduser);
		//获取该用户的行业信息
		session.setAttribute("pIndustry", pis.selectById(user.getP_industry_id()));
		session.setAttribute("cIndustry", cis.selectById(user.getC_industry_id()));
		
		//更新数据库中用户的信息
		user.setU_id(olduser.getU_id());
		userService.updateUser(user);
		
		return "user/edit_userinfo";
	}

	
	//根据父类id查询子类信息
	@ResponseBody
	@RequestMapping("/p2c")
	public List<Cindustry> p2c(int p_industry_id ) {
		return cis.getChilds(p_industry_id);
	}
	
	// 跳转到登录页面
	@RequestMapping("/loginFtl")
	public String loginFtl() {
		return "user/login/login";
	}

	// 登录
	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		user = userService.login(user);
		if (user!=null) {
			// 把用户信息存到session里
			session.setAttribute("ulogined", user);
			//获取该用户的行业信息
			session.setAttribute("pIndustry", pis.selectById(user.getP_industry_id()));
			session.setAttribute("cIndustry", cis.selectById(user.getC_industry_id()));
			return "user/index/index";
		}
		return "user/login/login";
	}

	// 退出登录
	@RequestMapping("/dlogin")
	public String dlogin(HttpSession session) {
		session.removeAttribute("ulogined");
		return "user/login/login";
	}

	// 跳转到注册页面
	@RequestMapping("/registerFtl")
	public String registerFtl() {
		return "user/login/register";
	}

	
	// 注册
	@RequestMapping("/registerUser")
	public String register(User user, Map<String, Object> map) {
		boolean result = userService.register(user);
		if (result == true)
			return "user/login/login";
		return "user/login/register";
	}
	
	//用户详情页面的展示
	@RequestMapping("/userDetail")
	public String dynamic(int u_id , HttpSession session) {
		
		UserDetailDisplay udd=userService.getUserDetail(u_id);
		
		session.setAttribute("udd", udd);
		
		//跳转到动态页面
		return "user/userDetail";
		
	}
	
}
