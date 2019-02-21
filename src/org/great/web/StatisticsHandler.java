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
	@RequestMapping("/getAllPrice.action")//��ȡ����ҩƷ�۸�
	public ModelAndView getAllPrice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<Drug> drugList=drugBiz.findAllDrug();
		session.setAttribute("drugList", drugList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_price");
		return mav;
	}
	@RequestMapping("/getPriceLog.action")//��ȡҩƷ�۸�����
	public ModelAndView getPriceLog(HttpServletRequest request,int drug_id) {
		HttpSession session = request.getSession();
		
		List<PriceLog> priceLogList=priceLogBiz.getPriceLog(drug_id);
		session.setAttribute("priceLogList", priceLogList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_priceLog");
		return mav;
	}
	@RequestMapping("/getAllInventory.action")//��ȡ����ҩƷ���
	public ModelAndView getDruginventory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<DrugStore> drugStoreInventoryList=drugStoreBiz.getDrugStoreInventory();
		session.setAttribute("drugStoreInventoryList", drugStoreInventoryList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_inventory");
		return mav;
	}
	@RequestMapping("/getAllBreakage.action")//��ȡ����ҩƷ������ϸ
	public ModelAndView getAllBreakage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<Requisition> breakageRrquisitionList=requisitionBiz.getAllBreakageRrquisitionList();
		session.setAttribute("breakageRrquisitionList", breakageRrquisitionList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("statistics_drug_breakage");
		return mav;
	}
//	@RequestMapping("/getAllCheck.action")//��ȡ�̵�ӯ��
//	public ModelAndView getAllCheck(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		
//		List<PriceLog> priceLogList=priceLogBiz.getPriceLog(drug_id);
//		session.setAttribute("priceLogList", priceLogList);
//		
//		//��ת���棬������һ������ģ��
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("statistics_drug_priceLog");
//		return mav;
//	}
}
