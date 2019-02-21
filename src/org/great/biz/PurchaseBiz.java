package org.great.biz;

import java.util.List;
import java.util.Map;

import org.great.entity.Purchase;

public interface PurchaseBiz
{
	public List<Purchase> findPurchase(Map map);
	
	public int addPurchase(Purchase purchase);
}
