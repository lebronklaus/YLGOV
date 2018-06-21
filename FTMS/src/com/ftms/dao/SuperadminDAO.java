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

import com.ftms.entity.Superadmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * Superadmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ftms.entity.Superadmin
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SuperadminDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SuperadminDAO.class);
	// property constants
	public static final String SUPERNAME = "supername";
	public static final String SUPERPASSWORD = "superpassword";

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

	public void save(Superadmin transientInstance) {
		log.debug("saving Superadmin instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Superadmin persistentInstance) {
		log.debug("deleting Superadmin instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Superadmin findById(java.lang.Integer id) {
		log.debug("getting Superadmin instance with id: " + id);
		try {
			Superadmin instance = (Superadmin) getCurrentSession().get(
					"com.ftms.dao.Superadmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Superadmin instance) {
		log.debug("finding Superadmin instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.dao.Superadmin")
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
		log.debug("finding Superadmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Superadmin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySupername(Object supername) {
		return findByProperty(SUPERNAME, supername);
	}

	public List findBySuperpassword(Object superpassword) {
		return findByProperty(SUPERPASSWORD, superpassword);
	}

	public List findAll() {
		log.debug("finding all Superadmin instances");
		try {
			String queryString = "from Superadmin";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Superadmin merge(Superadmin detachedInstance) {
		log.debug("merging Superadmin instance");
		try {
			Superadmin result = (Superadmin) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Superadmin instance) {
		log.debug("attaching dirty Superadmin instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Superadmin instance) {
		log.debug("attaching clean Superadmin instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SuperadminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SuperadminDAO) ctx.getBean("SuperadminDAO");
	}
}