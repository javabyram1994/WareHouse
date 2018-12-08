package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;
@Repository	
public class UomDaoImpl implements IUomDao {
 @Autowired
 private HibernateTemplate ht;
	
	public Integer saveUom(Uom u) {
		return (Integer) ht.save(u);
	}

	
	public void updateUom(Uom u) {
         ht.update(u);
	}

	
	public void deleteUom(Integer uId) {
         ht.delete(new Uom(uId));
	}

	
	public Uom getOneUomById(Integer uId) {
		return ht.get(Uom.class, uId);
	}

	
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}


	
	public boolean isUomModelExist(String uomModel) {
		@SuppressWarnings("unchecked")
		List<Long> rowCount=(List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.eq("model", uomModel)));
		return rowCount.get(0)!=0?true:false;
	}
	
	
	public boolean isUomConnectedWithItem(Integer id) {
		@SuppressWarnings("unchecked")
		List<Long> rowCount= (List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Item.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.eq("uom.id", id)));
		return rowCount.get(0)!=0?true:false;
	}

}
