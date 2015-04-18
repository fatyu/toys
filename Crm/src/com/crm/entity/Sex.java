package com.crm.entity;

/**
 * Entity Sex 性別类
 * 
 * @author Fatyu
 * 
 */
public class Sex {
	// 性别编码
	private String sexId;
	// 性别名称
	private String sexName;

	/**
	 * 性别包含属性构造方法
	 * 
	 * @param sexName
	 */
	public Sex(String sexName) {
		super();
		this.sexName = sexName;
	}

	/**
	 * 性别的默认构造方法
	 */
	public Sex() {
		super();
	}

	public String getSexId() {
		return sexId;
	}

	public void setSexId(String sexId) {
		this.sexId = sexId;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
}
