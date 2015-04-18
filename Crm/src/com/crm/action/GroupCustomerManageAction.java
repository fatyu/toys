package com.crm.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.crm.entity.CustomerType;
import com.crm.entity.Employee;
import com.crm.entity.GroupCustomer;
import com.crm.service.ICustomerTypeService;
import com.crm.service.IGroupCustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 集团顾客管理Action
 * 
 * @author Fatyu
 * 
 */
@Controller
public class GroupCustomerManageAction extends ActionSupport implements
		SessionAware {
	@Resource
	IGroupCustomerService groupCustomerService;
	@Resource
	ICustomerTypeService customerTypeService;
	private static final long serialVersionUID = 3497070227089692202L;
	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	private GroupCustomer groupCustomer;

	public GroupCustomer getGroupCustomer() {
		return groupCustomer;
	}

	public void setGroupCustomer(GroupCustomer groupCustomer) {
		this.groupCustomer = groupCustomer;
	}

	/**
	 * 列出所有的集团顾客
	 * 
	 * @return
	 */
	public String list() {
		Employee employee = (Employee) session.get("employee");

		List<GroupCustomer> gcs = groupCustomerService.list();
		List<GroupCustomer> groupCustomers = new ArrayList<GroupCustomer>();
		for (GroupCustomer gc : gcs) {
			if (gc.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				groupCustomers.add(gc);
			}
		}

		ActionContext.getContext().put("groupCustomers", groupCustomers);
		// System.out.println(groupCustomers.size());
		return "listsuccess";
	}

	/**
	 * 显示顾客的详细信息
	 * 
	 * @return
	 */
	public String detail() {
		GroupCustomer gc = groupCustomerService.findById(groupCustomer
				.getGroupCustomerId());
		CustomerType ct = customerTypeService.findById(gc
				.getGroupCustomerType());
		System.out
				.println("==============================================================");
		ActionContext.getContext().put("gc", gc);
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
			groupCustomerService.delete(groupCustomer.getGroupCustomerId());
			ActionContext.getContext().put("msg", "删除成功");
			return "deletesuccess";
		} catch (Exception e) {
			ActionContext.getContext().put("msg", "删除失败,数据可能已不存在。请重新登陆");
			return "deleteerror";
		}
	}

	/**
	 * 添加集团顾客
	 * 
	 * @return
	 */
	public String add() {
		GroupCustomer gc = new GroupCustomer();
		Employee employee = (Employee) session.get("employee");// 从session中获得雇员
		gc.setGroupCustomerName(groupCustomer.getGroupCustomerName());
		gc.setGroupCustomerAddress(groupCustomer.getGroupCustomerAddress());
		gc.setGroupCustomerPhoneNum(groupCustomer.getGroupCustomerPhoneNum());
		gc.setGroupCustomerPostNum(groupCustomer.getGroupCustomerPostNum());
		gc.setGroupCustomerType(groupCustomer.getGroupCustomerType());
		gc.setGroupCustomerCardNum(groupCustomer.getGroupCustomerCardNum());
		gc.setEmployee(employee);
		groupCustomerService.add(gc);
		ActionContext.getContext().put("msg", "添加成功");
		return "addsuccess";
	}

	/**
	 * 更新信息前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		GroupCustomer gc = groupCustomerService.findById(groupCustomer
				.getGroupCustomerId());
		ActionContext.getContext().put("gc", gc);
		return "preupdate";
	}

	/**
	 * 更新顾客信息
	 * 
	 * @return
	 */
	public String update() {
		GroupCustomer gc = groupCustomerService.findById(groupCustomer
				.getGroupCustomerId());
		gc.setGroupCustomerName(groupCustomer.getGroupCustomerName());
		gc.setGroupCustomerAddress(groupCustomer.getGroupCustomerAddress());
		gc.setGroupCustomerPhoneNum(groupCustomer.getGroupCustomerPhoneNum());
		gc.setGroupCustomerPostNum(groupCustomer.getGroupCustomerPostNum());
		gc.setGroupCustomerType(groupCustomer.getGroupCustomerType());
		gc.setGroupCustomerCardNum(groupCustomer.getGroupCustomerCardNum());
		groupCustomerService.update(gc);
		ActionContext.getContext().put("msg", "客户信息更新成功");
		return "updatesuccess";
	}

}
