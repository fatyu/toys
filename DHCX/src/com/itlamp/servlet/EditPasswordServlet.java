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
 * ����ϵͳ�û�����
 * @author Fatyu
 *
 */
public class EditPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EditPasswordServlet() {
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
		User user1 = (User) request.getSession().getAttribute("user");
		String lastpassword = request.getParameter("lastpasswrod");// ����û������ԭʼ����
		String password = request.getParameter("password");// ���������
		String repassword = request.getParameter("repassword");// �ظ�����
		String currentUserPws = request.getParameter("currentUserPwd");// ��õ�ǰ�û�����ʵ����

		if(user1!=null){
			User user = new User();
			if (currentUserPws.equals(lastpassword)) {// �ж��û������ԭʼ�������ʵ�����Ƿ���ͬ
				if (password.equals(repassword)) {// �ж����������������Ƿ���ͬ
					user.setPassword(repassword);
					user.setUsername(request.getParameter("username"));
					UserDao userDao = new UserDaoImpl();
					boolean flag = userDao.editPassword(user);
					if (flag) {
						request
								.setAttribute("msg",
										"�����޸ĳɹ�.");
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/message.jsp");
						dispatcher.forward(request, response);
					} else {
						request.setAttribute("msg", "�����޸�ʧ��.");
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/message.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("msg", "�����������벻ͬ.");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/message.jsp");
					dispatcher.forward(request, response);

				}
			} else {

				request.setAttribute("msg", "ԭʼ�������.");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/message.jsp");
				dispatcher.forward(request, response);
			}
		}else{
			request.setAttribute("msg", "���ȵ�¼.");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		}
	
	}

	public void init() throws ServletException {
	}

}
