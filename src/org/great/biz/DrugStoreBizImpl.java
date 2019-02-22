package org.great.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.great.entity.DrugStore;
import org.great.mapper.DrugStoreMapper;
import org.springframework.stereotype.Service;
@Service("drugStoreBiz")
public class DrugStoreBizImpl implements DrugStoreBiz {
	@Resource
	DrugStoreMapper drugStoreMapper;
	@Override
	public List<DrugStore> getDrugStoreInventory() {
		// TODO Auto-generated method stub
		return drugStoreMapper.getDrugStoreInventory();
	}

	@Override
	public List<DrugStore> getPsychotropicDrugStoreInventory() {
		// TODO Auto-generated method stub
		return drugStoreMapper.getPsychotropicDrugStoreInventory();
	}
	
	@Override
	public List<DrugStore> showDrugStore() {
		// TODO Auto-generated method stub
		return drugStoreMapper.findDrugStore();
	}
	@Override
	public boolean changeDrugState(String batch,String state) {
		// TODO Auto-generated method stub
		int ret=drugStoreMapper.changeState(batch,state);
		if(ret!=0) {
			return true;
		}
		return false;
	}
	@Override
	public List<DrugStore> selectDrugStore(Map cond) {
		// TODO Auto-generated method stub
		
		return drugStoreMapper.condDrugStore(cond);
	}
	@Override
	public List<DrugStore> findById(int id) {
		// TODO Auto-generated method stub
		return drugStoreMapper.findDrugStoreByDrugId(id);
	}
	@Override
	public boolean sendDrug(String batch, String amount) {
		// TODO Auto-generated method stub
		int ret=drugStoreMapper.distributeDrug(batch,amount);
		if(ret!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean setThresholdById(int drugstore_id, String drugstore_threshold) {
		// TODO Auto-generated method stub
		int ret=drugStoreMapper.setThresholdById(drugstore_id, drugstore_threshold);
		if(ret!=0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateDrugStoreNum(DrugStore drugStore)
	{
		return drugStoreMapper.updateDrugStoreNum(drugStore);
	}

	@Override
	public DrugStore findDrugStoreByDrugNameAndBatch(DrugStore drugStore)
	{
		// TODO Auto-generated method stub
		return  drugStoreMapper.findDrugStoreByDrugNameAndBatch(drugStore);
	}

	@Override
	public int addDrugStore(DrugStore drugStore)
	{
		return drugStoreMapper.addDrugStore(drugStore);
	}
	
	@Override
	public boolean changeNumber(String batch,String result,String state) {
		// TODO Auto-generated method stub
		int ret=drugStoreMapper.updateNum( batch, result, state);
		if(ret!=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<DrugStore> findExpire(String date) {
		// TODO Auto-generated method stub
		return drugStoreMapper.selectExpire(date);
	}

	@Override
	public DrugStore findDrugStoreByBatch(String batch) {
		// TODO Auto-generated method stub
		return drugStoreMapper.findDrugStoreByBatch(batch);
	}

	@Override
	public List<DrugStore> findDrugStoreByDrugId(int drug_id) {
		// TODO Auto-generated method stub
		return drugStoreMapper.findDrugStoreById(drug_id);
	}

}
