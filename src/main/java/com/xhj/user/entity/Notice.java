package com.xhj.user.entity;

import lombok.Data;

@Data
public class Notice {
	private int notice_id;
	private int senduser_id;
	private int receiveuser_id;
	private int status;
	private String notice_time;
}
