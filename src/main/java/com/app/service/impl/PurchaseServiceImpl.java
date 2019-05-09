package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.service.IPurchaseService;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

	@Autowired
	private IPurchaseDao dao;

	@Override
	@Transactional
	public Integer savePurchase(Purchase p) {
		return dao.savePurchase(p);
	}

	@Override
	@Transactional
	public void updatePurchase(Purchase p) {
		dao.updatePurchase(p);
	}

	@Override
	@Transactional
	public void deletePurchase(Integer id) {
		dao.deletePurchase(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Purchase getPurchaseById(Integer id) {
		return dao.getPurchaseById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Purchase> getAllPurchases() {
		return dao.getAllPurchases();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getPurchaseCountByQtyCheck() {
		return dao.getPurchaseCountByQtyCheck();
	}

}
