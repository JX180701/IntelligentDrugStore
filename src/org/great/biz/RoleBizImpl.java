package org.great.biz;

import java.util.List;

import javax.annotation.Resource;
import org.great.entity.Role;
import org.great.mapper.RoleMapper;
import org.springframework.stereotype.Service;

@Service("roleBiz")
public class RoleBizImpl implements RoleBiz
{
	@Resource
	private RoleMapper roleMapper;


	

	@Override
	public List<Role>findallrole (Role role)
	{
		// TODO Auto-generated method stub
		return roleMapper.findallrole(role);
	}


	@Override
	public boolean insertrole(Role role)
	{
		// TODO Auto-generated method stub
		return roleMapper.insertrole(role);
	}
	@Override
	public boolean deleterolebyid(int rid)
	{
		// TODO Auto-generated method stub
		return roleMapper.deleterolebyid(rid);
	}
	
	@Override
	public boolean updaterolebyid(Role role)
	{
		// TODO Auto-generated method stub
		return roleMapper.updaterolebyid(role);
	}


	@Override
	public Role findroleinfo(int rid)
	{
		// TODO Auto-generated method stub
		return roleMapper.findroleinfo(rid);
	}


	@Override
	public List<Role> specificfind(Role role)
	{
		// TODO Auto-generated method stub
		return roleMapper.specificfind(role);
	}


	@Override
	public List<Role> finduseraut(Role role)
	{
		// TODO Auto-generated method stub
		return roleMapper.finduseraut(role);
	}


	
}
