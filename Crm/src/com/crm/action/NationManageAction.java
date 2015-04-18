package com.crm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crm.entity.Nation;
import com.crm.service.INationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 控制民族信息的流程扭转
 * 
 * @author Fatyu
 * 
 */
@Controller
public class NationManageAction extends ActionSupport {
	@Resource
	INationService nationService;
	private static final long serialVersionUID = 4351737114704403837L;

	private String nationId;
	private String nationName;

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	/**
	 * 列出民族
	 * 
	 * @return
	 */
	public String list() {
		List<Nation> nations = nationService.list();
		ActionContext.getContext().put("nations", nations);
		return "listsuccess";
	}

	/**
	 * 更新信息前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		Nation na = nationService.findById(this.getNationId());
		ActionContext.getContext().put("nation", na);
		return "preupdate";
	}

	/**
	 * 更新民族信息
	 * 
	 * @return
	 */
	public String update() {
		Nation nation = nationService.findById(this.getNationId());
		nation.setNationName(this.getNationName());
		nationService.update(nation);
		ActionContext.getContext().put("msg", "民族信息更新成功");
		return "updatesuccess";
	}

}
