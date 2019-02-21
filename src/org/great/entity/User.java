package org.great.entity;

//Ա����
public class User {
	@Override
	public String toString()
	{
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", role_id="
				+ role_id + ", user_state=" + user_state + ", user_date=" + user_date + ", user_account=" + user_account
				+ ", role=" + role + "]";
	}
	private int 	user_id;		// ��Աid
	private String 	user_name;		// ��Ա����
	private String 	user_pwd;		// ��Ա����
	private int 	role_id;		// ��ɫid
	private String 	user_state;		// ״̬
	private String 	user_date;		// ��������
	private String 	user_account;	// ��½�˺�
	private Role role;
	public User(int user_id, String user_name, String user_pwd, int role_id, String user_state, String user_date,
			String user_account, Role role)
	{
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.role_id = role_id;
		this.user_state = user_state;
		this.user_date = user_date;
		this.user_account = user_account;
		this.role = role;
	}
	public User()
	{
		super();
	}
	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	public String getUser_pwd()
	{
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd)
	{
		this.user_pwd = user_pwd;
	}
	public int getRole_id()
	{
		return role_id;
	}
	public void setRole_id(int role_id)
	{
		this.role_id = role_id;
	}
	public String getUser_state()
	{
		return user_state;
	}
	public void setUser_state(String user_state)
	{
		this.user_state = user_state;
	}
	public String getUser_date()
	{
		return user_date;
	}
	public void setUser_date(String user_date)
	{
		this.user_date = user_date;
	}
	public String getUser_account()
	{
		return user_account;
	}
	public void setUser_account(String user_account)
	{
		this.user_account = user_account;
	}
	public Role getRole()
	{
		return role;
	}
	public void setRole(Role role)
	{
		this.role = role;
	}
	public User(String user_pwd, String user_account)
	{
		super();
		this.user_pwd = user_pwd;
		this.user_account = user_account;
	}

	

}
