package com.amisha.sec6_hibernate;

import org.hibernate.Session; // to use Session
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoHibernate {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setRollNo(2);
		s1.setsName("Amisha Sharma");
		s1.setsAge(23);

		// Whenever you want to work with DB, you'll have to open a session and to open
		// session, you need SessionFactory.
		// But before anything else, we need to do DBMS configuration to specify which
		// db, which username, password etc.

		Configuration cfg = new Configuration();
		cfg.configure(); 	// calling this method looks for the configuration file (default name -
							// hibernate.cfg.xml)
		cfg.addAnnotatedClass(com.amisha.sec6_hibernate.Student.class);		// to tell IDE where to locate it
		
		// Both Session and SessionFactory are interfaces, but Configuration is a class.
		SessionFactory sf = cfg.buildSessionFactory(); 	// buildSessionFactory() is a method available in class
														// "Configuration" which returns an object of "SessionFactory"
		Session session = sf.openSession(); // openSession() is an abstract method with return type "Session" object
											// declared inside interface "SessionFactory"

		Transaction transaction = session.beginTransaction();
		session.save(s1);
		// As per Database Principle, asset property says "everytime you saves data,
		// it's a transaction." So, hibernate sayes if you are saving data, you are
		// making a transaction, and hence you have to commit the transaction, otherwise
		// it won't be saved.
		transaction.commit(); 	// ERROR: relation "student" does not exist -- since student table doesn't exist
								// in DB -- adding cfg file to create table if not found

		System.out.println(s1);
	}

}
