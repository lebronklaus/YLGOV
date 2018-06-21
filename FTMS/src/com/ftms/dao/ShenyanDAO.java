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

import com.ftms.entity.Shenyan;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shenyan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ftms.entity.Shenyan
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ShenyanDAO {
	private static final Logger log = LoggerFactory.getLogger(ShenyanDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String LEVEL = "level";
	public static final String STATUS = "status";

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

	public List<Shenyan> searchCheck(String name, String level) {
		try {
			boolean flag = "".equals(name) && "无".equals(level);
			String queryString = "select id,year,level,status from Shenyan ";
			if (!flag) {
				queryString += "where ";
				boolean first = true;
				if (!"".equals(name)) {
					if (first) {
						queryString += "user.name like '" + name + "'";
					} else {
						queryString += "and user.name like '" + name + "'";
					}
					first = false;
				}
				if (!"无".equals(level)) {
					if (first) {
						queryString += "level like '" + level + "'";
					} else {
						queryString += "and level like '" + level + "'";
					}
					first = false;
				}
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public void save(Shenyan transientInstance) {
		log.debug("saving Shenyan instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shenyan persistentInstance) {
		log.debug("deleting Shenyan instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shenyan findById(java.lang.Integer id) {
		log.debug("getting Shenyan instance with id: " + id);
		try {
			Shenyan instance = (Shenyan) getCurrentSession().get(
					"com.ftms.entity.Shenyan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shenyan instance) {
		log.debug("finding Shenyan instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Shenyan")
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
		log.debug("finding Shenyan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Shenyan as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Shenyan instances");
		try {
			String queryString = "from Shenyan";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shenyan merge(Shenyan detachedInstance) {
		log.debug("merging Shenyan instance");
		try {
			Shenyan result = (Shenyan) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shenyan instance) {
		log.debug("attaching dirty Shenyan instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shenyan instance) {
		log.debug("attaching clean Shenyan instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShenyanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShenyanDAO) ctx.getBean("ShenyanDAO");
	}
	public List searchshenyanid(String username) {
		try {
			/*String queryString = "select shenyan.id from user,shenyan where user.id = shenyan.userid and user.username='"
					+ username+ "'";*/
			String queryString = "select shenyan.id from user,shenyan where user.id = shenyan.userid and user.username= ?";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, username);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}