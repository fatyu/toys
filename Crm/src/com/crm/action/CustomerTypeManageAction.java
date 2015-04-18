package com.crm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crm.entity.CustomerType;
import com.crm.service.ICustomerTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class CustomerTypeManageAction extends ActionSupport {
	@Resource
	ICustomerTypeService customerTypeService;
	private static final long serialVersionUID = 8958890120703781495L;

	private String typeId;
	private String typeName;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 列出类型
	 * 
	 * @return
	 */
	public String list() {
		List<CustomerType> cts = customerTypeService.list();
		ActionContext.getContext().put("cts", cts);
		return "listsuccess";
	}

	/**
	 * 查找指定类型
	 * 
	 * @return
	 */
	public String findById() {

		CustomerType ct = customerTypeService.findById(this.getTypeId());
		ActionContext.getContext().put("ct", ct);
		return "findsuccess";
	}

	/**
	 * 更新信息前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		CustomerType ct = customerTypeService.findById(this.getTypeId());
		ActionContext.getContext().put("ct", ct);
		return "preupdate";
	}

	/**
	 * 更新指定类别
	 * 
	 * @return
	 */
	public String update() {

		CustomerType ct = customerTypeService.findById(this.getTypeId());
		String name = this.getTypeName();

		if (name != null && name.trim() != "") {
			ct.setTypeName(name);
			customerTypeService.update(ct);
			ActionContext.getContext().put("msg", "类型修改成功");
			return "updatesuccess";
		} else {
			ActionContext.getContext().put("msg", "输入数据不能为空");
			return "input";
		}
	}

	/**
	 * 添加类型
	 * 
	 * @return
	 */
	public String add() {

		CustomerType ct = new CustomerType();
		String id = this.getTypeId();
		String name = this.getTypeName();

		if (id != null && id.trim() != "" && name != null && name.trim() != "") {
			ct.setTypeId(id);
			ct.setTypeName(name);
			customerTypeService.add(ct);
			ActionContext.getContext().put("msg", "类型添加成功");
			return "addsuccess";
		} else {
			ActionContext.getContext().put("msg", "输入数据不正确");
			return "input";
		}
	}

}
