package org.great.mapper;

import java.util.List;

import org.great.entity.RoleMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuMapper {
	public List<RoleMenu> getMenuListByRoleId(int role_id);//���ݽ�ɫid��ѯ��Ӧ�Ĳ˵��б�
}
