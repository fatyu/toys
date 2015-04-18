package com.fatyu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.Google);

		button.setOnClickListener(googlelistener);

	}

	private Button.OnClickListener googlelistener = new Button.OnClickListener() {
		public void onClick(View v) {

			Uri uri = Uri.parse("http://www.javaeye.com");
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);
			startActivity(intent);
		}
	};
}