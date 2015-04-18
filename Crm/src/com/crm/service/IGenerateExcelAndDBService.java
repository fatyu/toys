package com.crm.service;

import java.io.InputStream;

public interface IGenerateExcelAndDBService {

	public InputStream generateGCExcel();
	public InputStream generatePCExcel();
	
}