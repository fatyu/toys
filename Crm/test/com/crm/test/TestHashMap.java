package com.crm.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		// 农历节日
		Map<String, String> lcudate = new HashMap<String, String>();
		lcudate.put("正与初一", "春节");
		lcudate.put("正与十五", "元宵节");
		lcudate.put("五月初五", "端午节");
		lcudate.put("八月十五", "中秋节");
		lcudate.put("十二月三十", "大年三十");
		// 阳历节日
		Map<String, String> sundate = new HashMap<String, String>();
		sundate.put("0101", "元旦");
		sundate.put("0308", "妇女节");
		sundate.put("0312", "植树节");
		sundate.put("0501", "劳动节");
		sundate.put("0601", "儿童节");

		Set<String> keys1 = lcudate.keySet();

		for (Iterator<String> iter = keys1.iterator(); iter.hasNext();) {
			System.out.println(lcudate.get(iter.next()));
		}
	}
}
