package org.great.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.biz.DrugStoreBiz;
import org.great.biz.LibraryDetailBiz;
import org.great.biz.SellBiz;
import org.great.entity.DrugStore;
import org.great.entity.LibraryDetail;
import org.great.entity.Sell;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/psychotropic")
public class PsychotropicHandler {
	@Resource
	DrugStoreBiz drugStoreBiz;
	@Resource
	LibraryDetailBiz libraryDetailBiz;
	@Resource
	SellBiz sellBiz;
	@RequestMapping("/getPsychotropicInventory.action")//获取特殊药品库存
	public ModelAndView getAllInventory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<DrugStore> psychotropicStoreInventoryList=drugStoreBiz.getPsychotropicDrugStoreInventory();
		session.setAttribute("psychotropicStoreInventoryList", psychotropicStoreInventoryList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("psychotropic_inventory");
		return mav;
	}
	@RequestMapping("/getPsychotropicWarehousing.action")//获取特殊药品入库明细
	public ModelAndView getPsychotropicWarehousing(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<LibraryDetail> psychotropicLibraryDetailList=libraryDetailBiz.getPsychotropicLibraryDetailList();
		session.setAttribute("psychotropicLibraryDetailList",psychotropicLibraryDetailList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("psychotropic_warehousing");
		return mav;
	}
	@RequestMapping("/getPsychotropicSell.action")//获取特殊药品销售记录
	public ModelAndView getPsychotropicSell(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<Sell> psychotropicSellList=sellBiz.getPsychotropicSellList();
		session.setAttribute("psychotropicSellList", psychotropicSellList);
		
		//跳转界面，进入下一个操作模块
		ModelAndView mav = new ModelAndView();
		mav.setViewName("psychotropic_sell");
		return mav;
	}
}
