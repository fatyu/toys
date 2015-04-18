package com.itlamp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itlamp.bean.User;
import com.itlamp.dao.UserDao;
import com.itlamp.util.JdbcUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * UserDao的实现类
 * @author Fatyu
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 查询数据库的User对象是否存在
	 * 
	 * @param User
	 *            user
	 * @return User result
	 */
	public User queryUser(User user) {
		boolean flag = false;// 标记是否存在此用户
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		User result = null;
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("select * from dhcx_xtyh where username=\'"
							+ user.getUsername()
							+ "\' and password=\'"
							+ user.getPassword() + "\'");
			rs = ps.executeQuery();// 执行查询语句
			while (rs.next()) {
				result = new User();
				result.setUsername(rs.getString("username"));
				result.setPassword(rs.getString("password"));
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}
		if (flag) {
			return result;
		} else {
			return null;
		}
	}

	/**
	 * 更新系统用户密码
	 * @param User user
	 * @return boolean 修改结果 true|false
	 */
	public boolean editPassword(User user) {
		boolean flag = false;// 标记是否修改成功
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("update dhcx_xtyh set password=\'"
							+ user.getPassword() + "\' where username=\'"
							+ user.getUsername() + "\'");
			int a = ps.executeUpdate();
			if (a > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}
		return flag;

	}
}
