package com.crm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.GroupCustomer;
import com.crm.entity.PersonCustomer;
import com.crm.service.IGenerateExcelAndDBService;
import com.crm.service.IGroupCustomerService;
import com.crm.service.IPersonCustomerService;

/**
 * 生成excel
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class GenerateExcelAndDBService implements IGenerateExcelAndDBService {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	IGroupCustomerService groupCustomerService;

	@Resource
	IPersonCustomerService personCustomerService;

	// 生产集团客户excel
	public InputStream generateGCExcel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("客户名称");
		cell = row.createCell(1);
		cell.setCellValue("客户地址");

		cell = row.createCell(2);
		cell.setCellValue("地区邮编");

		cell = row.createCell(3);
		cell.setCellValue("客户类型");

		cell = row.createCell(4);
		cell.setCellValue("客户联系方式");

		cell = row.createCell(5);
		cell.setCellValue("客户身份证");

		List<GroupCustomer> list = groupCustomerService.list();
		if (list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				GroupCustomer gc = list.get(i);
				row = sheet.createRow(i + 1);
				cell = row.createCell(0);
				cell.setCellValue(gc.getGroupCustomerName());

				cell = row.createCell(1);
				cell.setCellValue(gc.getGroupCustomerAddress());

				cell = row.createCell(2);
				cell.setCellValue(gc.getGroupCustomerPostNum());

				cell = row.createCell(3);
				cell.setCellValue(gc.getGroupCustomerType());

				cell = row.createCell(4);
				cell.setCellValue(gc.getGroupCustomerPhoneNum());

				cell = row.createCell(5);
				cell.setCellValue(gc.getGroupCustomerCardNum());
			}

			File file = new File("gc.xls");

			try {
				OutputStream os = new FileOutputStream(file);
				wb.write(os);
				os.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			InputStream is = null;
			try {
				is = new FileInputStream(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return is;
		} else {
			return null;
		}

	}

	// 生产个人客户excel
	public InputStream generatePCExcel() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("客户名称");
		cell = row.createCell(1);
		cell.setCellValue("客户地址");

		cell = row.createCell(2);
		cell.setCellValue("客户民族");

		cell = row.createCell(3);
		cell.setCellValue("客户年龄");

		cell = row.createCell(4);
		cell.setCellValue("客户性别");

		cell = row.createCell(5);
		cell.setCellValue("客户身份证");

		cell = row.createCell(6);
		cell.setCellValue("客户级别");

		cell = row.createCell(7);
		cell.setCellValue("邮编");

		cell = row.createCell(8);
		cell.setCellValue("学历");

		cell = row.createCell(9);
		cell.setCellValue("爱好");

		cell = row.createCell(10);
		cell.setCellValue("联系方式");

		cell = row.createCell(11);
		cell.setCellValue("工作类型");

		cell = row.createCell(12);
		cell.setCellValue("职位");


		List<PersonCustomer> list = personCustomerService.list();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				PersonCustomer pc = list.get(i);
				row = sheet.createRow(i + 1);
				cell = row.createCell(0);
				cell.setCellValue(pc.getPersonCustomerName());
				cell = row.createCell(1);
				cell.setCellValue(pc.getPersonCustomerAddress());
				cell = row.createCell(2);
				cell.setCellValue(pc.getPersonCustomerNation());
				cell = row.createCell(3);
				cell.setCellValue(pc.getPersonCustomerAge());
				cell = row.createCell(4);
				cell.setCellValue(pc.getPersonCustomerSex());
				cell = row.createCell(5);
				cell.setCellValue(pc.getPersonCustomerCardNum());
				cell = row.createCell(6);
				cell.setCellValue(pc.getPersonCustomerLeavle());
				cell = row.createCell(7);
				cell.setCellValue(pc.getPersonCustomerPostCode());
				cell = row.createCell(8);
				cell.setCellValue(pc.getPersonCustomerEdu());
				cell = row.createCell(9);
				cell.setCellValue(pc.getPersonCustomerHobby());
				cell = row.createCell(10);
				cell.setCellValue(pc.getPersonCustomerPhoneNum());
				cell = row.createCell(11);
				cell.setCellValue(pc.getPersonCustomerJobType());
				cell = row.createCell(12);
				cell.setCellValue(pc.getPersonCustomerJobTitle());
			}

			File file = new File("pc.xls");

			try {
				OutputStream os = new FileOutputStream(file);
				wb.write(os);
				os.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			InputStream is = null;
			try {
				is = new FileInputStream(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return is;
		} else {
			return null;
		}

	}
}
