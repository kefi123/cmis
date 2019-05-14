package com.xhj.user.entity;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件信息对象
 */
public class MailInfo {

	//MimeMessage是个能理解MIME类型和头的电子邮件消息，里面存放了邮件的信息，是Message的子类
	private MimeMessage mimeMessage = null;

	public MailInfo() {
	}
	
	/**
	 * 构造函数,初始化一个MimeMessage对象
	 */
	public MailInfo(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}
	
	/*
	 * 获取发件人的邮件地址
	 */
	public String getMail() throws MessagingException{
		
		InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
		return address[0].getAddress();
		
	}
	
	/*
	 * 获取发件人的姓名
	 */
	public String getName() throws MessagingException{
		
		InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
		return address[0].getPersonal();
		
	}

}
