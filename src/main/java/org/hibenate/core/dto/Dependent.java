package org.hibenate.core.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Dependent {
	
	private String dependentName;
	private String relashionship;
	
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public String getRelashionship() {
		return relashionship;
	}
	public void setRelashionship(String relashionship) {
		this.relashionship = relashionship;
	}
	
	
	

}
