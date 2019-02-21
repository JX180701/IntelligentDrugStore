package org.great.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.great.biz.RoleBiz;
import org.great.biz.UserBiz;
import org.great.entity.Role;
import org.great.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Role")
public class RoleAction extends BaseAction {
	@Resource
	private RoleBiz rolebiz;

	private Role role;
	private List<Role> rolelist = new ArrayList<Role>();

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@RequestMapping(value = "/findallrole.action")
	public ModelAndView findallrole(Role role, HttpServletRequest request, ModelAndView mv) {
		rolelist = rolebiz.findallrole(role);
		if (rolelist.size() > 0) {
			request.setAttribute("rolelist", rolelist);
			mv.setViewName("/RoleMag");
		} else {
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/insertrole.action")
	public ModelAndView insertrole(Role role, ModelAndView mv) {
		rolebiz.insertrole(role);

		mv.setViewName("/maintainuser");

		return mv;
	}

	@RequestMapping(value = "/deleterole.action")
	public ModelAndView deleterole(int rid, ModelAndView mv) {
		rolebiz.deleterolebyid(rid);
		mv.setViewName("/RoleMag");
		return mv;
	}

	@RequestMapping(value = "/findroleinfo.action")
	public ModelAndView finduserrole(int rid, HttpServletRequest request, ModelAndView mv) {
		role = rolebiz.findroleinfo(rid);
		if (role != null) {
			request.setAttribute("role", role);
			mv.setViewName("/UpdateRole");
		} else {
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/specificfind.action")
	public ModelAndView specificfind(Role role, HttpServletRequest request, ModelAndView mv) {
		rolelist = rolebiz.specificfind(role);
		if (role != null) {
			request.setAttribute("role", role);

			mv.setViewName("/RoleMag");
		} else {
			mv.setViewName("Error");
		}
		return mv;
	}

	@RequestMapping(value = "/updaterole.action")
	public ModelAndView updateuser(Role role, ModelAndView mv, HttpSession session) {

		rolebiz.updaterolebyid(role);
		mv.setViewName("/RoleMag");
		return mv;

	}

}
