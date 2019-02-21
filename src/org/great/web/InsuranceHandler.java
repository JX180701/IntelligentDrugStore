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
	
	//��ѯ����ҽ��
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
	
	//���ҽ��
	@SystemLog(operationType = "ҽ������", operationName = "���ҽ��")
	@RequestMapping("/addInsurance.action")
	@ResponseBody
	public void addInsurance(Insurance insurance,HttpServletResponse response) {
		
		//���ҽ��ҩƷ
		int ret = insuranceBiz.addInsurance(insurance);

		//�ж�ĳҩƷ�Ƿ���ҽ��ҩƷ�����ǣ������ҩƷ��ϢΪҽ��
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
			out.println("alert('���ҽ���ɹ�');");
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
	
	//ɾ��ҽ��ҩƷ
	@SystemLog(operationType = "ҽ������", operationName = "ɾ��ҽ��")
	@RequestMapping("/deleteInsurance.action")
	@ResponseBody
	public void deleteInsurance(int insurance_id,HttpServletResponse response) {
		//����Ҫɾ����ҽ��ҩƷ
		Insurance insurance = insuranceBiz.findById(insurance_id);
		//�޸�ҩƷ���и�ҩƷ��ҽ����Ϣ
		Drug drug = drugBiz.findByName(insurance.getDrug_name());
		if(drug!=null) {
			drug.setDrug_insurance("no");
			drugBiz.updateDrug(drug);
		}
		//ɾ��ҽ��ҩƷ
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
			msg = "�ѽ�"+insurance.getDrug_name()+"�Ƴ���";
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("location.href = '/pharmacy/insurance/findAllInsurance.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//�޸�ҽ��ҩƷ��
	@SystemLog(operationType = "ҽ������", operationName = "�޸�ҽ��")
	@RequestMapping("/updateInsuranceName.action")
	@ResponseBody
	public String updateInsuranceName(int insurance_id,String drug_name,String changeValue) {
		
		//�޸�ҽ����Ϣ
		Insurance insurance = insuranceBiz.findById(insurance_id);
		insurance.setDrug_name(changeValue);
		int ret = insuranceBiz.updateInsurance(insurance);
		String msg = "no";
		if(ret>0) {
			msg = "yes";
		}
		//�޸�ҩƷ��ԭ����ҽ����Ϣ
		//�Ƴ�ԭ��ҩƷ��ҽ����Ϣ
		Drug drug = drugBiz.findByName(drug_name);
		if(drug!=null) {
			drug.setDrug_insurance("no");
			drugBiz.updateDrug(drug);
		}
		
		//����޸ĺ��ҽ����Ϣ
		Drug afterDrug = drugBiz.findByName(changeValue);
		if(afterDrug!=null) {
			afterDrug.setDrug_insurance("yes");
			drugBiz.updateDrug(afterDrug);
		}
		
		return msg;
	}
	
	//�޸�ҽ��ҩƷ���
	@SystemLog(operationType = "ҽ������", operationName = "�޸�ҽ��")
	@RequestMapping("/updateInsuranceCode.action")
	@ResponseBody
	public String updateInsuranceCode(int insurance_id,String insurance_code,String changeValue) {
		
		//�޸�ҽ����Ϣ
		Insurance insurance = insuranceBiz.findById(insurance_id);
		insurance.setInsurance_code(changeValue);
		int ret = insuranceBiz.updateInsurance(insurance);
		String msg = "no";
		if(ret>0) {
			msg = "yes";
		}
		
		return msg;
	}
	
	//������ѯҽ����Ϣ
	@RequestMapping("/searchConditionInsurance.action")
	public ModelAndView searchConditionInsurance(String drug_name) {
		List<Insurance> insuranceList = null;
		if(drug_name.equals("��")) {
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
