package com.crm.entity;

/**
 * Entity Nation 民族类
 * 
 * @author fatyu
 * 
 */
public class Nation {
	// 民族编号
	private String nationId;
	// 民族名称
	private String nationName;

	// 默认构造方法
	public Nation() {
		super();
	}

	/**
	 * 含有属性的构造方法
	 * 
	 * @param nationString
	 */
	public Nation(String nationName) {
		this.nationName = nationName;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

}
