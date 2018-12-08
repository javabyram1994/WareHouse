package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
     @Autowired
	private IWhUserTypeDao dao;
     
     @Transactional
	public Integer saveWhUser(WhUserType wh) {
		return dao.saveWhUser(wh) ;
	}

     @Transactional
	public void updateWhUser(WhUserType wh) {
		dao.updateWhUser(wh);

	}

     @Transactional
	public void deleteWhuser(Integer whId) {
	    dao.deleteWhuser(whId);

	}

     @Transactional(readOnly=true)
	public WhUserType getOneWhuser(Integer whId) {

		return dao.getOneWhuser(whId);
	}

     @Transactional(readOnly=true)
	public List<WhUserType> getAllWhUsers() {
		return dao.getAllWhUsers();
	}

     @Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserByType(String userType) {
		return dao.getAllWhUserByType(userType);
	}

}
