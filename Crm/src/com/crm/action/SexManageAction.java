package com.crm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crm.entity.Sex;
import com.crm.service.ISexService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class SexManageAction extends ActionSupport {
	@Resource
	ISexService sexService;
	private static final long serialVersionUID = 8958890120703781495L;

	private String sexId;
	private String sexName;

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getSexId() {
		return sexId;
	}

	public void setSexId(String sexId) {
		this.sexId = sexId;
	}

	/**
	 * 列出性别
	 * 
	 * @return
	 */
	public String list() {
		List<Sex> sexs = sexService.list();
		ActionContext.getContext().put("sexs", sexs);
		return "listsuccess";
	}

	/**
	 * 查找指定性别
	 * 
	 * @return
	 */
	public String findById() {

		Sex sex = sexService.findById(sexId);
		ActionContext.getContext().put("sex", sex);
		return "findsuccess";
	}

	/**
	 * 更新信息前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		Sex sex = sexService.findById(this.getSexId());
		ActionContext.getContext().put("sex", sex);
		return "preupdate";
	}

	/**
	 * 更新指定性别
	 * 
	 * @return
	 */
	public String update() {

		Sex sex = sexService.findById(this.getSexId());
		sex.setSexName(this.getSexName());
		sexService.update(sex);
		ActionContext.getContext().put("msg", "性别修改成功");
		return "updatesuccess";
	}

}
