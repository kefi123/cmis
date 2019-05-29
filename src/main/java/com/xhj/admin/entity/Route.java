package com.xhj.admin.entity;

import lombok.Data;

@Data
public class Route {
	private String source;
	private String transfer;
	private String target;
	private Connection connection;
}
