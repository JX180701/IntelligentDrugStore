package org.great.biz;

import java.util.List;

import org.great.entity.PriceLog;

public interface PriceLogBiz {
	public List<PriceLog> getPriceLog(int drug_id);
	
}
