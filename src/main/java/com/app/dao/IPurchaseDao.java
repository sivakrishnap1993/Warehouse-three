package com.app.dao;

import java.util.List;

import com.app.model.Purchase;

public interface IPurchaseDao {

	public Integer savePurchase(Purchase p);

	public void updatePurchase(Purchase p);

	public void deletePurchase(Integer id);

	public Purchase getPurchaseById(Integer id);

	public List<Purchase> getAllPurchases();
	
	public List<Object[]> getPurchaseCountByQtyCheck();
}
