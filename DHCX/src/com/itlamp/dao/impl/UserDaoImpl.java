package com.itlamp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itlamp.bean.User;
import com.itlamp.dao.UserDao;
import com.itlamp.util.JdbcUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * UserDao��ʵ����
 * @author Fatyu
 */
public class UserDaoImpl implements UserDao {

	/**
	 * ��ѯ���ݿ��User�����Ƿ����
	 * 
	 * @param User
	 *            user
	 * @return User result
	 */
	public User queryUser(User user) {
		boolean flag = false;// ����Ƿ���ڴ��û�
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
		User result = null;
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("select * from dhcx_xtyh where username=\'"
							+ user.getUsername()
							+ "\' and password=\'"
							+ user.getPassword() + "\'");
			rs = ps.executeQuery();// ִ�в�ѯ���
			while (rs.next()) {
				result = new User();
				result.setUsername(rs.getString("username"));
				result.setPassword(rs.getString("password"));
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}
		if (flag) {
			return result;
		} else {
			return null;
		}
	}

	/**
	 * ����ϵͳ�û�����
	 * @param User user
	 * @return boolean �޸Ľ�� true|false
	 */
	public boolean editPassword(User user) {
		boolean flag = false;// ����Ƿ��޸ĳɹ�
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
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
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}
		return flag;

	}
}
