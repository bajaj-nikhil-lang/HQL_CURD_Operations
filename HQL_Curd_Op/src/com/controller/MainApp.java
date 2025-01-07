package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		//Transient 
		Employee e1= new Employee(101,"Amit",12550);
		Employee e2= new Employee(102,"Sumit",15550);
		Employee e3= new Employee(103,"Ajit",17550);
		
		
		
		
		//Persistence 
		s.save(e1);
		s.save(e2);
		s.save(e3);
		
		t.commit();
		s.close();
		sf.close();

	}

}
