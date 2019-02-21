package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.TabooBiz;
import org.great.entity.Drug;
import org.great.entity.Taboo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/taboo")
public class TabooHandler {
	
	@Resource
	private TabooBiz tabooBiz;
	
	@Resource
	private DrugBiz drugBiz;
	
	//Ìí¼ÓÒ©Æ·Ê±Ìí¼ÓÅäÎé½û¼É
	@SystemLog(operationType = "ÅäÎé½û¼É", operationName = "Ìí¼Ó½û¼É")
	@RequestMapping("/addTaboo.action")
	@ResponseBody
	public String addTaboo(Taboo taboo) {
		
		//Ìí¼ÓÅäÎé½û¼É
		int ret = tabooBiz.addTaboo(taboo);
		
		return "success";
	}
	
	//²éÕÒËùÓĞÅäÎé½û¼É
	@RequestMapping("/findAllTaboo.action")
	public ModelAndView findAllTaboo(String page) {
		List<Drug> drugs = drugBiz.findAllDrug();
		List<Taboo> taboos = tabooBiz.findAllTaboo();
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.addObject("taboos", taboos);
		mav.setViewName(page);
		return mav;
	}
	
	//¸ü¸ÄÅäÎéÃèÊö
	@SystemLog(operationType = "ÅäÎé½û¼É", operationName = "¸ü¸Ä½û¼É")
	@RequestMapping("/updateTaboo.action")
	@ResponseBody
	public String updateTaboo(String tempValue,String changeValue) {
		Taboo taboo = tabooBiz.findByDiscribe(tempValue);
		taboo.setTaboo_discribe(changeValue);
		int ret = tabooBiz.updateTaboo(taboo);
		String retvalue = "no";
		if(ret>0) {
			retvalue="yes";
		}
		return retvalue;
	}
	
	//Ìø×ªÌí¼ÓÅäÎé½û¼ÉÒ³Ãæ
	@RequestMapping("/toAppendPage.action")
	public ModelAndView toAppendPage(String page) {
		List<Drug> drugs = drugBiz.findAllDrug();
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.setViewName(page);
		return mav;
	}
	
	//ÅĞ¶ÏÅäÎé½û¼ÉÊÇ·ñ´æÔÚ
	@RequestMapping("/tabooExist.action")
	@ResponseBody
	public String tabooExist(Taboo taboo) {
		String result = "yes";
		if(tabooBiz.findByOption(taboo)==null) {
			result = "no";
		}
		return result;
	}
	
	//Ìí¼ÓÅäÎé½û¼É
	@SystemLog(operationType = "ÅäÎé½û¼É", operationName = "Ìí¼Ó½û¼É")
	@RequestMapping("/appendTaboo.action")
	@ResponseBody
	public void appendTaboo(Taboo taboo,HttpServletResponse response) {
		int ret = tabooBiz.addTaboo(taboo);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ret>0) {
			out.println("<script>");
			out.println("alert('Ìí¼ÓÅäÎé³É¹¦');");
			out.println("location.href = '/pharmacy/taboo/toAppendPage.action?page=taboo_addTaboo';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//É¾³ıÅäÎé½û¼É
	@SystemLog(operationType = "ÅäÎé½û¼É", operationName = "É¾³ı½û¼É")
	@RequestMapping("/deleteTaboo.action")
	@ResponseBody
	public void deleteTaboo(Taboo taboo,HttpServletResponse response) {
		int ret = tabooBiz.deleteTaboo(taboo);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(ret>0) {
			out.println("<script>");
			out.println("alert('É¾³ıÅäÎé³É¹¦');");
			out.println("location.href = '/pharmacy/taboo/findAllTaboo.action?page=taboo_search';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//Ìõ¼ş²éÑ¯ÅäÎé½û¼É
	@RequestMapping("/searchConditionTaboo.action")
	public ModelAndView searchConditionTaboo(int drug_id1) {
		List<Taboo> taboos = null;
		if(drug_id1==0) {
			taboos = tabooBiz.findAllTaboo();
		}else {
			taboos = tabooBiz.searchConditionTaboo(drug_id1);
		}
		List<Drug> drugs = drugBiz.findAllDrug();
		ModelAndView mav = new ModelAndView();
		mav.addObject("drugs", drugs);
		mav.addObject("taboos", taboos);
		mav.setViewName("taboo_search");
		return mav;
	}
}
