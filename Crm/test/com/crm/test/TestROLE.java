package com.crm.test;

import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Employee;
import com.crm.entity.Role;
import com.crm.service.IRoleService;

public class TestROLE {

	private static IRoleService roleService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			roleService = (IRoleService) atc.getBean("roleService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		List<Role> rs = roleService.list();
		for (Role r : rs) {
			System.out.println(r.getRoleName());
			Set<Employee> emps = r.getEmployees();
			System.out.println(emps.size());
		}

	}
}
