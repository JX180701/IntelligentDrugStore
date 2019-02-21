package org.great.entity;

//参数表
public class Para
{
	private int para_id;
	private int para_pid;// 参数父id
	private String para_name;// 参数名
	private String para_value;// 参数值

	public Para()
	{
		super();
	}

	public Para(int para_id, int para_pid, String para_name, String para_value)
	{
		super();
		this.para_id = para_id;
		this.para_pid = para_pid;
		this.para_name = para_name;
		this.para_value = para_value;
	}

	public int getPara_id()
	{
		return para_id;
	}

	public void setPara_id(int para_id)
	{
		this.para_id = para_id;
	}

	public int getPara_pid()
	{
		return para_pid;
	}

	public void setPara_pid(int para_pid)
	{
		this.para_pid = para_pid;
	}

	public String getPara_name()
	{
		return para_name;
	}

	public void setPara_name(String para_name)
	{
		this.para_name = para_name;
	}

	public String getPara_value()
	{
		return para_value;
	}

	public void setPara_value(String para_value)
	{
		this.para_value = para_value;
	}

	@Override
	public String toString()
	{
		return "Para [para_id=" + para_id + ", para_pid=" + para_pid + ", para_name=" + para_name + ", para_value="
				+ para_value + "]";
	}
}
