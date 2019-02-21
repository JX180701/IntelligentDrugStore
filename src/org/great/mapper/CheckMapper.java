package org.great.mapper;

import org.great.entity.Check;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckMapper {
	public int addCheck(Check check);
}
