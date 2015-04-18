package com.crm.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.crm.entity.Complain;
import com.crm.service.IComplainService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 关怀信息action
 * 
 * @author Fatyu
 * 
 */
@Controller
public class ComplainManageAction extends ActionSupport {
	private static final long serialVersionUID = 5219223527651522620L;
	@Resource
	IComplainService complainService;

	private Complain complain;

	public Complain getComplain() {
		return complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	/**
	 * 查找所有未处理的投诉
	 * 
	 * @return
	 */
	public String listUnclear() {
		List<Complain> complains = complainService.list();
		List<Complain> complains1 = new ArrayList<Complain>();
		for (Complain c : complains) {
			if (c.getClear().equals("N")) {
				complains1.add(c);
			}
		}
		if (complains1.size() > 0) {
			ActionContext.getContext().put("complains", complains1);
			return "listunclearsuccess";
		} else {
			ActionContext.getContext().put("msg", "没有未处理的投诉");
			return "failed";
		}
	}

	/**
	 * 显示已经处理的投诉
	 * 
	 * @return
	 */
	public String listClear() {
		List<Complain> complains = complainService.list();
		List<Complain> complains1 = new ArrayList<Complain>();
		for (Complain c : complains) {
			if (c.getClear().equals("Y")) {
				complains1.add(c);
			}
		}
		if (complains1.size() > 0) {
			ActionContext.getContext().put("complains", complains1);
			return "listclearsuccess";
		} else {
			ActionContext.getContext().put("msg", "没有已处理的投诉");
			return "failed";
		}
	}

	/**
	 * 显示关怀信息的详细信息
	 * 
	 * @return
	 */
	public String detail() {
		Complain c = complainService.findById(complain.getComplainId());
		ActionContext.getContext().put("complain", c);
		return "detail";
	}

	/**
	 * 删除指定的关怀信息
	 * 
	 * @return
	 */
	public String delete() {
		try {
			complainService.delete(complain.getComplainId());
			ActionContext.getContext().put("msg", "删除成功");
			return "deletesuccess";
		} catch (Exception e) {
			ActionContext.getContext().put("msg", "删除失败,数据可能已不存在");
			return "deleteerror";
		}
	}

	/**
	 * 由客户服务人员添加客户投诉
	 * 
	 * @return
	 */
	public String addComplain() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		System.out.println(dateStr);
		Complain c = new Complain();
		c.setComplainName(complain.getComplainName());
		c.setComplainType(complain.getComplainType());
		c.setComplainDate(dateStr);
		c.setComplainContent(complain.getComplainContent());
		c.setClear("N");
		complainService.add(c);
		ActionContext.getContext().put("msg", "投诉信息已记录...等待投诉处理人员处理");
		return "addsuccess";
	}

	/**
	 * 更新前处理
	 * 
	 * @return
	 */
	public String preUpdate() {
		Complain c = complainService.findById(complain.getComplainId());
		ActionContext.getContext().put("complain", c);
		return "preupdate";
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	public String update() {
		Complain c = complainService.findById(complain.getComplainId());
		c.setClear(complain.getClear());
		c.setClearType(complain.getClearType());
		c.setFeeling(complain.getFeeling());
		complainService.update(c);
		ActionContext.getContext().put("msg", "投诉回执单填写成功");
		return "updatesuccess";
	}

}
