package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.GroupCustomer;
import com.crm.service.IGroupCustomerService;

/**
 * 提供GroupCustomer对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class GroupCustomerService implements IGroupCustomerService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 更新集团客户信息
	 * 
	 * @param GroupCustomer
	 */
	public void update(GroupCustomer groupCustomer) {
		sessionFactory.getCurrentSession().merge(groupCustomer);

	}

	/**
	 * 添加集团客户信息
	 * 
	 * @param GroupCustomer
	 */
	public void add(GroupCustomer groupCustomer) {
		sessionFactory.getCurrentSession().save(groupCustomer);

	}

	/**
	 * 删除指定id的集团客户
	 * 
	 * @param Integer
	 *            ...
	 */
	public void delete(Integer... ids) {
		for (int id : ids) {
			this.sessionFactory.getCurrentSession().delete(
					sessionFactory.getCurrentSession().get(GroupCustomer.class,
							id));
		}
	}

	/**
	 * 查找指定id的集团客户信息
	 * 
	 * @param Integer
	 * @return GroupCustomer
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public GroupCustomer findById(int id) {
		return (GroupCustomer) this.sessionFactory.getCurrentSession().get(
				GroupCustomer.class, new Integer(id));
	}

	/**
	 * 查找所有的集团客户信息
	 * 
	 * @return List<GroupCustomer>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<GroupCustomer> list() {
		return (List<GroupCustomer>) sessionFactory.getCurrentSession()
				.createQuery("from GroupCustomer").list();
	}

}
