package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Authority;
import org.great.entity.Menu;
import org.great.entity.Role;
import org.great.entity.RoleMenu;
import org.great.mapper.AuthMapper;
import org.great.mapper.RoleMapper;
import org.springframework.stereotype.Service;

@Service("authBiz")
public class AuthBizImpl implements AuthBiz
{
	@Resource
	private AuthMapper authMapper;


	@Override
	public List<Role>findrole (Role role)
	{
		// TODO Auto-generated method stub
		return authMapper.findrole(role);
	}
	

	@Override
	public List<Authority>findroleauth (int rid)
	{
		// TODO Auto-generated method stub
		return authMapper.findroleauth(rid);
	}


	@Override
	public List<Menu> GetMenuOnelist(int rid)
	{
		// TODO Auto-generated method stub
		return authMapper.GetMenuOnelist(rid);
	}


	/*@Override
	public List<Menu> GetMenuTwolist(int rid)
	{
		// TODO Auto-generated method stub
		return authMapper.GetMenuTwolist(rid);
	}*/


	@Override
	public List<Menu> GetMenuNOnelist(int rid)
	{
		// TODO Auto-generated method stub
		return authMapper.GetMenuNOnelist(rid);
	}


	

	@Override
	public boolean removemenu(RoleMenu rm)
	{
		// TODO Auto-generated method stub
		return authMapper.removemenu(rm);
	}


	@Override
	public boolean addmenu(RoleMenu rm)
	{
		// TODO Auto-generated method stub
		return authMapper.addmenu(rm);
	}


	@Override
	public int getCount(RoleMenu rm)
	{
		// TODO Auto-generated method stub
		return authMapper.getCount(rm);
	}


	


	

	
	
}
