package com.xhj.user.entity;

import lombok.Data;

@Data
public class User {
	private int u_id;
	private int p_industry_id;
	private int c_industry_id;
	private String u_name;
	private String u_password;
	private String u_avatar;
	private String u_realname;
	private boolean u_sex;
	private String u_company;
	private String u_position;
	private String u_mail;
}
