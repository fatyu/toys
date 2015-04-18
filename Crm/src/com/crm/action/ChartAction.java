package com.crm.action;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;

import com.crm.entity.Employee;
import com.crm.entity.GroupCustomer;
import com.crm.entity.PersonCustomer;
import com.crm.service.ICustomerTypeService;
import com.crm.service.IGroupCustomerService;
import com.crm.service.IPersonCustomerService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
/**
 * 根据客户数量生成图表
 * @author Fatyu
 */
public class ChartAction extends ActionSupport implements SessionAware {
	@Resource
	IGroupCustomerService groupCustomerService;
	@Resource
	ICustomerTypeService customerTypeService;
	@Resource
	IPersonCustomerService personCustomerService;
	private static final long serialVersionUID = 3633202170179921802L;
	private JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}


/**
 * 生成集团与个人的比例图
 * @return
 * @throws Exception
 */
	public String gcpc() throws Exception {
		Employee employee = (Employee) session.get("employee");
		List<GroupCustomer> gcs = groupCustomerService.list();
		List<GroupCustomer> groupCustomers = new ArrayList<GroupCustomer>();
		for (GroupCustomer gc : gcs) {
			if (gc.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				groupCustomers.add(gc);
			}
		}
		List<PersonCustomer> personCustomers1 = personCustomerService.list();
		List<PersonCustomer> personCustomers = new ArrayList<PersonCustomer>();
		for (PersonCustomer pc : personCustomers1) {
			if (pc.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				personCustomers.add(pc);
			}
		}
		int gcnum = groupCustomers.size();
		int pcnum = personCustomers.size();

		DefaultPieDataset piedataset = new DefaultPieDataset();
		piedataset.setValue("集团客户", gcnum);
		piedataset.setValue("个人客户", pcnum);
		this.createChart("集团客户与个人客户比例图", piedataset);
		return SUCCESS;
	}

	/**
	 * 集团客户级别比例图
	 * @return
	 * @throws Exception
	 */
	public String gcleavel() throws Exception {
		
		Employee employee = (Employee) session.get("employee");
		List<GroupCustomer> groupCustomers  = groupCustomerService.list();
		List<GroupCustomer> gcs= new ArrayList<GroupCustomer>();
		for (GroupCustomer gc : groupCustomers) {
			if (gc.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				gcs.add(gc);
			}
		}
		// 获取集团客户不同类型的客户个数

		int bgcnum = 0;
		int mgcnum = 0;
		int sgcnum = 0;
		int vipcnum = 0;
		int willbegcnum = 0;
		if (gcs.size() > 0) {
			for (GroupCustomer gc : gcs) {
				if (gc.getGroupCustomerType().equals("01"))
					bgcnum += 1;
				if (gc.getGroupCustomerType().equals("02"))
					mgcnum += 1;
				if (gc.getGroupCustomerType().equals("03"))
					sgcnum += 1;
				if (gc.getGroupCustomerType().equals("04"))
					vipcnum += 1;
				if (gc.getGroupCustomerType().equals("05"))
					willbegcnum += 1;
			}
		}
		DefaultPieDataset piedataset = new DefaultPieDataset();
		piedataset.setValue("大型集团客户", bgcnum);
		piedataset.setValue("中型集团客户", mgcnum);
		piedataset.setValue("小型集团客户", sgcnum);
		piedataset.setValue("VIP集团", vipcnum);
		piedataset.setValue("潜在集团客户", willbegcnum);
		this.createChart("集团客户分类比例图", piedataset);
		return SUCCESS;
	}
/**
 * 个人客户级别比例图
 * @return
 * @throws Exception
 */
	public String pcleavel() throws Exception {
		Employee employee = (Employee) session.get("employee");
		List<PersonCustomer> personCustomers1 = personCustomerService.list();
		List<PersonCustomer> personCustomers = new ArrayList<PersonCustomer>();
		for (PersonCustomer pc : personCustomers1) {
			if (pc.getEmployee().getEmployeeId() == employee.getEmployeeId()) {
				personCustomers.add(pc);
			}
		}
		// 获取个人客户不同类型的客户个数

		int bpcnum = 0;
		int spcnum = 0;
		int vipcnum = 0;
		int willbepcnum = 0;
		if (personCustomers.size() > 0) {
			for (PersonCustomer pc : personCustomers) {
				if (pc.getPersonCustomerLeavle().equals("06"))
					bpcnum += 1;
				if (pc.getPersonCustomerLeavle().equals("07"))
					spcnum += 1;
				if (pc.getPersonCustomerLeavle().equals("08"))
					vipcnum += 1;
				if (pc.getPersonCustomerLeavle().equals("09"))
					willbepcnum += 1;
			}
		}
		DefaultPieDataset piedataset = new DefaultPieDataset();
		piedataset.setValue("大客户", bpcnum);
		piedataset.setValue("小客户", spcnum);
		piedataset.setValue("VIP", vipcnum);
		piedataset.setValue("潜在客户", willbepcnum);
		this.createChart("个人客户分类比例图", piedataset);
		return SUCCESS;
	}

	/**
	 * 创建3d的饼图
	 * 
	 * @param title
	 * @param dpd
	 */
	public void createChart(String title, DefaultPieDataset dpd) {
		chart = ChartFactory.createPieChart3D(title, dpd, true, true, false);
		chart.getTitle().setFont(new Font("张海山锐线体简", Font.BOLD, 30));
		// 得到3D饼图的plot对象
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));
		// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})"));
		// 设置背景色为白色
		chart.setBackgroundPaint(Color.white);
		// 指定图片的透明度(0.0-1.0)
		plot.setForegroundAlpha(0.5f);
		// 指定显示的饼图上圆形(false)还椭圆形(true)
		plot.setCircular(true);

		plot.setLabelFont(new Font("张海山锐线体简", Font.BOLD, 16));
		chart.getLegend().setItemFont(new Font("张海山锐线体简", Font.PLAIN, 16));
	}

}
