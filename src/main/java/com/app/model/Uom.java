package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uomtab")
public class Uom {
	@Id
	@GeneratedValue(generator="uo_gen")
	@GenericGenerator(name = "uo_gen", strategy = "increment")
	@Column(name="uid")
	private Integer id;
	@Column(name="uname")
	private String type;
	@Column(name="umodel")
	private String model;
	@Column(name="udsc")
	private String dsc;
	public Uom() {
		super();
	}
	public Uom(Integer id) {
		super();
		this.id = id;
	}
	public Uom(Integer id, String type, String model, String dsc) {
		super();
		this.id = id;
		this.type = type;
		this.model = model;
		this.dsc = dsc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "Uom [id=" + id + ", type=" + type + ", model=" + model + ", dsc=" + dsc + "]";
	}
	

}
