package org.hibenate.core.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Own Staff")
public class FullTimer extends Employee {
	
	private int annualvage;

	public int getAnnualvage() {
		return annualvage;
	}

	public void setAnnualvage(int annualvage) {
		this.annualvage = annualvage;
	}
	
	

}
