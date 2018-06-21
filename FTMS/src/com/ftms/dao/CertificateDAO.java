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

import com.ftms.entity.Certificate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Certificate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ftms.entity.Certificate
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CertificateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CertificateDAO.class);
	// property constants
	public static final String TIME = "time";
	public static final String MAJOR = "major";
	public static final String CERTIFICATENAME = "certificatename";

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

	public void save(Certificate transientInstance) {
		log.debug("saving Certificate instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Certificate persistentInstance) {
		log.debug("deleting Certificate instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Certificate findById(java.lang.Integer id) {
		log.debug("getting Certificate instance with id: " + id);
		try {
			Certificate instance = (Certificate) getCurrentSession().get(
					"com.ftms.entity.Certificate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Certificate instance) {
		log.debug("finding Certificate instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Certificate")
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
		log.debug("finding Certificate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Certificate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findByMajor(Object major) {
		return findByProperty(MAJOR, major);
	}

	public List findByCertificatename(Object certificatename) {
		return findByProperty(CERTIFICATENAME, certificatename);
	}

	public List findAll() {
		log.debug("finding all Certificate instances");
		try {
			String queryString = "from Certificate";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Certificate merge(Certificate detachedInstance) {
		log.debug("merging Certificate instance");
		try {
			Certificate result = (Certificate) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Certificate instance) {
		log.debug("attaching dirty Certificate instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Certificate instance) {
		log.debug("attaching clean Certificate instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CertificateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CertificateDAO) ctx.getBean("CertificateDAO");
	}
}