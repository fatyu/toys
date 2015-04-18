package com.rankerBlog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rankerBlog.dto.Category;
import com.rankerBlog.dto.Users;
import com.rankerBlog.util.DBUtilHelper;

@SuppressWarnings("serial")
public class CategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 乱码的解决
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if (method.equals("addCategory")) {// 添加
			try {
				this.addCategory(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("deleteCategory")) {// 删除
			try {
				this.deleteCategory(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("listCategory")) {// 查询
			try {
				this.listCategory(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("beforeEdit")) {// 修改前处理
			try {
				this.beforeEdit(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("finishEdit")) {// 修改
			try {
				this.finishEdit(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (method.equals("getCategory")) {// 修改
			try {
				this.getCategory(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获得类别
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void getCategory(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		Category category = new Category();
		String sql = "select * from category order by level desc,id desc";
		List list = (List) DBUtilHelper.executeSQL(sql, category);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/admin/addBlog.jsp").forward(request,
				response);
	}

	/**
	 * 添加文章分类
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			String name = request.getParameter("name");
			String level = request.getParameter("level");

			String sql = "insert into category (name,level) value (?,?);";
			String[] params = { name, level };
			DBUtilHelper.executeSQL(sql, params);
			String message = "添加类别成功!";
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
	 * 查询所有类别
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public void listCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		Category category = new Category();
		String sql = "select * from category order by level desc,id desc";
		List list = (List) DBUtilHelper.executeSQL(sql, category);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/admin/adminCategory.jsp").forward(
				request, response);
	}

	/**
	 * 删除对应类别
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteCategory(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
		String id = request.getParameter("id");
		String sql = "delete from category where id=" + id;
		DBUtilHelper.executeSQL(sql);
		request.getRequestDispatcher("/category?method=listCategory").forward(
				request, response);
		}else {
			String message = "请先登录";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 获得要修改的类别对象
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void beforeEdit(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		
		String id = request.getParameter("id");
		String sql = "select * from category where id=" + id;
		Category c = new Category();
		List list = (List) DBUtilHelper.executeSQL(sql, c);
		if (list.size() >= 0) {
			Category category = (Category) list.get(0);
			request.setAttribute("category", category);
			request.getRequestDispatcher("/jsp/admin/editCategory.jsp")
					.forward(request, response);
		} else {
			String message = "出现未知错误,请联系管理员!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/jsp/admin/message.jsp").forward(
					request, response);
		}
	}

	/**
	 * 更新对应的类别信息
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void finishEdit(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String level = request.getParameter("level");

		String sql = "update category set name=?,level=? where id=" + id;
		String[] params = { name, level };
		DBUtilHelper.executeSQL(sql, params);
		request.getRequestDispatcher("/category?method=listCategory").forward(
				request, response);
		}else {
		String message = "请先登录";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/jsp/login.jsp").forward(request,
				response);
		}
	}
}
