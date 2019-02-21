package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import org.great.biz.LibraryBiz;
import org.great.biz.LibraryDetailBiz;
import org.great.biz.PurchaseBiz;
import org.great.biz.RequisitionBiz;
import org.great.entity.Drug;
import org.great.entity.Library;
import org.great.entity.LibraryDetail;
import org.great.entity.Purchase;
import org.great.entity.Requisition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exitDrug")
public class Drug_Exit_Action
{

	@Resource
	private RequisitionBiz requisitionbiz;

	@Resource
	private DrugBiz drugbiz;

	@Resource
	private LibraryBiz libraryBiz;

	@Resource
	private LibraryDetailBiz libraryDetailBiz;

	private Drug drug;

	private Library library;

	@SystemLog(operationType = "退厂", operationName = "退药申请")
	@RequestMapping(value = "/exitDrugRequest.action")
	public void exitDrugRequest(LibraryDetail libraryDetail, ModelAndView mv, HttpSession session,
			HttpServletResponse response)
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		String time = sdf.format(date);

		Library libraryy = libraryBiz.findLibraryIdByDrugNameAndBatch(libraryDetail.getLibrary());
		
		int numOld = Integer.valueOf(libraryy.getLibrary_num());
		int num = Integer.valueOf(libraryDetail.getLibrary_detail_num());

		int numnew = numOld - num;

		if (numnew < 0)
		{
			out.println("<script>");
			out.println("alert('退厂失败，请输入正确的数字');");
			out.println("location.href = '/pharmacy/exitDrug/drugExit.action';");
			out.println("</script>");
			out.flush();
			out.close();
		} else
		{
			libraryy.setLibrary_num(""+numnew);


			libraryDetail.setLibrary_id(
					libraryBiz.findLibraryIdByDrugNameAndBatch(libraryDetail.getLibrary()).getLibrary_id());

			libraryDetail.setLibrary(libraryBiz.findLibraryIdByDrugNameAndBatch(libraryDetail.getLibrary()));

			libraryDetail.setLibrary_detail_price(libraryDetail.getLibrary().getDrug().getPrice().getPrice_cost());

			libraryDetail.setLibrary_detail_date(time);

			libraryDetail.setLibrary_detail_type("退换产家");
			System.out.println(libraryDetailBiz);
			libraryDetailBiz.addLibraryDetail(libraryDetail);



			// 退厂成功减少库存
			libraryBiz.updateLibrary(libraryy);
			
			out.println("<script>");
			out.println("alert('退厂成功');");
			out.println("location.href = '/pharmacy/exitDrug/drugExit.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

	@RequestMapping(value = "/drugExit.action")
	public ModelAndView no(ModelAndView mv, HttpSession session)
	{
		List<Drug> drugList = drugbiz.findAllDrug();
		
		Library library4 = new Library();

		library4.setDrug_id(Integer.valueOf(drugList.get(0).getDrug_id()));

		List<Library> libraryListt = libraryBiz.findLibraryIdByDrugNameAndBatchList(library4);
		
		session.setAttribute("libraryListt", libraryListt);
		
		session.setAttribute("drugList", drugList);

		mv.setViewName("/Drug_Exit");

		return mv;
	}

	@RequestMapping(value = "/second.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String second(HttpServletRequest request, HttpServletResponse response, String drugId)
	{

		library = new Library();

		library.setDrug_id(Integer.valueOf(drugId));

		List<Library> libraryList = libraryBiz.findLibraryIdByDrugNameAndBatchList(library);

		String types = "";

		ObjectMapper om = new ObjectMapper();
		try
		{
			types = om.writeValueAsString(libraryList);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return types;
	}

}
