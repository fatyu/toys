package com.crm.service;

import java.util.List;

import com.crm.entity.GroupCustomer;

public interface IGroupCustomerService {
	public void add(GroupCustomer groupCustomer);

	public void delete(Integer... ids);

	public void update(GroupCustomer groupCustomer);

	public GroupCustomer findById(int id);

	public List<GroupCustomer> list();

}
