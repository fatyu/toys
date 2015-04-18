package com.crm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.crm.entity.Employee;
import com.crm.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录Action
 * 
 * @author Fatyu
 * 
 */
@Controller
public class LoginManageAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8408566806646715030L;
	@Resource
	IEmployeeService employeeService;

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// private Employee employee;
	// public Employee getEmployee() {
	// return employee;
	// }
	//
	// public void setEmployee(Employee employee) {
	// this.employee = employee;
	// }
	// /**
	// * 验证雇员登录
	// */
	// public String login() {
	// List<Employee> elist = employeeService.list();
	// if (elist.size() > 0) {
	// for (Employee emp : elist) {
	// // System.out.println(emp.getEmployeeName());
	// if (null != employee.getEmployeeName()
	// && !("".equals(employee.getEmployeeName()))
	// && null != employee.getEmployeePassword()
	// && !("".equals(employee.getEmployeePassword()))) {
	// if (emp.getEmployeeName()
	// .equals(employee.getEmployeeName())
	// && emp.getEmployeePassword().equals(
	// employee.getEmployeePassword())) {
	// session.put("employee", emp);//将employee设置到session中
	// return "success";
	// }
	// }
	// }
	// }
	// ActionContext.getContext().put("msg", "用户名或密码错误.请返回重新登录.");
	// return "input";
	//
	// }
	private String employeeName;
	private String employeePassword;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String login() {
		List<Employee> elist = employeeService.list();
		if (elist.size() > 0) {
			for (Employee emp : elist) {
				// System.out.println(emp.getEmployeeName());
				if (null != this.getEmployeeName()
						&& !("".equals(this.getEmployeeName().trim()))
						&& null != this.getEmployeePassword()
						&& !("".equals(this.getEmployeePassword().trim()))) {
					if (emp.getEmployeeName().equals(
							this.getEmployeeName().trim())
							&& emp.getEmployeePassword().equals(
									this.getEmployeePassword().trim())) {
						session.put("employee", emp);// 将employee设置到session中
						return "success";
					}
				}
			}
		}
		ActionContext.getContext().put("msg", "用户名或密码错误.请返回重新登录.");
		return "input";

	}

}
