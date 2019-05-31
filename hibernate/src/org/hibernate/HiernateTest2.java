package org.hibernate;

import java.util.Date;

import org.hibernate.cfg.Configuration;
import org.hibernate.dto.Student;
import org.hibernate.dto.Vehicle;

public class HiernateTest2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student();
		Student stu1=new Student();
		
		Vehicle vehicle=new Vehicle();
		Vehicle vehicle1=new Vehicle();
		Vehicle vehicle2=new Vehicle();
		
		
		//vehicle.setNum(1232);
		vehicle.setModel("activa");
		vehicle1.setModel("pept");
		vehicle2.setModel("car");
		
		stu.setRollNumber(4);
		stu.setName("4 stu");
		stu.setVehicle(vehicle);
		
		stu1.setRollNumber(3);
		stu1.setName("3 stu");
		stu1.setVehicle(vehicle1);
				
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(stu);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

		//sessionFactory.close();
		/*stu=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		stu=(stuDetails)session.get(stuDetails.class,4);
		System.out.println(stu.getstuName());
		session.close();
		System.out.println(stu.getstuName());
		System.out.println(stu.getvehicleList().size());
		sessionFactory.close();
		
*/		
	}


}
