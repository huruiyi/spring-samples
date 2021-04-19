package com.example.demo.test;

import org.hibernate.Session;

import com.example.demo.model.Main;
import com.example.demo.model.Sub;
import com.example.demo.tools.HibernateSessionFactory;

public class Test2 {

	public static void main(String[] args) {

		Main main = new Main();
		main.setMainname("mainname-test2");

		Sub sub = new Sub();
		for (int i = 1; i < 6; i++) {
			sub = new Sub();
			sub.setSubname("submain-test2-" + i);
			sub.setMain(main);

			main.getSubs().add(sub);
		}

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		session.save(main);
		session.save(sub);

		session.getTransaction().commit();
		session.close();
		System.out.println("test2 ok");
	}

}
