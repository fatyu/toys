package com.fatyu.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.fatyu.R;
import com.fatyu.model.Mp3Bean;
import com.fatyu.util.FileUtils;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * 主页面-->本地mp3列表
 * 
 * @author Fatyu
 * 
 */
public class LocalMp3ListActivity extends ListActivity {
	private List<Mp3Bean> mp3Beans = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.local_mp3_list);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void onResume() {
		FileUtils fileUtils = new FileUtils();
		mp3Beans = fileUtils.getMp3Files("mp3"+File.separator);
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Iterator iterator = mp3Beans.iterator(); iterator.hasNext();) {
			Mp3Bean mp3Bean = (Mp3Bean) iterator.next();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("mp3.name", mp3Bean.getMp3Name());
			map.put("mp3.size", mp3Bean.getMp3Size());
			list.add(map);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,
				R.layout.mp3info, new String[] { "mp3.name", "mp3.size" },
				new int[] { R.id.mp3_name, R.id.mp3_size });
		setListAdapter(simpleAdapter);
		super.onResume();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		if (mp3Beans != null) {
			Mp3Bean mp3Bean = mp3Beans.get(position);
			Intent intent = new Intent();
			intent.putExtra("mp3Bean", mp3Bean);
			intent.setClass(this,PlayActivity.class);
			startActivity(intent);
		}
	}

}
