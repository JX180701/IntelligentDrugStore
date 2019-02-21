package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.great.biz.TypeBiz;
import org.great.entity.Drug;
import org.great.entity.Type;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//ҩƷ���Ϳ�����
@Controller
@RequestMapping("/type")
public class TypeHandler {
	
	@Resource
	private TypeBiz typeBiz;
	@Resource
	private DrugBiz durgBiz;
	
	//ҩƷ����--����ҩƷ��������
	@RequestMapping(value="/findAllType.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public String findAllType() {
		String types = "";
		List<Object> list = typeBiz.findAllType();
		ObjectMapper om = new ObjectMapper();
		try {
			types = om.writeValueAsString(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}
	
	//���ҩƷ����
	@SystemLog(operationType = "��������", operationName = "�������")
	@RequestMapping(value="/addType.action")
	@ResponseBody
	public void addType(Type type,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж�����id�Ƿ����
		int ret = typeBiz.addType(type);
		if(ret>0) {
			out.println("<script>");
			out.println("alert('������ͳɹ�');");
			out.println("location.href = '/pharmacy/type/findTypes.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//��������--������������
	@RequestMapping(value="/findTypes.action")
	public ModelAndView findTypes(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Object> typelist = typeBiz.findAllType();
		ModelAndView mav = new ModelAndView();
		session.setAttribute("typelist", typelist);
		session.setAttribute("types", typelist);
		mav.setViewName("type_search");
		return mav;
	}
	
	//������ѯ
	@RequestMapping("/searchConditionType.action")
	public ModelAndView searchConditionType(HttpServletRequest request,String type_pid) {
		HttpSession session = request.getSession();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("type_pid", type_pid);
		List<Type> types = null;
		
		
//		types = typeBiz.findByCondition(map);
		if(type_pid.equals("0")) {
			types = typeBiz.findAllType();
		}else {
			types = typeBiz.findByCondition(map);
		}
		
		ModelAndView mav = new ModelAndView();
		session.setAttribute("types", types);
		mav.setViewName("type_search");
		
		return mav;
	}
	
	//����ҳ����ת
	@RequestMapping("/toPage.action")
	public ModelAndView toPage(String page) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(page);
		return mav;
	}
	
	//�ж�ҩƷ�����Ƿ����
	@RequestMapping(value="/typeExist.action")
	@ResponseBody
	public String typeExist(String type_name){
		String msg = "no";
		//�ж������Ƿ����
		Type type = typeBiz.findByName(type_name);
		if(type!=null) {
			msg = "yes";
		}
		return msg;
	}
	
	//��ת�޸�����ҳ��
	@RequestMapping("toUpdateType.action")
	public ModelAndView toUpdateType(String page,Type type) {
		ModelAndView mav = new ModelAndView();
		List<Type> listType = typeBiz.findAllType();
		Type updateType = typeBiz.findById(type);
		mav.addObject("listType", listType);
		mav.addObject("updateType", updateType);
		mav.setViewName(page);
		return mav;
	}
	
	//�޸�����
	@SystemLog(operationType = "��������", operationName = "�޸�����")
	@RequestMapping(value="/updateType.action")
	@ResponseBody
	public void updateType(Type type,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж�����id�Ƿ����
		int ret = typeBiz.updateType(type);
		if(ret>0) {
			out.println("<script>");
			out.println("alert('�޸����ͳɹ�');");
			out.println("location.href = '/pharmacy/type/findTypes.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//ɾ������
	@SystemLog(operationType = "��������", operationName = "ɾ������")
	@RequestMapping(value="/deleteType.action")
	@ResponseBody
	public void deleteType(int type_id,HttpServletResponse response){

		//ɾ�����࣬����ҩƷ�����ڸ÷����ҩƷ���ֶ���Ϊ��
		List<Drug> drugList = durgBiz.findAllDrug();
		for(Drug drug:drugList) {
			if(drug.getType_id() == type_id) {
				drug.setType_id(0);
				durgBiz.updateDrug(drug);
			}
		}
		int ret = typeBiz.deleteById(type_id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж�����id�Ƿ����
		if(ret>0) {
			out.println("<script>");
			out.println("alert('ɾ�����ͳɹ�');");
			out.println("location.href = '/pharmacy/type/findTypes.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
	
	//ɾ��һ��������
	@SystemLog(operationType = "��������", operationName = "ɾ������")
	@RequestMapping(value="/deleteSomeTypes.action")
	@ResponseBody
	public void deleteSomeTypes(int type_id,HttpServletResponse response){

		List<Type> typeList = typeBiz.findAllType();
		List<Drug> drugList = durgBiz.findAllDrug();
		for(Type type:typeList) {
			if(type.getType_pid()==type_id) {
				for(Drug drug:drugList) {
					if(drug.getType_id() == type.getType_id()) {
						drug.setType_id(0);
						durgBiz.updateDrug(drug);
					}
				}
				typeBiz.deleteById(type.getType_id());
			}
		}
		int ret = typeBiz.deleteById(type_id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ж�����id�Ƿ����
		if(ret>0) {
			out.println("<script>");
			out.println("alert('ɾ������ɹ�');");
			out.println("location.href = '/pharmacy/type/findTypes.action';");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}
}
