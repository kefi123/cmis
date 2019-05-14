package com.xhj.user.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhj.user.entity.MailFriend;
import com.xhj.user.entity.MailInfo;
import com.xhj.user.mapper.MailFriendMapper;

@Service
public class MailService {
	
	@Autowired
	MailFriendMapper mfm;
	
	//修改邮箱好友的状态
	public boolean updateStatus(MailFriend mf){
		
		mfm.updateMfStatus(mf);
		
		return true;
	}
	
	//读取已导入的邮箱好友
	public List<MailFriend> getMf(int u_id){
		
		List<MailFriend> mfs;
		
		mfs=mfm.getMf(u_id);
		
		return mfs;
		
	}
	
	//读取邮箱好友
	public List<MailFriend> getMailFriends(int u_id){
		
		String host="pop.qq.com";
		String username="1625071980@qq.com";
		//授权码
		String authorizationCode="tebwvwfmrjpxeegc";
		
		//设置属性
		Properties p=new Properties();
		//邮件服务器地址
		p.setProperty("mail.pop3.host", host);
		//pop3协议的端口
		p.setProperty("mail.pop3.port", "995");
		//SSL安全连接参数
		p.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.setProperty("mail.pop3.socketFactory.fallback", "true");
		p.setProperty("mail.pop3.socketFactory.port", "995");
		
		//创建此次获取邮箱内容的会话
		Session session = Session.getDefaultInstance(p,null);
		try {
			//Store类实现特定邮件协议上的读、写、监视、查找等操作。通过Store类可以访问Folder类
			Store store = session.getStore("pop3");
			store.connect(host,username,authorizationCode);
			
			//用于分级组织邮件，并提供照Message格式访问email的能力
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			
			//获取邮件信息
			Message message[] = folder.getMessages();
			
			//用来存储每个邮件信息
			MailInfo mi;
			
			//邮箱好友
			MailFriend mf;
			
			//为了更新数据，每次导入之前，先把该用户下面的邮箱好友多给删了
			mfm.deleteMf(u_id);
			
			//只要邮件信息不为空，那么就开始遍历邮件，获取发件人信息
			if(message!=null){
				for(int i=0;i<message.length;i++){
					mi=new MailInfo((MimeMessage) message[i]);
					
					//输出发件人信息
					try {
						
						//首先查看数据库中有没有该邮件好友
						mf=mfm.selectMFbyMail(mi.getMail());
						if(mf==null){
							//如果数据库中没有这条信息
							//插入数据库
							mf=new MailFriend();
							mf.setMf_uid(u_id);
							mf.setMf_name(mi.getName());
							mf.setMf_mail(mi.getMail());
							
							if(mi.getName()!=null)
								mfm.insertMF(mf);
						}
						else{
							mfm.updateNum(mi.getMail());
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("end---------------");
				//得到所有的原始的邮箱好友，提供给前台显示，供用户选择导入
				List<MailFriend> mfs=mfm.getAllMf(u_id);
				return mfs;
			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
