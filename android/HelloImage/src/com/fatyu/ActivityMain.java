package com.fatyu;

import android.app.Activity;
import android.os.Bundle;

public class ActivityMain extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        ImageView iv = new ImageView(this);
//        iv.setImageResource(R.drawable.helloworld);
//        setContentView(iv);
    }
}