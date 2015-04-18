package com.fatyu.activity;

import java.io.File;

import com.fatyu.R;
import com.fatyu.model.Mp3Bean;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * ����activity
 * 
 * @author fatyu
 * 
 */
public class PlayActivity extends Activity {
	private Mp3Bean mp3 = null;// mp3����

	private ImageButton begin;// ��ʼ��ť
	private ImageButton pause;// ��ͣ��ť
	private ImageButton stop;// ֹͣ��ť

	private boolean isplaying = false;// ������ڲ���
	private boolean ispause = false;// �����ͣ
	private boolean isstop = false;// �����ͣ

	private MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);
		Intent intent = getIntent();
		mp3 = (Mp3Bean) intent.getSerializableExtra("mp3Bean");
		begin = (ImageButton) findViewById(R.id.begin);
		begin.setOnClickListener(new BeginButtonListener());
		pause = (ImageButton) findViewById(R.id.pause);
		pause.setOnClickListener(new PauseButtonListener());
		stop = (ImageButton) findViewById(R.id.stop);
		stop.setOnClickListener(new StopButtonListener());

	}

	/**
	 * ��ʼ��ť
	 */
	class BeginButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (mp3.getMp3Name().endsWith("mp3")) {
				if (!isplaying) {
					String path = PlayActivity.this.getPath();
					mp = MediaPlayer.create(PlayActivity.this,
							Uri.parse("file://" + path));
					mp.setLooping(false);
					mp.start();
					isplaying = true;
				}
			} else {
				Toast.makeText(PlayActivity.this, "�ļ�������", 1).show();
			}
		}
	}
	
	/**
	 * ��ͣ��ť
	 */
	class PauseButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (mp3.getMp3Name().endsWith("mp3")&&mp!=null) {
				if (isplaying&&!ispause&&!isstop) {
					mp.pause();
					ispause = true;
					isplaying = false;
				}else if(ispause){
					mp.start();
				}
			} else {
				Toast.makeText(PlayActivity.this, "�޷���ͣ", 1).show();
			}
		}
	}
	
	/**
	 * ֹͣ��ť
	 */
	class StopButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (mp3.getMp3Name().endsWith("mp3")&&mp!=null) {
				mp.stop();
				mp.release();
				isplaying=false;
				ispause=false;
				isstop=true;
		} else {
			Toast.makeText(PlayActivity.this, "�޷�ֹͣ����", 1).show();
		}	
		}
		
	}
	/**
	 * ����ļ�����·��
	 * 
	 * @return
	 */
	private String getPath() {
		return Environment.getExternalStorageDirectory().getAbsolutePath()
				+ File.separator + "mp3" + File.separator + mp3.getMp3Name();
	}
}