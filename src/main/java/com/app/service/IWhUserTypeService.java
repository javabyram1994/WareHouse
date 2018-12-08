package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	public Integer saveWhUser(WhUserType wh);
	public void updateWhUser(WhUserType wh);
	public void deleteWhuser(Integer whId);
	public WhUserType getOneWhuser(Integer whId);
	public List<WhUserType> getAllWhUsers();
	
	public List<WhUserType> getAllWhUserByType(String userType);

}
