package com.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class HQLSelectOp1 {

	public static void main(String[] args) {

		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();

		//one row/record select operation
		
		String hql="from Employee where eid=102";
		
		Query q=s.createQuery(hql);
		
		Object o=q.uniqueResult();   //only for single record
		
		Employee e=(Employee)o;
		
		System.out.println("Em[ployee no:"+e.getEid());
		System.out.println("Employee name:"+e.getEname());
		System.out.println("Employee salary: "+e.getEsal());
		
		s.close();
		sf.close();
	}

}
