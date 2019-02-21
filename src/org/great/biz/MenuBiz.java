package org.great.biz;

import java.util.List;

import org.great.entity.Menu;
import org.great.entity.Para;

public interface MenuBiz
{
	

	public List<Menu> findallmenu(Menu menu);

	public boolean insertmenu(Menu menu);

	public boolean deletemenubyid(int mid);

	public boolean updatemenubyid(Menu menu);
	
	public Menu findmenuinfo(int mid);

	public List<Menu> specificfind(Menu menu);

	public List<Menu> finduseraut(Para para);
}
