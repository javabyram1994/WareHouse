package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public Integer saveCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void deleteCustomer(Integer cId);
	public Customer getOneCustomerById(Integer cId);
	public List<Customer> getAllCustomers();


}
