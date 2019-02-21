package org.great.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.DrugStoreBiz;
import org.great.entity.Drug;
import org.great.entity.DrugStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stock")
public class StockHandler {
	@Resource
	DrugStoreBiz drugStoreBiz;
	@Resource
	DrugBiz drugBiz;
	@RequestMapping("/getAllThreshold.action")//获取所有药品预警线
	public ModelAndView getAllPrice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Drug> thresholdList=drugBiz.findAllDrug();
		for(int i=0;i<thresholdList.size();i++) {
			int x;
			int sum=0;//库存总数
			int id=thresholdList.get(i).getDrug_id();
			List<DrugStore> temp=drugStoreBiz.findDrugStoreByDrugId(id);
			for(int j=0;j<temp.size();j++) {
				x=Integer.parseInt(temp.get(j).getDrugstore_num());
				sum += x;
			}
			thresholdList.get(i).setDrug_sum(sum);
		}
		
		session.setAttribute("thresholdList", thresholdList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stock_drugStore_warning");
		return mav;
	}
	
	@SystemLog(operationType = "药房设置", operationName = "设置预警")
	@RequestMapping("/setThresholdById.action")//设置指定药品预警线
	@ResponseBody
	public String getPrice(HttpServletRequest request,String drug_threshold_store,int drug_id) {
		Drug drug=new Drug();
		drug.setDrug_threshold_store(drug_threshold_store);
		drug.setDrug_id(drug_id);
		int a=drugBiz.updateDrugThresholdStore(drug);
		if(a>0) {
			return "a";
		}else {
			return "b";
		}
	
	}
}
