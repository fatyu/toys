package com.itlamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;

/**
 *列出所有的电话信息
 * 
 * @author Fatyu
 */
public class ListPersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListPersonServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");//设置字符集编码
		PersonDao personDao = new PersonDaoImpl();
		List list = personDao
				.queryPerson("select * from dhcx_ryxx order by company,department");
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/admin/phoneManage/listPerson.jsp");
		dispatcher.forward(request, response);
	}

	public void init() throws ServletException {
	}

}
