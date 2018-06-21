package cn.nwsuaf.gov.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import cn.nwsuaf.gov.bean.nongminUser;

public class nongminUserDAO {

	public nongminUser findById(String id) {
		System.out.println("sdfasdf");
		SessionFactory sf = new Configuration().configure(
				"/zynm.hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		nongminUser user = new nongminUser();
		Query query = session
				.createQuery("from nongminUser nongminuser where nongminuser.id=?");
		query.setString(0, id);
		user = (nongminUser) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	public nongminUser findByUser(String id) {
		System.out.println("sdfasdf");
		SessionFactory sf = new Configuration().configure(
				"/zynm.hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		nongminUser user = new nongminUser();
		Query query = session
				.createQuery("from nongminUser nongminuser where nongminuser.username=?");
		query.setString(0, id);
		user = (nongminUser) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

}
