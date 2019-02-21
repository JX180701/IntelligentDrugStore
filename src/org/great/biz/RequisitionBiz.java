package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.entity.Drug;
import org.great.entity.PriceLog;
import org.great.entity.Requisition;

public interface RequisitionBiz
{
	public List<Requisition> getAllBreakageRrquisitionList();

	public boolean takeDrug(Requisition requisition);

	public List<Requisition> selectRequisition(Requisition requisition);

	public List<Requisition> allRequisition(String userid);

	public boolean changeRequisition(Requisition requisition);

	public boolean updateState(Requisition requisition);
	
	public boolean deleteRequisition(String id);

	public List<Drug> showPrice();

	public List<Drug> ajaxPrice(String name);

	public List<Drug> selectPrice(Map cond);

	public boolean changePrice(PriceLog pricelog);

	public List<Requisition> lhFindRequest(Map map);
	
	public boolean updateNameTime(Requisition requisition);
}
