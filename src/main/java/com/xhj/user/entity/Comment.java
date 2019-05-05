package com.xhj.user.entity;

import lombok.Data;

@Data
//动态的评论类
public class Comment {
	private int comment_id;
	private int dynamic_id;
	private int reply_user_id;
	private int comment_user_id;
	private String comment_content;
	private int comment_like_number;
	private boolean is_reply;
}
