package com.rankerBlog.dto;

import java.sql.Date;

/**
 * entity DTO Blog
 * 
 * @author ranker
 * 
 */
public class Blog {
	private int id;//博文编号
	private String title;//博文标题
	private String content;//博文内容
	private int catalog;//博文类别
	private Date createdtime;//博文创建时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCatalog() {
		return catalog;
	}

	public void setCatalog(int catalog) {
		this.catalog = catalog;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

}
