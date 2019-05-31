package org.hibernate;

import java.lang.annotation.Annotation;
import java.util.Date;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.Address;
import org.hibernate.dto.UserDetails;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;

public class HibernateTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		Address address=new Address();
		address.setCountry("India");
		address.setCity("Delhi");
		user.setUserId(4);
		user.setUserName("4 user");
		user.setDob(new Date());
		/*user.setAddress(address);
		*/
		Address address2=new Address();
		address2.setCountry("India");
		address2.setCity("Mumbai");
		Address address3=new Address();
		address3.setCountry("Spain");
		address3.setCity("Madrid");
		Address address4=new Address();
		address4.setCountry("Germany");
		address4.setCity("Berlin");
		
		user.getAddressList().add(address);
		user.getAddressList().add(address2);
		user.getAddressList().add(address3);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		//sessionFactory.close();
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=(UserDetails)session.get(UserDetails.class,4);
		System.out.println(user.getUserName());
		session.close();
		System.out.println(user.getUserName());
		System.out.println(user.getAddressList().size());
		sessionFactory.close();
		
		
	}

}
