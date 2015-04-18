package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Sex;
import com.crm.service.ISexService;

/**
 * 对Sex表进行管理的服务
 * 
 * @author Fatyu
 * 
 */

@Service
@Transactional
public class SexService implements ISexService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 查找指定ID性别信息
	 * 
	 * @param int id
	 * @return Sex
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Sex findById(String id) {

		return (Sex) sessionFactory.getCurrentSession().get(Sex.class, id);
	}

	/**
	 * 列出所有的性别信息
	 * 
	 * @return List<Sex>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Sex> list() {
		return sessionFactory.getCurrentSession().createQuery("from Sex")
				.list();
	}

	/**
	 * 更新sex表中的数据
	 * 
	 * @param Sex
	 */
	public void update(Sex sex) {
		sessionFactory.getCurrentSession().merge(sex);

	}

}
