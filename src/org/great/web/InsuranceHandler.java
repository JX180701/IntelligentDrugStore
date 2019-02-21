package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.InsuranceBiz;
import org.great.entity.Drug;
import org.great.entity.Insurance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/insurance")
public class InsuranceHandler {
	
	@Resource
	InsuranceBiz insuranceBiz;
	
	@Resource
	DrugBiz drugBiz;
	
	//查询所有医保
	@RequestMapping("/findAllInsurance.action")
	public ModelAndView findAllInsurance(HttpServletRequest request) {
		
		List<Insurance> insuranceList = insuranceBiz.findAllInsurance();
		
		HttpSession session = request.getSession();
		session.setAttribute("insurances", insuranceList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Insurance_search");
		mav.addObject("insuranceList",insuranceList);
		return mav;
	}
	
	//添加医保
	@SystemLog(operationType = "医保管理", operationName = "添加医保")
	@RequestMapping("/addInsurance.action")
	@ResponseBody
	public void addInsurance(Insurance insurance,HttpServletResponse response) {
		
		//添加医保药品
		int ret = insuranceBiz.addInsurance(insurance);

		//判断某药品是否是医保药品，若是，则更改药品信息为医保
		Drug drug = drugBiz.findByName(insurance.getDrug_name());
		if(drug!=null) {
			drug.setDrug_insurance("yes");
			drugBiz.updateDrug(drug);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ret>0) {
			out.println("<script>");
			out.println("alert('添加医保成功');");
			out.println("location.href = '/pharmacy/insurance/findAllInsurance.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	@RequestMapping("/insuranceExist.action")
	@ResponseBody
	public String insuranceExist(String drug_name) {
		String ret = "";
		Insurance insurance = insuranceBiz.findByName(drug_name);
		if(insurance==null) {
			ret = "no";
		}else {
			ret = "yes";
		}
		return ret;
	}
	
	@RequestMapping("/toPage.action")
	public ModelAndView toPage(String page) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(page);
		return mav;
	}
	
	//删除医保药品
	@SystemLog(operationType = "医保管理", operationName = "删除医保")
	@RequestMapping("/deleteInsurance.action")
	@ResponseBody
	public void deleteInsurance(int insurance_id,HttpServletResponse response) {
		//查找要删除的医保药品
		Insurance insurance = insuranceBiz.findById(insurance_id);
		//修改药品表中该药品的医保信息
		Drug drug = drugBiz.findByName(insurance.getDrug_name());
		if(drug!=null) {
			drug.setDrug_insurance("no");
			drugBiz.updateDrug(drug);
		}
		//删除医保药品
		String msg = "no";
		int ret = insuranceBiz.deleteById(insurance_id);
		String url = "/pharmacy/insurance/findAllInsurance.action";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ret>0) {
			msg = "已将"+insurance.getDrug_name()+"移除！";
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("location.href = '/pharmacy/insurance/findAllInsurance.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//修改医保药品名
	@SystemLog(operationType = "医保管理", operationName = "修改医保")
	@RequestMapping("/updateInsuranceName.action")
	@ResponseBody
	public String updateInsuranceName(int insurance_id,String drug_name,String changeValue) {
		
		//修改医保信息
		Insurance insurance = insuranceBiz.findById(insurance_id);
		insurance.setDrug_name(changeValue);
		int ret = insuranceBiz.updateInsurance(insurance);
		String msg = "no";
		if(ret>0) {
			msg = "yes";
		}
		//修改药品中原来的医保信息
		//移除原来药品的医保信息
		Drug drug = drugBiz.findByName(drug_name);
		if(drug!=null) {
			drug.setDrug_insurance("no");
			drugBiz.updateDrug(drug);
		}
		
		//添加修改后的医保信息
		Drug afterDrug = drugBiz.findByName(changeValue);
		if(afterDrug!=null) {
			afterDrug.setDrug_insurance("yes");
			drugBiz.updateDrug(afterDrug);
		}
		
		return msg;
	}
	
	//修改医保药品编号
	@SystemLog(operationType = "医保管理", operationName = "修改医保")
	@RequestMapping("/updateInsuranceCode.action")
	@ResponseBody
	public String updateInsuranceCode(int insurance_id,String insurance_code,String changeValue) {
		
		//修改医保信息
		Insurance insurance = insuranceBiz.findById(insurance_id);
		insurance.setInsurance_code(changeValue);
		int ret = insuranceBiz.updateInsurance(insurance);
		String msg = "no";
		if(ret>0) {
			msg = "yes";
		}
		
		return msg;
	}
	
	//条件查询医保信息
	@RequestMapping("/searchConditionInsurance.action")
	public ModelAndView searchConditionInsurance(String drug_name) {
		List<Insurance> insuranceList = null;
		if(drug_name.equals("无")) {
			insuranceList = insuranceBiz.findAllInsurance();
		}else {
			Insurance insurance = insuranceBiz.findByName(drug_name);
			insuranceList = new ArrayList<Insurance>();
			insuranceList.add(insurance);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("insuranceList",insuranceList);
		mav.setViewName("Insurance_search");
		return mav;
	}
	
}
