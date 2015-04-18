package com.stock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.dao.StockDAO;
import com.stock.dao.impl.StockDAOImpl;
import com.stock.entity.Stock;

public class ListDataServlet extends HttpServlet {

	private static final long serialVersionUID = -5472659364154737281L;

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StockDAO sd = new StockDAOImpl();
		// System.out.println(request.getRemoteAddr());//获得访问的主机ip
		String ticker = request.getParameter("ticker");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");

		System.out.println(ticker);
		System.out.println(startdate.toLowerCase());
		System.out.println(enddate.toLowerCase());

		if (startdate.trim().equals("") && enddate.trim().equals("")
				&& !ticker.equals("")) {
			List<Stock> sbs = sd.listByTicker(ticker.toUpperCase());
			System.out.println(sbs.size());
			request.setAttribute("sbs", sbs);
			request.getRequestDispatcher("/jsp/data.jsp").forward(request,
					response);
		}
		if (!(startdate.trim().equals("")) && !(ticker.trim().equals(""))
				&& !(enddate.trim().equals(""))) {
			List<Stock> sbs = sd.listByTickerAndDate(ticker.toUpperCase(),
					startdate, enddate);
			System.out.println(sbs.size());
			request.setAttribute("sbs", sbs);
			request.getRequestDispatcher("/jsp/data.jsp").forward(request,
					response);
		}
		if (!startdate.equals("") && ticker.equals("")
				&& enddate.trim().equals("")) {
			List<Stock> sbs = sd.listByDate(startdate);
			System.out.println(sbs.size());
			request.setAttribute("sbs", sbs);
			request.getRequestDispatcher("/jsp/data.jsp").forward(request,
					response);
		}
		if (ticker.equals("") && startdate.equals("") && enddate.equals("")) {
			String message = "股票代码或起始日期必须选择一个.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/message.jsp").forward(request,
					response);
		}
	}

	public void init() throws ServletException {
		System.out.println("......通过股票代码查询的servlet被初始化......");
	}
}
