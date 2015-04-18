package com.crm.test;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Employee;
import com.crm.entity.Power;
import com.crm.entity.Role;
import com.crm.service.IEmployeeService;

/**
 * 测试雇员
 * 
 * @author Fatyu
 * 
 */
public class TestE {

	private static IEmployeeService employeeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			employeeService = (IEmployeeService) atc.getBean("employeeService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void del() {
		employeeService.delete(10);
	}

	@Test
	public void list() {
		List<Employee> es = employeeService.list();
		for (Employee e : es) {
			System.out.println(e.getEmployeeAddress());
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void find() {
		Employee e = employeeService.findById(2);
		System.out.println(e.getEmployeeName());
		// Iterator it = e.getGroupCustomers().iterator();

		Iterator roles = e.getRoles().iterator();
		while (roles.hasNext()) {
			Role r = (Role) roles.next();
			System.out.println(r.getRoleName());
			Iterator powers = r.getPowers().iterator();
			while (powers.hasNext()) {
				Power p = (Power) powers.next();
				System.out.println(p.getPowerName());
			}
		}
		// while (it.hasNext()) {
		// GroupCustomer g = (GroupCustomer) it.next();
		// System.out.println(g.getGroupCustomerName());
		// }
	}

	@Test
	public void add() {
		Employee e = new Employee();
		e.setEmployeeName("aaa");
		e.setEmployeeAddress("aaa");
		e.setEmployeeAge(10);
		e.setEmployeePassword("aaaaaa");
		e.setEmployeeSalary(1000);
		e.setEmployeeNation("01");
		e.setEmployeeSex("1");
		employeeService.add(e);

	}

}
