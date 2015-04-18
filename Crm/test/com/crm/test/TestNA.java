package com.crm.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Nation;
import com.crm.service.INationService;

/**
 * 测试名族
 * 
 * @author Fatyu
 * 
 */
public class TestNA {

	private static INationService nationService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			nationService = (INationService) atc.getBean("nationService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void find() {
		Nation nation = nationService.findById("01");
		System.out.println(nation.getNationName());

	}

	@Test
	public void list() {
		List<Nation> ns = nationService.list();
		for (Nation nation : ns) {
			System.out.println(nation.getNationName());
		}

	}

	@Test
	public void update() {
		Nation nation = nationService.findById("01");
		System.out.println(nation.getNationName());
		nation.setNationName("河南人");
		nationService.update(nation);
		nation = nationService.findById("01");
		System.out.println(nation.getNationName());

	}

}
