package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="whusertab")
public class WhUserType {
@Id
@GeneratedValue(generator="wh_gen")
@GenericGenerator(name = "wh_gen", strategy = "increment")
@Column(name="whid")
private Integer id;
@Column(name="whtype")
private String type;
@Column(name="whcode")
private String code;
@Column(name="whfortype")
private String forType;
@Column(name="whemail")
private String email;
@Column(name="whcontact")
private String contact;
@Column(name="whidtype")
private String idType;
@Column(name="whothers")
private String ifOthers;
@Column(name="whnum")
private String ifNum;
public WhUserType() {
	super();
}
public WhUserType(Integer id) {
	super();
	this.id = id;
}
public WhUserType(Integer id, String type, String code, String forType, String email, String contact, String idType,
		String ifOthers, String ifNum) {
	super();
	this.id = id;
	this.type = type;
	this.code = code;
	this.forType = forType;
	this.email = email;
	this.contact = contact;
	this.idType = idType;
	this.ifOthers = ifOthers;
	this.ifNum = ifNum;
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
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getForType() {
	return forType;
}
public void setForType(String forType) {
	this.forType = forType;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getIdType() {
	return idType;
}
public void setIdType(String idType) {
	this.idType = idType;
}
public String getIfOthers() {
	return ifOthers;
}
public void setIfOthers(String ifOthers) {
	this.ifOthers = ifOthers;
}
public String getIfNum() {
	return ifNum;
}
public void setIfNum(String ifNum) {
	this.ifNum = ifNum;
}
@Override
public String toString() {
	return "WhUserType [id=" + id + ", type=" + type + ", code=" + code + ", forType=" + forType + ", email=" + email
			+ ", contact=" + contact + ", idType=" + idType + ", ifOthers=" + ifOthers + ", ifNum=" + ifNum + "]";
}



}
