//package com.xhj.admin.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.xhj.admin.entity.Connection;
//import com.xhj.admin.entity.Route;
//import com.xhj.admin.service.ConnectionService;
//import com.xhj.user.entity.User;
//
////告知springboot这是一个控制器
//@Controller
//public class ConnectionController {
//	// 自动注解
//	@Autowired
//	ConnectionService connectionService;
//
//	// 更新人脉信息
//	// 告诉函数需要URL
//	@RequestMapping("/updateConnection")
//	public String updateConnection(Connection con, Map<String, Object> map) {
//		map.put("status", connectionService.updateConnection(con));
//		return "getConnection?page=1&size=4";
//	}
//
//	// 通过名称来查询人脉信息
//	@RequestMapping("/getConnectionByName")
//	public String getConnectionByName(int page, int size, String co_name, Map<String, Object> map) {
//		map.put("pageInfos", connectionService.getConnectionByName(page, size, co_name));
//		map.put("hrefs", "getConnectionByName");
//		return "connection/findConnection";
//
//	}
//
//	// 通过id来查询人脉信息
//	@RequestMapping("/getConnectionByID")
//	public String getConnectionByID(int co_id, Map<String, Object> map) {
//		map.put("connection", connectionService.getConnectionByID(co_id));
//		return "connection/updateConnection";
//	}
//
//	// 查询当前用户的所有人脉信息(分页)
//	@RequestMapping("/getConnection")
//	public String getConnection(int page, int size, Map<String, Object> map, HttpSession session) {
//		User user = (User) session.getAttribute("ulogined");
//		map.put("pageInfos", connectionService.getConnection(page, size, user.getUs_name()));
//		map.put("hrefs", "getConnection");
//		return "connection/findConnection";
//
//	}
//
//	// 查询当前用户名下所有的人脉信息
//	@ResponseBody
//	@RequestMapping("/getConByUname")
//	public List<Connection> getConByUname(HttpSession session) {
//		User user = (User) session.getAttribute("ulogined");
//		// 由于功能不完善，现在用户名确定
//		return connectionService.getConByUname(user.getUs_name());
//	}
//
//	// 删除人脉
//	@RequestMapping("/deleteConnection")
//	public String deleteConnection(int co_id, Map<String, Object> map) {
//		map.put("status", connectionService.deleteConnection(co_id));
//		return "getConnection?page=1&size=4";
//	}
//
//	// 跳转到添加人脉的页面
//	@RequestMapping("/addConnectionFtl")
//	public String addConnection() {
//		return "connection/addConnection";
//	}
//
//	// 添加人脉信息
//	@RequestMapping("/addConnection")
//	public String addConnection(Connection connection, Map<String, Object> map, HttpSession session) {
//		if (connection.getCo_name() != null && connection.getCo_name() != "") {
//			User user = (User) session.getAttribute("ulogined");
//			connection.setCo_us_name(user.getUs_name());
//			connection.setCo_num(1);
//			boolean result = connectionService.addConnection(connection);
//			map.put("status", result);
//		} else
//			map.put("status", false);
//		return "connection/addConnection";
//	}
//
//	// 跳转到人脉关系网络图界面
//	@RequestMapping("/conGraph")
//	public String conGraph() {
//		return "connection/conGraph";
//	}
//
//	// 跳转到人脉关系网络图界面
//	@RequestMapping("/conGraph2")
//	public String conGraph2() {
//		return "connection/conGraph2";
//	}
//
//	// 跳转到拓展人脉的界面
//	@RequestMapping("/exConFtl")
//	public String exConFtl() {
//		return "connection/exConFtl";
//	}
//
//	//查找人脉
//	@RequestMapping("/exCon")
//	public String exCon(String co_name,Map<String, Object> map,HttpSession session) {
//			User user = (User) session.getAttribute("ulogined");
//			Route route=connectionService.seConByUname(user.getUs_name(), co_name);
//			route.setSource(user.getUs_name());
//			route.setTarget(co_name);
//			map.put("route", route);
//		return "connection/routeGraph";
//	}
//}
