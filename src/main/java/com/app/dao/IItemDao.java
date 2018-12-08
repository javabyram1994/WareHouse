package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	public Integer saveItem(Item i);
	public void updateItem(Item i);
	public void deleteItem(Integer iId);
	public Item getOneItemById(Integer iId);
	public List<Item> getAllItems();

}
