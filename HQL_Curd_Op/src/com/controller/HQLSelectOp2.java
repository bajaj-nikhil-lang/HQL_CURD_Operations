package com.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class HQLSelectOp2 {

	public static void main(String[] args) {

		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();

		//one row/record select operation
		
		String hql="select ename from Employee";
		
		Query q=s.createQuery(hql);
		
		List<String> list=q.list();
		
		System.out.println("Employee names are:");
		for(String str:list) {
			System.out.println(str);
		}
		
		
		s.close();
		sf.close();
	}

}
