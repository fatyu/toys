package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Nation;
import com.crm.service.INationService;

/**
 * 对表Nation的操作服务
 * 
 * @author Fatyu
 * 
 */

@Service
@Transactional
public class NationService implements INationService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 通过ID获得Nation
	 * 
	 * @return Nation
	 * @param int id
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Nation findById(String id) {
		return (Nation) sessionFactory.getCurrentSession()
				.get(Nation.class, id);
	}

	/**
	 * 获得所有Nation
	 * 
	 * @return List<Nation>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Nation> list() {
		return sessionFactory.getCurrentSession().createQuery("from Nation")
				.list();
	}

	/**
	 * 更新Nation信息
	 * 
	 * @param Nation
	 *            nation
	 */
	public void update(Nation nation) {
		sessionFactory.getCurrentSession().merge(nation);

	}

}
