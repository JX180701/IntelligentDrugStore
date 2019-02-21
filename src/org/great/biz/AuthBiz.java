package org.great.biz;

import java.util.List;

import org.great.entity.Menu;
import org.great.entity.Authority;
import org.great.entity.Para;
import org.great.entity.Role;
import org.great.entity.RoleMenu;

public interface AuthBiz
{

	public List<Role> findrole(Role role);

	public List<Authority> findroleauth(int rid);

	public List<Menu> GetMenuOnelist(int rid);

	public List<Menu> GetMenuNOnelist(int rid);
	

	public boolean removemenu(RoleMenu rm);

	public boolean addmenu(RoleMenu rm);

	public int getCount(RoleMenu rm);
}
