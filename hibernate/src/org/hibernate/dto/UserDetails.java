package org.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="UsserInfo")
public class UserDetails {
@Id
@Column(name="Id")
//@GeneratedValue(strategy=GenerationType.SEQUENCE)
private int userId;

@Column(name="Name")
private  String userName;

@Column(name="Dateofbirth")
@Temporal(TemporalType.DATE)
private Date dob;
/*
@Embedded
@AttributeOverride(name="city", column=@Column(name="Home_City"))
*/
/*@ElementCollection
@JoinTable(name="User_Address")
private Set<Address> addressList=new HashSet();
*/

@ElementCollection(fetch=FetchType.EAGER)
@JoinTable(name="User_Address",
			joinColumns=@JoinColumn(name="Id")
		)
//@GenericGenerator(name="sequence-gen", strategy = "sequence")
@GenericGenerator(name = "increment", strategy = "increment")
//@GeneratedValue(generator = "increment")
@CollectionId(columns = { @Column(name="Address_Id") }, generator = "increment", type = @Type(type="long"))
private Collection<Address> addressList=new ArrayList<Address>();

public Collection<Address> getAddressList() {
	return addressList;
}
public void setAddressList(Collection<Address> addressList) {
	this.addressList = addressList;
}
public Date getDob() {
	return dob;
}
/*public Set<Address> getAddressList() {
	return addressList;
}
public void setAddressList(Set<Address> addressList) {
	this.addressList = addressList;
}*/
public void setDob(Date dob) {
	this.dob = dob;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

}
