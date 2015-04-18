package com.crm.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crm.entity.Complain;
import com.crm.service.IComplainService;

public class TestComplain {

	private static IComplainService complainService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext atc = new ClassPathXmlApplicationContext(
					"beans.xml");
			complainService = (IComplainService) atc.getBean("complainService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		System.out.println(dateStr);

		Complain c = new Complain();
		c.setComplainType("售后垃圾");
		c.setComplainDate(dateStr);
		c.setComplainContent("售后没有服务");

		complainService.add(c);
	}

	@Test
	public void testUpdate() {
		Complain c = complainService.findById(3);
		c.setClear("Y");
		c.setClearType("上门服务");
		c.setFeeling("非常满意");

		complainService.update(c);
	}

	@Test
	public void testdel() {
		complainService.delete(new Integer[] { 1, 2 });
	}

	@Test
	public void testlist() {
		List<Complain> list = complainService.list();
		for (Complain c : list) {
			System.out.println(c.getComplainType());
			System.out.println(c.getComplainContent());
			System.out.println(c.getComplainDate());
		}
	}

}
