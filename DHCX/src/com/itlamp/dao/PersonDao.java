package com.itlamp.dao;

import java.util.List;

import com.itlamp.bean.Person;

public interface PersonDao {

	@SuppressWarnings("unchecked")
	/**
	 * 查询信息
	 * @param String sql
	 * @return List
	 */
	public List queryPerson(String sql);

	/**
	 * 添加信息
	 * @param String sql
	 */
	public void addPerson(Person person);

	/**
	 * 删除信息
	 * @param String sql
	 */
	public void deletePerson(String sql);

	/**
	 * 修改信息
	 * @param String sql
	 * @return int 操作结果 >0
	 */
	public int updatePerson(String sql);
	
	@SuppressWarnings("unchecked")
	public List queryCompany(String sql);
}
