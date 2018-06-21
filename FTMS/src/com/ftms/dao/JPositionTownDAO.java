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

import com.ftms.entity.JPositionTown;

/**
 * A data access object (DAO) providing persistence and search support for
 * JPositionTown entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ftms.entity.JPositionTown
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JPositionTownDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JPositionTownDAO.class);
	// property constants
	public static final String COUNTY_ID = "countyId";
	public static final String TOWN_ID = "townId";
	public static final String TOWN_NAME = "townName";

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

	public void save(JPositionTown transientInstance) {
		log.debug("saving JPositionTown instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JPositionTown persistentInstance) {
		log.debug("deleting JPositionTown instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JPositionTown findById(java.lang.Integer id) {
		log.debug("getting JPositionTown instance with id: " + id);
		try {
			JPositionTown instance = (JPositionTown) getCurrentSession().get(
					"com.ftms.entity.JPositionTown", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JPositionTown instance) {
		log.debug("finding JPositionTown instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.JPositionTown")
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
		log.debug("finding JPositionTown instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from JPositionTown as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCountyId(Object countyId) {
		return findByProperty(COUNTY_ID, countyId);
	}

	public List findByTownId(Object townId) {
		return findByProperty(TOWN_ID, townId);
	}

	public List findByTownName(Object townName) {
		return findByProperty(TOWN_NAME, townName);
	}

	public List findAll() {
		log.debug("finding all JPositionTown instances");
		try {
			String queryString = "from JPositionTown";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JPositionTown merge(JPositionTown detachedInstance) {
		log.debug("merging JPositionTown instance");
		try {
			JPositionTown result = (JPositionTown) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JPositionTown instance) {
		log.debug("attaching dirty JPositionTown instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JPositionTown instance) {
		log.debug("attaching clean JPositionTown instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JPositionTownDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (JPositionTownDAO) ctx.getBean("JPositionTownDAO");
	}
}