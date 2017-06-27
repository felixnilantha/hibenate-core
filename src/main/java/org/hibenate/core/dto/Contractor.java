package org.hibenate.core.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Egency")
public class Contractor extends Employee {
	
	private int hourlyRate;

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	

}
