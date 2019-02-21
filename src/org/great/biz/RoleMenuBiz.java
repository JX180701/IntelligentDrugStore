package org.great.biz;

import java.util.List;

import org.great.entity.RoleMenu;

public interface RoleMenuBiz {
	public List<RoleMenu> getMenuListByRoleId(int role_id);
}
