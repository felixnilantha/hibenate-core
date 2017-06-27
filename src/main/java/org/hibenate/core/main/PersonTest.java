package org.hibenate.core.main;

import org.hibenate.core.dto.Passport;
import org.hibenate.core.dto.Person;
import org.hibenate.core.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonTest {

	public static void main(String[] args) {
		
		Person person1 = new Person();
		Person person2 = new Person();
		
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		Vehicle v3 = new Vehicle();
		Vehicle v4 = new Vehicle();
		
		v1.setModel("Car");
		v2.setModel("Bus");
		v3.setModel("Lorry");
		v4.setModel("Bike");
		
		
		person1.setPersonName("Jane Doe");
		person2.setPersonName("John Doe");
		
		Passport p1 =new Passport();
		Passport p2 =new Passport();
		
		p1.setCountry("Sri Lanka");
		p2.setCountry("India");
		
		person1.setPassport(p1);
		person2.setPassport(p2);
		
		person1.getVehicle().add(v1);
		person1.getVehicle().add(v2);
		person2.getVehicle().add(v3);
		person2.getVehicle().add(v4);
		
		
		// first this is you need to bring in the configuration 
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		// secondly we grab a session out of that session factory
		Session session= sessionFactory.openSession();
		// third we declare a transaction.
		session.beginTransaction();
		
		
		
		session.save(person1);
		session.save(person2);
		
		session.save(p1);
		session.save(p2);
		
		session.save(v1);
		session.save(v2);
		session.save(v3);
		session.save(v4);
		
		session.getTransaction().commit();
		session.close();
		

	}

}
