package org.great.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.biz.LogBiz;
import org.great.entity.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/log")
public class LogHandler {

	@Resource
	LogBiz logBiz;

	// 查找所有日志
	@RequestMapping(value = "/findAllLog.action")
	public ModelAndView findAllLog() {
		ModelAndView mav = new ModelAndView();
		List<Log> logList = logBiz.findAllLog();
		mav.setViewName("log_search");
		mav.addObject("logList", logList);
		return mav;
	}

	// 按日期查找日志
	@RequestMapping(value = "/findByDate.action")
	public ModelAndView findByDate(String date1,String date2) {
		ModelAndView mav = new ModelAndView();
		
		if (date1 == null || date1.equals(""))
		{
			date1= null;
		}else {
			date1 += " 00:00:00";
		}
		if (date2 == null || date2.equals(""))
		{
			date2= null;
		}else {
			date2 += " 23:59:59";
		}
		
		Map map = new HashMap<>();
		map.put("date1", date1);
		map.put("date2", date2);
		
		List<Log> logList = logBiz.findByDate(map);
		
		mav.setViewName("log_search");
		mav.addObject("logList", logList);
		return mav;
	}
}
