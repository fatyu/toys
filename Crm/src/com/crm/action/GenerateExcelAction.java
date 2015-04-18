package com.crm.action;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crm.service.IGenerateExcelAndDBService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class GenerateExcelAction extends ActionSupport {

	private static final long serialVersionUID = 5701166790227960043L;

	@Resource
	IGenerateExcelAndDBService generateExcelAndDBService;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InputStream getDownloadExcel() {
		if (this.getType().equals("gc")) {
			return generateExcelAndDBService.generateGCExcel();
		} else {
			return generateExcelAndDBService.generatePCExcel();
		}
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
