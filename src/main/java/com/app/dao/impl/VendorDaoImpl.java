package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveVendor(Vendor v) {
		return (Integer) ht.save(v);
	}

	
	public void updateVendor(Vendor v) {
		ht.update(v);

	}

	
	public void deleteVendor(Integer vId) {
		ht.delete(new Vendor(vId));

	}

	
	public Vendor getOneVendorById(Integer vId) {
		return ht.get(Vendor.class, vId);
	}

	
	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

}
