package org.great.entity;

//��ɫ�˵���
public class RoleMenu
{

	private int role_id;
	private int menu_id;
    private String  mids;
	public RoleMenu(int role_id, int menu_id, String mids)
	{
		super();
		this.role_id = role_id;
		this.menu_id = menu_id;
		this.mids = mids;
	}
	public RoleMenu()
	{
		super();
	}
	public int getRole_id()
	{
		return role_id;
	}
	public void setRole_id(int role_id)
	{
		this.role_id = role_id;
	}
	public int getMenu_id()
	{
		return menu_id;
	}
	public void setMenu_id(int menu_id)
	{
		this.menu_id = menu_id;
	}
	public String getMids()
	{
		return mids;
	}
	public RoleMenu(int role_id, String mids)
	{
		super();
		this.role_id = role_id;
		this.mids = mids;
	}
	public RoleMenu(int role_id, int menu_id)
	{
		super();
		this.role_id = role_id;
		this.menu_id = menu_id;
	}
	public void setMids(String mids)
	{
		this.mids = mids;
	}
	@Override
	public String toString()
	{
		return "RoleMenu [role_id=" + role_id + ", menu_id=" + menu_id + ", mids=" + mids + "]";
	}
	
}
