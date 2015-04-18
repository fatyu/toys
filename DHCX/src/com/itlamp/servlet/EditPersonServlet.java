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
 * 更新电话信息
 * @author Fatyu
 *
 */
public class EditPersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditPersonServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String uuid = request.getParameter("uuid");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		String homenumber = request.getParameter("homenumber");
		String phonenumber = request.getParameter("phonenumber");
		String officenumber = request.getParameter("officenumber");
		String department = request.getParameter("department");
		String sql = "update dhcx_ryxx set name=\'" + name + "\',title=\'"
				+ title + "\',address=\'" + address + "\',company=\'" + company
				+ "\',homenumber=\'" + homenumber + "\',phonenumber=\'"
				+ phonenumber + "\',officenumber=\'" + officenumber+ "\',department=\'" + department
				+ "\' where id=\'" + uuid + "\'";
		PersonDao personDao = new PersonDaoImpl();
		if(personDao.updatePerson(sql)>0){
			request.setAttribute("msg", "信息更新成功.");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
	
		}else{
			request.setAttribute("msg", "信息更新失败.");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void init() throws ServletException {
	}

}
