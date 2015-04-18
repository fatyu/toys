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
 * 更新系统用户密码
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
		request.setCharacterEncoding("gbk");//设置字符集编码
		User user1 = (User) request.getSession().getAttribute("user");
		String lastpassword = request.getParameter("lastpasswrod");// 获得用户输入的原始密码
		String password = request.getParameter("password");// 获得新密码
		String repassword = request.getParameter("repassword");// 重复密码
		String currentUserPws = request.getParameter("currentUserPwd");// 获得当前用户的真实密码

		if(user1!=null){
			User user = new User();
			if (currentUserPws.equals(lastpassword)) {// 判断用户输入的原始密码和真实密码是否相同
				if (password.equals(repassword)) {// 判断新密码两次输入是否相同
					user.setPassword(repassword);
					user.setUsername(request.getParameter("username"));
					UserDao userDao = new UserDaoImpl();
					boolean flag = userDao.editPassword(user);
					if (flag) {
						request
								.setAttribute("msg",
										"密码修改成功.");
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/message.jsp");
						dispatcher.forward(request, response);
					} else {
						request.setAttribute("msg", "密码修改失败.");
						RequestDispatcher dispatcher = request
								.getRequestDispatcher("/message.jsp");
						dispatcher.forward(request, response);
					}
				} else {
					request.setAttribute("msg", "两次密码输入不同.");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/message.jsp");
					dispatcher.forward(request, response);

				}
			} else {

				request.setAttribute("msg", "原始密码错误.");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/message.jsp");
				dispatcher.forward(request, response);
			}
		}else{
			request.setAttribute("msg", "请先登录.");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		}
	
	}

	public void init() throws ServletException {
	}

}
