package com.stock.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class ConnectionPool {

	private Vector<Connection> pool;
	private String driverName;
	private String userName;
	private String password;
	private String dbURL;
	private int poolSize = 1;// 默认的初始连接数
	private static ConnectionPool instance = null;

	private ConnectionPool() {
		init();
	}

	/**
	 * 返回连接池对象
	 * 
	 * @return ConnectionPoolUtil
	 */
	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	/**
	 * 初始化连接池
	 */
	private void init() {
		pool = new Vector<Connection>(poolSize);
		readProperties();// 读取配置文件
		addConnection();// 将连接添加到连接池中
	}

	/**
	 * 添加连接到连接池
	 */
	private void addConnection() {
		Connection conn = null;
		for (int i = 0; i < poolSize; i++) {
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(dbURL, userName, password);
				pool.add(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 读取配置文件方法
	 */
	private void readProperties() {
		String path ="e:\\db.properties";
		System.out.println(path);
		try {
			FileInputStream fis = new FileInputStream(path);
			Properties properties = new Properties();
			properties.load(fis);
			this.driverName = properties.getProperty("driverName");
			this.userName = properties.getProperty("userName");
			this.password = properties.getProperty("password");
			this.dbURL = properties.getProperty("dbURL");
			this.poolSize = Integer
					.parseInt(properties.getProperty("poolSize"));
			System.out.println(driverName+"\t"+userName+"\t"+password+"\t");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("读取数据库配置文件出错.");
		}
	}

	/**
	 * 获取一个连接
	 */
	public Connection getConnection() {
		if (pool.size() > 0) {
			Connection conn = pool.get(0);
			System.out.println("连接池的连接被调用....");
			pool.remove(conn);
			return conn;
		} else
			return null;
	}

	/**
	 * 关闭数据库连接池
	 */
	public void closePool() {
		for (int i = 0; i < poolSize; i++) {
			try {
				pool.get(i).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pool.remove(i);
		}
	}

	/**
	 * 释放数据库连接
	 * 
	 * @param conn
	 */
	public void release(Connection conn) {
		pool.add(conn);
	}
}
