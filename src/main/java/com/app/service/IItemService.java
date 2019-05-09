package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {

	public Integer saveItem(Item i);

	public void updateItem(Item i);

	public void deleteItem(Integer id);

	public Item getItemById(Integer id);

	public List<Item> getAllItems();

	public List<Object[]> getCountByMode();
}
