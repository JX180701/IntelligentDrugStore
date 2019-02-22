package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.entity.DrugStore;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugStoreMapper
{
	public int addDrugStore(DrugStore drugStore);
	public List<DrugStore> getDrugStoreInventory();
	public List<DrugStore> getPsychotropicDrugStoreInventory();
	public int changeState(String batch,String state);
	public List<DrugStore> findDrugStore();
	public List<DrugStore> condDrugStore(Map cond);
	public List<DrugStore> findDrugStoreById(int id);
	public int distributeDrug(String batch,String amount);
	public int setThresholdById(int drugstore_id,String drugstore_threshold);
	public boolean updateDrugStoreNum(DrugStore drugStore);
	public DrugStore findDrugStoreByDrugNameAndBatch(DrugStore drugStore);
	public int updateNum(String batch,String result,String state);
	public List<DrugStore> selectExpire(String date);
	public DrugStore findDrugStoreByBatch(String batch);
	public List<DrugStore> findDrugStoreByDrugId(int drug_id);

}
