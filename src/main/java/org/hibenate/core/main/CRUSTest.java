package org.hibenate.core.main;

import org.hibenate.core.dto.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUSTest {

	public static void main(String[] args) {
		
		Customer c1= new Customer();
		Customer c2= new Customer();
		Customer c3= new Customer();
		Customer c4= new Customer();
		
		c1.setCustomerName("created 1");
		c2.setCustomerName("created 2");
		c3.setCustomerName("created 3");
		c4.setCustomerName("created 4");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		// C in CRUD
		
		/*session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);*/
		
		session.getTransaction().commit();
		session.close();
		
		// R in CRUD
		
		session= sessionFactory.openSession();
		Customer cget= session.get(Customer.class, 4);
		System.out.println("R in CRUD " + cget.getCustomerName() );
		session.close();
		
		// D in CRUD
		session=sessionFactory.openSession();
		//before you delete you need to retrieve a customer record
		
		Customer dget=session.get(Customer.class, 1);
		session.beginTransaction();
		// now, deletion is happen through the session object
		//session.delete(dget);
		session.getTransaction().commit();
		session.close();
		
		// U in CRUD
		
		session=sessionFactory.openSession();
		Customer uget=session.get(Customer.class, 4);
		uget.setCustomerName("john Doe");
		uget.setCustomerName("Micheal Doe");
		
		session.beginTransaction();
		
		session.update(uget);
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
		
		
		
		
		

	}

}
