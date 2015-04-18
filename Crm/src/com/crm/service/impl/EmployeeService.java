package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Employee;
import com.crm.service.IEmployeeService;

/**
 * 提供Employee对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class EmployeeService implements IEmployeeService {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 删除指定id的雇员
	 * 
	 * @param Integer
	 */
	public void delete(Integer... ids) {
		for (int id : ids) {
			this.sessionFactory.getCurrentSession().delete(
					sessionFactory.getCurrentSession().get(Employee.class, id));
		}
	}

	/**
	 * 查找指定id的雇员
	 * 
	 * @param Integer
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Employee findById(int id) {
		return (Employee) this.sessionFactory.getCurrentSession().get(
				Employee.class, new Integer(id));
	}

	/**
	 * 查询所有的雇员信息
	 * 
	 * @return List<Employee>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Employee> list() {
		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	/**
	 * 增加雇员信息
	 * 
	 * @param Employee
	 */
	public void add(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	/**
	 * 更新雇员信息
	 * 
	 *@param Employee
	 */
	public void update(Employee employee) {
		sessionFactory.getCurrentSession().merge(employee);
	}

}
