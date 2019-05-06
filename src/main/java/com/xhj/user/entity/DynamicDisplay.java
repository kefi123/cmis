package com.xhj.user.entity;

import java.util.List;

import lombok.Data;

@Data
public class DynamicDisplay {
	private User user;
	private Dynamic dynamic;
	private List<DynamicPic> dynamicPic;
	private List<CommentDisplay> cds;
}
