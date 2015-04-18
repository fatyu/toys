package com.crm.test;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.CareInfo;
import com.crm.entity.Employee;
import com.crm.entity.GroupCustomer;
import com.crm.service.ICareInfoService;
import com.crm.service.IEmployeeService;

/**
 * 测试关怀信息
 * 
 * @author Fatyu
 * 
 */
public class TestCI {
	private static ICareInfoService careInfoService;
	private static IEmployeeService employeeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			careInfoService = (ICareInfoService) atc.getBean("careInfoService");
			employeeService = (IEmployeeService) atc.getBean("employeeService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void del() {
		careInfoService.delete(1);
	}

	@Test
	public void list() {
		List<CareInfo> cs = careInfoService.list();
		for (CareInfo c : cs) {
			System.out.println(c.getEmployee().getEmployeeName());
			System.out.println("info :	" + c.getInfoTitle() + "    "
					+ c.getInfoDate() + "     " + c.getInfoDetail());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void add() {
		Employee e = employeeService.findById(2);
		System.out.println(e.getEmployeeName());
		Iterator ggs = e.getGroupCustomers().iterator();
		while (ggs.hasNext()) {
			GroupCustomer p = (GroupCustomer) ggs.next();
			System.out.println(p.getGroupCustomerName());
		}
		CareInfo c = new CareInfo();
		c.setInfoType("wanwan");
		c.setInfoDate("2010-04-12");
		c.setInfoDetail("test1");
		c.setInfoTitle("tt1");
		c.setEmployee(e);
		c.setGroupCustomers(e.getGroupCustomers());
		careInfoService.add(c);
	}
}
