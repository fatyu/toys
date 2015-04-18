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
			String str = downloader.downFile("http://10.79.0.10/cmsroot/ytdt/油田召开座谈会庆祝第11个中国记者节.htm");/*注意权限的问题*/
			System.out.println(str);
		}
    }
}