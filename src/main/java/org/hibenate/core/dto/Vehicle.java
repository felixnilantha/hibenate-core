package org.hibenate.core.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE_DETAILS")
public class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vin;
	private String Model;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	public int getVin() {
		return vin;
	}
	public void setVin(int vin) {
		this.vin = vin;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	
	

}
