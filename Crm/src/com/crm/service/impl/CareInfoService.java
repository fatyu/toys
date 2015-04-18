package com.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.CareInfo;
import com.crm.service.ICareInfoService;

/**
 * 提供CareInfo对象数据库操作服务
 * 
 * @author Fatyu
 * 
 */
@Service
@Transactional
public class CareInfoService implements ICareInfoService {

	@Resource
	SessionFactory sessionFactory;

	/**
	 * 增加关怀信息
	 * 
	 * @param CareInfo
	 */
	public void add(CareInfo careInfo) {
		sessionFactory.getCurrentSession().save(careInfo);
	}

	/**
	 * 删除指定id的关怀信息
	 * 
	 * @param Integer
	 */
	public void delete(Integer... ids) {
		for (int id : ids) {
			this.sessionFactory.getCurrentSession().delete(
					sessionFactory.getCurrentSession().get(CareInfo.class, id));
		}
	}

	/**
	 * 查找指定id的关怀信息
	 * 
	 * @param Integer
	 */
	public CareInfo findById(int id) {
		return (CareInfo) this.sessionFactory.getCurrentSession().get(
				CareInfo.class, new Integer(id));
	}

	/**
	 * 查询所有的雇员信息
	 * 
	 * @return List<CareInfo>
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CareInfo> list() {
		return sessionFactory.getCurrentSession().createQuery("from CareInfo")
				.list();
	}

}
