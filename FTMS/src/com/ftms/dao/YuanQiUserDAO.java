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

import com.ftms.entity.YuanQiUser;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ftms.entity.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class YuanQiUserDAO {
	private static final Logger log = LoggerFactory.getLogger(YuanQiUserDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	

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

	public void save(YuanQiUser transientInstance) {
		log.debug("saving YuanQiUser instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(YuanQiUser persistentInstance) {
		log.debug("deleting YuanQiUser instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public YuanQiUser findById(java.lang.Integer id) {
		log.debug("getting YuanQiUser instance with id: " + id);
		try {
			YuanQiUser instance = (YuanQiUser) getCurrentSession().get(
					"com.ftms.entity.YuanQiUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(YuanQiUser instance) {
		log.debug("finding YuanQiUser instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.YuanQiUser")
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
		log.debug("finding YuanQiUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from YuanQiUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			
			int len = queryObject.list().size();
			System.out.println(len+"+++++++++++++++++++++++++++++findbyproe");
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByEmail(Object name) {
		return findByProperty(EMAIL, name);
	}
	public List findAll() {
		log.debug("finding all YuanQiUser instances");
		try {
			String queryString = "from YuanQiUser";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public YuanQiUser merge(YuanQiUser detachedInstance) {
		log.debug("merging YuanQiUser instance");
		try {
			YuanQiUser result = (YuanQiUser) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(YuanQiUser instance) {
		log.debug("attaching dirty YuanQiUser instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(YuanQiUser instance) {
		log.debug("attaching clean YuanQiUser instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YuanQiUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (YuanQiUserDAO) ctx.getBean("YuanQiUserDAO");
	}

	
}