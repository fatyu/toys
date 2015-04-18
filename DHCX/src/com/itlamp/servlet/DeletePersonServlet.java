package com.itlamp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;
/**
 * 删除电话信息
 * @author Fatyu
 *
 */
public class DeletePersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DeletePersonServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 删除信息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");//设置字符集编码
		String uuid = request.getParameter("uuid");// 获得信息表主键
		String sql = "delete from dhcx_ryxx where id=\'" + uuid + "\'";
		PersonDao personDao = new PersonDaoImpl();
		personDao.deletePerson(sql);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListPersonServlet");
		dispatcher.forward(request, response);
	}

	public void init() throws ServletException {
	}

}
