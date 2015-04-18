package com.crm.entity;

import java.util.Set;

/**
 * Entity Employee
 * 
 * @author fatyu
 * 
 */

public class Employee {

	// 雇员ID
	private int employeeId;
	// 雇员名称
	private String employeeName;
	// 雇员密码
	private String employeePassword;
	// 雇员性别
	private String employeeSex;
	// 雇员民族
	private String employeeNation;
	// 雇员年龄
	private int employeeAge;
	// 雇员住址
	private String employeeAddress;
	// 雇员工资
	private int employeeSalary;
	// 雇员发布的关怀信息
	private Set<CareInfo> careInfos;
	// 雇员的角色
	private Set<Role> roles;
	// 雇员的集团客户
	private Set<GroupCustomer> groupCustomers;
	// 雇员的个人客户
	private Set<PersonCustomer> personCustomers;

	private String roleId;
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}

	public String getEmployeeNation() {
		return employeeNation;
	}

	public void setEmployeeNation(String employeeNation) {
		this.employeeNation = employeeNation;
	}

	/**
	 * 默认构造方法 用于spring进行依赖注入
	 */
	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Set<CareInfo> getCareInfos() {
		return careInfos;
	}

	public void setCareInfos(Set<CareInfo> careInfos) {
		this.careInfos = careInfos;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<GroupCustomer> getGroupCustomers() {
		return groupCustomers;
	}

	public void setGroupCustomers(Set<GroupCustomer> groupCustomers) {
		this.groupCustomers = groupCustomers;
	}

	public Set<PersonCustomer> getPersonCustomers() {
		return personCustomers;
	}

	public void setPersonCustomers(Set<PersonCustomer> personCustomers) {
		this.personCustomers = personCustomers;
	}

}
