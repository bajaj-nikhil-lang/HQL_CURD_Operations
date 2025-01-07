package com.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLUpdate {

	public static void main(String[] args) {

		Configuration c= new Configuration();  //load .cfg file
		SessionFactory sf=c.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		
		String hql="update Employee set ename=\'Vijay\' where eid=102";
		
		Query q=s.createQuery(hql);
		
		int i=q.executeUpdate();
		
		System.out.println(i+"N  o of records updated ..!!");
		
		//note: we can update Primary Key (PK) also
		
		t.commit();
		s.close();
		sf.close();

	}

}
