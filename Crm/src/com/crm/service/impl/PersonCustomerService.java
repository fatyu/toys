package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.PersonCustomer;
import com.crm.service.IPersonCustomerService;

/**
 * 提供 PersonCustomer对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class PersonCustomerService implements IPersonCustomerService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 更新集团个人信息
	 * 
	 * @param PersonCustomer
	 */
	public void update(PersonCustomer personCustomer) {
		sessionFactory.getCurrentSession().merge(personCustomer);

	}

	/**
	 * 添加个人客户信息
	 * 
	 * @param PersonCustomer
	 */
	public void add(PersonCustomer personCustomer) {
		sessionFactory.getCurrentSession().save(personCustomer);

	}

	/**
	 * 删除指定id的个人客户
	 * 
	 * @param Integer
	 *            ...
	 */
	public void delete(Integer... ids) {
		for (int id : ids) {
			this.sessionFactory.getCurrentSession().delete(
					sessionFactory.getCurrentSession().get(
							PersonCustomer.class, id));
		}
	}

	/**
	 * 查找指定id的个人客户信息
	 * 
	 * @param Integer
	 * @return PersonCustomer
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PersonCustomer findById(int id) {
		return (PersonCustomer) this.sessionFactory.getCurrentSession().get(
				PersonCustomer.class, id);
	}

	/**
	 * 查找所有的个人客户信息
	 * 
	 * @return List<PersonCustomer>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<PersonCustomer> list() {
		return (List<PersonCustomer>) sessionFactory.getCurrentSession()
				.createQuery("from PersonCustomer").list();
	}

}
