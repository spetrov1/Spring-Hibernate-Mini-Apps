package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class OneToManyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		InstructorDetail instructorDetail = new InstructorDetail("svetoslav@youtube.com", "Playing tennis");
		Instructor instructor = new Instructor("Svetoslav", "Petrov", "svetoslav@abv.bg");
		
		Course course1 = new Course("Spring and Hibernate: For beginners");
		Course course2 = new Course("Angular: Ultimate Guide");
		
		instructor.setInstructorDetail(instructorDetail);
		instructor.addCourse(course1);
		// instructor.addCourse(course2);
		
		Review review1 = new Review("This is awesome course ... !!!");
		Review review2 = new Review("I liked it. 8/10 !!!");
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// session.save(instructor);
			// session.createQuery("delete from InstructorDetail").executeUpdate();
			// Course tempInstructor = session.get(Course.class, "2");
			// Course tempCourse = session.get(Course.class, "2");
			
			course2.addReview(review1);
			course2.addReview(review2);
			
			session.save(course2);
			session.getTransaction().commit();

			
			/*
			InstructorDetail instDet = session.get(InstructorDetail.class, "3");
			
			System.out.println(instDet.getInstructor());
			
			instDet.getInstructor().setInstructorDetail(null);
			session.delete(instDet);
			*/
			
			// commit transaction			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
