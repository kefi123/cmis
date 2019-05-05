package com.xhj.user.entity;

import lombok.Data;

@Data
//动态类
public class Dynamic {
	private int dynamic_id;
	private int dynamic_user_id;
	private String dynamic_content;
	private int like_number;
	private int comment_number;
	private int forward_number;
}
