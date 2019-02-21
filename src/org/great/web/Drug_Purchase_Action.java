package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.LibraryBiz;
import org.great.biz.LibraryDetailBiz;
import org.great.biz.PurchaseBiz;
import org.great.entity.Drug;
import org.great.entity.Library;
import org.great.entity.LibraryDetail;
import org.great.entity.Purchase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/purchase")
public class Drug_Purchase_Action
{
	@Resource
	private LibraryDetailBiz libraryDetailbiz;

	@Resource
	private PurchaseBiz purchasebiz;
	
	@Resource
	private DrugBiz drugbiz;
	
	@Resource
	private LibraryBiz libraryBiz;
	
	


	@RequestMapping(value = "/findPurchase.action")
	public ModelAndView login(String date1, String date2, ModelAndView mv, HttpSession session)
	{
		if (date1 == null || date1.equals(""))
		{
			date1= null;
		}
		if (date2 == null || date2.equals(""))
		{
			date2= null;
		}
		Map map = new HashMap<>();
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("id", null);
		
		List<Purchase> purchaseList = purchasebiz.findPurchase(map);

		session.setAttribute("purchaseList", purchaseList);

		mv.setViewName("/Drug_Purchase");

		return mv;
	}
	
	@RequestMapping(value = "/addPurchase.action")
	public ModelAndView login(ModelAndView mv, HttpSession session)
	{
		List<Drug> drugList = drugbiz.findAllDrug();

		session.setAttribute("drugList", drugList);

		mv.setViewName("/Drug_PurchasePut");

		return mv;
		
	}
	
	@SystemLog(operationType = "采购", operationName = "药品采购")
	@RequestMapping(value = "/adddPurchase.action")
	public void login(Purchase purchase,String threshold,String validity,ModelAndView mv, HttpSession session,HttpServletResponse response)
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		Long currenttime = System.currentTimeMillis();
		Date date = new Date(currenttime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		
		purchase.setPurchase_date(time);
		
		purchasebiz.addPurchase(purchase);
		
		Map map = new HashMap<>();
		map.put("date1", null);
		map.put("date2", null);
		map.put("id", null);
		List<Purchase> purchaseList = purchasebiz.findPurchase(map);
		
		Library library = new Library();
		
		
		library.setBatch(time);
		library.setDrug_id(purchase.getDrug_id());
		Library library2 = libraryBiz.findLibraryIdByDrugNameAndBatch(library);
		if (library2 != null)
		{
			int num = Integer.valueOf(library2.getLibrary_num());
			library2.setLibrary_num(""+(Integer.valueOf(purchase.getPurchase_num())+num));
			libraryBiz.updateLibrary(library2);
		}
		else
		{
			library.setLibrary_num(purchase.getPurchase_num());
			library.setLibrary_state("正常");
			library.setLibrary_threshold(threshold);
			library.setValidity(validity);
			library.setPurchase_id(purchaseList.get(purchaseList.size()-1).getPurchase_id());
			libraryBiz.addLibrary(library);
		}
		
		Library library3 = libraryBiz.findLibraryIdByDrugNameAndBatch(library);
		LibraryDetail libraryDetail = new LibraryDetail();
		libraryDetail.setLibrary_detail_num(purchase.getPurchase_num());
		libraryDetail.setLibrary_id(library3.getLibrary_id());
		libraryDetail.setLibrary_detail_price(library3.getDrug().getPrice().getPrice_cost());
		libraryDetail.setLibrary_detail_date(time);
		libraryDetail.setLibrary_detail_type("入库");
		System.out.println(libraryDetail);
		libraryDetailbiz.addLibraryDetail(libraryDetail);
		
		out.println("<script>");
		out.println("alert('添加成功！');");
		out.println("location.href = '/pharmacy/purchase/addPurchase.action';");
		out.println("</script>");
		out.flush();
		out.close();
		
	}
	

}
