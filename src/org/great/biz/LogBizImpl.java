package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.entity.Log;
import org.great.mapper.LogMapper;
import org.springframework.stereotype.Service;

@Service("logBiz")
public class LogBizImpl implements LogBiz{

	@Resource
	LogMapper logMapper;
	
	@Override
	public int addLog(Log log) {
		// TODO Auto-generated method stub
		return logMapper.addLog(log);
	}

	@Override
	public List<Log> findAllLog() {
		// TODO Auto-generated method stub
		return logMapper.findAllLog();
	}

	@Override
	public List<Log> findByDate(Map map) {
		// TODO Auto-generated method stub
		return logMapper.findByDate(map);
	}

}
