package com.crm.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Sex;
import com.crm.service.ISexService;

/**
 * 测试性别
 * 
 * @author Fatyu
 * 
 */
public class TestSEX {

	private static ISexService sexService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			sexService = (ISexService) atc.getBean("sexService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void find() {
		Sex sex = sexService.findById("1");
		System.out.println(sex.getSexId());
		System.out.println(sex.getSexName());
	}

	@Test
	public void list() {
		List<Sex> sexs = sexService.list();
		for (Sex sex : sexs) {
			System.out.println(sex.getSexId());
			System.out.println(sex.getSexName());
		}

	}

	@Test
	public void update() {
		Sex sex = sexService.findById("1");
		System.out.println(sex.getSexId());
		System.out.println(sex.getSexName());
		sex.setSexName("神");
		sexService.update(sex);
		System.out.println(sex.getSexId());
		System.out.println(sex.getSexName());

	}

}
