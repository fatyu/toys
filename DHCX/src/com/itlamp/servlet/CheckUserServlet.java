package com.itlamp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.bean.User;
import com.itlamp.dao.UserDao;
import com.itlamp.dao.impl.UserDaoImpl;
/**
 * ��֤�û���������
 * @author Fatyu
 */
public class CheckUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CheckUserServlet() {
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
		 request.setCharacterEncoding("gbk");//�����ַ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// --->System.out.println(username);
		// --->System.out.println(password);
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		UserDao ud = new UserDaoImpl();
		User result = ud.queryUser(user);
		if (result == null) {
			request.setAttribute("msg",
					"�û������������.");//���ش�����Ϣ
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		} else {
			request.getSession().setAttribute("user", result);
			request.setAttribute("msg",
			"��½�ɹ�.<a href=\"ListPersonServlet\">��ѯ������Ϣ</a>");//���ش�����Ϣ
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");//��ת��̨����ҳ��
			dispatcher.forward(request, response);
		}
	}

	public void init() throws ServletException {
	}

}
