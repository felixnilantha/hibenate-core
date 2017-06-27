package org.hibenate.core.main;

import java.util.Date;

import org.hibenate.core.dto.Address;
import org.hibenate.core.dto.Dependent;
import org.hibenate.core.dto.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibenateTest {

	public static void main(String[] args) {

		UserInfo userInfo = new UserInfo();
		Address homeAddress = new Address();
		Address officeAddress = new Address();
		Dependent dependentUser1 = new Dependent();
		Dependent dependentUser2 = new Dependent();

		userInfo.setUserName("Admin user");
		userInfo.setJoinDate(new Date());
		userInfo.setDescription("Description for the admin user.. ");
		homeAddress.setStreet("Sherman St");
		homeAddress.setSuburb("Forest Hill");
		homeAddress.setState("Victoria");
		homeAddress.setPostCode("3131");
		
		dependentUser1.setDependentName("Jone Doe");
		dependentUser1.setRelashionship("SON");
		
		dependentUser2.setDependentName("Jane Doe");
		dependentUser2.setRelashionship("DAUGHTER");
		
		
		
		officeAddress.setStreet("St. Kilda");
		officeAddress.setSuburb("Melbourne CBD");
		officeAddress.setState("Victoria");
		officeAddress.setPostCode("3000");
		
		userInfo.setHomeAddress(homeAddress);
		userInfo.setOfficeAddress(officeAddress);
		
		userInfo.getDependents().add(dependentUser1);
		userInfo.getDependents().add(dependentUser2);
		
		

		UserInfo userInfo2 = new UserInfo();
		Address address2 = new Address();
		Dependent dependentUser3 = new Dependent();
		Dependent dependentUser4 = new Dependent();
		

		userInfo2.setUserName("System user");
		userInfo2.setJoinDate(new Date());
		userInfo2.setDescription("Description for the system user.. ");
		address2.setStreet("Sherman St");
		address2.setSuburb("Forest Hill");
		address2.setState("Victoria");
		address2.setPostCode("3131");
		
		dependentUser3.setDependentName("Simon Doe");
		dependentUser3.setRelashionship("Step Son");
		
		dependentUser4.setDependentName("Jene Doe");
		dependentUser4.setRelashionship("Step Daughter");

		userInfo2.getDependents().add(dependentUser3);
		userInfo2.getDependents().add(dependentUser4);
		userInfo2.setHomeAddress(address2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userInfo);
		session.save(userInfo2);
		session.getTransaction().commit();
		session.close();

		// retreving data

		userInfo = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		userInfo = (UserInfo) session.get(UserInfo.class, 2);

		System.out.println("Retrive user " + "( " + userInfo.getUserId() + ", " + userInfo.getUserName() + " )");

	}

}
