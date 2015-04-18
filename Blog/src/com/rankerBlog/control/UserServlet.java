package com.rankerBlog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rankerBlog.dto.Users;
import com.rankerBlog.util.DBUtilHelper;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if (method.equals("addUser")) {
			try {
				addUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("login")) {
			try {
				this.findUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("logout")) {
			this.logout(request, response);
		}
	}

	/**
	 * 注册用户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (null == username || "".equals(username.trim()) || null == password
				|| "".equals(password.trim())) {
			String message = "用户名或密码不能为空";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
					request, response);
		} else {
			String sql = "insert into users (username,password) value (?,?)";
			String[] params = { username, password };
			DBUtilHelper.executeSQL(sql, params);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 查找用户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings("rawtypes")
	public void findUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Users user = new Users();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = "select * from users where username=\"" + username
				+ "\"and password=\"" + password + "\"";
		List list = (List) DBUtilHelper.executeSQL(sql, user);
		if (list.size() > 0) {
			user = (Users) list.get(0);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/admin/index.jsp").forward(
					request, response);
		} else {
			String message = "用户或密码不正确";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 注销用户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("/jsp/login.jsp").forward(request,
				response);
	}
}
