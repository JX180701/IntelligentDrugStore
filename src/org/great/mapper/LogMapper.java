package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.entity.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
	public int addLog(Log log);
	public List<Log> findAllLog();
	public List<Log> findByDate(Map map);
}
