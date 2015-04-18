package com.fatyu.stock.test;

import java.util.List;

import com.fatyu.stock.bean.StockBean;
import com.fatyu.stock.dao.StockDAO;
import com.fatyu.stock.dao.impl.StockDAOImpl;

public class Test {
	public static void main(String[] args) {
		StockDAO sd = new StockDAOImpl();
		long start = System.currentTimeMillis();
		List<StockBean> sbs = sd.listByTickerAndDate("DELL","02/14/2008","02/16/2008");
		List<StockBean> sbs1 = sd.listByTickerAndDate("IBM","02/14/2008","02/16/2008");
		long end = System.currentTimeMillis();
		System.out.println(sbs.size()+sbs1.size());
		System.out.println(end-start);
	}
}
