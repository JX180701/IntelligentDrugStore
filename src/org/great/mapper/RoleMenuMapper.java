package org.great.mapper;

import java.util.List;

import org.great.entity.RoleMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuMapper {
	public List<RoleMenu> getMenuListByRoleId(int role_id);//根据角色id查询对应的菜单列表
}
