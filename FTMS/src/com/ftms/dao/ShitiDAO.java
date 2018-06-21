package com.ftms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ftms.entity.Shiti;

/**
 * A data access object (DAO) providing persistence and search support for Shiti
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ftms.entity.Shiti
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ShitiDAO {
	private static final Logger log = LoggerFactory.getLogger(ShitiDAO.class);
	// property constants
	public static final String SJBH = "sjbh";
	public static final String QUESTIONRANK = "questionrank";
	public static final String SHITIID = "shitiid";
	public static final String QUESTION_TYPE = "questionType";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";
	public static final String ANSWERCONTENT = "answercontent";
	public static final String USERANSWER = "useranswer";
	public static final String USERANSWERCONTENT = "useranswercontent";

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
	public void panti(Shiti shijuan) {
		log.debug("panti");
		Shiti sj=null;
		try {
			Criteria criteria = getCurrentSession().createCriteria(Shiti.class);
				criteria.add(Restrictions.eq("sjbh", shijuan.getSjbh()));
				criteria.add(Restrictions.eq("shitiid", shijuan.getShitiid()));
			sj= (Shiti) criteria.list().get(0);
			sj.setUseranswer(shijuan.getUseranswer());
			sj.setUseranswercontent(shijuan.getUseranswercontent());
			merge(sj);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List getXuanze(String sjbh) {
		log.debug("getXuanze");
		try {
			Criteria criteria = getCurrentSession().createCriteria(Shiti.class);
				criteria.add(Restrictions.eq("sjbh",sjbh));
				criteria.add(Restrictions.eq("questionType", "选择题"));
				criteria.addOrder(Order.asc("sjid"));
				return criteria.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List getPanduan(String sjbh) {
		log.debug("getXuanze");
		try {
			Criteria criteria = getCurrentSession().createCriteria(Shiti.class);
				criteria.add(Restrictions.eq("sjbh",sjbh));
				criteria.add(Restrictions.eq("questionType", "判断题"));
				criteria.addOrder(Order.asc("sjid"));
				return criteria.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void deleteShijuan(String sjbh){
		log.debug("deleteShiti");
		try {
			String queryString = "delete Shiti where sjbh=?";;
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, sjbh);
			queryObject.executeUpdate();
		} catch (RuntimeException re) {
			log.error("delete all failed", re);
			throw re;
		}
	}
	public List getMiss(String sjbh){
		log.debug("getMiss");
		try {
			/*String queryString = "select questionrank from Shiti  where sjbh='" + sjbh+"' and useranswer is null";*/
			String queryString = "select questionrank from Shiti  where sjbh = ? and useranswer is null";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, sjbh);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void save(Shiti transientInstance) {
		log.debug("saving Shiti instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shiti persistentInstance) {
		log.debug("deleting Shiti instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shiti findById(java.lang.String id) {
		log.debug("getting Shiti instance with id: " + id);
		try {
			Shiti instance = (Shiti) getCurrentSession().get(
					"com.ftms.entity.Shiti", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shiti instance) {
		log.debug("finding Shiti instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Shiti")
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
		log.debug("finding Shiti instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Shiti as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySjbh(Object sjbh) {
		return findByProperty(SJBH, sjbh);
	}

	public List findByQuestionrank(Object questionrank) {
		return findByProperty(QUESTIONRANK, questionrank);
	}

	public List findByShitiid(Object shitiid) {
		return findByProperty(SHITIID, shitiid);
	}

	public List findByQuestionType(Object questionType) {
		return findByProperty(QUESTION_TYPE, questionType);
	}

	public List findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findByAnswercontent(Object answercontent) {
		return findByProperty(ANSWERCONTENT, answercontent);
	}

	public List findByUseranswer(Object useranswer) {
		return findByProperty(USERANSWER, useranswer);
	}

	public List findByUseranswercontent(Object useranswercontent) {
		return findByProperty(USERANSWERCONTENT, useranswercontent);
	}

	public List findAll() {
		log.debug("finding all Shiti instances");
		try {
			String queryString = "from Shiti";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shiti merge(Shiti detachedInstance) {
		log.debug("merging Shiti instance");
		try {
			Shiti result = (Shiti) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shiti instance) {
		log.debug("attaching dirty Shiti instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shiti instance) {
		log.debug("attaching clean Shiti instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShitiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShitiDAO) ctx.getBean("ShitiDAO");
	}
}