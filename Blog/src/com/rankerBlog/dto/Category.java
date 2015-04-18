package com.rankerBlog.dto;

/**
 * entity DTO Category
 * @author ranker
 */
public class Category {
	private int id;//类别编号
	private int level;//类别的现实级别
	private String name;//类别的名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
