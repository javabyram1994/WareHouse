package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeImpl implements IWhUserTypeDao {
    @Autowired
	private HibernateTemplate ht;

	
	public Integer saveWhUser(WhUserType wh) {
		return (Integer) ht.save(wh);
	}

	
	public void updateWhUser(WhUserType wh) {
		ht.update(wh);
		
	}

	
	public void deleteWhuser(Integer whId) {
		ht.delete(new WhUserType(whId));
		
	}

	
	public WhUserType getOneWhuser(Integer whId) {
		
		return ht.get(WhUserType.class,whId);
	}
	
	public List<WhUserType> getAllWhUsers() {
		return ht.loadAll(WhUserType.class);
	}


	
	public List<WhUserType> getAllWhUserByType(String userType) {
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eq("type", userType)));		   
		return list;
	}
	
}
