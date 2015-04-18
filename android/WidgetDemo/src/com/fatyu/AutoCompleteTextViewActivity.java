package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextViewActivity extends Activity {
	static final String[] langs = { "java", "ruby", "python", "groovy", "cpp",
			"jython" ,"jgroovy","jruby","javaeye","c#","php"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("autoCompleteTextView");
		setContentView(R.layout.autocomplete);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, langs);
		AutoCompleteTextView actx = (AutoCompleteTextView) findViewById(R.id.complete);
		actx.setAdapter(adapter);
	}

}
