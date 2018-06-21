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

import com.ftms.entity.Achievement;

/**
 * A data access object (DAO) providing persistence and search support for
 * Achievement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ftms.entity.Achievement
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AchievementDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AchievementDAO.class);
	// property constants
	public static final String START = "start";
	public static final String END = "end";
	public static final String COMPLETION = "completion";
	public static final String WINESS = "winess";

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

	public void save(Achievement transientInstance) {
		log.debug("saving Achievement instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Achievement persistentInstance) {
		log.debug("deleting Achievement instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Achievement findById(java.lang.Integer id) {
		log.debug("getting Achievement instance with id: " + id);
		try {
			Achievement instance = (Achievement) getCurrentSession().get(
					"com.ftms.entity.Achievement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Achievement instance) {
		log.debug("finding Achievement instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Achievement")
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
		log.debug("finding Achievement instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Achievement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStart(Object start) {
		return findByProperty(START, start);
	}

	public List findByEnd(Object end) {
		return findByProperty(END, end);
	}

	public List findByCompletion(Object completion) {
		return findByProperty(COMPLETION, completion);
	}

	public List findByWiness(Object winess) {
		return findByProperty(WINESS, winess);
	}

	public List findAll() {
		log.debug("finding all Achievement instances");
		try {
			String queryString = "from Achievement";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Achievement merge(Achievement detachedInstance) {
		log.debug("merging Achievement instance");
		try {
			Achievement result = (Achievement) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Achievement instance) {
		log.debug("attaching dirty Achievement instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Achievement instance) {
		log.debug("attaching clean Achievement instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AchievementDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AchievementDAO) ctx.getBean("AchievementDAO");
	}
}