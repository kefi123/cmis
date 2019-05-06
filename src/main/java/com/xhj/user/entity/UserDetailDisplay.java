package com.xhj.user.entity;

import java.util.List;

import lombok.Data;

@Data
public class UserDetailDisplay {
	private User user;
	private Parent_industry pi;
	private Cindustry ci;
	private List<DynamicDisplay> dds;
}
