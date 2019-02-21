package org.great.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.great.entity.Menu;
import org.great.entity.Para;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper {
	public int addPara(Para para);

	

	public List<Menu> findallmenu(Menu menu);

	public boolean insertmenu(@Param("menu")Menu menu);
	
	public boolean deletemenubyid(int mid);
	
	public boolean updatemenubyid(Menu menu);

	public Menu findmenuinfo(int mid);

	public List<Menu> specificfind(Menu menu);

	public List<Menu> finduseraut(Para para);
}
