package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;

	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod or) {
		return dao.saveOrderMethod(or);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod or) {
		dao.updateOrderMethod(or);
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}

	@Override
	@Transactional(readOnly = true)
	public OrderMethod getOrderMethodById(Integer id) {
		return dao.getOrderMethodById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodCountByMode() {
		return dao.getOrderMethodCountByMode();
	}

}
