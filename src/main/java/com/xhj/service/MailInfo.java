package com.xhj.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件信息对象
 * 
 * @author lupf
 *
 */
public class MailInfo {

	private MimeMessage mimeMessage = null;

	/**
	 * 构造函数,初始化一个MimeMessage对象
	 */
	public MailInfo() {
	}

	public MailInfo(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}

	/**
	 * * 获得发件人的地址和姓名
	 */
	public String getFrom() throws Exception {
		InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
		String from = address[0].getAddress();
		if (from == null) {
			from = "";
			System.out.println("无法知道发送者.");
		}
		String personal = address[0].getPersonal();

		if (personal == null) {
			personal = "";
			System.out.println("无法知道发送者的姓名.");
		}

		String fromAddr = null;
		if (personal != null || from != null) {
			fromAddr = personal + "<" + from + ">";
			//System.out.println(fromAddr);
		}
		return fromAddr;
	}
}
