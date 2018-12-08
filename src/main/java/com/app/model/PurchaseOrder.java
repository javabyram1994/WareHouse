package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purctab")
public class PurchaseOrder {
	@Id
	@Column(name="pid")
	@GeneratedValue(generator="pur_gen")
	@GenericGenerator(name = "pur_gen", strategy = "increment")
	private Integer id;
	@Column(name="code")
	private String code;
	
	@ManyToOne
	@JoinColumn(name="oidfk")
	private ShipmentType shcode;
	
	@ManyToOne
	@JoinColumn(name="whidfk")
    private WhUserType ven;
	
	
	
	@Column(name="ref_num")
	private String refNum;
	@Column(name="qua_che")
	private String quachk;
	@Column(name="def_stu")
	private String defstu;
	@Column(name="dsc")
	private String dsc;
	public PurchaseOrder(Integer id, String code, ShipmentType shcode, WhUserType ven, String refNum, String quachk,
			String defstu, String dsc) {
		super();
		this.id = id;
		this.code = code;
		this.shcode = shcode;
		this.ven = ven;
		this.refNum = refNum;
		this.quachk = quachk;
		this.defstu = defstu;
		this.dsc = dsc;
	}
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ShipmentType getShcode() {
		return shcode;
	}
	public void setShcode(ShipmentType shcode) {
		this.shcode = shcode;
	}
	public WhUserType getVen() {
		return ven;
	}
	public void setVen(WhUserType ven) {
		this.ven = ven;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getQuachk() {
		return quachk;
	}
	public void setQuachk(String quachk) {
		this.quachk = quachk;
	}
	public String getDefstu() {
		return defstu;
	}
	public void setDefstu(String defstu) {
		this.defstu = defstu;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", code=" + code + ", shcode=" + shcode + ", ven=" + ven + ", refNum="
				+ refNum + ", quachk=" + quachk + ", defstu=" + defstu + ", dsc=" + dsc + "]";
	}
	
	
	
}
