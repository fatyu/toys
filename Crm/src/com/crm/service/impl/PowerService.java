package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Power;
import com.crm.service.IPowerService;

/**
 * 提供 Power对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class PowerService implements IPowerService {
	@Resource
	SessionFactory sessionFactory;

	/**
	 * 查找指定Id的权限
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Power findById(int id) {
		return (Power) sessionFactory.getCurrentSession().get(Power.class,
				new Integer(id));
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Power> list() {
		return sessionFactory.getCurrentSession().createQuery("from Power")
				.list();
	}

}
