package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
	public int addRole(Role role);

	

	public List<Role> findallrole(Role role);

	public boolean insertrole(@Param("role")Role role);
	
	public boolean deleterolebyid(int rid);
	
	public boolean updaterolebyid(Role role);

	public Role findroleinfo(int rid);

	public List<Role> specificfind(Role role);

	public List<Role> finduseraut(Role role);
}
