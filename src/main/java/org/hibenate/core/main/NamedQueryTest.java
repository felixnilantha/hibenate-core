package org.hibenate.core.main;

import java.util.List;
import java.util.Map;

import org.hibenate.core.dto.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class NamedQueryTest {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		Query query= session.getNamedQuery("Customer.byId");
		query.setParameter(0, 5);
		
		
		List<Customer> customers =(List<Customer>) query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		for(Customer c: customers){
			System.out.println(c.getCustomerName());
		}

	}

}
