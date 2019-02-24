package org.great.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.great.aop.SystemLog;
import org.great.biz.DrugBiz;
import org.great.biz.InsuranceBiz;
import org.great.entity.Drug;
import org.great.entity.Insurance;
import org.great.entity.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//药品控制类
@Controller
@RequestMapping("/excel")
public class ExcelHandler {

	@Resource
	InsuranceBiz insuranceBiz;
	
	@Resource
	DrugBiz drugBiz;

	@SystemLog(operationType = "导入数据", operationName = "导入医保数据")
	@RequestMapping("/importInsurance.action")
	@ResponseBody
	public void importInsurance(MultipartFile file, HttpServletRequest request,HttpServletResponse response) {
		
		String fileName = file.getOriginalFilename();

		String root = request.getSession().getServletContext().getRealPath(File.separator);
		String path = root + "\\excel\\" + fileName;
		try {
			file.transferTo(new File(path));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExcelUtil excel = new ExcelUtil();
		Insurance insurance = new Insurance();
		try {
			List<Object> listType = excel.importBaseExcel(file, path, insurance);

			List<Insurance> ilist = insuranceBiz.findAllInsurance();

			for (int i = 0; i < listType.size(); i++) {
				Insurance insur = (Insurance) listType.get(i);
				String drug_name = insur.getDrug_name();
				for (int j = 0; j < ilist.size(); j++) {
					String drugName = ilist.get(j).getDrug_name();
					if (drugName.equals(drug_name)) {
						listType.remove(i);
						i--;
					}
				}
			}
			for (int i = 0; i < listType.size(); i++) {
				Insurance insur = (Insurance) listType.get(i);
				insuranceBiz.addInsurance(insur);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<script>");
		out.println("alert('导入医保信息成功');");
		out.println("location.href = '/pharmacy/insurance/findAllInsurance.action';");
		out.println("</script>");
		out.flush();
		out.close();
	}
	
	
	@SystemLog(operationType = "导入数据", operationName = "导入药品数据")
	@RequestMapping("/importDrug.action")
	@ResponseBody
	public void importDrug(MultipartFile file, HttpServletRequest request,HttpServletResponse response) {
		
		String fileName = file.getOriginalFilename();

		String root = request.getSession().getServletContext().getRealPath(File.separator);
		System.out.println(root);
		String path = root + "\\excel\\" + fileName;
		try {
			file.transferTo(new File(path));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExcelUtil excel = new ExcelUtil();
		Drug drug = new Drug();
		try {
			List<Object> listType = excel.importBaseExcel(file, path, drug);

			List<Drug> dlist = drugBiz.findAllDrug();

			for (int i = 0; i < listType.size(); i++) {
				Drug d = (Drug) listType.get(i);
				String drug_name = d.getDrug_name1();
				for (int j = 0; j < dlist.size(); j++) {
					String drugName = dlist.get(j).getDrug_name1();
					if (drugName.equals(drug_name)) {
						listType.remove(i);
						i--;
					}
				}
			}
			for (int i = 0; i < listType.size(); i++) {
				Drug d = (Drug) listType.get(i);
				drugBiz.addDrug(d);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<script>");
		out.println("alert('导入药品信息成功');");
		out.println("location.href = '/pharmacy/drug/searchDrug.action?page=drug_search';");
		out.println("</script>");
		out.flush();
		out.close();
	}
}
