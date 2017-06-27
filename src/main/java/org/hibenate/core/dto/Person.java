package org.hibenate.core.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "PERSON_DETAILS")
public class Person {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PERSON_ID")
	private int personId;
	private String personName;
	
	@OneToOne
	@JoinColumn(name="PASSPORT_ID")
	private Passport passport;
	
	
	//@JoinTable(name ="PERSON_VEHICLE", joinColumns=@JoinColumn(name ="PERSON_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	@OneToMany( mappedBy="person")
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
