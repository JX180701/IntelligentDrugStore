package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.great.aop.SystemLog;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.DrugStoreBiz;
import org.great.biz.LibraryBiz;
import org.great.biz.RequisitionBiz;
import org.great.biz.SellBiz;
import org.great.biz.TabooBiz;
import org.great.entity.Drug;
import org.great.entity.DrugStore;
import org.great.entity.Library;
import org.great.entity.Sell;
import org.great.entity.Taboo;
import org.great.entity.User;
import org.great.quartz.Analysis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.sun.javafx.collections.MappingChange.Map;

@Controller
@RequestMapping("/drugstore")
public class DrugStoreHandler {
	private String result = "error";
	@Resource
	private DrugStoreBiz drugstorebiz;
	
	@Resource
	private RequisitionBiz requisitionBiz;
	@Resource
	private DrugBiz drugbiz;
	
	@Resource
	private LibraryBiz librarybiz;
	
	
	@Resource
	private TabooBiz taboobiz;
	
	@Resource
	private SellBiz sellbiz;

	@RequestMapping(value = "/dispatcher.action")
	public String Dispatcher(HttpServletRequest request) {

		return "distribute";

	}

	@RequestMapping(value = "/checkNum.action", method = RequestMethod.POST ,produces = "application/json;charset=utf-8" )
	@ResponseBody
	public String CheckNum(HttpServletRequest request, HttpServletResponse response, String amount, String drug ) {
		List<DrugStore> drugList=drugstorebiz.findById(Integer.parseInt(drug));
		int sum=0;
		
		if(drugList.size()>0) {
			for(DrugStore d:drugList) {
				sum=sum+Integer.parseInt(d.getDrugstore_num());
			}	
		}
		Drug d=drugbiz.findById(Integer.parseInt(drug));
		String unit=d.getDrug_unit2();
		
		Map<String, String> cond = new HashMap<String, String>();
		cond.put("drug_id", drug);
		cond.put("drug_name", "");
		cond.put("cost", "0");
		cond.put("retail", "0");
		List<Drug> list=requisitionBiz.selectPrice(cond);
		
		String price="";
		if(list.size()>0) {
			price=list.get(0).getPrice().getPrice_retail();
			
		}
		 Map<String, String> map = new HashMap<String, String>();
		 
		map.put("price", price+"元");
		map.put("sum", ""+sum+unit);
		 
		 String result="";
		 ObjectMapper om = new ObjectMapper();
		 try {
			result = om.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  result;	
		}
	
	@RequestMapping(value = "/checkBatch.action", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String CheckBatch(HttpServletRequest request, HttpServletResponse response,  String drug ) {
		List<DrugStore> drugList=drugstorebiz.findById(Integer.parseInt(drug));
		String sum="";
		
		if(drugList.size()>0) {
			for(DrugStore d:drugList) {
				sum=sum+d.getBatch()+",";
			}	
		}
		return ""+sum;	
		}
	@RequestMapping(value = "/checkAnalysis.action", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkAnalysis(HttpServletRequest request, HttpServletResponse response,  String drug ) {
		
		List<Sell> sellList=sellbiz.getSell(drug);
		List<Double> analysisList=new ArrayList<Double>();
		for(Sell s:sellList) {
			analysisList.add(Double.valueOf(s.getSell_num()));
		}
		Double modulus=0.40;
		Double predict=0.00;
		int result=0;
		
		predict=Analysis.getExpect(analysisList,1,modulus);
		if(predict!=null) {
			System.out.println(predict);
			result=predict.intValue();
		}
		return ""+result;	
		}
	
	@RequestMapping(value = "/checkLibrary.action", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String CheckLibrary(HttpServletRequest request, HttpServletResponse response,  String id ) {
		List<Library> libraryList=librarybiz.findAllLibrary();
		
		int sum=0;
		for(Library l :libraryList) {
			if(l.getDrug_id()==Integer.parseInt(id)) {
			sum=sum+Integer.parseInt(l.getLibrary_num());	
			}
		}
		
	
		return ""+sum;	
		}
	
	@SystemLog(operationType = "药房管理", operationName = "发药")
	@RequestMapping(value = "/sendDrug.action")
	public String sendDrug(HttpServletRequest request,HttpServletResponse response,String drug_id,String amount,String price) {
		List<DrugStore> drugList=drugstorebiz.findById(Integer.parseInt(drug_id));
		int num=Integer.parseInt(amount);
		int result=(-1)*num;
		String s="";
		HashMap<String,String> resultMap=new HashMap<String,String>();
		String date=getTimeFormat();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Sell sell=null;
		for(int flag=0;flag<drugList.size();flag++) {
			DrugStore drugstore=drugList.get(flag);
			result=Integer.parseInt(drugstore.getDrugstore_num())+result;
			if(!drugstore.getDrugstore_num().equals("0")) {
				if(result>0) {
					resultMap.put(drugstore.getBatch(),""+result);
					 sell=new Sell(drugstore.getDrugstore_id(),user.getUser_id(),amount,date,price,drug_id);
					sellbiz.addSell(sell);
					break;	
				}else {
					resultMap.put(drugstore.getBatch(),"0" );
					 sell=new Sell(drugstore.getDrugstore_id(),user.getUser_id(),amount,date,price,drug_id);
					sellbiz.addSell(sell);
				}
			}	
		}
		
		for (String batch:resultMap.keySet()) {
			drugstorebiz.sendDrug(batch, resultMap.get(batch));
		}
		List<Taboo> tabooList=taboobiz.findTaboo(drug_id);
		
		try {
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('发药成功')");
			for(Taboo t:tabooList) {
				s=t.getTaboo_discribe().trim();
				s="alert("+"'药品禁忌："+s+"'"+")"+";";
				out.println(s);
			}
		    out.println("</script>");
		    
		    out.flush();
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "distribute";
	}
	@RequestMapping(value = "/distribute.action")
	public String Distribute(HttpServletRequest request) {

		return "distribute";

	}

	@RequestMapping(value = "/showUseState.action")
	public String showUseState(HttpServletRequest request) {
		List<DrugStore> drugstorelist = drugstorebiz.showDrugStore();
		HttpSession session = request.getSession();
		String page=request.getParameter("page");
		session.setAttribute("drugstorelist", drugstorelist);
		
		if(page!=null) {
			return "check";
		}
		return "stopUse";

	}

	@SystemLog(operationType = "药房管理", operationName = "库存状态")
	@RequestMapping(value = "/changeUseState.action")
	public String changeUseState(HttpServletRequest request) {
		String state = request.getParameter("state");
		String batch = request.getParameter("batch");
		if (drugstorebiz.changeDrugState(batch, state)) {

			return showUseState(request);
		} else {
			return "error";
		}
	}
	@RequestMapping(value = "/changeNumber.action")
	public void changeNumber(HttpServletRequest request,HttpServletResponse response) {
		String result = request.getParameter("result");
		String batch = request.getParameter("batch");
		String direction=request.getParameter("direction");
		if (drugstorebiz.changeNumber(batch, result,direction)) {
			PrintWriter out;
			System.out.println("进来了");
			try {
				response.setContentType("text/html;charset=gb2312");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('盘点成功')");
				out.println("location.href = '/pharmacy/drugstore/showUseState.action?page=check';");
			    out.println("</script>");
			    
			    out.flush();
			    out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	@RequestMapping(value = "/condUseState.action")
	public String condUseState(HttpServletRequest request) {

		HttpSession session = request.getSession();
		int drug_id = Integer.parseInt(request.getParameter("drug"));
		String batch = request.getParameter("batch");
		String expiration = request.getParameter("expiration");
		String drugname =request.getParameter("drug_name");
		String alert=request.getParameter("alert");
		
		
		HashMap<String, Object> cond = new HashMap<String, Object>();
		cond.put("drug", drug_id);
		cond.put("batch", batch);
		cond.put("expiration", expiration);
		cond.put("drugname", drugname);
		
		List<DrugStore> drugstorelist = drugstorebiz.selectDrugStore(cond);
		
		session.setAttribute("drugstorelist", drugstorelist);
		if(alert!=null) {
			return "check";
		}
		return "stopUse";
	}
	
	private String getTimeFormat() {
		Long l = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = formatter.format(l);
		return timeString;
	}
}
