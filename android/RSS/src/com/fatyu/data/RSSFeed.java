package com.fatyu.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class RSSFeed {

	private String title;
	private String pubdate;
	private int itemcount;
	private List<RSSItem> itemlist;

	/**
	 * ���췽��
	 */
	public RSSFeed() {
		itemlist = new Vector<RSSItem>(0);
	}
/**
 * ���Ԫ��
 * @param item
 * @return
 */
	public int addItem(RSSItem item) {
		itemlist.add(item);
		itemcount++;
		return itemcount;
	}
	/**
	 * ���ָ��id��Ԫ�ض���
	 * @param index
	 * @return
	 */
	public RSSItem getItem(int index){
		return itemlist.get(index);
	}
	/**
	 * ������е�Item
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getAllItems() {
		return itemlist;
	}
	@SuppressWarnings("unchecked")
	public List getAllItemsForListView(){
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		int size = itemlist.size();
		for(int i=0;i<size;i++){
			HashMap<String, Object>	item = new HashMap<String, Object>();
			item.put(RSSItem.TITLE, itemlist.get(i).getTitle());
			item.put(RSSItem.PUBDATE, itemlist.get(i).getPubdate());
			data.add(item);
		}
		return data;
	}
	
	int getItemCount()
	{
		return itemcount;
	}
	// ------------------------------Setter&Getter-----------------------------------start
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	// ------------------------------Setter&Getter-----------------------------------end


}
