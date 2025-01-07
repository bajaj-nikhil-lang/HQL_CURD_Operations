package com.controller;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class HQLCriteriaOp1 {

	public static void main(String[] args) {
		
		Configuration con= new Configuration();  //load .cfg file
		SessionFactory sf=con.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		
		//1//select * from Employee
		Criteria c=s.createCriteria(Employee.class);
		

	}

}
