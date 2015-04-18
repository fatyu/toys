package com.itlamp.dao;

import com.itlamp.bean.User;

public interface UserDao {
	/**
	 * 查询用户信息
	 * @param User
	 * @return User
	 */
	public User queryUser(User user);

	/**
	 * 修改用户信息
	 * @param User
	 * @return true|false
	 */
	public boolean editPassword(User user);
}
