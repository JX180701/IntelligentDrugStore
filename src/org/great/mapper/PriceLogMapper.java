package org.great.mapper;

import java.util.List;

import org.great.entity.PriceLog;
import org.springframework.stereotype.Repository;
@Repository
public interface PriceLogMapper {
	public int addPriceLog(PriceLog priceLog);//��ӵ��ۼ�¼
	public List<PriceLog> searchPriceLogByDrugId(int drug_id);//����ҩƷid��ѯ���ۼ�¼
}
