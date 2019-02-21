package org.great.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.biz.DrugBiz;
import org.great.biz.DrugStoreBiz;
import org.great.biz.PriceLogBiz;
import org.great.biz.RequisitionBiz;
import org.great.entity.Drug;
import org.great.entity.DrugStore;
import org.great.entity.PriceLog;
import org.great.entity.Requisition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/statistics")
public class StatisticsHandler {
	@Resource
	DrugBiz drugBiz;
	@Resource
	PriceLogBiz priceLogBiz;
	@Resource
	DrugStoreBiz drugStoreBiz;
	@Resource
	RequisitionBiz requisitionBiz;
	@RequestMapping("/getAllPrice.action")//获取所有药品价格
	public ModelAndView getAllPrice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<Drug> drugList=drugBiz.findAllDrug();
		session.setAttribute("drugList", drugList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_price");
		return mav;
	}
	@RequestMapping("/getPriceLog.action")//获取药品价格详情
	public ModelAndView getPriceLog(HttpServletRequest request,int drug_id) {
		HttpSession session = request.getSession();
		
		List<PriceLog> priceLogList=priceLogBiz.getPriceLog(drug_id);
		session.setAttribute("priceLogList", priceLogList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_priceLog");
		return mav;
	}
	@RequestMapping("/getAllInventory.action")//获取所有药品库存
	public ModelAndView getDruginventory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<DrugStore> drugStoreInventoryList=drugStoreBiz.getDrugStoreInventory();
		session.setAttribute("drugStoreInventoryList", drugStoreInventoryList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_inventory");
		return mav;
	}
	@RequestMapping("/getAllBreakage.action")//获取所有药品报损明细
	public ModelAndView getAllBreakage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<Requisition> breakageRrquisitionList=requisitionBiz.getAllBreakageRrquisitionList();
		session.setAttribute("breakageRrquisitionList", breakageRrquisitionList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_breakage");
		return mav;
	}
//	@RequestMapping("/getAllCheck.action")//获取盘点盈亏
//	public ModelAndView getAllCheck(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		
//		List<PriceLog> priceLogList=priceLogBiz.getPriceLog(drug_id);
//		session.setAttribute("priceLogList", priceLogList);
//		
//		//跳转界面，进入下一个操作模块
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("statistics_drug_priceLog");
//		return mav;
//	}
}
