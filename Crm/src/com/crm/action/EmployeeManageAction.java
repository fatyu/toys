package com.crm.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crm.entity.Employee;
import com.crm.entity.Nation;
import com.crm.entity.Role;
import com.crm.entity.Sex;
import com.crm.service.IEmployeeService;
import com.crm.service.INationService;
import com.crm.service.IRoleService;
import com.crm.service.ISexService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class EmployeeManageAction extends ActionSupport {

	@Resource
	IEmployeeService employeeService;
	@Resource
	ISexService sexService;
	@Resource
	INationService nationService;
	@Resource
	IRoleService roleService;

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private static final long serialVersionUID = -4018667209129688851L;

	/**
	 * 列出所有的雇员
	 * 
	 * @return
	 */
	public String list() {
		List<Employee> employees = employeeService.list();
		ActionContext.getContext().put("employees", employees);
		// System.out.println(groupCustomers.size());
		return "listsuccess";
	}

	/**
	 * 显示雇员的详细信息
	 * 
	 * @return
	 */
	public String detail() {
		Employee emp = employeeService.findById(employee.getEmployeeId());
		Sex sex = sexService.findById(emp.getEmployeeSex());
		Nation nation = nationService.findById(emp.getEmployeeNation());
		System.out.println(emp.getEmployeeNation());
		ActionContext.getContext().put("sex", sex);
		ActionContext.getContext().put("nation", nation);
		ActionContext.getContext().put("employee", emp);
		return "detail";
	}

	/**
	 * 删除指定的雇员
	 * 
	 * @return
	 */
	public String delete() {
		if (employee.getEmployeeId() == 1) {
			ActionContext.getContext().put("msg", "管理员不能被删除");
			return "deleteerror";
		} else {
			employeeService.delete(employee.getEmployeeId());
			ActionContext.getContext().put("msg", "删除成功");
			return "deletesuccess";
		}
	}

	/**
	 * 添加雇员
	 * 
	 * @return
	 */
	public String add() {
		Employee emp = new Employee();
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeAddress(employee.getEmployeeAddress());
		emp.setEmployeeAge(employee.getEmployeeAge());
		emp.setEmployeeNation(employee.getEmployeeNation());
		emp.setEmployeeSalary(employee.getEmployeeSalary());
		emp.setEmployeeSex(employee.getEmployeeSex());
		emp.setEmployeePassword(employee.getEmployeePassword());
		Role role = roleService.findById(Integer.parseInt(employee.getRoleId()));
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		employee.setRoles(roles);
		employeeService.add(employee);
		ActionContext.getContext().put("msg", "添加成功");
		return "addsuccess";
	}

	/**
	 * 更新信息前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		Employee emp = employeeService.findById(employee.getEmployeeId());
		ActionContext.getContext().put("emp", emp);
		return "preupdate";
	}

	/**
	 * 更新雇员信息
	 * 
	 * @return
	 */
	public String update() {
		Employee emp = employeeService.findById(employee.getEmployeeId());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeAddress(employee.getEmployeeAddress());
		emp.setEmployeeAge(employee.getEmployeeAge());
		emp.setEmployeeNation(employee.getEmployeeNation());
		emp.setEmployeeSalary(employee.getEmployeeSalary());
		emp.setEmployeeSex(employee.getEmployeeSex());
		emp.setEmployeePassword(employee.getEmployeePassword());
		Role role = roleService.findById(Integer.parseInt(employee.getRoleId()));
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		emp.setRoles(roles);
		employeeService.update(emp);
		ActionContext.getContext().put("msg", "雇员信息更新成功");
		return "updatesuccess";
	}

}
