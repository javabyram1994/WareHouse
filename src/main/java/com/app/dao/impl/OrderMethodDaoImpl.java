package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.Item;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	 @Autowired 
    private HibernateTemplate ht;
	
	public Integer saveOrderMethod(OrderMethod om) {
		return (Integer) ht.save(om);
	}

	
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);
	}

	
	public void deleteOrderMethod(Integer omId) {
		ht.delete(new OrderMethod(omId));
	}

	
	public OrderMethod getOneOrderMethod(Integer omId) {
		return ht.get(OrderMethod.class, omId);
	}

	
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}


	
	@SuppressWarnings("unchecked")
	public List<OrderMethod> getAllOderMethodByMode(String mode) {
		
		return (List<OrderMethod>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class).add(Restrictions.eq("mode",mode)));
	}
	
	 
	public boolean isOrderMethodExist(String omCode) {
		@SuppressWarnings("unchecked")
		List<Long> rowCount=(List<Long>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.eq("code", omCode)));
		return rowCount.get(0)!=0?true:false;
	}


	
	public boolean isOrderConnectedWithItem(Integer id) {
		@SuppressWarnings("unchecked")
		List<Long> rowCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(Item.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.or((Restrictions.eq("saleType.id", id)),(Restrictions.eq("purchaseType.id", id)))));
		
		return rowCount.get(0)!=0?true:false;
	}

}
