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

import com.ftms.entity.JPositionCity;

/**
 * A data access object (DAO) providing persistence and search support for
 * JPositionCity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ftms.entity.JPositionCity
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JPositionCityDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JPositionCityDAO.class);
	// property constants
	public static final String PROVINCE_ID = "provinceId";
	public static final String CITY_ID = "cityId";
	public static final String CITY_NAME = "cityName";

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

	public void save(JPositionCity transientInstance) {
		log.debug("saving JPositionCity instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JPositionCity persistentInstance) {
		log.debug("deleting JPositionCity instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JPositionCity findById(java.lang.Integer id) {
		log.debug("getting JPositionCity instance with id: " + id);
		try {
			JPositionCity instance = (JPositionCity) getCurrentSession().get(
					"com.ftms.entity.JPositionCity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(JPositionCity instance) {
		log.debug("finding JPositionCity instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.JPositionCity")
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
		log.debug("finding JPositionCity instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from JPositionCity as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProvinceId(Object provinceId) {
		return findByProperty(PROVINCE_ID, provinceId);
	}

	public List findByCityId(Object cityId) {
		return findByProperty(CITY_ID, cityId);
	}

	public List findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List findAll() {
		log.debug("finding all JPositionCity instances");
		try {
			String queryString = "from JPositionCity";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JPositionCity merge(JPositionCity detachedInstance) {
		log.debug("merging JPositionCity instance");
		try {
			JPositionCity result = (JPositionCity) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JPositionCity instance) {
		log.debug("attaching dirty JPositionCity instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JPositionCity instance) {
		log.debug("attaching clean JPositionCity instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JPositionCityDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (JPositionCityDAO) ctx.getBean("JPositionCityDAO");
	}
}