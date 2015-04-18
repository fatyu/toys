package com.rankerBlog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rankerBlog.dto.Blog;
import com.rankerBlog.dto.Users;
import com.rankerBlog.util.DBUtilHelper;

@SuppressWarnings("serial")
public class BlogServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 解决页面传输的数据出现乱码问题
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method.equals("addBlog")) {
			addBlog(request, response);
		} else if (method.equals("listBlog")) {
			try {
				this.listBlog(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("adminBlog")) {
			try {
				this.listBlog4Edit(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("beforeEdit")) {
			try {
				this.beforeEdit(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("deleteBlog")) {
			try {
				this.deleteBlog(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("showBlog")) {
			try {
				this.showBlog(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("finishEdit")) {
			try {
				this.finishEdit(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 添加博文
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			String title = request.getParameter("title");
			String category_id = request.getParameter("catalog");
			String content = request.getParameter("content");

			int result = 0;
			String sql = "INSERT INTO `blog`(`title`,`content`,`category_id`,`createdtime`) VALUE (?,?,?,NOW());";
			String[] params = { title, content, category_id };
			try {
				result = DBUtilHelper.executeSQL(sql, params);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			String message;// 声明返回信息

			if (result == 1) {
				message = "添加文章成功";
			} else {
				message = "添加文章失败";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
					request, response);
		} else {
			String message = "请先登录";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 查询所有的博文
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void listBlog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Blog blog = new Blog();
		String sql = "SELECT * FROM `blog` ORDER BY ID DESC;";
		List<Object> list = DBUtilHelper.executeSQL(sql, blog);
		if (list.size() > 0) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/admin/listBlog.jsp").forward(
					request, response);
		} else {
			request.setAttribute("message", new String("主人很懒..没有写任何博文"));
			request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
					request, response);
		}
	}

	/**
	 * 查询指定的博文
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public void showBlog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Blog _blog = new Blog();
		List list1 = (List) request.getAttribute("list");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String sql = "SELECT * FROM `blog` WHERE ID=" + id;
		List<Object> list = DBUtilHelper.executeSQL(sql, _blog);
		Blog blog = null;
		if (list.size() > 0) {
			blog = (Blog) list.get(0);
			if (blog != null) {
				request.setAttribute("blog", blog);
				request.setAttribute("list", list1);
				request.getRequestDispatcher("/jsp/admin/showBlog.jsp")
						.forward(request, response);
			}
		} else {
			String message = "博文不存在!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
					request, response);
		}
	}

	/**
	 * 删除博文
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void deleteBlog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			String id = request.getParameter("id");
			String sql = "DELETE FROM `blog` WHERE ID=" + id + ";";
			DBUtilHelper.executeSQL(sql);
			request.getRequestDispatcher("/blog?method=adminBlog").forward(
					request, response);
		} else {
			String message = "请先登录";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 为编辑操作查询所有的博文
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void listBlog4Edit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Blog _blog = new Blog();
		String sql = "SELECT * FROM `blog` ORDER BY ID DESC;";
		List<Object> list = DBUtilHelper.executeSQL(sql, _blog);
		if (list.size() > 0) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/admin/adminBlog.jsp").forward(
					request, response);
		} else {
			request.setAttribute("message", new String("主人很懒..没有写任何博文"));
			request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
					request, response);
		}
	}

	/**
	 * 返回编辑的博文对象
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void beforeEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			String sql = "SELECT * FROM `blog` WHERE ID=" + id;
			Blog _blog = new Blog();
			List<Object> list = DBUtilHelper.executeSQL(sql, _blog);
			Blog blog = null;
			if (list.size() > 0) {
				blog = (Blog) list.get(0);
				if (blog != null) {
					request.setAttribute("blog", blog);
					request.getRequestDispatcher("/jsp/admin/editBlog.jsp")
							.forward(request, response);
				}
			} else {
				String message = "博文不存在!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
						request, response);
			}
		} else {
			String message = "请先登录";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 对数据库进行更新
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void finishEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String title = request.getParameter("title");
		String category_id = request.getParameter("catalog");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		String sql = "update `blog` set `title`=?,`content`=?,`category_id`=? where `id`=?";

		String[] params = { title, content, category_id, id };
		DBUtilHelper.executeSQL(sql, params);
		request.getRequestDispatcher("/blog?method=adminBlog").forward(request,
				response);
	}

}
