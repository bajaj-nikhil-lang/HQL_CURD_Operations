package com.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class HQLSelectOp5 {

	public static void main(String[] args) {

		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();

		//parameter binding in hibernate. use java variable by variable parameter
		
		String name="Amit";
		
		String hql="from Employee where ename='"+name+"'";
		
		Query q=s.createQuery(hql);
		
		Object o=q.uniqueResult();
		Employee e=(Employee)o;
		
		System.out.println("Employee id:"+e.getEid());
		System.out.println("Employee name:"+e.getEname());
		System.out.println("Employee salary:"+e.getEsal());
		
		
		s.close();
		sf.close();

	}

}
