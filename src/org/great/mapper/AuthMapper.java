package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.entity.Authority;
import org.great.entity.Menu;
import org.great.entity.Role;
import org.great.entity.RoleMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthMapper {
	public int addRole(Role role);

	public List<Role> findrole(Role role);

	public List<Authority> findroleauth(int rid);
	
	   public List<Menu>GetMenuOnelist(int rid);
	   /*public List<Menu>GetMenuTwolist(int rid);*/
	   public List<Menu>GetMenuNOnelist(int rid);
/*	   public List<Menu>GetMenuNTwolist(int rid);
*/
	public boolean removemenu(RoleMenu rm);
	public boolean addmenu(RoleMenu rm);
   
	public int getCount(RoleMenu rm);
	
}
