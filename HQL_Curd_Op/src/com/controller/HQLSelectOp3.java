package com.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLSelectOp3 {

	public static void main(String[] args) {
		
		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();

		//select multiple column data from records
		
		String hql="select ename,esal from Employee";
		
		Query q=s.createQuery(hql);
		
		List<String> list=q.list();
		
		System.out.println("Employee names and salary are:");

		for(Object o:list) {
			//for each object it will return object array
			Object arr[]=(Object[])o;
			for(Object e:arr) {
				System.out.println(e);
			}
		}
		
		System.out.println("Employe name and salary are: ");
		for(Object o:list) {
			Object arr[]=(Object[])o;
			System.out.print(arr[0]+"  :  ");
			System.out.println(arr[1]);
		}
		
		s.close();
		sf.close();
	}

}
