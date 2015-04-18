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
 * Person�������ݿ�ʵ����
 * 
 * @author Fatyu
 * 
 */
public class PersonDaoImpl implements PersonDao {

	@SuppressWarnings("unchecked")
	/**
	 * ��ѯ��Ϣ
	 * @param String sql
	 * @return List<Person>
	 */
	public List queryPerson(String sql) {
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
		Person person = null;
		List<Person> plist = new ArrayList<Person>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();// ִ�в�ѯ���
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
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}
		return plist;

	}

	/**
	 * ����û�
	 * 
	 * @param Person
	 */
	public void addPerson(Person person) {
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
		try {

			ps = (PreparedStatement) conn
					.prepareStatement("insert into dhcx_ryxx (id,name,title,company,address,officeNumber,homeNumber,phoneNumber,username,department) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, UUID.randomUUID().toString().replaceAll("-", ""));// ����sql�ĵ�һ���ֶ�
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
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}

	}

	/**
	 * �h��������Ϣ
	 * 
	 * @param String
	 *            sql
	 */
	public void deletePerson(String sql) {
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
		try {

			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}
	}

	/**
	 * ���¸�����Ϣ
	 * 
	 * @param String
	 *            sql
	 * @return int result
	 */
	public int updatePerson(String sql) {
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
		int result = 0;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}
		return result;
	}
	
	//��ѯ������λ
	@SuppressWarnings("unchecked")
	public List queryCompany(String sql){
		Connection conn = (Connection) JdbcUtil.getConnection();// ������ݿ�����
		PreparedStatement ps = null;// ������ѯ����
		ResultSet rs = null;// ���������
		List<String> clist = new ArrayList<String>();
		clist.add("��ѯȫ��");
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();// ִ�в�ѯ���
			while (rs.next()) {
				clist.add(rs.getString("company"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.relase(rs);// �رս��������
			JdbcUtil.relase(ps);// �رղ�ѯ��������
			JdbcUtil.relase(conn);// �ر����ݿ�����
		}
		return clist;
		
	}
}
