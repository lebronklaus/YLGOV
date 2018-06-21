package com.ftms.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ftms.entity.JPositionProvice;

/**
 * A data access object (DAO) providing persistence and search support for
 * JPositionProvice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ftms.entity.JPositionProvice
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JPositionProviceDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JPositionProviceDAO.class);
	// property constants
	public static final String PROVICE_ID = "proviceId";
	public static final String PROVICE_NAME = "proviceName";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(JPositionProvice transientInstance) {
		log.debug("saving JPositionProvice instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JPositionProvice persistentInstance) {
		log.debug("deleting JPositionProvice instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JPositionProvice findById(java.lang.Integer id) {
		log.debug("getting JPositionProvice instance with id: " + id);
		try {
			JPositionProvice instance = (JPositionProvice) getCurrentSession()
					.get("com.ftms.entity.JPositionProvice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JPositionProvice instance) {
		log.debug("finding JPositionProvice instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.JPositionProvice")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding JPositionProvice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from JPositionProvice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProviceId(Object proviceId) {
		return findByProperty(PROVICE_ID, proviceId);
	}

	public List findByProviceName(Object proviceName) {
		return findByProperty(PROVICE_NAME, proviceName);
	}

	public List findAll() {
		log.debug("finding all JPositionProvice instances");
		try {
			String queryString = "from JPositionProvice";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JPositionProvice merge(JPositionProvice detachedInstance) {
		log.debug("merging JPositionProvice instance");
		try {
			JPositionProvice result = (JPositionProvice) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JPositionProvice instance) {
		log.debug("attaching dirty JPositionProvice instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JPositionProvice instance) {
		log.debug("attaching clean JPositionProvice instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JPositionProviceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (JPositionProviceDAO) ctx.getBean("JPositionProviceDAO");
	}
}