package com.fatyu.handler;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fatyu.model.Mp3Bean;

/**
 * 解析xml字符串.转换为mp3bean对象
 * 
 * @author Administrator
 * 
 */
public class XMLHandler extends DefaultHandler {

	public XMLHandler() {
		super();
	}

	public XMLHandler(List<Mp3Bean> mp3s) {
		this.mp3s = mp3s;
	}

	private List<Mp3Bean> mp3s = null;
	private Mp3Bean mp3 = null;

	public Mp3Bean getMp3() {
		return mp3;
	}

	public void setMp3(Mp3Bean mp3) {
		this.mp3 = mp3;
	}

	private String tagName = "";

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str = new String(ch, start, length);
		super.characters(ch, start, length);
		if (tagName.equals("id")) {
			mp3.setId(str);
		} else if (tagName.equals("mp3.name")) {
			mp3.setMp3Name(str);
		} else if (tagName.equals("mp3.size")) {
			mp3.setMp3Size(str);
		} else if (tagName.equals("lrc.name")) {
			mp3.setLrcName(str);
		} else if (tagName.equals("lrc.size")) {
			mp3.setLrcSize(str);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equals("resource")) {
			mp3s.add(mp3);
		}
		tagName = "";
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		this.tagName = localName;
		super.startElement(uri, localName, qName, attributes);
		if (tagName.equals("resource")) {
			mp3 = new Mp3Bean();
		}
	}

}
