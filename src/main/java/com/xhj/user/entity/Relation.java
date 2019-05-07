package com.xhj.user.entity;

import lombok.Data;

@Data
public class Relation {
	private int relation_id;
	private int user_id1;
	private int user_id2;
	private String relation_time;
}
