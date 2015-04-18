package com.crm.service;

import java.util.List;

import com.crm.entity.PersonCustomer;

public interface IPersonCustomerService {

	public List<PersonCustomer> list();

	public void delete(Integer... ids);

	public void update(PersonCustomer personCustomer);

	public PersonCustomer findById(int id);

	public void add(PersonCustomer personCustomer);

}
