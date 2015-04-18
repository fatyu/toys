package com.crm.entity;

import java.util.Set;

/**
 * Entity PersonCustomer 个人客户
 * 
 * @author Fatyu
 * 
 */
public class PersonCustomer {
	// 关怀信息
	private Set<CareInfo> careInfos;
	// 客户地址
	private String personCustomerAddress;
	// 客户年龄
	private int personCustomerAge;
	// 客户身份证号
	private String personCustomerCardNum;
	// 客户的教育情况
	private String personCustomerEdu;
	// 客户爱好
	private String personCustomerHobby;
	// 客户编号
	private int personCustomerId;
	// 客户职位
	private String personCustomerJobTitle;
	// 客户工作类型
	private String personCustomerJobType;
	// 客户级别
	private String personCustomerLeavle;
	// 客户名称
	private String personCustomerName;
	// 客户联系电话
	private String personCustomerPhoneNum;
	// 客户邮政编码
	private String personCustomerPostCode;
	// 客户性别
	private String personCustomerSex;
	// 客户民族
	private String personCustomerNation;
	//客户邮箱
	private String personCustomerEmail;
	public String getPersonCustomerEmail() {
		return personCustomerEmail;
	}

	public void setPersonCustomerEmail(String personCustomerEmail) {
		this.personCustomerEmail = personCustomerEmail;
	}

	public String getPersonCustomerSex() {
		return personCustomerSex;
	}

	public void setPersonCustomerSex(String personCustomerSex) {
		this.personCustomerSex = personCustomerSex;
	}

	public String getPersonCustomerNation() {
		return personCustomerNation;
	}

	public void setPersonCustomerNation(String personCustomerNation) {
		this.personCustomerNation = personCustomerNation;
	}

	private Employee employee;

	/**
	 * 默认的构造方法
	 */
	public PersonCustomer() {
		super();
	}

	public Set<CareInfo> getCareInfos() {
		return careInfos;
	}

	public void setCareInfos(Set<CareInfo> careInfos) {
		this.careInfos = careInfos;
	}

	public String getPersonCustomerAddress() {
		return personCustomerAddress;
	}

	public void setPersonCustomerAddress(String personCustomerAddress) {
		this.personCustomerAddress = personCustomerAddress;
	}

	public int getPersonCustomerAge() {
		return personCustomerAge;
	}

	public void setPersonCustomerAge(int personCustomerAge) {
		this.personCustomerAge = personCustomerAge;
	}

	public String getPersonCustomerCardNum() {
		return personCustomerCardNum;
	}

	public void setPersonCustomerCardNum(String personCustomerCardNum) {
		this.personCustomerCardNum = personCustomerCardNum;
	}

	public String getPersonCustomerEdu() {
		return personCustomerEdu;
	}

	public void setPersonCustomerEdu(String personCustomerEdu) {
		this.personCustomerEdu = personCustomerEdu;
	}

	public String getPersonCustomerHobby() {
		return personCustomerHobby;
	}

	public void setPersonCustomerHobby(String personCustomerHobby) {
		this.personCustomerHobby = personCustomerHobby;
	}

	public int getPersonCustomerId() {
		return personCustomerId;
	}

	public void setPersonCustomerId(int personCustomerId) {
		this.personCustomerId = personCustomerId;
	}

	public String getPersonCustomerJobTitle() {
		return personCustomerJobTitle;
	}

	public void setPersonCustomerJobTitle(String personCustomerJobTitle) {
		this.personCustomerJobTitle = personCustomerJobTitle;
	}

	public String getPersonCustomerJobType() {
		return personCustomerJobType;
	}

	public void setPersonCustomerJobType(String personCustomerJobType) {
		this.personCustomerJobType = personCustomerJobType;
	}

	public String getPersonCustomerLeavle() {
		return personCustomerLeavle;
	}

	public void setPersonCustomerLeavle(String personCustomerLeavle) {
		this.personCustomerLeavle = personCustomerLeavle;
	}

	public String getPersonCustomerName() {
		return personCustomerName;
	}

	public void setPersonCustomerName(String personCustomerName) {
		this.personCustomerName = personCustomerName;
	}

	public String getPersonCustomerPhoneNum() {
		return personCustomerPhoneNum;
	}

	public void setPersonCustomerPhoneNum(String personCustomerPhoneNum) {
		this.personCustomerPhoneNum = personCustomerPhoneNum;
	}

	public String getPersonCustomerPostCode() {
		return personCustomerPostCode;
	}

	public void setPersonCustomerPostCode(String personCustomerPostCode) {
		this.personCustomerPostCode = personCustomerPostCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
