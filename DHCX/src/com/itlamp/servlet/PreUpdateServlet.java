package com.itlamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.bean.Person;
import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;
/**
 * ����ǰ�����ݴ���
 * @author Fatyu
 *
 */
public class PreUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PreUpdateServlet() {
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
		request.setCharacterEncoding("gbk");//�����ַ�������
		String uuid = request.getParameter("uuid");//��ñ������
		PersonDao personDao = new PersonDaoImpl();
		List list = personDao
				.queryPerson("select * from dhcx_ryxx where id = \'" + uuid
						+ "\'");
		request.setAttribute("person", (Person) list.get(0));
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/admin/phoneManage/editPerson.jsp");
		dispatcher.forward(request, response);
	}

	public void init() throws ServletException {
	}

}
