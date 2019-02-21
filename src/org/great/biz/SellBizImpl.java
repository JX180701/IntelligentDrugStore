package org.great.biz;

import java.util.List;

import javax.annotation.Resource;

import org.great.entity.Sell;
import org.great.mapper.SellMapper;
import org.springframework.stereotype.Service;
@Service("sellBiz")
public class SellBizImpl implements SellBiz {
@Resource
SellMapper sellMapper;
	@Override
	public List<Sell> getSellList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Sell> unsold(String date) {
		// TODO Auto-generated method stub
		return sellMapper.unsalable(date);
	}
	@Override
	public List<Sell> getPsychotropicSellList() {
		// TODO Auto-generated method stub
		return sellMapper.getPsychotropicSellList();
	}
	@Override
	public boolean addSell(Sell sell) {
		// TODO Auto-generated method stub
		if(sellMapper.addSell(sell)>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Sell> getSell(String drug_id) {
		// TODO Auto-generated method stub
		return sellMapper.getSellList(drug_id);
	}

}
