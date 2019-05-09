package com.app.dao;

import java.util.List;

import com.app.model.SaleOrder;

public interface ISaleOrderDao {

	
	public Integer saveSaleOrder(SaleOrder sl);
	
	public void updateSaleOrder(SaleOrder sl);
	
	public void deleteSaleOrder(Integer id);
	
	public SaleOrder getSaleOrderById(Integer id);
	
	public List<SaleOrder> getAllSaleOrders();
	
	public List<Object[]> saleorderCountByMode(); 
}
