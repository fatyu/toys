package com.itlamp.dao;

import com.itlamp.bean.User;

public interface UserDao {
	/**
	 * ��ѯ�û���Ϣ
	 * @param User
	 * @return User
	 */
	public User queryUser(User user);

	/**
	 * �޸��û���Ϣ
	 * @param User
	 * @return true|false
	 */
	public boolean editPassword(User user);
}
