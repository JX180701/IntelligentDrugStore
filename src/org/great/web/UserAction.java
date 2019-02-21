package org.great.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.great.aop.SystemLog;
import org.great.biz.UserBiz;
import org.great.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class UserAction extends BaseAction
{
	@Resource
	private UserBiz userbiz;

	private User user;
	private List<User> userlist = new ArrayList<User>();
	private List<User> useraut = new ArrayList<User>();

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@RequestMapping(value = "/findalluser.action")
	public ModelAndView findalluser(User user, HttpServletRequest request, ModelAndView mv)
	{
		userlist = userbiz.findalluser(user);
		if (userlist.size() > 0)
		{
			request.setAttribute("userlist", userlist);
			mv.setViewName("/UserMag");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}

	@SystemLog(operationType = "鐢ㄦ埛绠＄悊", operationName = "娣诲姞鐢ㄦ埛")
	@RequestMapping(value = "/insertuser.action")
	public ModelAndView insertuser(User user, ModelAndView mv)
	{
		userbiz.insertuser(user);
		mv.setViewName("/maintainuser");
		userlist = userbiz.findalluser(user);
		return mv;
	}

	@SystemLog(operationType = "鐢ㄦ埛绠＄悊", operationName = "鍒犻櫎鐢ㄦ埛")
	@RequestMapping(value = "/deleteuser.action")
	public  void deleteuser(int uid, ModelAndView mv,HttpServletResponse response)
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		
		userbiz.deleteuserbyid(uid);
		
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		out.println("<script>");
		out.println("alert('删除成功！');");
		out.println("location.href ='/pharmacy/User/findalluser.action';");
		out.println("</script>");
		out.flush();
		out.close();

	}
	@SystemLog(operationType = "鐢ㄦ埛绠＄悊", operationName = "淇敼鐢ㄦ埛")
	@RequestMapping(value = "/updateuser.action")
	public void updateuser(User user, ModelAndView mv, HttpSession session,HttpServletResponse response)
	{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		
		userbiz.updateuserbyid(user);
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		out.println("<script>");
		out.println("alert('修改成功！');");
		out.println("location.href ='/pharmacy/User/findalluser.action';");
		out.println("</script>");
		out.flush();
		out.close();
		
	}

	@RequestMapping(value = "/finduserinfo.action")
	public ModelAndView finduserinfo(int uid, HttpServletRequest request, ModelAndView mv)
	{
		user = userbiz.finduserinfo(uid);
		if (user != null)
		{
			request.setAttribute("user", user);
			mv.setViewName("/UpdateUser");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/specificfind.action")
	public ModelAndView finduserinfo(User user, HttpServletRequest request, ModelAndView mv)
	{
		userlist = userbiz.specificfind(user);
		if (user != null)
		{
			request.setAttribute("user", user);
			mv.setViewName("/UpdateUser");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/finduseraut.action")
	public ModelAndView finduseraut(User user, HttpServletRequest request, ModelAndView mv)
	{
		useraut = userbiz.finduseraut(user);
		if (useraut.size() > 0)
		{
			request.setAttribute("useraut", useraut);
			mv.setViewName("/useraut");
		} else
		{
			mv.setViewName("Error");
		}
		return mv;
	}

}
