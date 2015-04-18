package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 主要用于异步消息处理交互的使用
 * Handler不是新创建一个线程,而是抢占主线程在主线程上执行.
 * @author Administrator
 *
 */
public class HandlerActivity extends Activity {

	private Button startbutton = null;

	private Button endbutton = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		startbutton = (Button) this.findViewById(R.id.startbutton);
		endbutton = (Button) this.findViewById(R.id.endbutton);
		// 为按钮控件添加监听器
		startbutton.setOnClickListener(new StartButtonListener());
		endbutton.setOnClickListener(new EndButtonListener());

	}

	class StartButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			handler.post(thread);
		}
	}

	class EndButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			handler.removeCallbacks(thread);
		}
	}
	
	
	Handler handler = new Handler(){
		
		
	};
	
	Runnable thread = new Runnable(){

		@Override
		public void run() {
			System.out.println("Handler invoked methods...");
			handler.postDelayed(thread, 3000);//将当前线程添加到线程队列中,延迟3秒执行
		}
	};
}















