package org.great.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.ParaBiz;
import org.great.biz.RoleBiz;
import org.great.biz.UserBiz;
import org.great.entity.Para;
import org.great.entity.Role;
import org.great.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Para")
public class ParaAction extends BaseAction {
	@Resource
	private ParaBiz parabiz;

	private Para para;
	private List<Para> paralist = new ArrayList<Para>();

	public Para getPara() {
		return para;
	}

	public void setPara(Para para) {
		this.para = para;
	}

	@RequestMapping(value = "/findallpara.action")
	public ModelAndView findallpara(Para para, HttpServletRequest request, ModelAndView mv) {
		paralist = parabiz.findallpara(para);
		if (paralist.size() > 0) {
			request.setAttribute("paralist", paralist);
			mv.setViewName("/ParaMag");
		} else {
			mv.setViewName("Error");
		}
		return mv;
	}

	@SystemLog(operationType = "参数管理", operationName = "添加参数")
	@RequestMapping(value = "/insertpara.action")
	public ModelAndView insertpara(Para para, ModelAndView mv) {
		parabiz.insertpara(para);

		mv.setViewName("/ParaMag");

		return mv;
	}

	@SystemLog(operationType = "参数管理", operationName = "删除参数")
	@RequestMapping(value = "/deletepara.action")
	public ModelAndView deletepara(int pid, ModelAndView mv) {
		parabiz.deleteparabyid(pid);
		mv.setViewName("/ParaMag");

		return mv;
	}

	@RequestMapping(value = "/findparainfo.action")
	public ModelAndView findparainfo(int pid, HttpServletRequest request, ModelAndView mv) {
		para = parabiz.findparainfo(pid);
		if (para != null) {
			request.setAttribute("para", para);
			mv.setViewName("/UpdatePara");
		} else {
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/specificfind.action")
	public ModelAndView specificfind(Para para, HttpServletRequest request, ModelAndView mv) {
		// new 涓�涓猙iz
		paralist = parabiz.specificfind(para);
		// 鍒ゆ柇缁撴灉
		if (para != null) {
			request.setAttribute("para", para);

			mv.setViewName("/ParaMag");
		} else {
			mv.setViewName("Error");
		}
		return mv;
	}

	@SystemLog(operationType = "参数管理", operationName = "更新参数")
	@RequestMapping(value = "/updatepara.action")
	public ModelAndView updatepara(Para para, ModelAndView mv, HttpSession session) {

		parabiz.updateparabyid(para);
		mv.setViewName("/ParaMag");
		return mv;
	}

}
