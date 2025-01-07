package com.controller1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.model.Employee;

public class HQLProjectionOp1 {

	public static void main(String[] args) {

		Configuration con= new Configuration();  //load .cfg file
		SessionFactory sf=con.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		
		Criteria c=s.createCriteria(Employee.class);
		//multiple records but single columns
		Projection p=Projections.property("ename");
		c.setProjection(p);
		
		List<String>list=c.list();
		
		System.out.println("Employee names are:");
		
		
		for(String str:list) {
			System.out.println(str);
		}
		
		
		s.close();
		sf.close();

	}

}
