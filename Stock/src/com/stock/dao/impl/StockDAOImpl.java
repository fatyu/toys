package com.stock.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.StockDAO;
import com.stock.entity.Stock;
import com.stock.util.ConnectionPool;

//import com.stock.util.JdbcUtil;

public class StockDAOImpl implements StockDAO {
	Connection conn = null;
	Statement stmt = null;
	ConnectionPool cp = ConnectionPool.getInstance();

	public List<Stock> listByDate(String date) {
		String sql = "select * from T_STOCK where stockdate=to_date(\'" + date
				+ "\',\'MM/DD/YYYY\')";
		System.out.println(sql);
		List<Stock> sbs = new ArrayList<Stock>();
		// conn = JdbcUtil.getConnection();
		conn = cp.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Stock sb = new Stock();
				sb.setTicker(rs.getString(1));
				sb.setDate(rs.getString(2));
				sb.setTime(rs.getString(3));
				sb.setOpenPrice(rs.getDouble(4));
				sb.setClosePrice(rs.getDouble(5));
				sb.setHighPrice(rs.getDouble(6));
				sb.setLowPrice(rs.getDouble(7));
				sb.setVolume(rs.getInt(8));
				// System.out.println(sb.getVolume());
				sbs.add(sb);
			}
			// System.out.println(sbs.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				cp.release(conn);
			} catch (Exception e) {
				e.printStackTrace();
				cp.closePool();
			}
		}
		return sbs;
	}

	public List<Stock> listByTicker(String ticker) {
		String sql = "select * from T_STOCK where ticker=\'" + ticker + "\'";
		System.out.println(sql);
		List<Stock> sbs = new ArrayList<Stock>();
		conn = cp.getConnection();
		// conn = JdbcUtil.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Stock sb = new Stock();
				sb.setTicker(rs.getString(1));
				sb.setDate(rs.getString(2));
				sb.setTime(rs.getString(3));
				sb.setOpenPrice(rs.getDouble(4));
				sb.setClosePrice(rs.getDouble(5));
				sb.setHighPrice(rs.getDouble(6));
				sb.setLowPrice(rs.getDouble(7));
				sb.setVolume(rs.getInt(8));
				sbs.add(sb);
			}
			// System.out.println(sbs.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				cp.release(conn);
			} catch (Exception e) {
				e.printStackTrace();
				cp.closePool();
			}
		}
		return sbs;
	}

	public List<Stock> listByTickerAndDate(String ticker, String startdate,
			String enddate) {
		String sql = "select * from T_STOCK where ticker=\'" + ticker
				+ "\' and (stockdate between to_date(\'" + startdate
				+ "\',\'MM/DD/YYYY\') and to_date(\'" + enddate
				+ "\',\'MM/DD/YYYY\'))";
		System.out.println(sql);
		List<Stock> sbs = new ArrayList<Stock>();
		// conn = JdbcUtil.getConnection();
		conn = cp.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Stock sb = new Stock();
				sb.setTicker(rs.getString(1));
				sb.setDate(rs.getString(2));
				sb.setTime(rs.getString(3));
				sb.setOpenPrice(rs.getDouble(4));
				sb.setClosePrice(rs.getDouble(5));
				sb.setHighPrice(rs.getDouble(6));
				sb.setLowPrice(rs.getDouble(7));
				sb.setVolume(rs.getInt(8));
				sbs.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				cp.release(conn);
			} catch (Exception e) {
				e.printStackTrace();
				cp.closePool();
			}
		}
		return sbs;
	}

	public List<Stock> list() {

		return null;
	}
}
