package com.crm.service;

import java.util.List;

import com.crm.entity.Role;

public interface IRoleService {

	public List<Role> list();

	public Role findById(int id);

}
