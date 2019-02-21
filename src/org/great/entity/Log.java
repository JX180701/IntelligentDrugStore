package org.great.entity;

//��־��
public class Log
{
	private int log_id;
	private int user_id; // ��Աid
	private String log_thing; // ��������
	private String log_date; // ����ʱ��
	private User user;

	public Log()
	{
		super();
	}

	public Log(int log_id, int user_id, String log_thing, String log_date)
	{
		super();
		this.log_id = log_id;
		this.user_id = user_id;
		this.log_thing = log_thing;
		this.log_date = log_date;
	}

	public Log(int log_id, int user_id, String log_thing, String log_date, User user) {
		super();
		this.log_id = log_id;
		this.user_id = user_id;
		this.log_thing = log_thing;
		this.log_date = log_date;
		this.user = user;
	}

	public int getLog_id()
	{
		return log_id;
	}

	public void setLog_id(int log_id)
	{
		this.log_id = log_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public String getLog_thing()
	{
		return log_thing;
	}

	public void setLog_thing(String log_thing)
	{
		this.log_thing = log_thing;
	}

	public String getLog_date()
	{
		return log_date;
	}

	public void setLog_date(String log_date)
	{
		this.log_date = log_date;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Log [log_id=" + log_id + ", user_id=" + user_id + ", log_thing=" + log_thing + ", log_date=" + log_date
				+ ", user=" + user + "]";
	}

}
