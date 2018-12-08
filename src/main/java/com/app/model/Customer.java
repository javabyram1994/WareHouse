package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="customer")
public class Customer {
@Id
@Column(name="cusid")
@GeneratedValue(generator="cus_gen")
@GenericGenerator(name = "cus_gen", strategy = "increment")
private Integer custId;
@Column(name="cuscode")
private String custCode;
@Column(name="custadd")
private String custAddr;
@ElementCollection(fetch=FetchType.EAGER)
@CollectionTable(name="cusloc",joinColumns=@JoinColumn(name="cusid"))
@Column(name="cusloc")
private List<String> custLocs;
@Column(name="cenabled")
private String custEnabled;
@Column(name="cemail")
private String custEmail;
@Column(name="ccont")
private String custContact;
public Customer() {
	super();
}
public Customer(Integer custId) {
	super();
	this.custId = custId;
}
public Customer(Integer custId, String custCode, String custAddr, List<String> custLocs, String custEnabled,
		String custEmail, String custContact) {
	super();
	this.custId = custId;
	this.custCode = custCode;
	this.custAddr = custAddr;
	this.custLocs = custLocs;
	this.custEnabled = custEnabled;
	this.custEmail = custEmail;
	this.custContact = custContact;
}
public Integer getCustId() {
	return custId;
}
public void setCustId(Integer custId) {
	this.custId = custId;
}
public String getCustCode() {
	return custCode;
}
public void setCustCode(String custCode) {
	this.custCode = custCode;
}
public String getCustAddr() {
	return custAddr;
}
public void setCustAddr(String custAddr) {
	this.custAddr = custAddr;
}
public List<String> getCustLocs() {
	return custLocs;
}
public void setCustLocs(List<String> custLocs) {
	this.custLocs = custLocs;
}
public String getCustEnabled() {
	return custEnabled;
}
public void setCustEnabled(String custEnabled) {
	this.custEnabled = custEnabled;
}
public String getCustEmail() {
	return custEmail;
}
public void setCustEmail(String custEmail) {
	this.custEmail = custEmail;
}
public String getCustContact() {
	return custContact;
}
public void setCustContact(String custContact) {
	this.custContact = custContact;
}
@Override
public String toString() {
	return "Customer [custId=" + custId + ", custCode=" + custCode + ", custAddr=" + custAddr + ", custLocs=" + custLocs
			+ ", custEnabled=" + custEnabled + ", custEmail=" + custEmail + ", custContact=" + custContact + "]";
}

}
