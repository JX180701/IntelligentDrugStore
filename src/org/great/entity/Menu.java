package org.great.entity;

//菜单表
public class Menu
{
	private int menu_id;
	private int menu_pid; // 菜单父id
	private String menu_name; // 菜单名
	private String menu_url; // 菜单路径
	private Menu menu;

	public Menu()
	{
		super();
	}

	public Menu(int menu_id, int menu_pid, String menu_name, String menu_url)
	{
		super();
		this.menu_id = menu_id;
		this.menu_pid = menu_pid;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
	}

	public int getMenu_id()
	{
		return menu_id;
	}

	public void setMenu_id(int menu_id)
	{
		this.menu_id = menu_id;
	}

	public int getMenu_pid()
	{
		return menu_pid;
	}

	public void setMenu_pid(int menu_pid)
	{
		this.menu_pid = menu_pid;
	}

	public String getMenu_name()
	{
		return menu_name;
	}

	public void setMenu_name(String menu_name)
	{
		this.menu_name = menu_name;
	}

	public String getMenu_url()
	{
		return menu_url;
	}

	public void setMenu_url(String menu_url)
	{
		this.menu_url = menu_url;
	}

	@Override
	public String toString()
	{
		return "Menu [menu_id=" + menu_id + ", menu_pid=" + menu_pid + ", menu_name=" + menu_name + ", menu_url="
				+ menu_url + "]";
	}
}
