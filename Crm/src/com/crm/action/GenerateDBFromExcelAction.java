package com.crm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.crm.entity.Employee;
import com.crm.entity.GroupCustomer;
import com.crm.entity.PersonCustomer;
import com.crm.service.IEmployeeService;
import com.crm.service.IGenerateExcelAndDBService;
import com.crm.service.IGroupCustomerService;
import com.crm.service.IPersonCustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class GenerateDBFromExcelAction extends ActionSupport implements
		SessionAware {

	private static final long serialVersionUID = -7283561405978496249L;

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	@Resource
	IGenerateExcelAndDBService generateExcelAndDBService;

	@Resource
	IEmployeeService employeeService;

	@Resource
	IGroupCustomerService groupCustomerService;

	@Resource
	IPersonCustomerService personCustomerService;

	private File excel;
	private String excelFileName;

	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String execute() throws Exception {
		try {
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("excels");
			if (excel != null) {

				File save = new File(new File(realpath), excelFileName);
				if (!save.getParentFile().exists()) {
					save.getParentFile().mkdirs();
				}
				FileUtils.copyFile(excel, save);
				// //////////////////使用poi进行文件解析
				InputStream xls = new FileInputStream(realpath
						+ File.separatorChar + save.getName());
				HSSFWorkbook wb = new HSSFWorkbook(xls);
				HSSFSheet sheet = wb.getSheetAt(0);
				HSSFRow row = sheet.getRow(0);
				HSSFCell cell = null;
				int rnum = sheet.getLastRowNum();
				int cnum = row.getLastCellNum();
				System.out.println(cnum);
				Employee employee = (Employee) session.get("employee");
				if (cnum < 10) {// 集团客户xls
					for (int i = 1; i <= rnum; i++) {
						row = sheet.getRow(i);
						GroupCustomer gc = new GroupCustomer();
						row = sheet.getRow(i);
						cell = row.getCell(0);
						gc.setGroupCustomerName(cell.getStringCellValue());

						cell = row.getCell(1);
						gc.setGroupCustomerAddress(cell.getStringCellValue());

						cell = row.getCell(2);
						gc.setGroupCustomerPostNum(cell.getStringCellValue());

						cell = row.getCell(3);
						gc.setGroupCustomerType(cell.getStringCellValue());
						cell = row.getCell(4);
						gc.setGroupCustomerPhoneNum(cell.getStringCellValue());

						cell = row.getCell(5);
						gc.setGroupCustomerCardNum(cell.getStringCellValue());
						gc.setEmployee(employee);
						groupCustomerService.add(gc);

					}
				} else {// 个人客户xls
					for (int i = 1; i <= rnum; i++) {
						row = sheet.getRow(i);
						PersonCustomer pc = new PersonCustomer();
						row = sheet.getRow(i);
						cell = row.getCell(0);
						pc.setPersonCustomerName(cell.getStringCellValue());
						cell = row.getCell(1);
						pc.setPersonCustomerAddress(cell.getStringCellValue());
						cell = row.getCell(2);
						pc.setPersonCustomerNation(cell.getStringCellValue());
						cell = row.getCell(3);
						pc.setPersonCustomerAge((int) cell
								.getNumericCellValue());
						cell = row.getCell(4);
						pc.setPersonCustomerSex(cell.getStringCellValue());
						cell = row.getCell(5);
						pc.setPersonCustomerCardNum(cell.getStringCellValue());
						cell = row.getCell(6);
						pc.setPersonCustomerLeavle(cell.getStringCellValue());
						cell = row.getCell(7);
						pc.setPersonCustomerPostCode(cell.getStringCellValue());
						cell = row.getCell(8);
						pc.setPersonCustomerEdu(cell.getStringCellValue());
						cell = row.getCell(9);
						pc.setPersonCustomerHobby(cell.getStringCellValue());
						cell = row.getCell(10);
						pc.setPersonCustomerPhoneNum(cell.getStringCellValue());
						cell = row.getCell(11);
						pc.setPersonCustomerJobType(cell.getStringCellValue());
						cell = row.getCell(12);
						pc.setPersonCustomerJobTitle(cell.getStringCellValue());
						pc.setEmployee(employee);
						personCustomerService.add(pc);
					}
				}
			}
			ActionContext.getContext().put("msg", "添加成功");
			return SUCCESS;
		} catch (Exception e) {
			ActionContext.getContext().put("msg", "文件内容格式错误...请检查后重新上传");
			return "importerror";
		}

	}
}
