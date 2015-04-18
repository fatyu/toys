package com.crm.action;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.crm.entity.Employee;
import com.crm.entity.Power;
import com.crm.entity.Role;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 进行权限判断
 * 
 * @author Fatyu
 * 
 */
@Controller
public class CrmAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	// 获得session对象
	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	/**
	 * 集团顾客查询
	 */
	public String listGroup() throws Exception {
		return validate("listGroup", "groupsuccess", "failed");
	}

	/**
	 * 个人顾客查询
	 */
	public String listPerson() throws Exception {
		return validate("listPerson", "personsuccess", "failed");
	}

	/**
	 * 关怀客户
	 */
	public String careCustomer() throws Exception {
		return validate("careCustomer", "carecustomersuccess", "failed");
	}

	/**
	 * 信息管理
	 */
	public String infoManage() throws Exception {
		return validate("infoManage", "infosuccess", "failed");
	}

	/**
	 * 雇员管理
	 */
	public String emplManage() throws Exception {
		return validate("emplManage", "emplsuccess", "failed");
	}

	/**
	 * 数据字典管理
	 */
	public String data() throws Exception {
		return validate("data", "datasuccess", "failed");
	}

	/**
	 * 公司介绍
	 */
	public String company() throws Exception {
		return validate("company", "companysuccess", "failed");
	}

	/**
	 * 添加客户投诉
	 */
	public String addComplain() throws Exception {
		return validate("addComplain", "preaddComplainsuccess", "failed");
	}

	/**
	 * 添加客户投诉
	 */
	public String updateComplain() throws Exception {
		return validate("updateComplain", "preupdateComplainsuccess", "failed");
	}
	
	/**
	 *备份客户数据
	 */
	public String backup() throws Exception {
		return validate("backup", "backupsuccess", "failed");
	}
	
	/**
	 * 导入客户数据
	 */
	public String importdata() throws Exception {
		return validate("importdata", "importdatasuccess", "failed");
	}
	
	/**
	 * 客户图表
	 */
	public String createChart() throws Exception {
		return validate("createChart", "createchartsuccess", "failed");
	}

	/**
	 * 验证权限
	 * 
	 * @param methodName
	 * @param success
	 * @param failed
	 * @return
	 */
	public String validate(String methodName, String success, String failed) {
		Employee employee = (Employee) session.get("employee");// 获得已登录employee对象
		if (employee == null) {
			ActionContext.getContext().put("msg", "您没有登陆，请先登录系统。");
			return failed;
		} else {
			Set<Role> roles = employee.getRoles();// 获得用户角色
			boolean flag = false;// 标记用户是否有权限
			for (Role role : roles) {// 迭代角色中的权限 于方法名进行判断
				for (Power power : role.getPowers()) {
					if (methodName.equals(power.getPowerName())) {
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				return success;
			} else {
				ActionContext.getContext().put("msg", "您没有访问权限,如果要访问,请联系管理员。");
				return failed;
			}
		}

	}

}
