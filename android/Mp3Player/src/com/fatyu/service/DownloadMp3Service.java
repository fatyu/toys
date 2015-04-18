package com.fatyu.service;

import com.fatyu.model.Mp3Bean;
import com.fatyu.util.HttpDownloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * ����mp3�ļ�����, ʹ�ö��߳̽����ļ�����
 * 
 * @author fatyu
 * 
 */
public class DownloadMp3Service extends Service {
	private final static String TAG = "DownloadMp3Service";

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	// �����������õķ���
	@Override
	public void onStart(Intent intent, int startId) {
		Mp3Bean mp3 = (Mp3Bean) intent.getSerializableExtra("mp3bean");
		Log.i(TAG, mp3.toString());
		DownloadThread downloadThread = new DownloadThread(mp3);
		Thread thread = new Thread(downloadThread);//�����߳�
		thread.start();//�������߳�
		super.onStart(intent, startId);
	}

	class DownloadThread implements Runnable {
		private Mp3Bean mp3 ;

		public DownloadThread(Mp3Bean mp3) {
			super();
			this.mp3 = mp3;
		}

		@Override
		public void run() {
			String uri = "http://10.79.76.42:8080/music/"+mp3.getMp3Name();
			System.out.println(uri);
			//�����ļ�����api����mp3�ļ�����
			HttpDownloader hd = new HttpDownloader();
			int result = hd.downFile(uri, "mp3", mp3.getMp3Name());
			if(result==-1){//����ʧ��
				Log.i(TAG, " ����ʧ��");
			}else if(result==0){//���سɹ�
				Log.i(TAG, " ���سɹ�");
			}else{//�ļ��Ѿ�����
				Log.i(TAG, " �ļ��Ѿ�����");
			}
		}
	}
}
