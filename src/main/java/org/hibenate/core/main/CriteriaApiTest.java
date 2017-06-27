package org.hibenate.core.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibenate.core.dto.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;

public class CriteriaApiTest {

	public static void main(String[] args) {
		
		Customer cexample = new Customer();
		cexample.setCustomerId(21);
		cexample.setCustomerName("c21");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria= cb.createQuery(Customer.class);
		
		//Example example = Example.create(cexample).excludeProperty(name);
		
		Root<Customer> cusRoot=  criteria.from(Customer.class);
		//criteria.select(cusRoot).where(cb.equal(cusRoot.get(, "c19"));
		
		session.getTransaction().commit();
		session.close();
		
		/*for(Customer c: customers){
			System.out.println(c.getCustomerName());
		}*/

	}

}
