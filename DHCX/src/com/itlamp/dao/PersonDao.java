package com.itlamp.dao;

import java.util.List;

import com.itlamp.bean.Person;

public interface PersonDao {

	@SuppressWarnings("unchecked")
	/**
	 * ��ѯ��Ϣ
	 * @param String sql
	 * @return List
	 */
	public List queryPerson(String sql);

	/**
	 * �����Ϣ
	 * @param String sql
	 */
	public void addPerson(Person person);

	/**
	 * ɾ����Ϣ
	 * @param String sql
	 */
	public void deletePerson(String sql);

	/**
	 * �޸���Ϣ
	 * @param String sql
	 * @return int ������� >0
	 */
	public int updatePerson(String sql);
	
	@SuppressWarnings("unchecked")
	public List queryCompany(String sql);
}
