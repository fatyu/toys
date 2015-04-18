package com.fatyu.data;

public class RSSItem {

	public static final String TITLE = "title";
	public static final String PUBDATE = "pubdate";
	
	private String title;
	private String pubdate;
	private String link;
	private String category;
	private String description;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String  toString(){
		if(title.length()>20){
			return title.substring(0, 42)+"......";
		}
		return title;
		
	}
	

}
