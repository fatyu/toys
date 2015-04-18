package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * 可编辑文本框
 * @author fatyu 
 *
 */
public class EditTextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("EditTextView");
		setContentView(R.layout.edittext);
		find_and_modify_text_view();
	}

 
	private void find_and_modify_text_view() {
		Button get_edit_view_button = (Button) findViewById(R.id.get_value_button);
		get_edit_view_button.setOnClickListener(get_view_value_listener);
	}
	
	private Button.OnClickListener get_view_value_listener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			EditText et = (EditText) findViewById(R.id.edittext_view);
			setTitle("您输入的是:"+et.getText());
		}
		
	};

}
