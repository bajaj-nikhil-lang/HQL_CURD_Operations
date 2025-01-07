package com.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		
		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		String hql="delete from Employee where eid=101";
		Query q=s.createQuery(hql);
		int i=q.executeUpdate();
		System.out.println(i+" No of records deleted");
		
		t.commit();
		s.close();
		sf.close();

	}

}
