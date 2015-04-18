package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * 不可编辑文本框
 * @author Fatyu
 *
 */
public class TextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("TextView");//设置标题
		setContentView(R.layout.text);//设置视图的样式
		find_and_modify_text_view();//调用修改方法
	}

	//在后台进行文本视图的值
	private void find_and_modify_text_view() {
		TextView tv = (TextView) findViewById(R.id.text_view);
		CharSequence old = tv.getText();
		tv.setText(old+"\n"+"修改后的文本为:张羽不想在新疆呆了");
	}

}
