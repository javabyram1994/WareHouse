package com.app.dao;

import java.util.List;

import com.app.model.Uom;

public interface IUomDao {
	public Integer saveUom(Uom u);
	public void updateUom(Uom u);
	public void deleteUom(Integer uId);
	public Uom getOneUomById(Integer uId);
	public List<Uom> getAllUoms();
	public boolean isUomModelExist(String uomModel);
	public boolean isUomConnectedWithItem(Integer id);

}
