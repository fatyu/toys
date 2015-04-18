package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class CheckboxActivity extends Activity {
	CheckBox java;
	CheckBox python;
	CheckBox cpp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox);
		setTitle("CheckBoxActivity");
		make_checkbox_view();
	}

	private void make_checkbox_view() {
		java = (CheckBox) findViewById(R.id.java);
		cpp = (CheckBox) findViewById(R.id.cpp);
		python = (CheckBox) findViewById(R.id.python);
		Button get_value_button = (Button) findViewById(R.id.get_checkbox_button);
		get_value_button.setOnClickListener(get_value_button_listener);
	}

	private Button.OnClickListener get_value_button_listener = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			String result = " ";
			if (java.isChecked()) {
				result += "java ";
			}
			if (cpp.isChecked()) {
				result += "cpp ";
			}
			if (python.isChecked()) {
				result += "python ";
			}
			if ((!java.isChecked()) && (!cpp.isChecked())
					&& (!python.isChecked())) {
				result = "Nothing";
			}
			setTitle("被选择的是:"+result);
		}
	};

}
