package com.fatyu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerViewActivity extends Activity {

	Spinner spinner,spinner_xml;//���ڻ�ȡview�������б�����
	List<String> langs = null;//�洢�����б�Ԫ��ֵ
	ArrayAdapter<String> aalangs;//����������
	//ʹ�ô��뷽ʽ�������б�����Ԫ��
	private static String[] languages = { "Java", "CPP", "Python", "Ruby",
			"Groovy" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Spinner Test");
		setContentView(R.layout.spinner);
		find_and_modify_view();
	}

	private void find_and_modify_view() {
		spinner = (Spinner) findViewById(R.id.spinner);
		langs = new ArrayList<String>();
		for (int i = 0; i < languages.length; i++) {
			langs.add(languages[i]);
		}

		aalangs = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, langs);
		aalangs
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(aalangs);//���������б���������
		//------------------------------ʹ��xml�������ݵĴ���
		
		spinner_xml = (Spinner) findViewById(R.id.spinner_xml);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.langs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_xml.setAdapter(adapter);
	}

}