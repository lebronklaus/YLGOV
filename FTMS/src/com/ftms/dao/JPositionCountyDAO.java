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

import com.ftms.entity.JPositionCounty;

/**
 * A data access object (DAO) providing persistence and search support for
 * JPositionCounty entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ftms.entity.JPositionCounty
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JPositionCountyDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JPositionCountyDAO.class);
	// property constants
	public static final String CITY_ID = "cityId";
	public static final String COUNTY_ID = "countyId";
	public static final String COUNTY_NAME = "countyName";

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

	public void save(JPositionCounty transientInstance) {
		log.debug("saving JPositionCounty instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JPositionCounty persistentInstance) {
		log.debug("deleting JPositionCounty instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JPositionCounty findById(java.lang.Integer id) {
		log.debug("getting JPositionCounty instance with id: " + id);
		try {
			JPositionCounty instance = (JPositionCounty) getCurrentSession()
					.get("com.ftms.entity.JPositionCounty", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JPositionCounty instance) {
		log.debug("finding JPositionCounty instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.JPositionCounty")
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
		log.debug("finding JPositionCounty instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from JPositionCounty as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCityId(Object cityId) {
		return findByProperty(CITY_ID, cityId);
	}

	public List findByCountyId(Object countyId) {
		return findByProperty(COUNTY_ID, countyId);
	}

	public List findByCountyName(Object countyName) {
		return findByProperty(COUNTY_NAME, countyName);
	}

	public List findAll() {
		log.debug("finding all JPositionCounty instances");
		try {
			String queryString = "from JPositionCounty";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JPositionCounty merge(JPositionCounty detachedInstance) {
		log.debug("merging JPositionCounty instance");
		try {
			JPositionCounty result = (JPositionCounty) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JPositionCounty instance) {
		log.debug("attaching dirty JPositionCounty instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JPositionCounty instance) {
		log.debug("attaching clean JPositionCounty instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JPositionCountyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (JPositionCountyDAO) ctx.getBean("JPositionCountyDAO");
	}
}