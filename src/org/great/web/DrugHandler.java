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

//药品控制类
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
	
	//验证药品是否存在
	@RequestMapping(value="/drugExist.action")
	@ResponseBody
	public String drugExist(String name){
		String result = "no";
		//判断药品是否存在
		if(drugBiz.findByName(name)!=null) {
			result = "yes";
		}
		return result;
	}
	
	//添加药品信息
	@SystemLog(operationType = "药品管理", operationName = "添加药品")
	@RequestMapping("/addDrug.action")
	public ModelAndView addDrug(HttpServletRequest request, Drug drug,Direction direction,Price price) {
		//添加药品价格
		priceBiz.addPrice(price);
		int priceret = price.getPrice_id();
		//添加用法用量信息
		directionBiz.addDirection(direction);
		int directionret = direction.getDirection_id();
		
		//添加药品信息
		drug.setDirection_id(directionret);
		drug.setPrice_id(priceret);
		drugBiz.addDrug(drug);
		
		HttpSession session = request.getSession();
		//读取所有药品信息，用于添加配伍禁忌
		List<Drug> drugList = drugBiz.findAllDrug();
		
		session.setAttribute("drugList", drugList);
		session.setAttribute("drug", drug);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("drug_setTaboo");
		return mav;
	}
	
	
	//跳转到设置医保页面，并判断是否医保
	@RequestMapping("/redirDrug.action")
	public ModelAndView redirDrug(int drug_id,String drug_name1) {
		
		//查询医保信息
		List<Insurance> insuranceList = insuranceBiz.findAllInsurance();
		
		//判断该药品是否医保药品
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
		
		//页面跳转
		ModelAndView mav = new ModelAndView();
		mav.addObject("insuranceList",insuranceList);
		mav.addObject("isInsurance",isInsurance);
		if(insurance!=null) {
			mav.addObject("insurance",insurance);
		}
		mav.setViewName("drug_setInsurance");
		return mav;
	}
	
	//跳转药品首页
	@RequestMapping("/searchDrug.action")
	public ModelAndView redirDrug(String page) {
		
		//查询所有药品
		List<Drug> drugs = drugBiz.findAllDrug();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.setViewName(page);
		
		return mav;
	}
	
	//跳转查询
	@RequestMapping("/searchConditionDrug.action")
	public ModelAndView redirDrug(String drug_name,String drug_special1,String drug_antibiotic,String drug_insurance) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("drug_name", drug_name);
		map.put("drug_special1", drug_special1);
		map.put("drug_antibiotic",drug_antibiotic);
		map.put("drug_insurance", drug_insurance);
		List<Drug> drugs = drugBiz.findByCondition(map);
		
		//查询所有药品
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.setViewName("drug_search");
		
		return mav;
	}
	//无值页面跳转
	@RequestMapping("/toPage.action")
	public ModelAndView toPage(String page) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(page);
		
		return mav;
	}
	//修改页面跳转
	@RequestMapping("/toUpdateDrug.action")
	public ModelAndView toUpdateDrug(String page,int drug_id) {
		
		//查找药品
		Drug drug = drugBiz.findById(drug_id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("drug",drug);
		mav.setViewName(page);
		
		return mav;
	}
	
	//修改药品信息
	@SystemLog(operationType = "药品管理", operationName = "修改药品")
	@RequestMapping("/updateDrug.action")
	public ModelAndView updateDrug(HttpServletRequest request, Drug drug,Direction direction,Price price) {
		
		//修改价格
		priceBiz.updatePrice(price);
		//修改用法用量信息
		directionBiz.updateDirection(direction);
		//修改药品
		drugBiz.updateDrug(drug);
		
		Drug udrug = drugBiz.findById(drug.getDrug_id());
		
		HttpSession session = request.getSession();
		//读取所有药品信息，用于添加配伍禁忌
		List<Drug> drugList = drugBiz.findAllDrug();
		
		session.setAttribute("drugList", drugList);
		session.setAttribute("drug", udrug);
		
		//跳转界面，进入下一个操作模块
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
	
	//跳转药品预警页面
	@RequestMapping("/toThresholdLibrary.action")
	public ModelAndView toThresholdLibrary(String page) {
		
		//查询所有药品
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
