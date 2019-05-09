package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {

	public Integer saveOrderMethod(OrderMethod or);

	public void updateOrderMethod(OrderMethod or);

	public void deleteOrderMethod(Integer id);

	public OrderMethod getOrderMethodById(Integer id);

	public List<OrderMethod> getAllOrderMethods();
	
	public List<Object[]> getOrderMethodCountByMode();
}
