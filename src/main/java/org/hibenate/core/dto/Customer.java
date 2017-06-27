package org.hibenate.core.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.metamodel.StaticMetamodel;

import org.hibernate.annotations.DynamicUpdate;

@Entity
/*@NamedQueries({@NamedQuery(name="Customer.byId", query= "from Customer where customerId > ?"),
	@NamedQuery(name="Customer.byName", query= "from Customer where customerName = ?")})*/
//@DynamicUpdate
@StaticMetamodel(Customer.class)
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int  customerId;
	private String customerName;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	

}
