package com.crm.entity;

import java.util.Set;

/**
 * Entity Power 权限类
 * 
 * @author Fatyu
 * 
 */
public class Power {
	// 权限编号
	private int powerId;
	// 权限名称
	private String powerName;
	// 关联的角色
	private Set<Role> roles;

	/**
	 * 角色的默认构造方法
	 */
	public Power() {
		super();
	}

	public int getPowerId() {
		return powerId;
	}

	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
