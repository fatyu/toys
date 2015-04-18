package com.crm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.crm.entity.CustomerType;
import com.crm.entity.Employee;
import com.crm.entity.Nation;
import com.crm.entity.PersonCustomer;
import com.crm.entity.Sex;
import com.crm.service.ICustomerTypeService;
import com.crm.service.INationService;
import com.crm.service.IPersonCustomerService;
import com.crm.service.ISexService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class PersonCustomerManageAction extends ActionSupport implements
		SessionAware {

	@Resource
	IPersonCustomerService personCustomerService;
	@Resource
	ISexService sexService;
	@Resource
	INationService nationService;
	@Resource
	ICustomerTypeService customerTypeService;

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	private PersonCustomer personCustomer;

	public PersonCustomer getPersonCustomer() {
		return personCustomer;
	}

	public void setPersonCustomer(PersonCustomer personCustomer) {
		this.personCustomer = personCustomer;
	}

	private static final long serialVersionUID = 1849480372496812904L;

	/**
	 * 列出所有的集团顾客
	 * 
	 * @return
	 */
	public String list() {
		Employee employee = (Employee) session.get("employee");

		List<PersonCustomer> personCustomers1 = personCustomerService.list();
		List<PersonCustomer> personCustomers = new ArrayList<PersonCustomer>();
		for (PersonCustomer pc : personCustomers1) {
			if (pc.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				personCustomers.add(pc);
			}
		}
		ActionContext.getContext().put("personCustomers", personCustomers);
		// System.out.println(groupCustomers.size());
		return "listsuccess";
	}

	/**
	 * 显示顾客的详细信息
	 * 
	 * @return
	 */
	public String detail() {
		PersonCustomer pc = personCustomerService.findById(personCustomer
				.getPersonCustomerId());
		Sex sex = sexService.findById(pc.getPersonCustomerSex());
		Nation nation = nationService.findById(pc.getPersonCustomerNation());
		CustomerType ct = customerTypeService.findById(pc
				.getPersonCustomerLeavle());

		ActionContext.getContext().put("pc", pc);
		ActionContext.getContext().put("sex", sex);
		ActionContext.getContext().put("nation", nation);
		ActionContext.getContext().put("ct", ct);
		return "detail";
	}

	/**
	 * 删除指定的集团顾客
	 * 
	 * @return
	 */
	public String delete() {
		try {
			personCustomerService.delete(personCustomer.getPersonCustomerId());
			ActionContext.getContext().put("msg", "删除成功");
			return "deletesuccess";
		} catch (Exception e) {
			ActionContext.getContext().put("msg", "删除失败,数据可能已不存在");
			return "deleteerror";
		}
	}

	/**
	 * 添加集团顾客
	 * 
	 * @return
	 */
	public String add() {
		PersonCustomer pc = new PersonCustomer();
		Employee employee = (Employee) session.get("employee");// 从session中获得雇员
		pc.setPersonCustomerName(personCustomer.getPersonCustomerName());
		pc.setPersonCustomerAddress(personCustomer.getPersonCustomerAddress());
		pc.setPersonCustomerAge(personCustomer.getPersonCustomerAge());
		pc.setPersonCustomerCardNum(personCustomer.getPersonCustomerCardNum());
		pc.setPersonCustomerEdu(personCustomer.getPersonCustomerEdu());
		pc.setPersonCustomerHobby(personCustomer.getPersonCustomerHobby());
		pc
				.setPersonCustomerJobTitle(personCustomer
						.getPersonCustomerJobTitle());
		pc.setPersonCustomerJobType(personCustomer.getPersonCustomerJobType());
		pc.setPersonCustomerLeavle(personCustomer.getPersonCustomerLeavle());
		pc.setPersonCustomerNation(personCustomer.getPersonCustomerNation());
		pc.setPersonCustomerSex(personCustomer.getPersonCustomerSex());
		pc
				.setPersonCustomerPhoneNum(personCustomer
						.getPersonCustomerPhoneNum());
		pc
				.setPersonCustomerPostCode(personCustomer
						.getPersonCustomerPostCode());
		pc.setEmployee(employee);
		personCustomerService.add(pc);
		ActionContext.getContext().put("msg", "添加成功");
		return "addsuccess";
	}

	/**
	 * 更新信息前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		PersonCustomer pc = personCustomerService.findById(personCustomer
				.getPersonCustomerId());
		ActionContext.getContext().put("pc", pc);
		return "preupdate";
	}

	/**
	 * 更新顾客信息
	 * 
	 * @return
	 */
	public String update() {
		PersonCustomer pc = (PersonCustomer) personCustomerService
				.findById(personCustomer.getPersonCustomerId());
		pc.setPersonCustomerName(personCustomer.getPersonCustomerName());
		pc.setPersonCustomerAddress(personCustomer.getPersonCustomerAddress());
		pc.setPersonCustomerAge(personCustomer.getPersonCustomerAge());
		pc.setPersonCustomerCardNum(personCustomer.getPersonCustomerCardNum());
		pc.setPersonCustomerEdu(personCustomer.getPersonCustomerEdu());
		pc.setPersonCustomerHobby(personCustomer.getPersonCustomerHobby());
		pc
				.setPersonCustomerJobTitle(personCustomer
						.getPersonCustomerJobTitle());
		pc.setPersonCustomerJobType(personCustomer.getPersonCustomerJobType());
		pc.setPersonCustomerLeavle(personCustomer.getPersonCustomerLeavle());
		pc.setPersonCustomerNation(personCustomer.getPersonCustomerNation());
		pc.setPersonCustomerSex(personCustomer.getPersonCustomerSex());
		pc
				.setPersonCustomerPhoneNum(personCustomer
						.getPersonCustomerPhoneNum());
		pc
				.setPersonCustomerPostCode(personCustomer
						.getPersonCustomerPostCode());
		personCustomerService.update(pc);
		ActionContext.getContext().put("msg", "客户信息更新成功");
		return "updatesuccess";
	}
}
