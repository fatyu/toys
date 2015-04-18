package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TimePicker;

public class TimePickerViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("TimePicker");
		setContentView(R.layout.timepicker);
		TimePicker tp = (TimePicker) findViewById(R.id.timepicker);
		tp.setIs24HourView(false);
	}

}
