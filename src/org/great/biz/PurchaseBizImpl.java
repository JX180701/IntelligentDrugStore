package org.great.biz;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.great.entity.Purchase;
import org.great.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

@Service("purchaseBiz")
public class PurchaseBizImpl implements PurchaseBiz
{
	@Resource
	private PurchaseMapper purchaseMapper;

	@Override
	public List<Purchase> findPurchase(Map map)
	{
		return purchaseMapper.findPurchase(map);
	}

	@Override
	public int addPurchase(Purchase purchase)
	{
		return purchaseMapper.addPurchase(purchase);
	}
}
