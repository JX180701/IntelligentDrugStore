package org.great.entity;

//使用说明
public class Direction
{
	private int direction_id;
	private int direction_num;// 用量
	private int direction_time;// 每日次数
	private String direction_describe;// 用法描述

	@Override
	public String toString()
	{
		return "Direction [direction_id=" + direction_id + ", direction_num=" + direction_num + ", direction_time="
				+ direction_time + ", direction_describe=" + direction_describe + "]";
	}

	public int getDirection_id()
	{
		return direction_id;
	}

	public void setDirection_id(int direction_id)
	{
		this.direction_id = direction_id;
	}

	public int getDirection_num()
	{
		return direction_num;
	}

	public void setDirection_num(int direction_num)
	{
		this.direction_num = direction_num;
	}

	public int getDirection_time()
	{
		return direction_time;
	}

	public void setDirection_time(int direction_time)
	{
		this.direction_time = direction_time;
	}

	public String getDirection_describe()
	{
		return direction_describe;
	}

	public void setDirection_describe(String direction_describe)
	{
		this.direction_describe = direction_describe;
	}

	public Direction()
	{
		super();
	}

	public Direction(int direction_id, int direction_num, int direction_time, String direction_describe)
	{
		super();
		this.direction_id = direction_id;
		this.direction_num = direction_num;
		this.direction_time = direction_time;
		this.direction_describe = direction_describe;
	}
}
