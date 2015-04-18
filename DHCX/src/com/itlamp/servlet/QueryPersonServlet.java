package com.itlamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;

/**
 * 模糊查詢
 * 
 * @author Fatyu
 * 
 */
public class QueryPersonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public QueryPersonServlet() {
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
		request.setCharacterEncoding("gbk");// 设置字符集编码
		String kind = request.getParameter("kind");
		String keyword = request.getParameter("keyword");
		String company = request.getParameter("company");//获取工作单位
		PersonDao pd = new PersonDaoImpl();
		List list = null;
		// 根据不同的条件进行数据的查询
		// 1表示名字
		// 2表示辦公室電話
		// 3表示家庭電話
		// 4表示手機號碼
		
		if(company==null||company.equals("")||company.equals("查询全部")){
			if (kind.equals("1")) {
				String sql = "select * from dhcx_ryxx where name like\'%" + keyword
						+ "%\' order by company,department";
				list = pd.queryPerson(sql);
			} else if (kind.equals("2")) {
				String sql = "select * from dhcx_ryxx where officenumber like\'%"
						+ keyword + "%\' order by company,department";
				list = pd.queryPerson(sql);
			} else if (kind.equals("3")) {
				String sql = "select * from dhcx_ryxx where homenumber like\'%"
						+ keyword + "%\' order by company,department";
				list = pd.queryPerson(sql);
			} else if (kind.equals("4")) {
				String sql = "select * from dhcx_ryxx where phonenumber like\'%"
						+ keyword + "%\' order by company,department";
				list = pd.queryPerson(sql);
			}
			request.setAttribute("list", list);

			if (request.getParameter("admin") != null
					&& request.getParameter("admin").equals("admin")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/admin/phoneManage/searchResult.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		}else{
			if (kind.equals("1")) {
				
				String sql = "select * from dhcx_ryxx where name like\'%" + keyword
						+ "%\' and company=\'"+company+"\' order by company,department";
				list = pd.queryPerson(sql);
			} else if (kind.equals("2")) {
				String sql = "select * from dhcx_ryxx where officenumber like\'%"
						+ keyword + "%\' and company=\'"+company+"\' order by company,department";
				list = pd.queryPerson(sql);
			} else if (kind.equals("3")) {
				String sql = "select * from dhcx_ryxx where homenumber like\'%"
						+ keyword + "%\' and company=\'"+company+"\' order by company,department";
				list = pd.queryPerson(sql);
			} else if (kind.equals("4")) {
				String sql = "select * from dhcx_ryxx where phonenumber like\'%"
						+ keyword + "%\' and company=\'"+company+"\' order by company,department";
				list = pd.queryPerson(sql);
			}
			request.setAttribute("list", list);

			if (request.getParameter("admin") != null
					&& request.getParameter("admin").equals("admin")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/admin/phoneManage/searchResult.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	public void init() throws ServletException {
	}

}
