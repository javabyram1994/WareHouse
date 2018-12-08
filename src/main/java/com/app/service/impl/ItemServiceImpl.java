package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Transactional
	public Integer saveItem(Item i) {
		// TODO Auto-generated method stub
		return dao.saveItem(i);
	}

	@Transactional
	public void updateItem(Item i) {
		dao.updateItem(i);
	}

	@Transactional
	public void deleteItem(Integer iId) {
		dao.deleteItem(iId);
	}

	@Transactional(readOnly=true)
	public Item getOneItemById(Integer iId) {
		return dao.getOneItemById(iId);
	}

	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

}
