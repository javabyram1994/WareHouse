package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;
@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private IVendorDao dao;
	@Transactional
	public Integer saveVendor(Vendor v) {
		return dao.saveVendor(v);
	}

	@Transactional
	public void updateVendor(Vendor v) {
           dao.updateVendor(v);
	}

	@Transactional
	public void deleteVendor(Integer vId) {
          dao.deleteVendor(vId);
	}

	@Transactional(readOnly=true)
	public Vendor getOneVendorById(Integer vId) {
		return dao.getOneVendorById(vId);
	}

	@Transactional(readOnly=true)
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

}
