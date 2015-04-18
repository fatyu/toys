package com.fatyu;

import com.fatyu.util.HttpDownloader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FileDownloadActivity extends Activity {
	
	private Button downFile;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        downFile = (Button) this.findViewById(R.id.downbutton);
        downFile.setOnClickListener(new DownListener());
    }
    class DownListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			HttpDownloader downloader = new HttpDownloader();
			String str = downloader.downFile("http://10.79.0.10/cmsroot/ytdt/�����ٿ���̸����ף��11���й����߽�.htm");/*ע��Ȩ�޵�����*/
			System.out.println(str);
		}
    }
}