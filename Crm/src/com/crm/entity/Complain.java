package com.crm.entity;

/**
 * Entity Complain 关怀信息
 * 
 * @author Fatyu
 * 
 */
public class Complain {
	// 投诉的编号
	private int complainId;
	// 投诉类型
	private String complainType;
	// 投诉人
	private String complainName;

	// 投诉内容
	private String complainContent;

	// 投诉时间
	private String complainDate;

	// 投诉是否解决 //由投诉处理部门进行填写
	private String clear;
	// 解决方案的类型 【电话解决 上门服务 邮件服务】 //由投诉处理部门进行填写
	private String clearType;
	// 客户投诉满意程度 //由投诉处理部门进行填写[ 很不满意 不太满意 一般 较满意 很满意]
	private String feeling;

	public String getClear() {
		return clear;
	}

	public String getClearType() {
		return clearType;
	}

	public String getComplainContent() {
		return complainContent;
	}

	public String getComplainDate() {
		return complainDate;
	}

	public int getComplainId() {
		return complainId;
	}

	public String getComplainName() {
		return complainName;
	}

	public String getComplainType() {
		return complainType;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	public void setClearType(String clearType) {
		this.clearType = clearType;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public void setComplainName(String complainName) {
		this.complainName = complainName;
	}

	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

}
