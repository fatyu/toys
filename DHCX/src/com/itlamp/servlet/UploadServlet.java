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
	File tmpDir = null;// ��ʼ���ϴ��ļ�����ʱ���Ŀ¼
	File saveDir = null;// ��ʼ���ϴ��ļ���ı���Ŀ¼

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
				DiskFileItemFactory dff = new DiskFileItemFactory();// �����ö���
				dff.setRepository(tmpDir);// ָ���ϴ��ļ�����ʱĿ¼
				dff.setSizeThreshold(1024000);// ָ�����ڴ��л������ݴ�С,��λΪbyte
				ServletFileUpload sfu = new ServletFileUpload(dff);// �����ö���
				sfu.setFileSizeMax(5000000);// ָ�������ϴ��ļ������ߴ�
				FileItemIterator fii = sfu.getItemIterator(request);// ����request
				while (fii.hasNext()) {
					FileItemStream fis = fii.next();// �Ӽ����л��һ���ļ���
					if (!fis.isFormField() && fis.getName().length() > 0) {// ���˵����з��ļ���
						String fileName = fis.getName().substring(
								fis.getName().lastIndexOf("\\"));// ����ϴ��ļ����ļ���
						BufferedInputStream in = new BufferedInputStream(fis
								.openStream());// ����ļ�������
						BufferedOutputStream out = new BufferedOutputStream(
								new FileOutputStream(new File(saveDir
										+ fileName)));// ����ļ������
						Streams.copy(in, out, true);// ��ʼ���ļ�д����ָ�����ϴ��ļ���

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
							request.setAttribute("msg", "���ȵ�¼.");
							RequestDispatcher dispatcher = request
									.getRequestDispatcher("/message.jsp");// ��������ҳ����ת
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
							"�������ݳɹ�.<a href=\"/dhcx/ListPersonServlet\">��ѯ������Ϣ</a>");//���ش�����Ϣ
							RequestDispatcher dispatcher = request
									.getRequestDispatcher("/message.jsp");//��ת��̨����ҳ��
							dispatcher.forward(request, response);
						}
					}
				}
			}
		} catch (Exception e) {
			request.setAttribute("msg", "���ݵ���ʧ��.");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/message.jsp");// ��������ҳ����ת
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

	public void init() throws ServletException {
		/*
		 * ���ϴ��ļ��к���ʱ�ļ��н��г�ʼ��
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
