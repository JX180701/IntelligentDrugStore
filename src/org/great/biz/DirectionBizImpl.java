package org.great.biz;

import javax.annotation.Resource;

import org.great.entity.Direction;
import org.great.mapper.DirectionMapper;
import org.springframework.stereotype.Service;

@Service("directionBiz")
public class DirectionBizImpl implements DirectionBiz {
	
	@Resource
	DirectionMapper directionMapper;
	
	public int addDirection(Direction direction) {
		return directionMapper.addDirection(direction);
	}

	@Override
	public int updateDirection(Direction direction) {
		// TODO Auto-generated method stub
		return directionMapper.updateDirection(direction);
	}
	
}
