package org.great.biz;

import java.util.List;

import org.great.entity.Para;
import org.great.entity.Role;

public interface RoleBiz
{
	

	public List<Role> findallrole(Role role);

	public boolean insertrole(Role role);

	public boolean deleterolebyid(int rid);

	public boolean updaterolebyid(Role role);
	
	public Role findroleinfo(int rid);

	public List<Role> specificfind(Role role);

	public List<Role> finduseraut(Role role);

	
}
