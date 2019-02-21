package org.great.biz;

import java.util.List;

import org.great.entity.Sell;

public interface SellBiz {
	public List<Sell> getSellList();
	public List<Sell> unsold(String date);
	public List<Sell> getPsychotropicSellList();
	public boolean addSell(Sell sell);
	public  List<Sell> getSell(String drug_id);
}
