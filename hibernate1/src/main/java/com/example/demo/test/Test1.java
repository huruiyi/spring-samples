package com.example.demo.test;

import org.hibernate.Session;

import com.example.demo.model.Main;
import com.example.demo.model.Sub;
import com.example.demo.tools.HibernateSessionFactory;

public class Test1 {

	public static void main(String[] args) {

		Main main = new Main();
		main.setMainname("mainname-test1");

		Sub sub = new Sub();
		sub.setSubname("submain-test1");
		sub.setMain(main);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		session.save(main);
		session.save(sub);

		session.getTransaction().commit();
		session.close();
		System.out.println("test1 ok");
	}

}
