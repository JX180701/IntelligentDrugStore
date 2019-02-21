package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.entity.Log;

public interface LogBiz
{
	public int addLog(Log log);
	public List<Log> findAllLog();
	public List<Log> findByDate(Map map);
}
