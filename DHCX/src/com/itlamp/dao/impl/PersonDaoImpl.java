package com.itlamp.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.itlamp.bean.Person;
import com.itlamp.dao.PersonDao;
import com.itlamp.util.JdbcUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Person访问数据库实现类
 * 
 * @author Fatyu
 * 
 */
public class PersonDaoImpl implements PersonDao {

	@SuppressWarnings("unchecked")
	/**
	 * 查询信息
	 * @param String sql
	 * @return List<Person>
	 */
	public List queryPerson(String sql) {
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		Person person = null;
		List<Person> plist = new ArrayList<Person>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();// 执行查询语句
			while (rs.next()) {
				person = new Person();
				person.setId(rs.getString("id"));
				person.setName(rs.getString("name"));
				person.setAddress(rs.getString("address"));
				person.setCompany(rs.getString("company"));
				person.setHomeNumber(rs.getString("homenumber"));
				person.setOfficeNumber(rs.getString("officenumber"));
				person.setPhoneNumber(rs.getString("phonenumber"));
				person.setTitle(rs.getString("title"));
				person.setUsername(rs.getString("username"));
				person.setDepartment(rs.getString("department"));
				plist.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}
		return plist;

	}

	/**
	 * 添加用户
	 * 
	 * @param Person
	 */
	public void addPerson(Person person) {
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		try {

			ps = (PreparedStatement) conn
					.prepareStatement("insert into dhcx_ryxx (id,name,title,company,address,officeNumber,homeNumber,phoneNumber,username,department) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, UUID.randomUUID().toString().replaceAll("-", ""));// 设置sql的第一个字段
			ps.setString(2, person.getName());
			ps.setString(3, person.getTitle());
			ps.setString(4, person.getCompany());
			ps.setString(5, person.getAddress());
			ps.setString(6, person.getOfficeNumber());
			ps.setString(7, person.getHomeNumber());
			ps.setString(8, person.getPhoneNumber());
			ps.setString(9, person.getUsername());
			ps.setString(10, person.getDepartment());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}

	}

	/**
	 * 刪除个人信息
	 * 
	 * @param String
	 *            sql
	 */
	public void deletePerson(String sql) {
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		try {

			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}
	}

	/**
	 * 更新个人信息
	 * 
	 * @param String
	 *            sql
	 * @return int result
	 */
	public int updatePerson(String sql) {
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		int result = 0;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}
		return result;
	}
	
	//查询工作单位
	@SuppressWarnings("unchecked")
	public List queryCompany(String sql){
		Connection conn = (Connection) JdbcUtil.getConnection();// 获得数据库连接
		PreparedStatement ps = null;// 声明查询对象
		ResultSet rs = null;// 声明结果集
		List<String> clist = new ArrayList<String>();
		clist.add("查询全部");
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();// 执行查询语句
			while (rs.next()) {
				clist.add(rs.getString("company"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// 关闭结果集连接
			JdbcUtil.relase(ps);// 关闭查询对象连接
			JdbcUtil.relase(conn);// 关闭数据库连接
		}
		return clist;
		
	}
}
