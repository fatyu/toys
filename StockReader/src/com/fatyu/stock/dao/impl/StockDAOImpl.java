package com.fatyu.stock.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fatyu.stock.bean.StockBean;
import com.fatyu.stock.dao.StockDAO;
import com.fatyu.stock.util.JdbcUtil;

public class StockDAOImpl implements StockDAO {
	Connection conn = null;
	Statement stmt = null;

	@Override
	public List<StockBean> listByDate(String date) {
		String sql = "select * from T_STOCK where stockdate=to_date(\'" + date
				+ "\',\'MM/DD/YYYY\')";
		List<StockBean> sbs = new ArrayList<StockBean>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			StockBean sb = new StockBean();
			while (rs.next()) {

				sb.setTicker(rs.getString(1));
				sb.setDate(rs.getString(2));
				sb.setTime(rs.getString(3));
				sb.setOpenPrice(rs.getDouble(4));
				sb.setClosePrice(rs.getDouble(5));
				sb.setHighPrice(rs.getDouble(6));
				sb.setLowPrice(rs.getDouble(7));
				sb.setVolume(rs.getInt(8));
				System.out.println(sb.getVolume());
				sbs.add(sb);
			}
			System.out.println(sbs.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sbs;
	}

	@Override
	public List<StockBean> listByTicker(String ticker) {
		String sql = "select * from T_STOCK where ticker=\'" + ticker + "\'";
		List<StockBean> sbs = new ArrayList<StockBean>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			StockBean sb = new StockBean();
			while (rs.next()) {
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
			System.out.println(sbs.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sbs;
	}

	@Override
	public List<StockBean> listByTickerAndDate(String ticker, String startdate,
			String enddate) {
		String sql = "select * from T_STOCK where ticker=\'" + ticker + "\' and (stockdate between to_date(\'"+startdate+"\',\'MM/DD/YYYY\') and to_date(\'" +
				enddate+"\',\'MM/DD/YYYY\'))";
		System.out.println(sql);
		List<StockBean> sbs = new ArrayList<StockBean>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			StockBean sb = new StockBean();
			while (rs.next()) {

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
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sbs;
	}
}
