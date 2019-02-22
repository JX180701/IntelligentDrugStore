package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.entity.Drug;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugMapper {
	public int addDrug(Drug drug);
	public List<Drug> findAllDrug();
	public Drug findById(int drug_id);
	public int updateDrug(Drug drug);
	public List<Drug> findByCondition(Map map);
	public Drug findByName(String name);
	public Drug getPriceByDrugId(Drug drug);//通过药品id查询价格详情
	public List<Drug> findPrice();
	public List<Drug> ajaxFindName(String name);
	public List<Drug> condPrice(Map cond);
	public int updateLibraryThreshold(int drug_id,String drug_threshold_library);
	public int updateDrugThresholdStore(Drug drug);
	public List<Drug> findAll();
	
}
