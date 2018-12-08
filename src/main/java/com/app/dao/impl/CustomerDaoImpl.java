package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;
	public Integer saveCustomer(Customer c) {
		return (Integer) ht.save(c);
	}

	
	public void updateCustomer(Customer c) {
		ht.update(c);

	}

	
	public void deleteCustomer(Integer cId) {
		ht.delete(new Customer(cId));

	}

	
	public Customer getOneCustomerById(Integer cId) {
		return ht.get(Customer.class, cId);
	}

	
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}

}
