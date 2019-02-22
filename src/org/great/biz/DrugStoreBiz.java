package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.entity.DrugStore;

public interface DrugStoreBiz {
	public List<DrugStore> getDrugStoreInventory();
	public List<DrugStore> getPsychotropicDrugStoreInventory();
	public List<DrugStore> showDrugStore();
	public boolean changeDrugState(String batch,String state);
	public List<DrugStore> selectDrugStore(Map cond );
	public List<DrugStore> findById(int id);
	public boolean sendDrug(String batch,String amount); 
	public boolean setThresholdById(int drugstore_id,String drugstore_threshold);
	public DrugStore findDrugStoreByDrugNameAndBatch(DrugStore drugStore);
	public boolean updateDrugStoreNum(DrugStore drugStore);
	public int addDrugStore(DrugStore drugStore);
	public boolean changeNumber(String batch,String result,String state);
	public List<DrugStore> findExpire(String date);
	public DrugStore findDrugStoreByBatch(String batch);
	public List<DrugStore> findDrugStoreByDrugId(int drug_id);

}
