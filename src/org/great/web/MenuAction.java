package org.great.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.biz.MenuBiz;
import org.great.biz.ParaBiz;
import org.great.biz.RoleBiz;
import org.great.biz.UserBiz;
import org.great.entity.Menu;
import org.great.entity.Para;
import org.great.entity.Role;
import org.great.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Menu")
public class MenuAction extends BaseAction
{
	@Resource
	private MenuBiz menubiz;

	private Menu menu;
	private List<Menu> menulist = new ArrayList<Menu>();
	
	
	

	public Menu getMenu()
	{
		return menu;
	}

	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

	@RequestMapping(value = "/findallmenu.action")
	public ModelAndView findallmenu(Menu menu, HttpServletRequest request, ModelAndView mv)
	{
		System.out.println("查找所有角色");
		// new 一个biz
		menulist = menubiz.findallmenu(menu);
		System.out.println(menulist);
		// 判断结果
		if (menulist.size() > 0)
		{
			request.setAttribute("menulist", menulist);
			mv.setViewName("/MenuMag");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}	
	
	@RequestMapping(value = "/insertmenu.action")
	public ModelAndView insertmenu(Menu menu, ModelAndView mv)
	{
		System.out.println("成功");
		// new 一个biz
		menubiz.insertmenu(menu);
	
			mv.setViewName("/MenuMag");
	
		return mv;
	}
	
	@RequestMapping(value = "/deletemenu.action")
	public ModelAndView deletemenu(int mid, ModelAndView mv)
	{
		System.out.println("删除参数");
		// new 一个biz
		menubiz.deletemenubyid(mid);
		// 判断结果
	

			mv.setViewName("/MenuMag");
		
			
			return mv;
		}
	
	@RequestMapping(value = "/findmenuinfo.action")
	public ModelAndView findmenuinfo(int mid, HttpServletRequest request, ModelAndView mv)
	{
		System.out.println("查找用户信息");
		// new 一个biz
		menu = menubiz.findmenuinfo(mid);
		System.out.println(menu);
		// 判断结果
		if (menu!=null)
		{
			request.setAttribute("menu", menu);
			System.out.println(menu);
			mv.setViewName("/UpdateMenu");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}
	
	@RequestMapping(value = "/specificfind.action")
	public ModelAndView specificfind(Menu menu, HttpServletRequest request, ModelAndView mv)
	{
		System.out.println("查找kkkkkk信息");
		// new 一个biz
		menulist = menubiz.specificfind(menu);
		System.out.println(menu);
		// 判断结果
		if (menu!=null)
		{
			request.setAttribute("menu", menu);
			
			mv.setViewName("/MenuMag");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}
	
	@RequestMapping(value = "/updatemenu.action")
	public ModelAndView updatemenu(Menu menu, ModelAndView mv,HttpSession session)
	{
		System.out.println(menu);
		
		System.out.println("修改角色");
		// new 一个biz
		menubiz.updatemenubyid(menu);
		// 判断结果
		System.out.println(menubiz.updatemenubyid(menu));
			mv.setViewName("/MenuMag");
			return mv;
	
			
		}
	
	
	
	
}


