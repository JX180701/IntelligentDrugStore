package org.great.mapper;

import org.great.entity.Direction;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionMapper {
	public int addDirection(Direction direction);
	public int updateDirection(Direction direction);
}
