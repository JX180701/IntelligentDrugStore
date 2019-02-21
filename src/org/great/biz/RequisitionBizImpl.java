package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.great.biz.RequisitionBiz;
import org.great.entity.Drug;
import org.great.entity.PriceLog;
import org.great.entity.Requisition;
import org.great.mapper.DrugMapper;
import org.great.mapper.PriceLogMapper;
import org.great.mapper.RequisitionMapper;
import org.springframework.stereotype.Service;
@Service("requisitionBizImpl")
public class RequisitionBizImpl implements RequisitionBiz {
	@Resource
	RequisitionMapper requisitionMapper;
	
	@Resource
	DrugMapper drugMapper;
	
	@Resource
	PriceLogMapper priceLogMapper;
	
	RowBounds rb;
	
	@Override
	public List<Requisition> getAllBreakageRrquisitionList() {
		// TODO Auto-generated method stub
		return requisitionMapper.getAllBreakageRrquisitionList();
	}
	@Override
	public boolean takeDrug( Requisition requisition) {
		// TODO Auto-generated method stub
		int ret=requisitionMapper.addRequisition(requisition);
		if(ret!=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Requisition> selectRequisition(Requisition requisition) {
		// TODO Auto-generated method stub
		return requisitionMapper.select(requisition);
	}

	@Override
	public List<Requisition> allRequisition(String userid) {
		// TODO Auto-generated method stub
		return requisitionMapper.findRequisition(userid);
	}

	@Override
	public boolean changeRequisition(Requisition requisition) {
		// TODO Auto-generated method stub
		int ret=requisitionMapper.modRequisition(requisition);
		if(ret!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRequisition(String id) {
		// TODO Auto-generated method stub
		int ret=requisitionMapper.removeRequisition(id);
		if(ret!=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Drug> showPrice() {
		// TODO Auto-generated method stub
		return drugMapper.findPrice();
	}

	@Override
	public boolean changePrice(PriceLog pricelog) {
		// TODO Auto-generated method stub
		int ret= priceLogMapper.addPriceLog(pricelog);
		if(ret!=0) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<Drug> selectPrice(Map cond) {
		// TODO Auto-generated method stub
		return drugMapper.condPrice(cond);
	}

	@Override
	public List<Drug> ajaxPrice(String name) {
		// TODO Auto-generated method stub
		return drugMapper.ajaxFindName(name);
	}
	@Override
	public List<Requisition> lhFindRequest(Map map)
	{
		return requisitionMapper.lhFindRequest(map);
	}
	@Override
	public boolean updateState(Requisition requisition)
	{
		return requisitionMapper.updateState(requisition);
	}
	@Override
	public boolean updateNameTime(Requisition requisition)
	{
		// TODO Auto-generated method stub
		return requisitionMapper.updateNameTime(requisition);
	}

}
