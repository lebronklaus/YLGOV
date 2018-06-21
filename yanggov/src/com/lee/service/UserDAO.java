package com.lee.service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cn.nwsuaf.gov.service.HibernateSessionFactory;

import com.lee.mode.User;

public class UserDAO {

	public User passw(String name) throws HibernateException, Exception {
		System.out.println("ddddddddddddd");
//		SessionFactory sf = new AnnotationConfiguration().configure()
//				.buildSessionFactory();
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();

		Query query = session
				.createQuery("from User user where user.username =?");
		query.setString(0, name);
		User user = (User) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public void usew(User name) throws HibernateException, Exception {
	 
		Session session = HibernateSessionFactory.createFactory().openSession();
		session.beginTransaction();
		session.save(name);
		session.getTransaction().commit();
		session.close();
	}
}
