package com.crm.service;

import java.util.List;

import com.crm.entity.CustomerType;

public interface ICustomerTypeService {

	public List<CustomerType> list();

	public void update(CustomerType customerType);

	public CustomerType findById(String typeId);

	public void add(CustomerType customerType);

}
