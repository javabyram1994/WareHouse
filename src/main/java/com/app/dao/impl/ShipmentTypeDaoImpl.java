package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	
	
	@Autowired
    private HibernateTemplate ht;
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer) ht.save(st);
	}

	
	public void updateShipmentType(ShipmentType st) {
              ht.update(st);
	}

	
	public void deleteShipmentType(Integer stId) {
              ht.delete(new ShipmentType(stId));
	}

	
	public ShipmentType getOneShipmentType(Integer stId) {
		return ht.get(ShipmentType.class, stId);
	}

	
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}


	
	public List<ShipmentType> getAllShipmentByType(String shCode) {
		
		return (List<ShipmentType>) ht.findByCriteria(DetachedCriteria.forClass(ShipmentType.class).add(Restrictions.eq("shcode", shCode)));
	}

}
