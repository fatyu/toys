package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class RadioActivity extends Activity  implements View.OnClickListener{
	RadioGroup radio ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		setTitle("RadioTest");
		radio = (RadioGroup)findViewById(R.id.menu);
		Button clear = (Button) findViewById(R.id.clear_button);
		clear.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		radio.clearCheck();
		
	}


}
