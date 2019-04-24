package com.xhj.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xhj.user.entity.Cindustry;
import com.xhj.user.entity.User;
import com.xhj.user.mapper.CindustryMapper;
import com.xhj.user.service.CindustryService;
import com.xhj.user.service.Parent_industry_service;
import com.xhj.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	Parent_industry_service pis;

	@Autowired
	CindustryService cis;
	
	//上传头像
	@Value("${file.uploadFolder}")
    private String uploadFolder;
	
	@RequestMapping("/uploadAvatar")
	public String uploadAvatar(MultipartFile file,HttpSession session){
		
		//得到文件名
		String fileName=file.getOriginalFilename();
		//得到文件后缀
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
		//重新生成唯一的文件名，存放入数据库
		String newFileName=UUID.randomUUID().toString()+suffixName;
		
		File filesss=new File(uploadFolder);
		if(filesss.exists()==false){
			filesss.mkdirs();
		}
		
		//创建文件
		File newFile=new File(uploadFolder+newFileName);
		
		//复制文件到指定的地方
		try {
			file.transferTo(newFile);
		} catch (IOException e2) {
			e2.printStackTrace();
		} 
		
		//虚拟访问地址
		String vAddress="http://localhost:8080/uploadAvatars/"+newFileName;
		
		//更新到该用户的数据库中
		User user=(User) session.getAttribute("ulogined");
		
		userService.updateAvatar(user.getU_id(),vAddress);
		
		//更新到session里
		user.setU_avatar(vAddress);
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
		return "login/login";
	}

	// 跳转到注册页面
	@RequestMapping("/registerFtl")
	public String registerFtl() {
		return "login/register";
	}

	/*
	// 注册
	@RequestMapping("/register")
	public String register(User user, Map<String, Object> map) {
		boolean result = userService.register(user);
		if (result == true)
			return "login/login";
		return "login/register";
	}
	*/
}
