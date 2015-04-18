package com.fatyu.stock.dao;

import java.util.List;

import com.fatyu.stock.bean.StockBean;
/**
 * 股票数据的操作接口
 * @author Fatyu
 *
 */
public interface StockDAO {
	
	/**
	 * 查询指定股票代码的所有记录
	 * @return List
	 */
	public List<StockBean> listByTicker(String ticker);
	/**
	 * 查询指定日期的股票记录
	 * @return List
	 */
	public List<StockBean> listByDate(String date);
	/**
	 * 查询指定日期和指定股票的记录
	 * @return List
	 */
	public List<StockBean> listByTickerAndDate(String ticker,String startdate,String enddate);
}
