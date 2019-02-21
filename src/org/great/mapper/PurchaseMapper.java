package org.great.mapper;

import java.util.List;
import java.util.Map;

import org.great.entity.Purchase;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseMapper
{
	public int addPurchase(Purchase purchase);

	public List<Purchase> findPurchase(Purchase purchase);
	
	public List<Purchase> findPurchase(Map map);
}
