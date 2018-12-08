package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {
	
	@Autowired
    private HibernateTemplate ht;
	
	public Integer saveItem(Item i) {
		return (Integer) ht.save(i);
	}

	
	public void updateItem(Item i) {
        ht.update(i);
	}

	
	public void deleteItem(Integer iId) {
       ht.delete(new Item(iId));
	}

	
	public Item getOneItemById(Integer iId) {
		return ht.get(Item.class, iId);
	}

	
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

}
