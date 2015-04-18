package com.fatyu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDownloader {

	private URL url = null;
	public String downFile(String file){
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		String line = null;
		try {
			url = new URL(file);
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			br =new BufferedReader(new InputStreamReader(huc.getInputStream())) ;
			while((line=br.readLine())!=null){
				System.out.println(line);
				sb.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
