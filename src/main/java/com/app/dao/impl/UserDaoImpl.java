package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;

	
	public void saveUser(User user) {
		ht.save(user);

	}


	@Override
	public User findByUserName(String userName) {
		User user=null;
		@SuppressWarnings("unchecked")
		List<User> users=(List<User>) ht.findByCriteria(DetachedCriteria.forClass(User.class).add(Restrictions.eq("userEmail", userName)));
		if(users!=null && !users.isEmpty()) {
			user=users.get(0);
		}
		return user;
	}
	
}
