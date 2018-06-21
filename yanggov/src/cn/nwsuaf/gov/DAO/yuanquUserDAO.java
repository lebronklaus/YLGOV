package cn.nwsuaf.gov.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.nwsuaf.gov.bean.yuanquUser;

public class yuanquUserDAO {
	public yuanquUser findById(String id) {
		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		yuanquUser user = new yuanquUser();
		Query query = session
				.createQuery("from yuanquUser yuanquuser where yuanquuser.id=?");
		query.setString(0, id);
		user = (yuanquUser) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	// 按用户名查找
	public yuanquUser findByUser(String id) {
		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();

		yuanquUser user = new yuanquUser();
		Query query = session
				.createQuery("from yuanquUser yuanquuser where yuanquuser.username=?");
		query.setString(0, id);
		user = (yuanquUser) query.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	@Test
	public void findid() {
		yuanquUser nm = new yuanquUser();
		nm = findById("1");
		System.out.println(nm.getUsername());
	}

	public void addUser(yuanquUser yq) {
		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(yq);
		session.getTransaction().commit();
	}
}
