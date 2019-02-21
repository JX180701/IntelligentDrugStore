package org.great.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.DirectionBiz;
import org.great.biz.DrugBiz;
import org.great.biz.InsuranceBiz;
import org.great.biz.LibraryBiz;
import org.great.biz.PriceBiz;
import org.great.entity.Direction;
import org.great.entity.Drug;
import org.great.entity.Insurance;
import org.great.entity.Library;
import org.great.entity.Price;
import org.great.entity.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//ҩƷ������
@Controller
@RequestMapping("/drug")
public class DrugHandler {
	
	@Resource
	DrugBiz drugBiz;
	@Resource
	DirectionBiz directionBiz;
	@Resource
	InsuranceBiz insuranceBiz;
	@Resource
	PriceBiz priceBiz;
	@Resource
	LibraryBiz libraryBiz;
	
	//��֤ҩƷ�Ƿ����
	@RequestMapping(value="/drugExist.action")
	@ResponseBody
	public String drugExist(String name){
		String result = "no";
		//�ж�ҩƷ�Ƿ����
		if(drugBiz.findByName(name)!=null) {
			result = "yes";
		}
		return result;
	}
	
	//���ҩƷ��Ϣ
	@SystemLog(operationType = "ҩƷ����", operationName = "���ҩƷ")
	@RequestMapping("/addDrug.action")
	public ModelAndView addDrug(HttpServletRequest request, Drug drug,Direction direction,Price price) {
		//���ҩƷ�۸�
		priceBiz.addPrice(price);
		int priceret = price.getPrice_id();
		//����÷�������Ϣ
		directionBiz.addDirection(direction);
		int directionret = direction.getDirection_id();
		
		//���ҩƷ��Ϣ
		drug.setDirection_id(directionret);
		drug.setPrice_id(priceret);
		drugBiz.addDrug(drug);
		
		HttpSession session = request.getSession();
		//��ȡ����ҩƷ��Ϣ����������������
		List<Drug> drugList = drugBiz.findAllDrug();
		
		session.setAttribute("drugList", drugList);
		session.setAttribute("drug", drug);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("drug_setTaboo");
		return mav;
	}
	
	
	//��ת������ҽ��ҳ�棬���ж��Ƿ�ҽ��
	@RequestMapping("/redirDrug.action")
	public ModelAndView redirDrug(int drug_id,String drug_name1) {
		
		//��ѯҽ����Ϣ
		List<Insurance> insuranceList = insuranceBiz.findAllInsurance();
		
		//�жϸ�ҩƷ�Ƿ�ҽ��ҩƷ
		String isInsurance = "no";
		Insurance insurance = null;
		
		Drug drug = drugBiz.findById(drug_id);
		
		for(Insurance i:insuranceList) {
			if(i.getDrug_name().equals(drug_name1)) {
				isInsurance = "yes";
				insurance = i;
			}
		}
		drug.setDrug_insurance(isInsurance);
		drugBiz.updateDrug(drug);
		
		//ҳ����ת
		ModelAndView mav = new ModelAndView();
		mav.addObject("insuranceList",insuranceList);
		mav.addObject("isInsurance",isInsurance);
		if(insurance!=null) {
			mav.addObject("insurance",insurance);
		}
		mav.setViewName("drug_setInsurance");
		return mav;
	}
	
	//��תҩƷ��ҳ
	@RequestMapping("/searchDrug.action")
	public ModelAndView redirDrug(String page) {
		
		//��ѯ����ҩƷ
		List<Drug> drugs = drugBiz.findAllDrug();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.setViewName(page);
		
		return mav;
	}
	
	//��ת��ѯ
	@RequestMapping("/searchConditionDrug.action")
	public ModelAndView redirDrug(String drug_name,String drug_special1,String drug_antibiotic,String drug_insurance) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("drug_name", drug_name);
		map.put("drug_special1", drug_special1);
		map.put("drug_antibiotic",drug_antibiotic);
		map.put("drug_insurance", drug_insurance);
		List<Drug> drugs = drugBiz.findByCondition(map);
		
		//��ѯ����ҩƷ
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.setViewName("drug_search");
		
		return mav;
	}
	//��ֵҳ����ת
	@RequestMapping("/toPage.action")
	public ModelAndView toPage(String page) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(page);
		
		return mav;
	}
	//�޸�ҳ����ת
	@RequestMapping("/toUpdateDrug.action")
	public ModelAndView toUpdateDrug(String page,int drug_id) {
		
		//����ҩƷ
		Drug drug = drugBiz.findById(drug_id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drug",drug);
		mav.setViewName(page);
		
		return mav;
	}
	
	//�޸�ҩƷ��Ϣ
	@SystemLog(operationType = "ҩƷ����", operationName = "�޸�ҩƷ")
	@RequestMapping("/updateDrug.action")
	public ModelAndView updateDrug(HttpServletRequest request, Drug drug,Direction direction,Price price) {
		
		//�޸ļ۸�
		priceBiz.updatePrice(price);
		//�޸��÷�������Ϣ
		directionBiz.updateDirection(direction);
		//�޸�ҩƷ
		drugBiz.updateDrug(drug);
		
		Drug udrug = drugBiz.findById(drug.getDrug_id());
		
		HttpSession session = request.getSession();
		//��ȡ����ҩƷ��Ϣ����������������
		List<Drug> drugList = drugBiz.findAllDrug();
		
		session.setAttribute("drugList", drugList);
		session.setAttribute("drug", udrug);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("drug_setTaboo");
		return mav;
	}
	
	@RequestMapping("/updateLibraryThreshold.action")
	@ResponseBody
	public String updateLibraryThreshold(int drug_id,String drug_threshold_library) {
		String message = "no";
		int ret = drugBiz.updateLibraryThreshold(drug_id, drug_threshold_library);
		if(ret>0) {
			message = "yes";
		}
		
		return message;
	}
	
	//��תҩƷԤ��ҳ��
	@RequestMapping("/toThresholdLibrary.action")
	public ModelAndView toThresholdLibrary(String page) {
		
		//��ѯ����ҩƷ
		List<Drug> drugList = drugBiz.findAllDrug();
		List<Drug> drugs = new ArrayList<Drug>();
		
		for(int i=0;i<drugList.size();i++) {
			Drug drug = drugList.get(i);
			int count = 0;
			List<Library> libraryList =  libraryBiz.findByDrugId(drug.getDrug_id());
			for(int j=0;j<libraryList.size();j++) {
				Library library = libraryList.get(j);
				count += Integer.valueOf(library.getLibrary_num());
			}
			drug.setDrug_sum(count);
			drugs.add(drug);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.setViewName(page);
		
		return mav;
	}
}
