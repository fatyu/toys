package com.rankerBlog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rankerBlog.dto.Comment;
import com.rankerBlog.dto.Users;
import com.rankerBlog.util.DBUtilHelper;

@SuppressWarnings("serial")
public class CommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 乱码的解决
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if (method.equals("addComment")) {// 添加
			try {
				this.addComment(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("listComment")) {// 查询
			try {
				this.listComment(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("getMyComment")) {// 查询
			try {
				this.getMyComment(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("deleteComment")) {// 查询
			try {
				this.deleteComment(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 添加评论分类
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void addComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String content = request.getParameter("content");
		String username = request.getParameter("username");
		String blog_id = request.getParameter("id");

		String sql = "insert into Comment (username,content,blog_id,createdtime) value (?,?,?,now());";
		String[] params = { username, content, blog_id };
		DBUtilHelper.executeSQL(sql, params);
		request.getRequestDispatcher(
				"/comment?method=listComment&&id=" + blog_id).forward(request,
				response);
	}

	/**
	 * 查询所有评论
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public void listComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Comment comment = new Comment();
		String blog_id = request.getParameter("id");
		String sql = "select * from comment where blog_id=" + blog_id
				+ " order by id desc";
		List list = (List) DBUtilHelper.executeSQL(sql, comment);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/blog?method=showBlog&&id=" + blog_id)
				.forward(request, response);
	}

	/**
	 * 删除评论
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void deleteComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			String id = request.getParameter("id");
			String blog_id = request.getParameter("bid");
			String sql = "delete from comment where id=" + id;
			DBUtilHelper.executeSQL(sql);
			request.getRequestDispatcher(
					"/comment?method=getMyComment&&id=" + blog_id).forward(
					request, response);

		} else {
			String message = "请先登录";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 返回对应博文的评论
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public void getMyComment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Comment comment = new Comment();
		String blog_id = request.getParameter("id");
		String sql = "select * from comment where blog_id=" + blog_id
				+ " order by id desc";
		List list = (List) DBUtilHelper.executeSQL(sql, comment);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/admin/adminComment.jsp").forward(
				request, response);
	}
}
