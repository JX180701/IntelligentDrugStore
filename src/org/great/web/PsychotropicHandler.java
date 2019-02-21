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
	@RequestMapping("/getPsychotropicInventory.action")//��ȡ����ҩƷ���
	public ModelAndView getAllInventory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<DrugStore> psychotropicStoreInventoryList=drugStoreBiz.getPsychotropicDrugStoreInventory();
		session.setAttribute("psychotropicStoreInventoryList", psychotropicStoreInventoryList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("psychotropic_inventory");
		return mav;
	}
	@RequestMapping("/getPsychotropicWarehousing.action")//��ȡ����ҩƷ�����ϸ
	public ModelAndView getPsychotropicWarehousing(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<LibraryDetail> psychotropicLibraryDetailList=libraryDetailBiz.getPsychotropicLibraryDetailList();
		session.setAttribute("psychotropicLibraryDetailList",psychotropicLibraryDetailList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("psychotropic_warehousing");
		return mav;
	}
	@RequestMapping("/getPsychotropicSell.action")//��ȡ����ҩƷ���ۼ�¼
	public ModelAndView getPsychotropicSell(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<Sell> psychotropicSellList=sellBiz.getPsychotropicSellList();
		session.setAttribute("psychotropicSellList", psychotropicSellList);
		
		//��ת���棬������һ������ģ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("psychotropic_sell");
		return mav;
	}
}
