package org.great.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.great.biz.AuthBiz;
import org.great.entity.Authority;
import org.great.entity.Menu;
import org.great.entity.Role;
import org.great.entity.RoleMenu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Auth")
public class AuthAction extends BaseAction
{
	@Resource()
	private AuthBiz authbiz;
	private Authority auth;
	private List<Role> rolelist = new ArrayList<Role>();
	private List<Authority> authlist = new ArrayList<Authority>();

	List<Menu> MenuOnelist = null;

	// ������ж����˵�
	List<Menu> MenuTwolist = null;

	// ���δ��һ���˵�
	List<Menu> MenuNOnelist = null;

	// ���δ�ж����˵�
	List<Menu> MenuNTwolist = null;

	@RequestMapping(value = "/findrole.action")
	public ModelAndView findallrole(Role role, HttpServletRequest request, ModelAndView mv)
	{
		System.out.println("查找所有角色");
		// new 一个biz
		rolelist = authbiz.findrole(role);

		System.out.println(rolelist);
		// 判断结果
		if (rolelist.size() > 0)
		{
			request.setAttribute("rolelist", rolelist);
			mv.setViewName("/AutMag");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/findroleauth.action")
	public ModelAndView findroleauth(int rid, HttpServletRequest request, ModelAndView mv)
	{
		/*
		 * System.out.println("查找角色权限"); // new 一个biz //authlist =
		 * authbiz.findroleauth(rid); MenuOnelist = authbiz.GetMenuOnelist(rid);
		 * MenuTwolist = authbiz.GetMenuOnelist(rid); MenuNOnelist =
		 * authbiz.GetMenuNOnelist(rid); MenuNTwolist = authbiz.GetMenuNTwolist(rid);
		 * System.out.println(MenuOnelist); System.out.println(MenuTwolist);
		 * System.out.println(MenuNOnelist); System.out.println(MenuNTwolist); // 判断结果
		 * 
		 * request.setAttribute("MenuOnelist",MenuOnelist);
		 * request.setAttribute("MenuTwolist",MenuTwolist);
		 * request.setAttribute("MenuNOnelist",MenuNOnelist);
		 * request.setAttribute("MenuNTwolist",MenuNTwolist);
		 * 
		 * mv.setViewName("/AutMag");
		 */
		return mv;
	}

	@RequestMapping(value = "/allot.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String allot(@RequestBody String yyy)
	{
		System.out.println(yyy);
		int y = Integer.valueOf(yyy.substring(4));
		System.out.println(y);
		List<Menu> MenuOnelist = authbiz.GetMenuOnelist(y);
		System.out.println(MenuOnelist);
		List<Map<String, Object>> mapList = menuToMap(MenuOnelist);
		JSONArray json = new JSONArray(mapList);
		return json.toString();

	}

	//

	@RequestMapping(value = "/unallot.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String unallot(@RequestBody String yyy)
	{
		System.out.println(yyy);
		int y = Integer.valueOf(yyy.substring(4));
		System.out.println(y);
		List<Menu> MenuNOnelist = authbiz.GetMenuNOnelist(y);
		System.out.println(MenuNOnelist);
		List<Map<String, Object>> mapList = menuToMap(MenuNOnelist);
		JSONArray json = new JSONArray(mapList);
		System.out.println(json);
		return json.toString();

	}

	@RequestMapping(value = "/GetMenuOnelist.action")
	public ModelAndView GetMenuOnelist(int rid, HttpServletRequest request, ModelAndView mv)
	{
		/*
		 * System.out.println("查找角色权限"); // new 一个biz MenuOnelist =
		 * authbiz.GetMenuTwolist(rid); System.out.println(MenuOnelist); // 判断结果 if
		 * (MenuOnelist.size() > 0) { request.setAttribute("MenuOnelist",MenuOnelist);
		 * mv.setViewName("/PermissionsMenu"); } else { mv.setViewName("Error"); }
		 */
		return mv;
	}

	

	@RequestMapping(value = "/GetMenuNOnelist.action")
	public ModelAndView GetMenuNOnelist(int rid, HttpServletRequest request, ModelAndView mv)
	{
		/*
		 * System.out.println("查找角色权限"); // new 一个biz MenuNOnelist =
		 * authbiz.GetMenuNOnelist(rid); System.out.println(MenuNOnelist); // 判断结果 if
		 * (MenuNOnelist.size() > 0) {
		 * request.setAttribute("MenuNOnelist",MenuNOnelist);
		 * mv.setViewName("/PermissionsMenu"); } else { mv.setViewName("Error"); }
		 */
		return mv;
	}

	
	@ResponseBody
	@RequestMapping(value="/addmenu.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	
	public String addMenu(@RequestBody RoleMenu rm,HttpServletRequest request) {
		String ret="请选择要添加的权限！";
		System.out.println("-----"+rm.toString()+"---"+ret+"----");
		
		boolean flag = false;
		
		if (rm.getMids()==null||rm.getMids()=="") {
			return ret;
		}
		int r_id = Integer.valueOf(rm.getRole_id());
		String[] menuids = rm.getMids().split(",");

		// 插入数据
		for (int i = 0; i < menuids.length; i++) {
			int m_id = Integer.valueOf(menuids[i]);
			
			// 如果有子节点就不插入
			rm.setMenu_id(m_id);
			rm.setRole_id(r_id);
			int count = authbiz.getCount(rm);
			if (count > 0) {
				continue;
			}
			
			flag = authbiz.addmenu(rm);
			System.out.println("插入数据菜单--" + m_id + "角色：" + r_id);
			
		}
		if(flag) {
			ret="添加成功";
		}else {
			ret="添加失败";
		}
		return ret;
	}

	@ResponseBody
	@RequestMapping(value="/removemenu.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	
	public String removeMenu( @RequestBody RoleMenu rm) {
		String ret="请选择要移除的权限！";
		System.out.println("-----"+rm.toString()+"---"+ret+"----");
		
		boolean flag = false;
		
		if (rm.getMids()==null||rm.getMids()=="") {
			return ret;
		}
		int r_id = Integer.valueOf(rm.getRole_id());
		String[] menuids = rm.getMids().split(",");

		// 插入数据
		for (int i = menuids.length - 1; i >= 0; i--) {
			int m_id = Integer.valueOf(menuids[i]);
			
			// 如果有子节点就不插入
			rm.setMenu_id(m_id);
			rm.setRole_id(r_id);
			int count = authbiz.getCount(rm);
			if (count > 0) {
				continue;
			}
			
			//没有子节点执行删除操作
			flag = authbiz.removemenu(rm);
			System.out.println("插入数据菜单--" + m_id + "角色：" + r_id+"--flag="+flag);
			
			if(flag) {
				ret="移除成功";
			}else {
				ret="移除失败";
			}
		}
		return ret;
	}
	private List<Map<String, Object>> menuToMap(List<Menu> menuList)
	{

		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		for (Menu menu : menuList)
		{
			Map<String, Object> node = new HashMap<String, Object>();

			node.put("id", menu.getMenu_id());
			node.put("name", menu.getMenu_name());
			node.put("pId", menu.getMenu_pid());

			if (menu.getMenu_pid() != 0)
			{
				mapList.add(node);
			} else
			{
				node.put("open", true);// 节点展开

				for (Menu m : menuList)
				{
					if (m.getMenu_pid() == menu.getMenu_id())
					{

						// 如果有子节点则添加
						mapList.add(node);
						break;
					}
				}
			}
		}
		return mapList;
	}
}
