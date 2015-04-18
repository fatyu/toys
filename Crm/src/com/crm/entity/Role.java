package com.crm.entity;

import java.util.Set;

/**
 * Entity Role 角色类
 * 
 * @author Fatyu
 * 
 */
public class Role {
	// 角色的编号
	private int roleId;
	// 角色名称
	private String roleName;
	// 角色的关联用户
	private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	// 角色的权限
	private Set<Power> powers;

	/**
	 * 角色的默认构造方法
	 */
	public Role() {
		super();
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Power> getPowers() {
		return powers;
	}

	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}

}
