package com.rankerBlog.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBUtilHelper {
	/**
	 * 执行sql操作数据库
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int executeSQL(String sql, String... params)
			throws SQLException {
		DataSource ds = null;
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/blog");
		} catch (Exception e) {
			System.out.println("没有对应的数据源");
		}

		QueryRunner qr = new QueryRunner(ds);
		Connection conn = ds.getConnection();
		return qr.update(conn, sql, params);
	}

	/**
	 * 查询实体对象列表
	 * 
	 * @param sql
	 * @param beanclass
	 * @return 
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> executeSQL(String sql, Object beanclass)
			throws SQLException {
		DataSource ds = null;
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/blog");
		} catch (Exception e) {
			System.out.println("没有对应的数据源");
		}
		QueryRunner qr = new QueryRunner(ds);
		List<Object> list = (List<Object>)qr.query(sql, new BeanListHandler(beanclass.getClass()));
		return list;
	}
}
