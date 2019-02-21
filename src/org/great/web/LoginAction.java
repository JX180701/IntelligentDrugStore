package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.RequisitionBiz;
import org.great.biz.RoleMenuBiz;
import org.great.biz.UserBiz;
import org.great.entity.Check;
import org.great.entity.RoleMenu;
import org.great.entity.User;
import org.great.mapper.CheckMapper;
import org.great.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Login")
public class LoginAction
{

	@Resource
	private RequisitionBiz requestBiz;

	@Resource
	private UserBiz userbiz;
	@Resource
	private RoleMenuBiz roleMenuBiz;
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	/*
	 * @Resource private CheckMapper checkMapper;
	 * 
	 * @RequestMapping(value = "/loginn.action") public String
	 * userinfo2(HttpServletRequest request,User user) {
	 * 
	 * return "index";
	 */
	@RequestMapping(value = "/Login.action")
	@SystemLog(operationType = "Áî®Êà∑ÁÆ°ÁêÜ", operationName = "Áî®Êà∑ÁôªÈôÜ")
	public ModelAndView login(User loginUser, ModelAndView mv, HttpSession session, HttpServletResponse response)
	{
		User user = userbiz.login(loginUser);
		if (user != null && user.getUser_state().equals("“—…æ≥˝") == false)
		{
			if (user.getRole_id() == 3)
			{
				Map map = new HashMap<>();
				map.put("date1", null);
				map.put("date2", null);
				map.put("id", null);
				int newnum = requestBiz.lhFindRequest(map).size();
				int oldnum = Integer.valueOf(user.getUser_date());
				int newreqnum = newnum - oldnum;
				session.setAttribute("newreqnum", newreqnum);
				user.setUser_date("" + newnum);
				userbiz.updateUserDate(user);
				session.setAttribute("role_id", 3);
			} else
			{
				session.setAttribute("role_id", null);
			}
			int role_id = userbiz.getRoleIdByUserId(user);
			List<RoleMenu> menuList = roleMenuBiz.getMenuListByRoleId(role_id);
			session.setAttribute("user", user);
			session.setAttribute("login_name", user.getUser_name());
			session.setAttribute("login_account", user.getUser_account());
			session.setAttribute("login_id", user.getUser_id());
			session.setAttribute("menuList", menuList);

			mv.setViewName("/Main");
			return mv;
		} else
		{
			PrintWriter out = null;
			try
			{
				out = response.getWriter();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			out.println("<script>");
			out.println("location.href = '/pharmacy'; alert('µ«¬º ß∞‹!')");
			out.println("</script>");
			out.flush();
			out.close();
			return null;
		}
	}
}
