package com.controller2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.model.Employee;

//display all employee details whose name start with A and salary between 10k to 15k
public class q2 {

	public static void main(String[] args) {
		Configuration con= new Configuration();  //load .cfg file
		SessionFactory sf=con.configure().buildSessionFactory();   //create single session
		Session s=sf.openSession();
		
		//1//display all employee details
		Criteria c=s.createCriteria(Employee.class);
		//2
		
		ProjectionList plist=Projections.projectionList();
		plist.add(Projections.property("eid"));
		plist.add(Projections.property("ename"));
		plist.add(Projections.property("esal"));
		c.setProjection(plist);
		
		Criterion cr1=Restrictions.like("ename", "V%");
		Criterion cr2=Restrictions.between("esal", 10000,19000);
		
		c.add(cr1);
		c.add(cr2);
		List<Object>list=c.list();
		System.out.println("Employee id,Name,Salary are:");
		
		for(Object o:list) {
			Object arr[]=(Object[])o;
			System.out.println(arr[0]+"\t"+arr[1]+"\t"+arr[2]);
		}
		
		
		
		s.close();
		sf.close();
	}

}
