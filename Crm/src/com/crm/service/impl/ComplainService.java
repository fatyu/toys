package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Complain;
import com.crm.service.IComplainService;

/**
 * 提供 Complain对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class ComplainService implements IComplainService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 更新客户投诉信息
	 * 
	 * @param Complain
	 */
	public void update(Complain complain) {
		sessionFactory.getCurrentSession().merge(complain);

	}

	/**
	 * 添加客户投诉
	 * 
	 * @param Complain
	 */
	public void add(Complain complain) {
		sessionFactory.getCurrentSession().save(complain);

	}

	/**
	 * 删除指定id的客户投诉
	 * 
	 * @param Integer
	 *            ...
	 */
	public void delete(Integer... ids) {
		for (int id : ids) {
			this.sessionFactory.getCurrentSession().delete(
					sessionFactory.getCurrentSession().get(Complain.class, id));
		}
	}

	/**
	 * 查找指定id的客户投诉
	 * 
	 * @param Integer
	 * @return PersonCustomer
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Complain findById(int id) {
		return (Complain) this.sessionFactory.getCurrentSession().get(
				Complain.class, id);
	}

	/**
	 * 查找所有的客户投诉
	 * 
	 * @return List<Complain>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Complain> list() {
		return (List<Complain>) sessionFactory.getCurrentSession().createQuery(
				"from Complain").list();
	}

}
