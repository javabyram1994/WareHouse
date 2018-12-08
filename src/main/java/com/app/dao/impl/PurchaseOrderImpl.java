package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrderImpl implements IPurchaseOrderDao {
	
	
	@Autowired
    private HibernateTemplate ht;
	
	public Integer savePurchase(PurchaseOrder po) {
		return (Integer) ht.save(po);
	}

	
	public void updatePurchase(PurchaseOrder po) {
		ht.update(po);

	}

	
	public void deletePurchase(Integer pId) {
		ht.delete(new PurchaseOrder(pId));

	}

	
	public PurchaseOrder getOnePurchaseOrderById(Integer pId) {
		return ht.get(PurchaseOrder.class, pId);
	}

	
    public List<PurchaseOrder> getAllPurchaseOrders() {
		return ht.loadAll(PurchaseOrder.class);
	}

}
