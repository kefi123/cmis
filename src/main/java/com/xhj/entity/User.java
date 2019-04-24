package com.xhj.entity;

import lombok.Data;

@Data
public class User {
	private String us_name;
	private String us_password;
	private String us_nickname;
	private String us_mail;
	private String us_authcode;
	private boolean us_level;
}
