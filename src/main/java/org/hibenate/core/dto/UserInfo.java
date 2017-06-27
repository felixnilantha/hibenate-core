package org.hibenate.core.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserInfo {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	
	// address is a value object and doesn't have a meaning on its own.
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name ="street", column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name ="suburb", column=@Column(name="HOME_SUBRUB")),
		@AttributeOverride(name ="postCode", column=@Column(name="HOME_POSTCODE")),
		@AttributeOverride(name ="state", column=@Column(name="HOME_STATE"))})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	
	
	@Lob //marking this as a Large Object
	private String Description;
	
	// if you do not want any filed to be persists you can  ether make it transient or static
	// same thing can be achieve by using transient annotation. 
	
	private transient String demoTransientIdentifier;
	@Transient
	private String demoTransientAnnotation;
	private static String demoStaticAnnotation;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name = "USER_DEPENDENTS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="sequence-gen", strategy="sequence")
	@CollectionId(columns = { @Column(name="DEPENDENT_ID") }, generator = "sequence-gen", type = @Type(type="long"))
	private Collection<Dependent> dependents = new ArrayList<Dependent>();
	
	//private Set<Dependent> dependents = new HashSet<Dependent>() ;
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Collection<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(Collection<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	
	
	
	
	
		

}
