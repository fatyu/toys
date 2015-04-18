package com.fatyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * ����ͼ����java��
 * 
 * @author Fatyu
 * 
 */
public class ActivityMain extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);// ����main��xml������ͼ�Ĵ���
		find_and_modify_button();
	}

	private void find_and_modify_button() {
		// ��������ͼ(������)��ť
		Button process_view_button = (Button) findViewById(R.id.process_button);
		process_view_button.setOnClickListener(process_view_button_listener);

		// ��������ͼ(������)��ť
		Button seek_bar_view_button = (Button) findViewById(R.id.seek_bar_view_button);
		seek_bar_view_button.setOnClickListener(seek_bar_view_button_listener);

		// ��������ͼ(������)��ť
		Button rate_bar_view_button = (Button) findViewById(R.id.rate_bar_view_button);
		rate_bar_view_button.setOnClickListener(rate_bar_view_button_listener);

		// ��������ͼ(ͼƬǽ)��ť
		Button image_bar_view_button = (Button) findViewById(R.id.image_bar_view_button);
		image_bar_view_button.setOnClickListener(image_bar_view_button_listener);

	}

	private Button.OnClickListener process_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, ProcessBarActivity.class);
			startActivity(intent);
		}
	};
	private Button.OnClickListener seek_bar_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, SeekBarActivity.class);
			startActivity(intent);
		}
	};
	private Button.OnClickListener rate_bar_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, RateBarActivity.class);
			startActivity(intent);
		}
	};
	private Button.OnClickListener image_bar_view_button_listener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityMain.this, ImageBarActivity.class);
			startActivity(intent);
		}
	};

}