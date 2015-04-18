package com.fatyu.stock.bean;

/**
 * 股票实体Bean
 * 
 * @author Fatyu
 * 
 */
public class StockBean {
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	private String ticker;// 股票代码
	private String date;// 交易日期
	private String time;// 交易时间
	private double openPrice;// 股票开盘价格
	private double closePrice;// 股票收盘价格
	private double highPrice;// 股票最高价格
	private double lowPrice;// 股票最低价格
	private int volume;// 股票成交量

}
