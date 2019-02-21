package org.great.entity;

//盘点表
public class Check
{
	private int check_id;// 盘点id
	private String check_count;// 计算库存
	private String check_reality;// 实际库存
	private String check_target;// 目标盈利
	private String check_profit;// 实际盈利
	private String check_value;// 盈亏数额

	@Override
	public String toString()
	{
		return "Check [check_id=" + check_id + ", check_count=" + check_count + ", check_reality=" + check_reality
				+ ", check_target=" + check_target + ", check_profit=" + check_profit + ", check_value=" + check_value
				+ "]";
	}

	public int getCheck_id()
	{
		return check_id;
	}

	public void setCheck_id(int check_id)
	{
		this.check_id = check_id;
	}

	public String getCheck_count()
	{
		return check_count;
	}

	public void setCheck_count(String check_count)
	{
		this.check_count = check_count;
	}

	public String getCheck_reality()
	{
		return check_reality;
	}

	public void setCheck_reality(String check_reality)
	{
		this.check_reality = check_reality;
	}

	public String getCheck_target()
	{
		return check_target;
	}

	public void setCheck_target(String check_target)
	{
		this.check_target = check_target;
	}

	public String getCheck_profit()
	{
		return check_profit;
	}

	public void setCheck_profit(String check_profit)
	{
		this.check_profit = check_profit;
	}

	public String getCheck_value()
	{
		return check_value;
	}

	public void setCheck_value(String check_value)
	{
		this.check_value = check_value;
	}

	public Check()
	{
		super();
	}

	public Check(int check_id, String check_count, String check_reality, String check_target, String check_profit,
			String check_value)
	{
		super();
		this.check_id = check_id;
		this.check_count = check_count;
		this.check_reality = check_reality;
		this.check_target = check_target;
		this.check_profit = check_profit;
		this.check_value = check_value;
	}

}
