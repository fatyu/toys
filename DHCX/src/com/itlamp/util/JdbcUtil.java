package com.itlamp.util;

import java.sql.*;

/**
 * Jdbc������
 * @author Fatyu
 */
public class JdbcUtil {
	/**
	 * ֻ��ʼ��һ�ε�ע������
	 */
	// 1.ע����������[singlton Dp]
	static {// static���������ڼ�ֻ��ʼ��һ��
		try {
			Class.forName("com.mysql.jdbc.Driver");// ע��mysql���ݿ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������ݿ�����
	 * 
	 * @return Connection����
	 */
	// 2.�������ݿ�
	public static Connection getConnection() {
		Connection conn = null;// �������Ӷ���
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dhcx", "root", "root");
			// ��������������������
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * ���ݴ��ݵĲ������͹رն�Ӧ�����ݿ���Դ
	 * 
	 * @param obj
	 */
	public static void relase(Object obj) {
		try {
			if (obj instanceof ResultSet) {
				((ResultSet) obj).close();
			} else if (obj instanceof Statement) {
				((Statement) obj).close();
			} else if (obj instanceof PreparedStatement) {
				((PreparedStatement) obj).close();
			} else if (obj instanceof Connection) {
				((Connection) obj).close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
