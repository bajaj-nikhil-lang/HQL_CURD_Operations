package com.controller1;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.model.Employee;

public class HQLCreiteriaOp1 {

	public static void main(String[] args) {

		Configuration con= new Configuration();  //load .cfg file
		SessionFactory sf=con.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		
		//1//select * from Employee
		Criteria c=s.createCriteria(Employee.class);
		//2
		Criterion cr=Restrictions.eq("eid", 102);
		//3
		c.add(cr);
		
		Object o=c.uniqueResult();
		
		System.out.println("Employee details are:");
		Employee e=(Employee)o;
		
		System.out.println("Employee id:"+e.getEid());
		System.out.println("Employee name:"+e.getEname());
		System.out.println("Employee id:"+e.getEsal());
		
	
		//note: we can update Primary Key (PK) also
		
		
		s.close();
		sf.close();

	}

}
