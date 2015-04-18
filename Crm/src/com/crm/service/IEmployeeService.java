package com.crm.service;

import java.util.List;

import com.crm.entity.Employee;

public interface IEmployeeService {

	public List<Employee> list();

	public void delete(Integer... ids);

	public void update(Employee employee);

	public Employee findById(int id);

	public void add(Employee employee);

}
