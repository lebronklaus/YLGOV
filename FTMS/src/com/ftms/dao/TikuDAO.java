package com.ftms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Restrictions;
import com.ftms.entity.Tiku;

/**
 * A data access object (DAO) providing persistence and search support for Tiku
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ftms.entity.Tiku
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TikuDAO {
	private static final Logger log = LoggerFactory.getLogger(TikuDAO.class);
	// property constants
	public static final String PROFESSION = "profession";
	public static final String QUESTION_TYPE = "questionType";
	public static final String DIFFICULTY = "difficulty";
	public static final String QUESTION = "question";
	public static final String SELECTION_A = "selectionA";
	public static final String SELECTION_B = "selectionB";
	public static final String SELECTION_C = "selectionC";
	public static final String SELECTION_D = "selectionD";
	public static final String ANSWER = "answer";

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
	public List findQuestion(String profession,String questionType,String difficulty,String question){
		log.debug("finding question");
		try {
			Criteria criteria = getCurrentSession().createCriteria(Tiku.class);
			if(!"请选择".equals(profession)){
				criteria.add(Restrictions.eq("profession", profession));
			}
			if(!"请选择".equals(questionType)){
				criteria.add(Restrictions.eq("questionType", questionType));
			}
			if(!"请选择".equals(difficulty)){
				criteria.add(Restrictions.eq("difficulty", difficulty));
			}
			if(!"".equals(question)){
				criteria.add(Restrictions.like("question", "%"+question+"%"));
			}
			return criteria.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findXuanze(String profession, String difficulty, int count) {
		log.debug("finding xuanze");
		try {
			/*String queryString = "from Tiku  where profession='" + profession
					+ "' and questionType='选择题' and difficulty='"
					+ difficulty + "' order by rand()";*/
			String queryString = "from Tiku  where profession = ? and questionType='选择题' and difficulty = ? order by rand()";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, profession);
			queryObject.setString(1,difficulty);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(count);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findPanduan(String profession, String difficulty, int count) {
		log.debug("finding panduan");
		try {
			/*String queryString = "from Tiku  where profession='" + profession
					+ "' and questionType='判断题' and difficulty='"
					+ difficulty + "' order by rand()";*/
			String queryString = "from Tiku  where profession = ? and questionType='判断题' and difficulty = ? order by rand()";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, profession);
			queryObject.setString(1,difficulty);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(count);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void save(Tiku transientInstance) {
		log.debug("saving Tiku instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tiku persistentInstance) {
		log.debug("deleting Tiku instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tiku findById(java.lang.Integer id) {
		log.debug("getting Tiku instance with id: " + id);
		try {
			Tiku instance = (Tiku) getCurrentSession().get("com.ftms.entity.Tiku",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tiku instance) {
		log.debug("finding Tiku instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Tiku")
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
		log.debug("finding Tiku instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tiku as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProfession(Object profession) {
		return findByProperty(PROFESSION, profession);
	}

	public List findByQuestionType(Object questionType) {
		return findByProperty(QUESTION_TYPE, questionType);
	}

	public List findByDifficulty(Object difficulty) {
		return findByProperty(DIFFICULTY, difficulty);
	}

	public List findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}

	public List findBySelectionA(Object selectionA) {
		return findByProperty(SELECTION_A, selectionA);
	}

	public List findBySelectionB(Object selectionB) {
		return findByProperty(SELECTION_B, selectionB);
	}

	public List findBySelectionC(Object selectionC) {
		return findByProperty(SELECTION_C, selectionC);
	}

	public List findBySelectionD(Object selectionD) {
		return findByProperty(SELECTION_D, selectionD);
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findAll() {
		log.debug("finding all Tiku instances");
		try {
			String queryString = "from Tiku";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tiku merge(Tiku detachedInstance) {
		log.debug("merging Tiku instance");
		try {
			Tiku result = (Tiku) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tiku instance) {
		log.debug("attaching dirty Tiku instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tiku instance) {
		log.debug("attaching clean Tiku instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TikuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TikuDAO) ctx.getBean("TikuDAO");
	}
}