package org.great.web;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.great.biz.LibraryDetailBiz;
import org.great.biz.PurchaseBiz;
import org.great.entity.LibraryDetail;
import org.great.entity.Purchase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/libraryDetail")
public class Drug_LibraryDetail_Action
{
	@Resource
	private LibraryDetailBiz libraryDetailbiz;

	private LibraryDetail libraryDetail;

	@RequestMapping(value = "/findLibraryDetail.action")
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

		List<LibraryDetail> libraryDetailList = libraryDetailbiz.findAllLibraryDetail(map);

		session.setAttribute("libraryDetailList", libraryDetailList);

		mv.setViewName("/LibraryDetail");

		return mv;
	}

}
