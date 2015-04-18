package com.stock.dao;

import java.util.List;

import com.stock.entity.Stock;
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
	public List<Stock> listByTicker(String ticker);
	/**
	 * 查询指定日期的股票记录
	 * @return List
	 */
	public List<Stock> listByDate(String date);
	/**
	 * 查询指定日期和指定股票的记录
	 * @return List
	 */
	public List<Stock> listByTickerAndDate(String ticker,String startdate,String enddate);
}
