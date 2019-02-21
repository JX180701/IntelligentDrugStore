package org.great.entity;

public class Authority
{
	private int aut_id;
	private String aut_name;
	private int aut_pid;
	private String aut_pname;

	private Menu menu;
    private Role role;
	public Authority(int aut_id, String aut_name, int aut_pid, String aut_pname, Menu menu, Role role)
	{
		super();
		this.aut_id = aut_id;
		this.aut_name = aut_name;
		this.aut_pid = aut_pid;
		this.aut_pname = aut_pname;
		this.menu = menu;
		this.role = role;
	}
	public Authority()
	{
		super();
	}
	public int getAut_id()
	{
		return aut_id;
	}
	public void setAut_id(int aut_id)
	{
		this.aut_id = aut_id;
	}
	public String getAut_name()
	{
		return aut_name;
	}
	public void setAut_name(String aut_name)
	{
		this.aut_name = aut_name;
	}
	public int getAut_pid()
	{
		return aut_pid;
	}
	public void setAut_pid(int aut_pid)
	{
		this.aut_pid = aut_pid;
	}
	public String getAut_pname()
	{
		return aut_pname;
	}
	public void setAut_pname(String aut_pname)
	{
		this.aut_pname = aut_pname;
	}
	public Menu getMenu()
	{
		return menu;
	}
	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}
	public Role getRole()
	{
		return role;
	}
	public void setRole(Role role)
	{
		this.role = role;
	}
	@Override
	public String toString()
	{
		return "Authority [aut_id=" + aut_id + ", aut_name=" + aut_name + ", aut_pid=" + aut_pid + ", aut_pname="
				+ aut_pname + ", menu=" + menu + ", role=" + role + "]";
	}
	
}
