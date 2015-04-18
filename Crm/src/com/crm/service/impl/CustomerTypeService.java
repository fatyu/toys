package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.CustomerType;
import com.crm.service.ICustomerTypeService;

/**
 * 对表CustomerType的操作服务
 * 
 * @author Fatyu
 * 
 */

@Service
@Transactional
public class CustomerTypeService implements ICustomerTypeService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 添加CustomerType
	 * 
	 * @param CustomerType
	 */
	public void add(CustomerType customerType) {
		sessionFactory.getCurrentSession().persist(customerType);
	}

	/**
	 * 通过ID获得CustomerType
	 * 
	 * @return CustomerType
	 * @param String
	 *            id
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public CustomerType findById(String typeId) {
		return (CustomerType) sessionFactory.getCurrentSession().get(
				CustomerType.class, typeId);
	}

	/**
	 * 获得所有的客户级别
	 * 
	 * @return CustomerType
	 * @param String
	 *            id
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerType> list() {
		return sessionFactory.getCurrentSession().createQuery(
				"from CustomerType").list();
	}

	/**
	 * 更新客户级别
	 * 
	 * @param CustomerType
	 */
	public void update(CustomerType customerType) {
		sessionFactory.getCurrentSession().merge(customerType);
	}

}
