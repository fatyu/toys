package com.crm.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.crm.entity.CareInfo;
import com.crm.entity.Employee;
import com.crm.entity.GroupCustomer;
import com.crm.entity.PersonCustomer;
import com.crm.service.ICareInfoService;
import com.crm.service.IGroupCustomerService;
import com.crm.service.IPersonCustomerService;
import com.crm.util.LunarCalendarUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 关怀信息action
 * 
 * @author Fatyu
 * 
 */
@Controller
public class CareInfoManageAction extends ActionSupport implements SessionAware {
	@Resource
	ICareInfoService careInfoService;
	@Resource
	IPersonCustomerService personCustomerService;
	@Resource
	IGroupCustomerService groupCustomerService;
	private static final long serialVersionUID = 2714132238346957950L;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	private CareInfo careInfo;

	public CareInfo getCareInfo() {
		return careInfo;
	}

	public void setCareInfo(CareInfo careInfo) {
		this.careInfo = careInfo;
	}

	/**
	 * 查找所有的关怀信息
	 * 
	 * @return
	 */
	public String list() {
		Employee employee = (Employee) session.get("employee");
		List<CareInfo> infos1 = careInfoService.list();
		List<CareInfo> infos = new ArrayList<CareInfo>();

		for (CareInfo ci : infos1) {
			if (ci.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				infos.add(ci);
			}
		}
		ActionContext.getContext().put("infos", infos);
		return "listsuccess";
	}

	/**
	 * 显示关怀信息的详细信息
	 * 
	 * @return
	 */
	public String detail() {
		CareInfo info = careInfoService.findById(careInfo.getInfoId());
		ActionContext.getContext().put("info", info);
		return "detail";
	}

	/**
	 * 删除指定的关怀信息
	 * 
	 * @return
	 */
	public String delete() {
		try {
			careInfoService.delete(careInfo.getInfoId());
			ActionContext.getContext().put("msg", "删除成功");
			return "deletesuccess";
		} catch (Exception e) {
			ActionContext.getContext().put("msg", "删除失败,数据可能已不存在");
			return "deleteerror";
		}
	}

	/**
	 * 根据传入的参数不同进行不同类型的信息客户检查
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String checkCustomer() {
		Set<PersonCustomer> pc = new HashSet<PersonCustomer>();
		Set<GroupCustomer> gc = new HashSet<GroupCustomer>();
		String today = "";
		Date date = new Date();
		if (date.getMonth() + 1 < 10 && date.getDate() < 10) {
			today = "0" + (date.getMonth() + 1) + "0" + date.getDate();
		} else if (date.getMonth() + 1 >= 10 && date.getDate() < 10) {
			today = (date.getMonth() + 1) + "0" + date.getDate();
		} else if (date.getMonth() + 1 < 10 && date.getDate() > 10) {
			today = "0" + (date.getMonth() + 1) + date.getDate();
		} else if (date.getMonth() + 1 > 10 && date.getDate() > 10) {
			today = "" + (date.getMonth() + 1) + date.getDate();
		}

		// 农历节日
		Map<String, String> lcudate = new HashMap<String, String>();
		lcudate.put("正月初一", "春节");
		lcudate.put("正月十五", "元宵节");
		lcudate.put("五月初五", "端午节");
		lcudate.put("八月十五", "中秋节");
		lcudate.put("十二月三十", "大年三十");
		// 阳历节日
		Map<String, String> sundate = new HashMap<String, String>();
		sundate.put("0101", "元旦");
		sundate.put("0308", "妇女节");
		sundate.put("0312", "植树节");
		sundate.put("0501", "劳动节");
		sundate.put("0601", "儿童节");
		sundate.put("1001", "国庆节");

		Set<String> keys1 = lcudate.keySet();
		Set<String> keys2 = sundate.keySet();

		if (this.getType().equals("hope")) {// 节日祝福 判断下一天是不是节日
			List<PersonCustomer> pcs = personCustomerService.list();
			List<GroupCustomer> gcs = groupCustomerService.list();
			LunarCalendarUtils lcu = new LunarCalendarUtils();

			String result1 = lcu.today();
			String result2 = lcu.today();

			result1 = result1.substring(23, result1.length());
			result2 = result2.substring(24, result2.length());
			// 判断农历节日
			for (String flag : keys1) {
				System.out.println(flag);
				System.out.println(result1);
				System.out.println(result2);

				if (result1.equals(flag) || result2.equals(flag)) {
					for (PersonCustomer personCustomer : pcs) {
						pc.add(personCustomer);
					}

					for (GroupCustomer groupCustomer : gcs) {
						gc.add(groupCustomer);
					}
					ActionContext.getContext()
							.put("lcudate", lcudate.get(flag));

				}
			}

			// 判断阳历节日
			for (String flag : keys2) {
				System.out.println(flag);
				System.out.println(today);
				if (today.equals(flag)) {
					for (PersonCustomer personCustomer : pcs) {
						pc.add(personCustomer);
					}

					for (GroupCustomer groupCustomer : gcs) {
						gc.add(groupCustomer);
					}
					ActionContext.getContext()
							.put("sundate", sundate.get(flag));

				}
			}
			ActionContext.getContext().put("hope", "hope");
			ActionContext.getContext().put("pc", pc);
			ActionContext.getContext().put("gc", gc);
		} else if (this.getType().equals("company")) {// 公司信息全部发送
			List<PersonCustomer> pcs = personCustomerService.list();
			for (PersonCustomer personCustomer : pcs) {
				pc.add(personCustomer);
			}

			List<GroupCustomer> gcs = groupCustomerService.list();
			for (GroupCustomer groupCustomer : gcs) {
				gc.add(groupCustomer);
			}
			ActionContext.getContext().put("pc", pc);
			ActionContext.getContext().put("gc", gc);
			ActionContext.getContext().put("company", "company");

		} else if (this.getType().equals("birthday")) {// 获取身份证 判断当天生日的个人客户
			// 发送祝福信息
			List<PersonCustomer> pcs = personCustomerService.list();

			for (PersonCustomer personCustomer : pcs) {

				String birthday = personCustomer.getPersonCustomerCardNum();
				if (birthday.length() == 18) {
					birthday = birthday.substring(10, 14);
					System.out.println(birthday);
					System.out.println(today);
					if (birthday.equals(today)) {
						pc.add(personCustomer);
					}
				}
			}
			ActionContext.getContext().put("pc", pc);
			ActionContext.getContext().put("birthday", "birthday");
		}

		if (pc.isEmpty() && gc.isEmpty()) {
			System.out.println(pc.size());
			System.out.println(gc.size());
			ActionContext.getContext().put("msg", "没有需要关怀的客户");
			return "nocustomer";
		} else {
			return "checksuccess";
		}

	}

	/**
	 * 发送关怀信息
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String send() {
		CareInfo ci = new CareInfo();
		String title = careInfo.getInfoTitle();
		String type = careInfo.getInfoType();
		String detail = careInfo.getInfoTitle();
		if (title != null && title.trim() != "" && type != null
				&& type.trim() != "" && detail != null && detail.trim() != "") {
			ci.setInfoTitle(title);
			ci.setInfoType(type);
			ci.setInfoDetail(careInfo.getInfoDetail());
		} else {
			ActionContext.getContext().put("msg", "输入数据不正确");
			return "input";
		}
		ci.setInfoDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		ci.setEmployee((Employee) session.get("employee"));

		// =========================================================================
		Set<PersonCustomer> pc = new HashSet<PersonCustomer>();
		Set<GroupCustomer> gc = new HashSet<GroupCustomer>();
		String today = "";
		Date date = new Date();
		if (date.getMonth() + 1 < 10 && date.getDate() < 10) {
			today = "0" + (date.getMonth() + 1) + "0" + date.getDate();
		} else if (date.getMonth() + 1 >= 10 && date.getDate() < 10) {
			today = (date.getMonth() + 1) + "0" + date.getDate();
		} else if (date.getMonth() + 1 < 10 && date.getDate() > 10) {
			today = "0" + (date.getMonth() + 1) + date.getDate();
		} else if (date.getMonth() + 1 > 10 && date.getDate() > 10) {
			today = "" + (date.getMonth() + 1) + date.getDate();
		}

		// 农历节日
		Map<String, String> lcudate = new HashMap<String, String>();
		lcudate.put("正月初一", "春节");
		lcudate.put("正月十五", "元宵节");
		lcudate.put("五月初五", "端午节");
		lcudate.put("八月十五", "中秋节");
		lcudate.put("十二月三十", "大年三十");
		// 阳历节日
		Map<String, String> sundate = new HashMap<String, String>();
		sundate.put("0101", "元旦");
		sundate.put("0308", "妇女节");
		sundate.put("0312", "植树节");
		sundate.put("0501", "劳动节");
		sundate.put("0601", "儿童节");
		sundate.put("1001", "国庆节");

		Set<String> keys1 = lcudate.keySet();
		Set<String> keys2 = sundate.keySet();

		if (this.getType().equals("hope")) {// 节日祝福 判断下一天是不是节日
			List<PersonCustomer> pcs = personCustomerService.list();
			List<GroupCustomer> gcs = groupCustomerService.list();
			LunarCalendarUtils lcu = new LunarCalendarUtils();

			String result1 = lcu.today();
			String result2 = lcu.today();

			result1 = result1.substring(23, result1.length());
			result2 = result2.substring(24, result2.length());
			// 判断农历节日
			for (String flag : keys1) {

				if (result1.equals(flag) || result2.equals(flag)) {
					for (PersonCustomer personCustomer : pcs) {
						pc.add(personCustomer);
					}

					for (GroupCustomer groupCustomer : gcs) {
						gc.add(groupCustomer);
					}
				}
			}

			// 判断阳历节日
			for (String flag : keys2) {
				if (today.equals(flag)) {
					for (PersonCustomer personCustomer : pcs) {
						pc.add(personCustomer);
					}

					for (GroupCustomer groupCustomer : gcs) {
						gc.add(groupCustomer);
					}
				}
			}
		} else if (this.getType().equals("company")) {// 公司信息全部发送
			List<PersonCustomer> pcs = personCustomerService.list();
			for (PersonCustomer personCustomer : pcs) {
				pc.add(personCustomer);
			}

			List<GroupCustomer> gcs = groupCustomerService.list();
			for (GroupCustomer groupCustomer : gcs) {
				gc.add(groupCustomer);
			}

		} else if (this.getType().equals("birthday")) {// 获取身份证 判断当天生日的个人客户
			// 发送祝福信息
			List<PersonCustomer> pcs = personCustomerService.list();

			for (PersonCustomer personCustomer : pcs) {

				String birthday = personCustomer.getPersonCustomerCardNum();
				if (birthday.length() == 18) {
					birthday = birthday.substring(10, 14);
					if (birthday.equals(today)) {
						pc.add(personCustomer);
					}
				}
			}
		}
		// =========================================================================

		if (null != pc && !pc.isEmpty()) {
			ci.setPersonCustomers(pc);
		}
		if (null != gc && !gc.isEmpty()) {
			ci.setGroupCustomers(gc);
		}
		careInfoService.add(ci);
		ActionContext.getContext().put("msg", "消息发送成功");
		return "sendsuccess";
	}

}
