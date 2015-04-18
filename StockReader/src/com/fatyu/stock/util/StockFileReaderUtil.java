package com.fatyu.stock.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Fatyu
 * 
 */
public class StockFileReaderUtil {
	/**
	 * 进行数据的插入操作
	 * 
	 * @param file
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public static void insertIntoDB(File file) throws IOException,
			SQLException, ClassNotFoundException, ParseException {
		BufferedReader br = new BufferedReader(new FileReader(file));// 创建读取文件流
		String line;// 缓存读取的一行字符串
		String insert;
		String[] data = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");//注册驱动
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "stock", "stock");//创建连接
		conn.setAutoCommit(false);//设置自动提交为否
		PreparedStatement pstmt = null; // 初始化查询
		String stockname = file.getName().substring(0,
				file.getName().lastIndexOf("."));//获得股票代码
		while ((line = br.readLine()) != null) {
			data = line.split(",");
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date tDate = df.parse(data[0]);
			java.sql.Date date = new java.sql.Date(tDate.getTime());
			insert = "insert into T_STOCK ( TICKER,STOCKDATE, STOCKTIME,OPENPRICE,HIGHPRICE,LOWPRICE,CLOSEPRICE,VOLUME) values (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);// 通过连接对象创建Ps对象
			pstmt.setString(1, stockname);
			pstmt.setDate(2, date);
			pstmt.setString(3, data[1]);
			pstmt.setDouble(4, Double.parseDouble(data[2]));
			pstmt.setDouble(5, Double.parseDouble(data[3]));
			pstmt.setDouble(6, Double.parseDouble(data[4]));
			pstmt.setDouble(7, Double.parseDouble(data[5]));
			pstmt.setInt(8, Integer.parseInt(data[6]));
			pstmt.execute();
			pstmt.close();
		}
		pstmt.close();
		conn.commit();
		conn.close();
	}

	/**
	 * 根据路径获得路径下的txt文件
	 * 
	 * @param path
	 * @return
	 */
	public static File[] getFiles(String path) {
		File file = new File(path);
		FileFilter ff = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.getName().endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		};
		File[] files = file.listFiles(ff);
		return files;
	}

	// public static void test() throws ClassNotFoundException, SQLException {
	//
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// Connection conn = DriverManager.getConnection(
	// "jdbc:oracle:thin:@localhost:1521:orcl", "stock", "stock");
	// conn.setAutoCommit(false);
	// Statement stmt = null; // 初始化查询
	// String insert =
	// "insert into T_TEST ( startdate,enddate) values (to_date('2007-11-15' , 'YYYY-MM-DD' ),to_date('2007-11-16' , 'YYYY-MM-DD' ))";
	// stmt = conn.createStatement();// 通过连接对象创建Ps对象
	// stmt.execute(insert);
	// stmt.close();
	// }

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException, ParseException {
		 File[] files = getFiles("e:\\");
		 for (File file :files){
			 insertIntoDB(file);
		 }
	}
}
