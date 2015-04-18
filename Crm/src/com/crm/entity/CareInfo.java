package com.crm.entity;

import java.util.Set;

/**
 * Entity CareInfo 关怀信息
 * 
 * @author Fatyu
 * 
 */
public class CareInfo {
	// 关怀信息编号
	private int infoId;
	// 信息标题
	private String infoTitle;
	// 信息类型
	private String infoType;
	// 信息发送日期
	private String infoDate;
	// 信息内容
	private String infoDetail;
	// 发送者
	private Employee employee;
	// 个体接收者
	private Set<PersonCustomer> personCustomers;
	// 集团接收者
	private Set<GroupCustomer> groupCustomers;

	/**
	 * 默认构造方法
	 */
	public CareInfo() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public String getInfoDate() {
		return infoDate;
	}

	public String getInfoDetail() {
		return infoDetail;
	}

	public int getInfoId() {
		return infoId;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setInfoDate(String infoDate) {
		this.infoDate = infoDate;
	}

	public void setInfoDetail(String infoDetail) {
		this.infoDetail = infoDetail;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public Set<PersonCustomer> getPersonCustomers() {
		return personCustomers;
	}

	public void setPersonCustomers(Set<PersonCustomer> personCustomers) {
		this.personCustomers = personCustomers;
	}

	public Set<GroupCustomer> getGroupCustomers() {
		return groupCustomers;
	}

	public void setGroupCustomers(Set<GroupCustomer> groupCustomers) {
		this.groupCustomers = groupCustomers;
	}

}
