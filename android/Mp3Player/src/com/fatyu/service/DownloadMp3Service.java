package com.fatyu.service;

import com.fatyu.model.Mp3Bean;
import com.fatyu.util.HttpDownloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * 下载mp3文件服务, 使用多线程进行文件下载
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

	// 服务启动调用的方法
	@Override
	public void onStart(Intent intent, int startId) {
		Mp3Bean mp3 = (Mp3Bean) intent.getSerializableExtra("mp3bean");
		Log.i(TAG, mp3.toString());
		DownloadThread downloadThread = new DownloadThread(mp3);
		Thread thread = new Thread(downloadThread);//创建线程
		thread.start();//启动新线程
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
			//调用文件下载api进行mp3文件下载
			HttpDownloader hd = new HttpDownloader();
			int result = hd.downFile(uri, "mp3", mp3.getMp3Name());
			if(result==-1){//下载失败
				Log.i(TAG, " 下载失败");
			}else if(result==0){//下载成功
				Log.i(TAG, " 下载成功");
			}else{//文件已经存在
				Log.i(TAG, " 文件已经存在");
			}
		}
	}
}
