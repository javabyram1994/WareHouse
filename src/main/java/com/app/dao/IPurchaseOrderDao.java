package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {

	public Integer savePurchase(PurchaseOrder po);
	public void updatePurchase(PurchaseOrder po);
	public void deletePurchase(Integer pId);
	public PurchaseOrder getOnePurchaseOrderById(Integer pId);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
