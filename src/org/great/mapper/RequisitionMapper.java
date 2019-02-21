package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.great.entity.Drug;
import org.great.entity.Requisition;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionMapper
{
	public List<Requisition> getAllBreakageRrquisitionList();
	public int addRequisition(Requisition requisition);
	public List<Requisition> findRequisition(String userid);
	public List<Requisition> select(Requisition requisition);
	public int modRequisition (Requisition requisition);
	public int removeRequisition (String id);
	public List<Drug> findPrice();

	public List<Requisition> lhFindRequest(Map map);
	
	public boolean updateState(Requisition requisition);
	
	public boolean updateNameTime(Requisition requisition);
}
