package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.DrugStoreBiz;
import org.great.biz.LibraryBiz;
import org.great.biz.LibraryDetailBiz;
import org.great.biz.PriceBiz;
import org.great.biz.RequisitionBiz;
import org.great.entity.Drug;
import org.great.entity.DrugStore;
import org.great.entity.Library;
import org.great.entity.LibraryDetail;
import org.great.entity.Price;
import org.great.entity.PriceLog;
import org.great.entity.Purchase;
import org.great.entity.Requisition;
import org.great.entity.User;
import org.great.mapper.RequisitionMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/requisition")
public class RequisitionHandler
{

	private String result = "error";
	private List<Requisition> requestList = new ArrayList<Requisition>();

	@Resource
	private RequisitionBiz requisitionBiz;

	@Resource
	private DrugStoreBiz drugStoreBiz;
	
	@Resource
	private DrugBiz drugbiz;

	@Resource
	private LibraryBiz libraryBiz;
	
	@Resource
	private LibraryDetailBiz libraryDetailbiz;
	
	@Resource
	private PriceBiz priceBiz;
	
	@RequestMapping(value = "/Requisition.action")
	public String Requisition(HttpServletRequest request,HttpSession session) {

		List<Drug> drugList = drugbiz.findAllDrug();
		
		
		String page=request.getParameter("page");
		session.setAttribute("drugList", drugList);
		if(page.equals("batch")) {
			return "cancel";
		}else if(page.equals("predict")){
			return "analysis";
		}
		return "requisition";
	}
	
	@SystemLog(operationType = "申请管理", operationName = "添加申请")
	@RequestMapping(value = "/addRequisition.action")
	public String addRequisition(HttpServletRequest request, HttpServletResponse response,Requisition requisition) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String time = getTimeFormat();
		requisition.setRequisition_date1(time);
		requisition.setRequisition_state("待审核");
		requisition.setUser_id(user.getUser_id());
		
		
		// 填写申请时间
		
		if (requisitionBiz.takeDrug(requisition)) {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('成功提交申请');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			    out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "requisition";
		} else {
			return result;
		}
	}

	@RequestMapping(value = "/showRequisition.action")
	public String showRequisition(HttpServletRequest request, Requisition requisition) {
		HttpSession session = request.getSession();
		
		requestList = requisitionBiz.selectRequisition(requisition);
		session.setAttribute("requestList", requestList);

		return "showRequisition";
	}
	
	@RequestMapping(value = "/condRequisition.action")
	public String condRequisition(HttpServletRequest request, String drug,String requisition_state,String requisition_type,String requisition_date1) {
		
		Requisition requisition=new Requisition(Integer.parseInt(drug), requisition_state, requisition_date1, requisition_type);
		HttpSession session = request.getSession();
		requestList = requisitionBiz.selectRequisition(requisition);
		session.setAttribute("requestList", requestList);

		return "showRequisition";
	}

	@RequestMapping(value = "/deleteRequisition.action")
	@SystemLog(operationType = "申请管理", operationName = "删除申请")
	public void deleteRequisition(HttpServletRequest request,HttpServletResponse response,Requisition requisition) throws IOException {
		String requisition_id = request.getParameter("requisition_id");

		if (requisitionBiz.deleteRequisition(requisition_id)) {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('删除成功')");
				out.println("location.href = '/pharmacy/requisition/showRequisition.action';");
				out.println("</script>");
				out.flush();
			    out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 // 可通过String类型返回信息
		} 
		
	}
	@RequestMapping(value = "/changeRequisition.action")
	@SystemLog(operationType = "申请管理", operationName = "更改申请")
	public void modRequisition(HttpServletRequest request,HttpServletResponse response,Requisition requisition) {
		String[] array = request.getParameter("array").split(",");
		
		Requisition r=new Requisition(Integer.parseInt(array[0]),Integer.parseInt(array[1]), Integer.parseInt(array[2]), array[3], array[4], array[5], array[6], array[7],array[8]);
		
		if (requisitionBiz.changeRequisition(r)) {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('修改成功')");
				out.println("location.href = '/pharmacy/requisition/showRequisition.action';");
				out.println("</script>");
				out.flush();
			    out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
	}
	
	@RequestMapping(value = "/showPrice.action")
	public ModelAndView showPrice(HttpServletRequest request) {
		
		List<Drug> pricelist=requisitionBiz.showPrice();
		ModelAndView model =new ModelAndView();
		model.addObject("pricelist",pricelist);
		model.setViewName("changePrice");
		return model;
		
	}
	
	@RequestMapping(value = "/condPrice.action")

	public ModelAndView condPrice(HttpServletRequest request) {

		HashMap<String,Object> cond = new HashMap<String, Object>();
		
		String drugid=request.getParameter("drug");
		String drugname=request.getParameter("drug_name");
		String cost=request.getParameter("cost");
		String retail=request.getParameter("retail");
		
		int id=Integer.parseInt(drugid);
		cond.put("drug_id", id);
		cond.put("drug_name", drugname);
		cond.put("cost", cost);
		cond.put("retail", retail);
		
		List<Drug> pricelist=requisitionBiz.selectPrice(cond);
		
		ModelAndView model =new ModelAndView();
		model.addObject("pricelist",pricelist);
		model.setViewName("changePrice");
		return model;
		
	}
	
	@SystemLog(operationType = "价格管理", operationName = "调价")
	@RequestMapping(value = "/changePrice.action")
	public ModelAndView changePrice(HttpServletRequest request) {
		ModelAndView model =new ModelAndView();
		
		String oldprice=request.getParameter("oldprice");
		String newprice=request.getParameter("newprice");
		String drug_id=request.getParameter("drug_id");
		String price_id=request.getParameter("price_id");
		String time = getTimeFormat();
		Price p=new Price(Integer.parseInt(price_id),newprice);
		priceBiz.updatePrice(p);
		PriceLog pricelog=new PriceLog(Integer.parseInt(drug_id),oldprice,newprice,time,"待审核");
	
		if (requisitionBiz.changePrice(pricelog)) {
			model=showPrice(request);
			
		} 
		return model;
	}
	
	@RequestMapping(value = "/findDrugAjax.action", method = RequestMethod.GET,produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String findDrugAjax(HttpServletRequest request, HttpServletResponse response, String name) {
		List<Drug> drugList=requisitionBiz.ajaxPrice("%"+name+"%");
		
		String result="";
		for (Drug d:drugList) {
			result=result+d.getDrug_name1()+",";
		}
		
		return result;	
	}
	
	private String getTimeFormat() {
		Long l = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = formatter.format(l);
		return timeString;
	}

	@RequestMapping(value = "/lhFindRequest.action")
	public ModelAndView login(String date1, String date2, ModelAndView mv, HttpSession session)
	{
		if (date1 == null || date1.equals(""))
		{
			date1 = null;
		}
		if (date2 == null || date2.equals(""))
		{
			date2 = null;
		}
		Map map = new HashMap<>();
		map.put("date1", date1);
		map.put("date2", date2);

		List<Requisition> lhRequestList = requisitionBiz.lhFindRequest(map);

		session.setAttribute("lhRequestList", lhRequestList);

		mv.setViewName("/Drug_Request");

		return mv;
	}

	@SystemLog(operationType = "审核", operationName = "药品审核")
	@RequestMapping(value = "/auirequest.action")
	public void auirequest(String type, Requisition requisition, Library library, ModelAndView mv, HttpSession session,
			HttpServletResponse response)
	{
		Long currenttime = System.currentTimeMillis();
		Date date = new Date(currenttime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(date);

		requisition.setRequisition_date2(time);
		int loginId = (int) session.getAttribute("login_id");
		requisition.setAdmin_id(loginId);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 未通过
		if (type.equals("0"))
		{
			requisition.setRequisition_state("未通过");
			requisitionBiz.updateState(requisition);
			requisitionBiz.updateNameTime(requisition);

			out.println("<script>");
			out.println("location.href = '/pharmacy/requisition/lhFindRequest.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
		// 通过
		else
		{
			Map map = new HashMap<>();
			map.put("date1", null);
			map.put("date2", null);
			map.put("id", requisition.getRequisition_id());
			System.out.println("22");
			List<Requisition>  requisitionn = requisitionBiz.lhFindRequest(map);
			System.out.println("33");
			// 1.申请数量是多少
			int num1 = Integer.valueOf(requisition.getRequisition_num());
			if (requisitionn.get(0).getRequisition_type().equals("药品请领"))
			{

				// 2.该药品的所有批次的数量总和
				// int drugid = requisition.getDrug_id();
				// System.out.println("药品ID:"+drugid);

				List<Library> libraryList = libraryBiz.findLibraryIdByDrugNameAndBatchList(library);

				int num2 = 0;
				for (int i = 0; i < libraryList.size(); i++)
				{
					num2 += Integer.valueOf(libraryList.get(i).getLibrary_num());
				}

				int num3 = num2 - num1;

				// 3.数量够 审核通过
				if (num3 >= 0)
				{

					for (int i = 0; i < libraryList.size(); i++)
					{
						library = libraryList.get(i);
						int num4 = Integer.valueOf(libraryList.get(i).getLibrary_num());
						int num5 = num1 - num4;
						if (num5 <= 0)
						{
							library.setLibrary_num("" + (0 - num5));
							libraryBiz.updateLibrary(library);
							LibraryDetail libraryDetail = new LibraryDetail();
							libraryDetail.setLibrary_id(library.getLibrary_id());
							libraryDetail.setLibrary_detail_num(""+num1);
							libraryDetail.setLibrary_detail_price(library.getDrug().getPrice().getPrice_cost());
							libraryDetail.setLibrary_detail_date(time);
							libraryDetail.setLibrary_detail_type("出库");
							libraryDetailbiz.addLibraryDetail(libraryDetail);

							// 药房
							DrugStore drugStore = new DrugStore();
							drugStore.setDrug_id(library.getDrug_id());
							drugStore.setBatch(library.getBatch());
							DrugStore drugStore2 = drugStoreBiz.findDrugStoreByDrugNameAndBatch(drugStore);
							if (drugStore2 != null)
							{
								drugStore2
										.setDrugstore_num("" + (Integer.valueOf(drugStore2.getDrugstore_num()) + num1));
								drugStoreBiz.updateDrugStoreNum(drugStore2);
							} else
							{
								drugStore.setPurchase_id(library.getPurchase_id());
								drugStore.setValidity(library.getValidity());
								drugStore.setDrugstore_num("" + num1);
								drugStore.setDrugstore_threshold(library.getLibrary_threshold());
								drugStore.setDrugstore_state(library.getLibrary_state());
								drugStore.setDrug(library.getDrug());
								drugStore.setPurchase(library.getPurchase());

								drugStoreBiz.addDrugStore(drugStore);
							}
							break;
						} else
						{
							num1 = num5;
							library.setLibrary_num("0");
							libraryBiz.updateLibrary(library);
							
							LibraryDetail libraryDetail = new LibraryDetail();
							libraryDetail.setLibrary_id(library.getLibrary_id());
							libraryDetail.setLibrary_detail_num(""+num4);
							libraryDetail.setLibrary_detail_price(library.getDrug().getPrice().getPrice_cost());
							libraryDetail.setLibrary_detail_date(time);
							libraryDetail.setLibrary_detail_type("出库");
							libraryDetailbiz.addLibraryDetail(libraryDetail);

						}
					}
					requisitionBiz.updateNameTime(requisition);
					requisition.setRequisition_state("通过");
					requisitionBiz.updateState(requisition);
					out.println("<script>");
					out.println("alert('操作成功！');");
					out.println("location.href ='/pharmacy/requisition/lhFindRequest.action';");
					out.println("</script>");
					out.flush();
					out.close();
				}
				// 3.数量不够 审核不通过
				else
				{
					out.println("<script>");
					out.println("alert('库存不足');");
					out.println("location.href = '/pharmacy/requisition/lhFindRequest.action';");
					out.println("</script>");
					out.flush();
					out.close();
				}
				// 4.返回结果
			}else if (requisitionn.get(0).getRequisition_type().equals("药品退库"))
			{
				String batch = requisitionn.get(0).getRequisition_batch();
				int id = requisitionn.get(0).getDrug_id();
				System.out.println(id);
				System.out.println(batch);
				
				//药房库存减少
				DrugStore drugStore = new DrugStore();
				drugStore.setDrug_id(id);
				drugStore.setBatch(batch);
				drugStore = drugStoreBiz.findDrugStoreByDrugNameAndBatch(drugStore);
				System.out.println(drugStore);
				drugStore.setDrugstore_num(""+(Integer.valueOf(drugStore.getDrugstore_num())-num1));
				drugStoreBiz.updateDrugStoreNum(drugStore);
				
				
				//药库库存增加
				Library library2 = new Library();
				library2.setDrug_id(id);
				library2.setBatch(batch);
				library2 = libraryBiz.findLibraryIdByDrugNameAndBatch(library2);
				System.out.println(library2);
				library2.setLibrary_num(""+(num1+Integer.valueOf(library2.getLibrary_num())));
				libraryBiz.updateLibrary(library2);
				
				LibraryDetail libraryDetail = new LibraryDetail();
				libraryDetail.setLibrary_id(library2.getLibrary_id());
				libraryDetail.setLibrary_detail_num(""+num1);
				libraryDetail.setLibrary_detail_price(library2.getDrug().getPrice().getPrice_cost());
				libraryDetail.setLibrary_detail_date(time);
				libraryDetail.setLibrary_detail_type("入库");
				libraryDetailbiz.addLibraryDetail(libraryDetail);
				
				//
				requisitionBiz.updateNameTime(requisition);
				requisition.setRequisition_state("通过");
				requisitionBiz.updateState(requisition);
				out.println("<script>");
				out.println("alert('操作成功！');");
				out.println("location.href ='/pharmacy/requisition/lhFindRequest.action';");
				out.println("</script>");
				out.flush();
				out.close();
				
				
				
			}
			else if (requisitionn.get(0).getRequisition_type().equals("药品报损"))
			{
				System.out.println(requisitionn.get(0));
				String batch = requisitionn.get(0).getRequisition_batch();
				int id = requisitionn.get(0).getDrug_id();
				System.out.println(id);
				System.out.println(batch);
				
				//药房库存减少
				DrugStore drugStore = new DrugStore();
				drugStore.setDrug_id(id);
				drugStore.setBatch(batch);
				drugStore = drugStoreBiz.findDrugStoreByDrugNameAndBatch(drugStore);
				System.out.println(drugStore);
				drugStore.setDrugstore_num(""+(Integer.valueOf(drugStore.getDrugstore_num())-num1));
				
				System.out.println(requisition);
				requisitionBiz.updateNameTime(requisition);
				requisition.setRequisition_state("通过");
				System.out.println("-----");
				requisitionBiz.updateState(requisition);
				
				out.println("<script>");
				out.println("alert('操作成功！');");
				out.println("location.href ='/pharmacy/requisition/lhFindRequest.action';");
				out.println("</script>");
				out.flush();
				out.close();
			}
		}
	}
}
