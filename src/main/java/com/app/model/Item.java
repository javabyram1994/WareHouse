package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="itemtab")

public class Item {
	@Id
	@Column(name="iid")
	@GeneratedValue(generator="itm_gen")
	@GenericGenerator(name = "itm_gen", strategy = "increment")
	private Integer id;
	@Column(name="icode")
	private String code;
	@Column(name="iwidth")
	private double width;
	@Column(name="ilength")
	private double length;
	@Column(name="iheight")
	private double height;
	@Column(name="cost")
	private double baseCost;
	@Column(name="currency")
	private String baseCurrency;
	@Column(name="des")
	private String discr;

	@ManyToOne
	@JoinColumn(name="uidfk")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name="omsale")
	private OrderMethod saleType;




	@ManyToOne
	@JoinColumn(name="ompurchase")
	private OrderMethod purchaseType;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_custuser_tab",joinColumns=@JoinColumn(name="itmIdFK"),inverseJoinColumns=@JoinColumn(name="custIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> custUser=new ArrayList<WhUserType>(0);;


	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_venuser_tab",joinColumns=@JoinColumn(name="itmIdFk"),inverseJoinColumns=@JoinColumn(name="venIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> venUser=new ArrayList<WhUserType>(0);;

	public Item() {
		super();
	}
	public Item(Integer id) {
		super();
		this.id = id;
	}
	public Item(Integer id, String code, double width, double length, double height, double baseCost,
			String baseCurrency, String discr, Uom uom, OrderMethod saleType, List<WhUserType> venUser,
			OrderMethod purchaseType, List<WhUserType> custUser) {
		super();
		this.id = id;
		this.code = code;
		this.width = width;
		this.length = length;
		this.height = height;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.discr = discr;
		this.uom = uom;
		this.saleType = saleType;
		this.venUser = venUser;
		this.purchaseType = purchaseType;
		this.custUser = custUser;
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
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getDiscr() {
		return discr;
	}
	public void setDiscr(String discr) {
		this.discr = discr;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public OrderMethod getSaleType() {
		return saleType;
	}
	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}
	public List<WhUserType> getVenUser() {
		return venUser;
	}
	public void setVenUser(List<WhUserType> venUser) {
		this.venUser = venUser;
	}
	public OrderMethod getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}
	public List<WhUserType> getCustUser() {
		return custUser;
	}
	public void setCustUser(List<WhUserType> custUser) {
		this.custUser = custUser;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", width=" + width + ", length=" + length + ", height=" + height
				+ ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", discr=" + discr + ", uom=" + uom
				+ ", saleType=" + saleType + ", venUser=" + venUser + ", purchaseType=" + purchaseType + ", custUser="
				+ custUser + "]";
	}


}
