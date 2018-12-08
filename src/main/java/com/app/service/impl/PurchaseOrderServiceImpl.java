package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@Service

public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	@Autowired
	private IPurchaseOrderDao dao;

	@Transactional
	public Integer savePurchase(PurchaseOrder po) {
		return dao.savePurchase(po);
	}

	@Transactional
	public void updatePurchase(PurchaseOrder po) {
       dao.updatePurchase(po);
	}

	@Transactional
	public void deletePurchase(Integer pId) {
       dao.deletePurchase(pId);
	}

	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderById(Integer pId) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrderById(pId);
	}

	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return dao.getAllPurchaseOrders();
	}

}
