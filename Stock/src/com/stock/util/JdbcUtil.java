package com.stock.util;

import java.sql.*;

/**
 * @author Fatyu 
 */
public class JdbcUtil {
	/**
	 * 只初始化一次的注册驱动
	 */
	// 1.注册驱动程序[singlton Dp]
	static {// static块在运行期间只初始化一次
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 注册mysql数据库的驱动
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立数据库连接
	 * 
	 * @return Connection对象
	 */
	// 2.连接数据库
	public static Connection getConnection() {
		Connection conn = null;// 声明连接对象
		try {
			conn = DriverManager.getConnection(
					" jdbc:oracle:thin:@127.0.0.1:1521:orcl", "stock", "stock");
			// 由驱动管理器创建连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 根据传递的参数类型关闭对应的数据库资源
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
