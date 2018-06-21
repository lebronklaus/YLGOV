package cn.nwsuaf.gov.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.nwsuaf.gov.bean.qiyeUser;

public class qiyeUserDAO {

	public qiyeUser findById(String id) {
		System.out.println("sdfasdf");
		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		qiyeUser user = new qiyeUser();
		Query query = session
				.createQuery("from qiyeUser qiyeuser where qiyeuser.id=?");
		query.setString(0, id);
		user = (qiyeUser) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	// 按用户名查找
	public qiyeUser findByUser(String id) {
		System.out.println("sdfasdf");
		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		qiyeUser user = new qiyeUser();
		Query query = session
				.createQuery("from qiyeUser qiyeuser where qiyeuser.username=?");
		query.setString(0, id);
		user = (qiyeUser) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	public void addUser(qiyeUser qy) {
		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(qy);
		session.getTransaction().commit();
	}

}
