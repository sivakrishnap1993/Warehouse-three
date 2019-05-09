package com.app.service;

import java.util.List;

import com.app.model.SaleOrder;

public interface ISaleOrderService {

	public Integer saveSaleOrder(SaleOrder sl);

	public void updateSaleOrder(SaleOrder sl);

	public void deleteSaleOrder(Integer id);

	public SaleOrder getSaleOrderById(Integer id);

	public List<SaleOrder> getAllSaleOrders();

	public List<Object[]> saleorderCountByMode(); 
}
