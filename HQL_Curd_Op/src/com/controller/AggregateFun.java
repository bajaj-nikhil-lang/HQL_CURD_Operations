package com.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AggregateFun {

	public static void main(String[] args) {
		
		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		
		//use of aggregate functions => max,min,avg,count
		String hql="select avg(esal) from Employee";
		String hql2="select max(esal) from Employee";
		String hql3="select min(esal) from Employee";
		
		Query q=s.createQuery(hql);
		Query q2=s.createQuery(hql2);
		Query q3=s.createQuery(hql3);
		
		double avg=(double) q.uniqueResult();
		int max=(int) q2.uniqueResult();
		int min=(int) q3.uniqueResult();
		
		System.out.println("Average salary is :"+avg);
		System.out.println("Max salary is :"+max);
		System.out.println("Min salary is :"+min);
		
		s.close();
		sf.close();
		
		

	}

}
