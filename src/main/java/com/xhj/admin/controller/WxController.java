package com.xhj.admin.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xhj.user.entity.User;
import com.xhj.user.service.UserService;

@RestController
public class WxController {
	final static String APPID = "wx2097e93d06efa4f0";
	static final String SECRET = "212b59b252b5a58cf739be2806145e18";
	@Autowired
	UserService userService;

	@RequestMapping("/wxLogin")
	public String wxLogin(String code, String us_name, String us_password, HttpSession session) {
		String jscode2session = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET
				+ "&js_code=" + code + "&grant_type=authorization_code";

		String result = "";

		BufferedReader in = null;
		InputStream is = null;
		InputStreamReader isr = null;

		//用来存放session_key和openid
		String session_key="";
		String openid="";
		String uid="";
		
		
		// 封装user然后判断登录是否成功
		User user = new User();
		user.setUs_name(us_name);
		user.setUs_password(us_password);
		user.setUs_level(true);

		try {
			URL url = new URL(jscode2session);
			URLConnection conn = url.openConnection();
			conn.connect();
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			in = new BufferedReader(isr);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println(result);
			//从result中截取字段
			session_key=result.substring(16,40);
			openid=result.substring(52,80);
			
			String login = userService.login(user);
			if (login.equals("登录成功")) {
				// 以3rd_session为key,sesson_key+openid为值存入session中
				uid = UUID.randomUUID().toString();
				session.setAttribute(uid, session_key+openid);
				System.out.println(uid);
				return uid;
			}
			else if(login.equals("密码错误")){
				return "errpass";
			}
			

		} catch (IOException e) {
			// 抛出发生了格式错误的URL。要么在规范字符串中找不到合法的协议，要么无法解析字符串。
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch (Exception e2) {
				// 异常记录
			}
		}
		return "erruser";
	}

	//检测登录态
	@RequestMapping("/checkSession")
	public String checkSession(String uid,HttpSession session){
		System.out.println(uid);
		String str=(String) session.getAttribute(uid);
		System.out.println(str);
		if(str!=null&&str!=""){
			return "success";
		}
		return "fail";
	}
}
