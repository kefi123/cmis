package com.xhj.user.service;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xhj.entity.Connection;
import com.xhj.mapper.ConnectionMapper;
import com.xhj.service.MailInfo;
import com.xhj.user.entity.User;
import com.xhj.user.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	// 登录
	public User login(User user) {
		User user_x = userMapper.selectUsersByName(user.getU_name());
		if (user_x != null) {
			if (user.getU_password().equals(user_x.getU_password()))
				return user_x;
			else
				return null;
		} else
			return null;
	}
	
	//更新头像信息
	public boolean updateAvatar(int u_id,String u_avatar){
		return userMapper.updateAvatar(u_id,u_avatar);
	}
	
/*
	// 注册
	@Transactional
	public boolean register(User user) {
		boolean result, result1, result2;
		result = true;
		result1 = userMapper.insertUser(user);
		result2 = estCon(user);
		if (result1 == false || result2 == false)
			result = false;
		return result;
	}

	// 根据邮箱信息爬出相关联的人脉添加到数据库里
	public boolean estCon(User user) {
		try {
			String host = "pop.qq.com";

			Properties p = new Properties();
			p.setProperty("mail.pop3.host", "pop.qq.com"); // 按需要更改
			p.setProperty("mail.pop3.port", "995");
			// SSL安全连接参数
			p.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.setProperty("mail.pop3.socketFactory.fallback", "true");
			p.setProperty("mail.pop3.socketFactory.port", "995");

			Session session = Session.getDefaultInstance(p, null);
			Store store = session.getStore("pop3");
			store.connect(host, user.getUs_mail(), user.getUs_authcode());

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			Message message[] = folder.getMessages();
			MailInfo re = null;
			Connection con = null;
			if (null != message) {
				for (int i = 0; i < message.length; i++) {
					re = new MailInfo((MimeMessage) message[i]);
					con = new Connection();
					con.setCo_us_name(user.getUs_name());
					String fromAdd = re.getFrom();
					con.setCo_name(fromAdd.substring(0, fromAdd.indexOf("<")));
					con.setCo_mail(fromAdd.substring(fromAdd.indexOf("<") + 1, fromAdd.indexOf(">")));
					//初始为1(刚添加的时候都为1)
					con.setCo_num(1);
					// 添加之前先确定数据库里有没有相同名字或者邮箱的人脉信息，有的话返回false，没有的话添加
					Connection con1 = connectionMapper.aselectConByName(con.getCo_name());
					Connection con2 = connectionMapper.selectConnectionsByMail(con.getCo_mail());
					
					if(con1!=null)
						connectionMapper.updateConNum(con1.getCo_id());
					else{
						if(con2!=null){
							connectionMapper.updateConNum(con2.getCo_id());
						}
						else{
							connectionMapper.addConnection(con);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	*/

}
