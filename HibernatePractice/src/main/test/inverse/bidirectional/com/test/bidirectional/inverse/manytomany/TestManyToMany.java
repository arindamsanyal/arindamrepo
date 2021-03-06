package com.test.bidirectional.inverse.manytomany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.hibernate.util.HibernateConfigUtil;

public class TestManyToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateConfigUtil
				.configure("com/test/hibernate/resources/test-hibernate-mapping.cfg.xml");

		Session session = sessionFactory.openSession();

		try {
            //Saving Student 
			Student student1 = new Student();
			Student student2 = new Student();
			student1.setStudentName("Arindam");
			student2.setStudentName("Vickey");
			
			Course c1 = new Course();
			c1.setCourseName("JAVA");
			c1.setDuration(2);
			
			Course c2 = new Course();
			c2.setCourseName("Spring");
			c2.setDuration(4);
			
			Set<Course> coursesForStudent1 = new HashSet<Course>();
			coursesForStudent1.add(c1);
			
			Set<Course> coursesForStudent2 = new HashSet<Course>();
			coursesForStudent2.add(c2);
			
			student1.setCourses(coursesForStudent1);
			student2.setCourses(coursesForStudent2);
			
			/*Course c2 = new Course();
			Course c3 = new Course();
			Course c4 = new Course();
			c1.setCourseName("JAVA");
			c1.setDuration(2);
			c2.setCourseName("Spring");
			c2.setDuration(4);
			c3.setCourseName(".Net");
			c3.setDuration(6);
			c4.setCourseName("Hibernate");
			c4.setDuration(3);

			Set<Course> coursesForStudent1 = new HashSet<Course>();
			coursesForStudent1.add(c1);
			coursesForStudent1.add(c2);
			coursesForStudent1.add(c3);
			coursesForStudent1.add(c4);

			Set<Course> coursesForStudent2 = new HashSet<Course>();

			coursesForStudent2.add(c2);
			coursesForStudent2.add(c3);
			coursesForStudent2.add(c4);

			student1.setCourses(coursesForStudent1);

			student2.setCourses(coursesForStudent2);*/
			
		/*	Set<Student> students = new HashSet<Student>();
			students.add(student1);
			
			Set<Student> students2 = new HashSet<Student>();
			students2.add(student2);
			//students.add(student2);
			c1.setStudents(students);
			c2.setStudents(students2);*/

			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
			
		}

		finally {

			session.close();
			sessionFactory.close();
		}
	}

}
