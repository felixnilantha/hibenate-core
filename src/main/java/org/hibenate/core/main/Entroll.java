package org.hibenate.core.main;

import org.hibenate.core.dto.Course;
import org.hibenate.core.dto.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Entroll {
	
	public static void main(String[] args) {
		
		// I am going to create multiple students 
		
		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
		
		std1.setStudentName("John Doe");
		std2.setStudentName("Jane Doe");
		std3.setStudentName("Jenifer Doe ");
		
		// I am also going to create multiple course 
		
		Course cs1 = new Course();
		Course cs2 = new Course();
		Course cs3 = new Course();
		
		cs1.setCourseName("Politicle Science");
		cs2.setCourseName("Mathamatics");
		cs3.setCourseName("Rocket Science");
		
		std1.getCourse().add(cs1);
		std1.getCourse().add(cs2);
		
		cs1.getStudents().add(std3);
		cs1.getStudents().add(std2);
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.persist(std1);
		session.persist(std2);
		session.persist(std3);
		
		/*session.save(cs1);
		session.save(cs2);
		session.save(cs3);*/
		session.getTransaction().commit();
		session.close();
		
	}

}
