package com.itlamp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.bean.Person;
import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;

/**
 * 添加电话信息的Servlet
 * 
 * @author Fatyu
 * 
 */
public class AddPersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddPersonServlet() {
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
	 * 获得请求调用Dao进行数据的添加
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");// 设置请求的字符集编码为gbk
		String username = request.getParameter("username");

		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		String homenumber = request.getParameter("homenumber");
		String phonenumber = request.getParameter("phonenumber");
		String officenumber = request.getParameter("officenumber");
		String department = request.getParameter("department");

		Person person = new Person();

		person.setAddress(address);
		person.setCompany(company);
		person.setDepartment(department);
		person.setTitle(title);
		person.setUsername(username);
		person.setHomeNumber(homenumber);
		person.setOfficeNumber(officenumber);
		person.setName(name);
		person.setPhoneNumber(phonenumber);
		if (username == null || username.equals("")) {
			request.setAttribute("msg", "请先登录.");// 设置添加操作的结果信息
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");// 服务器端页面跳转
			dispatcher.forward(request, response);
		} else {
			PersonDao personDao = new PersonDaoImpl();
			personDao.addPerson(person);

			request.setAttribute("msg", "信息添加成功.");// 设置添加操作的结果信息
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");// 服务器端页面跳转
			dispatcher.forward(request, response);
		}

	}

	public void init() throws ServletException {
	}

}
