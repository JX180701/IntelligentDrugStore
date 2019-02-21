package org.great.mapper;

import org.great.entity.Price;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceMapper {
	public int addPrice(Price price);
	public int updatePrice(Price price);
	
}
