package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("datepicker");
		setContentView(R.layout.datepicker);
		DatePicker dp = (DatePicker) findViewById(R.id.datepicker);
		dp.init(2010, 05, 18, null);
	}
	

}
