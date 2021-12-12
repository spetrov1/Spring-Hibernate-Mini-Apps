package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		InstructorDetail instructorDetail = new InstructorDetail("paul@youtube.com", "Watch TV");
		Instructor instructor = new Instructor("Paul", "Wall", "paul@luv2code.com");
		instructor.setInstructorDetail(instructorDetail);
		

		try {			
			// create a Student
			System.out.println("Creating new student");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			// System.out.println("Saving the instructor");
			// session.save(instructor);
			
			InstructorDetail instDet = session.get(InstructorDetail.class, "3");
			
			System.out.println(instDet.getInstructor());
			
			instDet.getInstructor().setInstructorDetail(null);
			session.delete(instDet);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
