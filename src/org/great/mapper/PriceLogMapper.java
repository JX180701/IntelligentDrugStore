package org.great.mapper;

import java.util.List;

import org.great.entity.PriceLog;
import org.springframework.stereotype.Repository;
@Repository
public interface PriceLogMapper {
	public int addPriceLog(PriceLog priceLog);//添加调价记录
	public List<PriceLog> searchPriceLogByDrugId(int drug_id);//根据药品id查询调价记录
}
