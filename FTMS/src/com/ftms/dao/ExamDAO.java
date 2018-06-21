package com.ftms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ftms.entity.Exam;

/**
 * A data access object (DAO) providing persistence and search support for Exam
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.ftms.entity.Exam
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ExamDAO {
	private static final Logger log = LoggerFactory.getLogger(ExamDAO.class);
	// property constants
	public static final String LEVEL = "level";
	public static final String TIME = "time";
	public static final String ADDRESS = "address";
	public static final String NAME = "name";
	public static final String GENDER = "gender";
	public static final String PHONE = "phone";
	public static final String IDNUMBER = "idnumber";
	public static final String EDUCATION = "education";
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

	public List<Exam> updateExam(String name, int time, String level,
			String address, String status) {
		 try {
		 Criteria criteria = getCurrentSession().createCriteria(Exam.class);
		 if (!"".equals(name)) {
		 criteria.add(Restrictions.like("name",name));
		 }
		 if (!"无".equals(level)) {
		 criteria.add(Restrictions.like("level", level));
		 }
		 if (!(time == 0)) {
		 criteria.add(Restrictions.eq("time", time));
		 }
		 if (!"无".equals(address)) {
		 criteria.add(Restrictions.like("address", address));
		 }
		 if (!"无".equals(status)) {
		 criteria.add(Restrictions.like("status", status));
		 }
		 return criteria.list();
		 } catch (RuntimeException re) {
		 log.error("find all failed", re);
		 throw re;
		 }
	}
	public List<Exam> searchExam(String name, int time, String level,
			String address, String status) {
		// try {
		// Criteria criteria = getCurrentSession().createCriteria(Exam.class);
		// if (!"".equals(name)) {
		// criteria.add(Restrictions.like("name",name));
		// }
		// if (!"无".equals(level)) {
		// criteria.add(Restrictions.like("level", level));
		// }
		// if (!(time == 0)) {
		// criteria.add(Restrictions.eq("time", time));
		// }
		// if (!"无".equals(address)) {
		// criteria.add(Restrictions.like("address", address));
		// }
		// if (!"无".equals(status)) {
		// criteria.add(Restrictions.like("status", status));
		// }
		// return criteria.list();
		// } catch (RuntimeException re) {
		// log.error("find all failed", re);
		// throw re;
		// }
		try {
			boolean flag = "".equals(name) && "无".equals(level) && time == 0
					&& "无".equals(address) && "无".equals(status);
			String queryString = "select name,level,time,address,status,picpath,gender,birthday,idnumber,phone,"
					+ "JPositionProvice.proviceName,"
					+ "JPositionCity.cityName,"
					+ "JPositionCounty.countyName,"
					+ "JPositionTown.townName,education,"
					+ "prof2.prof1.name,"
					+ "prof2.name,id from Exam ";
			if (!flag) {
				queryString += "where ";
				boolean first = true;
				if (!"".equals(name)) {
					if (first) {
						queryString += "name like '" + name + "'";
					} else {
						queryString += "and name like '" + name + "'";
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
				if (!(time == 0)) {
					if (first) {
						queryString += "time like '" + time + "'";
					} else {
						queryString += "and time like '" + time + "'";
					}
					first = false;
				}
				if (!"无".equals(address)) {
					if (first) {
						queryString += "address like '" + address + "'";
					} else {
						queryString += "and address like '" + address + "'";
					}
					first = false;
				}
				if (!"无".equals(status)) {
					if (first) {
						queryString += "status like '" + status + "'";
					} else {
						queryString += "and status like '" + status + "'";
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

	public int examExist(String name, String level) {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Exam.class);
			if (!"".equals(name)) {
				criteria.add(Restrictions.like("name", name));
			}
			if (!"无".equals(level)) {
				criteria.add(Restrictions.like("level", level));
			}
			return criteria.list().size();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<Exam> examJudge(String name, String level) {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Exam.class);
			if (!"".equals(name)) {
				criteria.add(Restrictions.like("name", name));
			}
			if (!"无".equals(level)) {
				criteria.add(Restrictions.like("level", level));
			}
			return criteria.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void save(Exam transientInstance) {
		log.debug("saving Exam instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Exam persistentInstance) {
		log.debug("deleting Exam instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Exam findById(java.lang.Integer id) {
		log.debug("getting Exam instance with id: " + id);
		try {
			Exam instance = (Exam) getCurrentSession().get(
					"com.ftms.entity.Exam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Exam instance) {
		log.debug("finding Exam instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Exam")
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
		log.debug("finding Exam instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Exam as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByIdnumber(Object idnumber) {
		return findByProperty(IDNUMBER, idnumber);
	}

	public List findByEducation(Object education) {
		return findByProperty(EDUCATION, education);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Exam instances");
		try {
			String queryString = "from Exam";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Exam merge(Exam detachedInstance) {
		log.debug("merging Exam instance");
		try {
			Exam result = (Exam) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Exam instance) {
		log.debug("attaching dirty Exam instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Exam instance) {
		log.debug("attaching clean Exam instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExamDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExamDAO) ctx.getBean("ExamDAO");
	}
}