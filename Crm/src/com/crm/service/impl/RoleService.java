package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Role;
import com.crm.service.IRoleService;

/**
 * 提供Role对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class RoleService implements IRoleService {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 查找指定Id的角色
	 * 
	 * @param Integer
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Role findById(int id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class,
				new Integer(id));
	}

	/**
	 * 查找所有的角色
	 * 
	 * @return List<Role>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Role> list() {
		return sessionFactory.getCurrentSession().createQuery("from Role")
				.list();
	}

}
