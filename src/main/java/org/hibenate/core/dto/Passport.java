package org.hibenate.core.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PASSPORT_DETAILS")
public class Passport {
	
	/// we are going to assume one person only has one passport
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PASSPORT_ID")
	private int passportId; // we are going to assume that passport Id only contains interger
	@Column(name="COUNTRY_ISSUED")
	private String country;
	
	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
