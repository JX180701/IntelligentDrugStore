package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Menu;
import org.great.entity.Para;
import org.great.entity.Role;
import org.great.mapper.MenuMapper;
import org.great.mapper.ParaMapper;
import org.springframework.stereotype.Service;

@Service("menuBiz")
public class MenuBizImpl implements MenuBiz
{
	@Resource
	private MenuMapper menuMapper;


	

	@Override
	public List<Menu>findallmenu (Menu menu)
	{
		// TODO Auto-generated method stub
		return menuMapper.findallmenu(menu);
	}


	@Override
	public boolean insertmenu(Menu menu)
	{
		// TODO Auto-generated method stub
		return menuMapper.insertmenu(menu);
	}
	@Override
	public boolean deletemenubyid(int mid)
	{
		// TODO Auto-generated method stub
		return menuMapper.deletemenubyid(mid);
	}
	
	@Override
	public boolean updatemenubyid(Menu menu)
	{
		// TODO Auto-generated method stub
		return menuMapper.updatemenubyid(menu);
	}


	@Override
	public Menu findmenuinfo(int mid)
	{
		// TODO Auto-generated method stub
		return menuMapper.findmenuinfo(mid);
	}


	@Override
	public List<Menu> specificfind(Menu menu)
	{
		// TODO Auto-generated method stub
		return menuMapper.specificfind(menu);
	}


	@Override
	public List<Menu> finduseraut(Para para)
	{
		// TODO Auto-generated method stub
		return null;
	}


	


	


	
}
