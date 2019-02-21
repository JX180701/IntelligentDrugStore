package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.RoleMenu;
import org.great.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;
@Service("roleMenuBiz")
public class RoleMenuBizImpl implements RoleMenuBiz {
	@Resource
	private RoleMenuMapper roleMenuMapper;
	@Override
	public List<RoleMenu> getMenuListByRoleId(int role_id) {
		// TODO Auto-generated method stub
		return roleMenuMapper.getMenuListByRoleId(role_id);
	}

}
