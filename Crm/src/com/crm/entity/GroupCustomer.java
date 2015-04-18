package com.crm.entity;

import java.util.Set;

/**
 * Entity GroupCustomer 集团用户类
 * 
 * @author Fatyu
 * 
 */
public class GroupCustomer {

	// 集团编号
	private int groupCustomerId;
	// 集团名称
	private String groupCustomerName;
	// 集团法人身份证
	private String groupCustomerCardNum;
	// 集团地址
	private String groupCustomerAddress;
	// 集团邮编
	private String groupCustomerPostNum;
	// 集团类型
	private String groupCustomerType;
	// 集团联系电话
	private String groupCustomerPhoneNum;
	// 集团关怀信息
	private Set<CareInfo> careInfos;

	//集团邮箱
	private String groupCustomerEmail;
	
	public String getGroupCustomerEmail() {
		return groupCustomerEmail;
	}

	public void setGroupCustomerEmail(String groupCustomerEmail) {
		this.groupCustomerEmail = groupCustomerEmail;
	}

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * 默认构造方法
	 */
	public GroupCustomer() {
		super();
	}

	public int getGroupCustomerId() {
		return groupCustomerId;
	}

	public void setGroupCustomerId(int groupCustomerId) {
		this.groupCustomerId = groupCustomerId;
	}

	public String getGroupCustomerName() {
		return groupCustomerName;
	}

	public void setGroupCustomerName(String groupCustomerName) {
		this.groupCustomerName = groupCustomerName;
	}

	public String getGroupCustomerCardNum() {
		return groupCustomerCardNum;
	}

	public void setGroupCustomerCardNum(String groupCustomerCardNum) {
		this.groupCustomerCardNum = groupCustomerCardNum;
	}

	public String getGroupCustomerAddress() {
		return groupCustomerAddress;
	}

	public void setGroupCustomerAddress(String groupCustomerAddress) {
		this.groupCustomerAddress = groupCustomerAddress;
	}

	public String getGroupCustomerPostNum() {
		return groupCustomerPostNum;
	}

	public void setGroupCustomerPostNum(String groupCustomerPostNum) {
		this.groupCustomerPostNum = groupCustomerPostNum;
	}

	public String getGroupCustomerType() {
		return groupCustomerType;
	}

	public void setGroupCustomerType(String groupCustomerType) {
		this.groupCustomerType = groupCustomerType;
	}

	public String getGroupCustomerPhoneNum() {
		return groupCustomerPhoneNum;
	}

	public void setGroupCustomerPhoneNum(String groupCustomerPhoneNum) {
		this.groupCustomerPhoneNum = groupCustomerPhoneNum;
	}

	public Set<CareInfo> getCareInfos() {
		return careInfos;
	}

	public void setCareInfos(Set<CareInfo> careInfos) {
		this.careInfos = careInfos;
	}

}
