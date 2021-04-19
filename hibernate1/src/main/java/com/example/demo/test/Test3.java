package com.example.demo.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.example.demo.dao.MainDAO;
import com.example.demo.model.Main;
import com.example.demo.model.Sub;
import com.example.demo.tools.HibernateSessionFactory;

public class Test3 {
	public static void main(String[] args) {

		Main main = new Main();
		main.setMainname("mainname");

		Sub sub = new Sub();
		sub.setSubname("submain");
		sub.setMain(main);

		Sub sub1 = new Sub();
		sub1.setSubname("submain1");
		sub1.setMain(main);

		Sub sub2 = new Sub();
		sub2.setSubname("submain2");
		sub2.setMain(main);

		Sub sub3 = new Sub();
		sub3.setSubname("submain3");
		sub3.setMain(main);

		Sub sub4 = new Sub();
		sub4.setSubname("submain4");
		sub4.setMain(main);

		Set<Sub> subs = new HashSet<Sub>();
		subs.addAll(Arrays.asList(sub1, sub2, sub3, sub4));
		main.setSubs(subs);

		Session session = HibernateSessionFactory.getSession();

		session.beginTransaction();

		session.save(main);

		session.getTransaction().commit();
		session.close();

		MainDAO mainDao = new MainDAO();
		List<Main> list = mainDao.findAll();
		for (Main item : list) {
			System.out.println("*****************************");
			System.out.println(item.getId() + "  " + item.getMainname());
			Set<Sub> itemSubs = item.getSubs();
			for (Sub iSub : itemSubs) {
				System.out.println("\t" + iSub.getId() + "  " + iSub.getMain().getId() + "  " + iSub.getSubname());
			}
			System.out.println("\n");
		}

	}
}
