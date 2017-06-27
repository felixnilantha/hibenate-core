package org.hibenate.core.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibenate.core.dto.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class HQLTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		/*for (int j = 0; j < 20; j++) {
			Customer c = new Customer();
			c.setCustomerName("c" + j);
			session.save(c);
			
		}*/
		
		Query query= session.createQuery("select new map (customerId, customerName) from Customer");
		query.setFirstResult(10);
		query.setMaxResults(6);
		
		List<Map<Integer,String>> customers =(List<Map<Integer, String>>) query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		for(Map<Integer, String> c: customers){
			System.out.println(c.entrySet());
		}

		

	}

}
