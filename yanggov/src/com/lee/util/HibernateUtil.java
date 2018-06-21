package com.lee.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//π§æﬂ¿‡

public class HibernateUtil {

	private static SessionFactory sf;
	Configuration conf = new Configuration().configure();
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		return sf;

	}

}
