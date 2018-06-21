package cn.nwsuaf.gov.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionfactory = null;

	public static SessionFactory createFactory() throws Exception {
		if (sessionfactory == null) {
			sessionfactory = new Configuration().configure()
					.buildSessionFactory();
		}

		return sessionfactory;
	}
}
