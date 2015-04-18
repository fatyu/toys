package com.crm.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Employee;
import com.crm.entity.GroupCustomer;
import com.crm.service.IEmployeeService;
import com.crm.service.IGroupCustomerService;

public class TestPC {

	private static IGroupCustomerService groupCustomerService;
	private static IEmployeeService employeeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			groupCustomerService = (IGroupCustomerService) atc
					.getBean("groupCustomerService");
			employeeService = (IEmployeeService) atc.getBean("employeeService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		GroupCustomer gc = new GroupCustomer();
		gc.setGroupCustomerName("113311");
		gc.setGroupCustomerPhoneNum("11111111111");
		gc.setGroupCustomerPostNum("800000");
		gc.setGroupCustomerType("vip111");
		gc.setGroupCustomerAddress("adssadsa");
		gc.setGroupCustomerCardNum("多萨里");

		groupCustomerService.add(gc);
	}

	@Test
	public void del() {
		groupCustomerService.delete(8);
	}

	@Test
	public void list() {
		List<GroupCustomer> gcs = groupCustomerService.list();
		for (GroupCustomer gc : gcs) {
			System.out.println(gc.getGroupCustomerName());
			Employee emp = gc.getEmployee();
			System.out.println(emp.getEmployeeAddress());
		}

	}

	@Test
	public void testE() {
		Employee gc = new Employee();
		GroupCustomer gc1 = new GroupCustomer();
		gc1.setGroupCustomerName("113311");
		gc1.setGroupCustomerPhoneNum("11111111111");
		gc1.setGroupCustomerPostNum("800000");
		gc1.setGroupCustomerType("vip111");
		gc1.setGroupCustomerAddress("adssadsa");
		gc1.setGroupCustomerCardNum("多萨里");
		groupCustomerService.add(gc1);
		Set<GroupCustomer> gs = new HashSet<GroupCustomer>();
		gs.add(gc1);
		gc.setEmployeeAddress("dsadsa");
		gc.setEmployeeName("dsa");
		gc.setEmployeePassword("dasdas");
		gc.setEmployeeSalary(231);
		gc.setGroupCustomers(gs);
		employeeService.add(gc);
	}
}
