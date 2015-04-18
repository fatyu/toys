package com.fatyu.activity;

import com.fatyu.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * ��ҳ��
 * @author Fatyu
 */
public class MainActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//�����б�
		Intent local = new Intent();
		local.setClass(this, LocalMp3ListActivity.class);
		//�������б�
		Intent remote = new Intent();
		remote.setClass(this, Mp3PlayerActivity.class);
		//���tabҳ����
		TabHost tabhost = getTabHost();
		//��ȡϵͳ����Դ
		Resources res = getResources();
		//��ӱ���mp3listActivity
		TabHost.TabSpec localTabSpec = tabhost.newTabSpec("Local Mp3");
		localTabSpec.setContent(local);
		localTabSpec.setIndicator("Local Mp3", res.getDrawable(android.R.drawable.star_big_on));
		tabhost.addTab(localTabSpec);
		//��ӷ�����mp3listActivity
		TabHost.TabSpec remoteTabSpec = tabhost.newTabSpec("Remote Mp3");
		remoteTabSpec.setContent(remote);
		remoteTabSpec.setIndicator("Remote Mp3", res.getDrawable(android.R.drawable.star_big_off));
		tabhost.addTab(remoteTabSpec);
	}
}
