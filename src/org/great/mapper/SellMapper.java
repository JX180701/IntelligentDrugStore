package org.great.mapper;

import java.util.List;

import org.great.entity.Sell;
import org.springframework.stereotype.Repository;

@Repository
public interface SellMapper {
	public int addSell(Sell sell);
	public List<Sell> getSellList();
	public List<Sell> unsalable(String date);
	public List<Sell> getPsychotropicSellList();
	public List<Sell> getSellList(String drug_id);
}
