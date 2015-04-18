package com.crm.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Power;
import com.crm.service.IPowerService;

public class TestPOWER {

	private static IPowerService powerService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			powerService = (IPowerService) atc.getBean("powerService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		List<Power> ps = powerService.list();
		for (Power p : ps) {
			System.out.println(p.getPowerName());
		}

	}

	@Test
	public void find() {
		Power p = powerService.findById(4);
		System.out.println(p.getPowerName());

	}

}
