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

import com.ftms.entity.Prof2;

/**
 * A data access object (DAO) providing persistence and search support for Prof2
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ftms.entity.Prof2
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class Prof2DAO {
	private static final Logger log = LoggerFactory.getLogger(Prof2DAO.class);
	// property constants
	public static final String NAME = "name";

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

	public List getProf2(int c1id) {
		try {
			/*String queryString = "from Prof2 where prof1.id=" + c1id;*/
			String queryString = "from Prof2 where prof1.id = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setInteger(0, c1id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void save(Prof2 transientInstance) {
		log.debug("saving Prof2 instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Prof2 persistentInstance) {
		log.debug("deleting Prof2 instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Prof2 findById(java.lang.Integer id) {
		log.debug("getting Prof2 instance with id: " + id);
		try {
			Prof2 instance = (Prof2) getCurrentSession().get(
					"com.ftms.entity.Prof2", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Prof2 instance) {
		log.debug("finding Prof2 instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Prof2")
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
		log.debug("finding Prof2 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Prof2 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Prof2 instances");
		try {
			String queryString = "from Prof2";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Prof2 merge(Prof2 detachedInstance) {
		log.debug("merging Prof2 instance");
		try {
			Prof2 result = (Prof2) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Prof2 instance) {
		log.debug("attaching dirty Prof2 instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Prof2 instance) {
		log.debug("attaching clean Prof2 instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Prof2DAO getFromApplicationContext(ApplicationContext ctx) {
		return (Prof2DAO) ctx.getBean("Prof2DAO");
	}
}