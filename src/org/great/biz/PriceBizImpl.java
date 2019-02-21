package org.great.biz;

import javax.annotation.Resource;

import org.great.entity.Price;
import org.great.mapper.PriceMapper;
import org.springframework.stereotype.Service;

@Service("priceBiz")
public class PriceBizImpl implements PriceBiz {
	
	@Resource
	PriceMapper priceMapper;
	
	@Override
	public int addPrice(Price price) {
		// TODO Auto-generated method stub
		return priceMapper.addPrice(price);
	}

	@Override
	public int updatePrice(Price price) {
		// TODO Auto-generated method stub
		return priceMapper.updatePrice(price);
	}

	

}
