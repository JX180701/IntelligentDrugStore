package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.PriceLog;
import org.great.mapper.PriceLogMapper;
import org.springframework.stereotype.Service;
@Service("priceLogBiz")
public class PriceLogBizImpl implements PriceLogBiz {
	@Resource
	PriceLogMapper priceLogMapper;
	@Override
	public List<PriceLog> getPriceLog(int drug_id) {
		// TODO Auto-generated method stub
		return priceLogMapper.searchPriceLogByDrugId(drug_id);
	}

}
