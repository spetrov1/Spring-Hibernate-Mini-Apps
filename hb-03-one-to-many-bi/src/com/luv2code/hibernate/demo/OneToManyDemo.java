package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class OneToManyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		/*
		InstructorDetail instructorDetail = new InstructorDetail("svetoslav@youtube.com", "Playing tennis");
		Instructor instructor = new Instructor("Svetoslav", "Petrov", "svetoslav@abv.bg");
		instructor.setInstructorDetail(instructorDetail);
		*/
		// Course course1 = new Course("Spring and Hibernate: For beginners");
		// Course course2 = new Course("Angular: Ultimate Guide");
				
		try {			
			// create a Student
			// System.out.println("Creating new student");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object ... and instructor detail
			// System.out.println("Saving the instructor");
			// session.save(instructor);
			Instructor tempInstructor = session.get(Instructor.class, "2");
			
			System.out.println(tempInstructor.getCourses());
			
			// course1.setInstructor(tempInstructor);
			// session.save(course1);
			
			// course2.setInstructor(tempInstructor);
			// session.save(course2);
			
			// session.createQuery("delete from Course where instructor_id = null").executeUpdate();
			
			/*
			InstructorDetail instDet = session.get(InstructorDetail.class, "3");
			
			System.out.println(instDet.getInstructor());
			
			instDet.getInstructor().setInstructorDetail(null);
			session.delete(instDet);
			*/
			
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
