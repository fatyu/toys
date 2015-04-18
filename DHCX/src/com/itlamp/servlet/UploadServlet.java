package com.itlamp.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itlamp.bean.Person;
import com.itlamp.bean.User;
import com.itlamp.dao.PersonDao;
import com.itlamp.dao.impl.PersonDaoImpl;

public class UploadServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	File tmpDir = null;// 初始化上传文件的临时存放目录
	File saveDir = null;// 初始化上传文件后的保存目录

	public UploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				DiskFileItemFactory dff = new DiskFileItemFactory();// 创建该对象
				dff.setRepository(tmpDir);// 指定上传文件的临时目录
				dff.setSizeThreshold(1024000);// 指定在内存中缓存数据大小,单位为byte
				ServletFileUpload sfu = new ServletFileUpload(dff);// 创建该对象
				sfu.setFileSizeMax(5000000);// 指定单个上传文件的最大尺寸
				FileItemIterator fii = sfu.getItemIterator(request);// 解析request
				while (fii.hasNext()) {
					FileItemStream fis = fii.next();// 从集合中获得一个文件流
					if (!fis.isFormField() && fis.getName().length() > 0) {// 过滤掉表单中非文件域
						String fileName = fis.getName().substring(
								fis.getName().lastIndexOf("\\"));// 获得上传文件的文件名
						BufferedInputStream in = new BufferedInputStream(fis
								.openStream());// 获得文件输入流
						BufferedOutputStream out = new BufferedOutputStream(
								new FileOutputStream(new File(saveDir
										+ fileName)));// 获得文件输出流
						Streams.copy(in, out, true);// 开始把文件写到你指定的上传文件夹

						InputStream xls = new FileInputStream(saveDir
								+ fileName);

						HSSFWorkbook wb = new HSSFWorkbook(xls);
						HSSFSheet sheet = wb.getSheetAt(0);
						HSSFRow row = sheet.getRow(0);
						HSSFCell cell = null;
						int rnum = sheet.getLastRowNum();
						User user = (User) request.getSession().getAttribute(
								"user");
						if (user == null) {
							request.setAttribute("msg", "请先登录.");
							RequestDispatcher dispatcher = request
									.getRequestDispatcher("/message.jsp");// 服务器端页面跳转
							dispatcher.forward(request, response);
						} else {
							for (int i = 1; i < rnum; i++) {
								row = sheet.getRow(i);
								Person person = new Person();
								person.setUsername(user.getUsername());
								row = sheet.getRow(i);

								cell = row.getCell(0);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setCompany(cell.getStringCellValue());
								cell = row.getCell(1);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setDepartment(cell.getStringCellValue());
								cell = row.getCell(2);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setTitle(cell.getStringCellValue());
								cell = row.getCell(3);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setName(cell.getStringCellValue());
								
								cell = row.getCell(4);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setOfficeNumber(cell
										.getStringCellValue());
								cell = row.getCell(5);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setHomeNumber(cell.getStringCellValue());

								cell = row.getCell(6);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person
										.setPhoneNumber(cell
												.getStringCellValue());

								cell = row.getCell(7);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								person.setAddress(cell.getStringCellValue());
								

								// System.out.println(person.getCompany());
								// System.out.println(person.getAddress());
								// System.out.println(person.getDepartment());
								// System.out.println(person.getHomeNumber());
								// System.out.println(person.getName());
								// System.out.println(person.getOfficeNumber());
								// System.out.println(person.getPhoneNumber());
								// System.out.println(person.getTitle());
								
								PersonDao pd = new PersonDaoImpl();
								pd.addPerson(person);
							}
							request.setAttribute("msg",
							"导入数据成功.<a href=\"/dhcx/ListPersonServlet\">查询所有信息</a>");//返回错误信息
							RequestDispatcher dispatcher = request
									.getRequestDispatcher("/message.jsp");//跳转后台管理页面
							dispatcher.forward(request, response);
						}
					}
				}
			}
		} catch (Exception e) {
			request.setAttribute("msg", "数据导入失败.");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");// 服务器端页面跳转
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		/*
		 * 对上传文件夹和临时文件夹进行初始化
		 */
		super.init();
		String tmpPath = "c:\\tmpdir";
		String savePath = "c:\\updir";
		tmpDir = new File(tmpPath);
		saveDir = new File(savePath);
		if (!tmpDir.isDirectory())
			tmpDir.mkdir();
		if (!saveDir.isDirectory())
			saveDir.mkdir();

	}
}
