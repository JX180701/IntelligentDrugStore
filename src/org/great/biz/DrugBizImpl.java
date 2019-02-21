package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.entity.Drug;
import org.great.mapper.DrugMapper;
import org.springframework.stereotype.Service;

@Service("drugBiz")
public class DrugBizImpl implements DrugBiz {

	@Resource
	DrugMapper drugMapper;
	@Override
	public int addDrug(Drug drug) {
		// TODO Auto-generated method stub
		return drugMapper.addDrug(drug);
	}
	@Override
	public List<Drug> findAllDrug() {
		// TODO Auto-generated method stub
		return drugMapper.findAllDrug();
	}
	@Override
	public Drug findById(int drug_id) {
		// TODO Auto-generated method stub
		return drugMapper.findById(drug_id);
	}
	@Override
	public int updateDrug(Drug drug) {
		// TODO Auto-generated method stub
		return drugMapper.updateDrug(drug);
	}
	@Override
	public List<Drug> findByCondition(Map map) {
		// TODO Auto-generated method stub
		return drugMapper.findByCondition(map);
	}
	@Override
	public Drug findByName(String name) {
		// TODO Auto-generated method stub
		return drugMapper.findByName(name);
	}
	
	@Override
	public Drug getPriceByDrugId(Drug drug) {
		// TODO Auto-generated method stub
		return drugMapper.getPriceByDrugId(drug);
	}
	@Override
	public int updateLibraryThreshold(int drug_id, String drug_threshold_library) {
		// TODO Auto-generated method stub
		return drugMapper.updateLibraryThreshold(drug_id, drug_threshold_library);
	}
	@Override
	public int updateDrugThresholdStore(Drug drug) {
		// TODO Auto-generated method stub
		return drugMapper.updateDrugThresholdStore(drug);
	}
}
