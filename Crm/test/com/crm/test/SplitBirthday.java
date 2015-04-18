package com.crm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SplitBirthday {

	static String birthday = "412326198711190010";

	public static String spliteB() {
		birthday = birthday.substring(10, 14);
		return birthday;
	}

	public static void main(String[] args) {
		// Date date = new Date();
		// System.out.println("0"+(date.getMonth()+1)+date.getDate());
		// System.out.println(date.toString());
		// System.out.println(spliteB());
		// System.out.println();

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		System.out.println(dateStr);
	}

}
