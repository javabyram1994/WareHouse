package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
	public Integer saveVendor(Vendor v);
	public void updateVendor(Vendor v);
	public void deleteVendor(Integer vId);
	public Vendor getOneVendorById(Integer vId);
	public List<Vendor> getAllVendors();

}
