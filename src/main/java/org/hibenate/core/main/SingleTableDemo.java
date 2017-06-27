package org.hibenate.core.main;

import org.hibenate.core.dto.Contractor;
import org.hibenate.core.dto.Employee;
import org.hibenate.core.dto.FullTimer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTableDemo {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmployeeName("John Doe");
		
		Contractor con = new Contractor();
		con.setEmployeeName("Contract Doe");
		con.setHourlyRate(40);
		
		FullTimer full = new FullTimer();
		full.setEmployeeName("Full Timer Doe");
		full.setAnnualvage(70);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.persist(emp);
		session.persist(con);
		session.persist(full);
		
		/*session.save(cs1);
		session.save(cs2);
		session.save(cs3);*/
		session.getTransaction().commit();
		session.close();

	}

}
