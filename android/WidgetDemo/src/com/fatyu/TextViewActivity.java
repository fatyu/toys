package com.fatyu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * ���ɱ༭�ı���
 * @author Fatyu
 *
 */
public class TextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("TextView");//���ñ���
		setContentView(R.layout.text);//������ͼ����ʽ
		find_and_modify_text_view();//�����޸ķ���
	}

	//�ں�̨�����ı���ͼ��ֵ
	private void find_and_modify_text_view() {
		TextView tv = (TextView) findViewById(R.id.text_view);
		CharSequence old = tv.getText();
		tv.setText(old+"\n"+"�޸ĺ���ı�Ϊ:���������½�����");
	}

}
