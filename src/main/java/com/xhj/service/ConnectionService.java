package com.xhj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhj.entity.Connection;
import com.xhj.entity.Route;
import com.xhj.mapper.ConnectionMapper;
import com.xhj.user.entity.User;
import com.xhj.user.mapper.UserMapper;

@Service
public class ConnectionService {
	@Autowired
	ConnectionMapper connectionMapper;
	@Autowired
	UserMapper userMapper;

	// 更新人脉信息
	public boolean updateConnection(Connection con) {
		return connectionMapper.updateConnection(con);
	}

	// 删除人脉
	public boolean deleteConnection(int co_id) {
		return connectionMapper.deleteConnection(co_id);
	}

	// 通过name查询人脉
	public PageInfo<Connection> getConnectionByName(int page, int size, String co_name) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Connection> connections = connectionMapper.selectConnectionsByName(co_name);
		// 封装分页之后的数据
		PageInfo<Connection> pageInfoConnection = new PageInfo<Connection>(connections);
		return pageInfoConnection;
	}

	// 通过co_us_name查询人脉
	public List<Connection> getConByUname(String co_us_name) {
		return connectionMapper.selectConByUname(co_us_name);
	}

	// 查找人脉
	public Route seConByUname(String co_us_name, String co_name) {
		List<Connection> cons = connectionMapper.selectConByUname(co_us_name);
		Route route = new Route();
		Connection con = null;
		User user = null;
		Connection con1 = new Connection();
		for (int i = 0; i < cons.size(); i++) {
			user = userMapper.sUByNickName(cons.get(i).getCo_name());
			if (user != null) {
				con1.setCo_us_name(user.getUs_name());
				con1.setCo_name(co_name);
				con = connectionMapper.seConByUname(con1);
				if (con != null) {
					route.setConnection(con);
					route.setTransfer(cons.get(i).getCo_name());
					break;
				}
			}
		}
		return route;
	}

	// 通过id查询人脉
	public Connection getConnectionByID(int co_id) {
		return connectionMapper.selectConnectionByID(co_id);
	}

	// 查询人脉
	public PageInfo<Connection> getConnection(int page, int size, String us_name) {

		// 开启分页插件,放在查询语句上面
		PageHelper.startPage(page, size);
		List<Connection> connections = connectionMapper.selectConByUname(us_name);
		// 封装分页之后的数据
		PageInfo<Connection> pageInfoConnection = new PageInfo<Connection>(connections);
		return pageInfoConnection;
	}

	// 添加人脉
	public boolean addConnection(Connection connection) {
		// 添加之前先确定数据库里有没有相同名字或者邮箱的人脉信息，有的话返回false，没有的话添加
		Connection con1 = connectionMapper.aselectConByName(connection.getCo_name());
		Connection con2 = connectionMapper.selectConnectionsByMail(connection.getCo_mail());
		if (con1 == null && con2 == null) {
			return connectionMapper.addConnection(connection);
		}
		return false;
	}
}
