package com.ftms.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ftms.entity.Results;

/**
 * A data access object (DAO) providing persistence and search support for
 * Results entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ftms.entity.Results
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ResultsDAO {
	private static final Logger log = LoggerFactory.getLogger(ResultsDAO.class);
	// property constants
	public static final String ACHIEVEMENT = "achievement";
	public static final String TOTAL = "total";
	public static final String REAL = "real";
	public static final String APPROVAL = "approval";
	public static final String OPPOSITION = "opposition";
	public static final String LEVEL = "level";
	public static final String NUMBER = "number";
	public static final String WRITESCORE = "writescore";
	public static final String INTERVIEWSCORE = "interviewscore";
	public static final String TOTALSCORE = "totalscore";

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

	// 条件查询
	public List searchByAll(String province, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
		try {
			boolean flag = "不限".equals(province) && "不限".equals(prof1)
					&& "不限".equals(prof2) && "不限".equals(gender)
					&& "不限".equals(education) && "不限".equals(level)
					&& "不限".equals(fazheng);
			String queryString = "select user.username,"
					+ "user.name,"
					+ "user.gender,"
					+ "user.birthday,"
					+ "user.password,"
					+ "user.phone,"
					+ "user.education,"
					+ "user.idnumber,"
					+ "user.prof2.prof1.name,"
					+ "user.prof2.name,"
					+ "user.JPositionProvice.proviceName,"
					+ "user.JPositionCity.cityName,"
					+ "user.JPositionCounty.countyName,"
					+ "user.JPositionTown.townName,"
					+ "fazhengtime,"
					+ "level,"
					+ "writescore,"
					+ "interviewscore,"
					+ "totalscore,"
					+ "number from Results ";
			if (!flag) {
				queryString += "where";
				boolean first = true;
				if (!"不限".equals(province)) {
					if (first) {
						queryString += " user.JPositionProvice.proviceName like '"
								+ province + "' ";
					} else {
						queryString += " and user.JPositionProvice.proviceName like '"
								+ province + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof1)) {
					if (first) {
						queryString += " user.prof2.prof1.name like '" + prof1
								+ "' ";
					} else {
						queryString += " and user.prof2.prof1.name like '"
								+ prof1 + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof2)) {
					if (first) {
						queryString += " user.prof2.name like '" + prof2 + "' ";
					} else {
						queryString += " and user.prof2.name like '" + prof2
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(gender)) {
					if (first) {
						queryString += "  user.gender like '" + gender + "' ";
					} else {
						queryString += " and  user.gender like '" + gender
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(education)) {
					if (first) {
						queryString += "  user.education like '" + education
								+ "' ";
					} else {
						queryString += " and user.education like '" + education
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(level)) {
					if (first) {
						queryString += "  level like '" + level + "' ";
					} else {
						queryString += " and level like '" + level + "' ";
					}
					first = false;
				}
				if (!"不限".equals(fazheng)) {
					if (first) {
						queryString += "  YEAR(fazhengtime) like '" + fazheng
								+ "' ";
					} else {
						queryString += " and YEAR(fazhengtime) like '"
								+ fazheng + "' ";
					}
				}
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			if (!"不限".equals(age)) {
				List<Object> results = queryObject.list();
				List<Object> ages1 = new ArrayList<Object>();
				List<Object> ages2 = new ArrayList<Object>();
				List<Object> ages3 = new ArrayList<Object>();
				List<Object> ages4 = new ArrayList<Object>();
				List<Object> ages5 = new ArrayList<Object>();
				List<Object> ages6 = new ArrayList<Object>();
				Iterator<Object> iter = results.iterator();
				while (iter.hasNext()) {
					Object[] data = (Object[]) iter.next();
					int a =getAge((Timestamp) data[3]);
					if (a < 20) {
						ages1.add(data);
					} else if (a >= 20 && a < 30) {
						ages2.add(data);
					} else if (a >= 30 && a < 40) {
						ages3.add(data);
					} else if (a >= 40 && a < 50) {
						ages4.add(data);
					} else if (a >= 50 && a < 60) {
						ages5.add(data);
					} else if (a >= 60) {
						ages6.add(data);
					}
				}
				if ("20以下".equals(age)) {
					return ages1;
				} else if ("20-30".equals(age)) {
					return ages2;
				} else if ("30-40".equals(age)) {
					return ages3;
				} else if ("40-50".equals(age)) {
					return ages4;
				} else if ("50-60".equals(age)) {
					return ages5;
				} else if ("60以上".equals(age)) {
					return ages6;
				}
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int getAge(Timestamp birthday) {
		Timestamp today = new Timestamp(new Date().getTime());
		String[] b = birthday.toString().split(" ")[0].split("-");
		String[] t = today.toString().split(" ")[0].split("-");
		int age = Integer.parseInt(t[0]) - Integer.parseInt(b[0]);
		if (Integer.parseInt(t[1]) < Integer.parseInt(b[1])) {
			age -= 1;
		} else if (Integer.parseInt(t[1]) == Integer.parseInt(b[1])) {
			if (Integer.parseInt(t[2]) < Integer.parseInt(b[2])) {
				age -= 1;
			}
		}
		return age;
	}

	public List searchByProvince(String city, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
//		try {
//			boolean flag = "不限".equals(city) && "不限".equals(prof1)
//					&& "不限".equals(prof2) && "不限".equals(gender)
//					&& "不限".equals(education) && "不限".equals(level)
//					&& "不限".equals(fazheng);
//			String queryString = "from Results ";
//			if (!flag) {
//				queryString += "where";
//				boolean first = true;
//				if (!"不限".equals(city)) {
//					if (first) {
//						queryString += " user.JPositionCity.cityName like '"
//								+ city + "' ";
//					} else {
//						queryString += " and user.JPositionCity.cityName like '"
//								+ city + "' ";
//					}
//					first = false;
//				}
//				if (!"不限".equals(prof1)) {
//					if (first) {
//						queryString += " user.prof2.prof1.name like '" + prof1
//								+ "' ";
//					} else {
//						queryString += " and user.prof2.prof1.name like '"
//								+ prof1 + "' ";
//					}
//					flag = false;
//				}
//				if (!"不限".equals(prof2)) {
//					if (first) {
//						queryString += " user.prof2.name like '" + prof2 + "' ";
//					} else {
//						queryString += " and user.prof2.name like '" + prof2
//								+ "' ";
//					}
//					flag = false;
//				}
//				if (!"不限".equals(gender)) {
//					if (first) {
//						queryString += "  user.gender like '" + gender + "' ";
//					} else {
//						queryString += " and  user.gender like '" + gender
//								+ "' ";
//					}
//					flag = false;
//				}
//				if (!"不限".equals(education)) {
//					if (first) {
//						queryString += "  user.education like '" + education
//								+ "' ";
//					} else {
//						queryString += " and user.education like '" + education
//								+ "' ";
//					}
//					flag = false;
//				}
//				if (!"不限".equals(level)) {
//					if (first) {
//						queryString += "  level like '" + level + "' ";
//					} else {
//						queryString += " and level like '" + level + "' ";
//					}
//				}
//				if (!"不限".equals(fazheng)) {
//					if (first) {
//						queryString += "  YEAR(fazhengtime) like '" + fazheng
//								+ "' ";
//					} else {
//						queryString += " and YEAR(fazhengtime) like '"
//								+ fazheng + "' ";
//					}
//				}
//			}
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			if (!"不限".equals(age)) {
//				List<Results> results = queryObject.list();
//				List<Results> ages1 = new ArrayList<Results>();
//				List<Results> ages2 = new ArrayList<Results>();
//				List<Results> ages3 = new ArrayList<Results>();
//				List<Results> ages4 = new ArrayList<Results>();
//				List<Results> ages5 = new ArrayList<Results>();
//				List<Results> ages6 = new ArrayList<Results>();
//				for (Results r : results) {
//					int a = getAge(r.getUser().getBirthday());
//					if (a < 20) {
//						ages1.add(r);
//					} else if (a >= 20 && a < 30) {
//						ages2.add(r);
//					} else if (a >= 30 && a < 40) {
//						ages3.add(r);
//					} else if (a >= 40 && a < 50) {
//						ages4.add(r);
//					} else if (a >= 50 && a < 60) {
//						ages5.add(r);
//					} else if (a >= 60) {
//						ages6.add(r);
//					}
//				}
//				if ("20以下".equals(age)) {
//					return ages1;
//				} else if ("20-30".equals(age)) {
//					return ages2;
//				} else if ("30-40".equals(age)) {
//					return ages3;
//				} else if ("40-50".equals(age)) {
//					return ages4;
//				} else if ("50-60".equals(age)) {
//					return ages5;
//				} else if ("60以上".equals(age)) {
//					return ages6;
//				}
//			}
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			throw re;
//		}
		try {
			boolean flag = "不限".equals(city) && "不限".equals(prof1)
					&& "不限".equals(prof2) && "不限".equals(gender)
					&& "不限".equals(education) && "不限".equals(level)
					&& "不限".equals(fazheng);
			String queryString = "select user.username,"
					+ "user.name,"
					+ "user.gender,"
					+ "user.birthday,"
					+ "user.password,"
					+ "user.phone,"
					+ "user.education,"
					+ "user.idnumber,"
					+ "user.prof2.prof1.name,"
					+ "user.prof2.name,"
					+ "user.JPositionProvice.proviceName,"
					+ "user.JPositionCity.cityName,"
					+ "user.JPositionCounty.countyName,"
					+ "user.JPositionTown.townName,"
					+ "fazhengtime,"
					+ "level,"
					+ "writescore,"
					+ "interviewscore,"
					+ "totalscore,"
					+ "number from Results ";
			if (!flag) {
				queryString += "where";
				boolean first = true;
				if (!"不限".equals(city)) {
					if (first) {
						queryString += " user.JPositionCity.cityName like '"
								+ city + "' ";
					} else {
						queryString += " and user.JPositionCity.cityName like '"
								+ city + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof1)) {
					if (first) {
						queryString += " user.prof2.prof1.name like '" + prof1
								+ "' ";
					} else {
						queryString += " and user.prof2.prof1.name like '"
								+ prof1 + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof2)) {
					if (first) {
						queryString += " user.prof2.name like '" + prof2 + "' ";
					} else {
						queryString += " and user.prof2.name like '" + prof2
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(gender)) {
					if (first) {
						queryString += "  user.gender like '" + gender + "' ";
					} else {
						queryString += " and  user.gender like '" + gender
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(education)) {
					if (first) {
						queryString += "  user.education like '" + education
								+ "' ";
					} else {
						queryString += " and user.education like '" + education
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(level)) {
					if (first) {
						queryString += "  level like '" + level + "' ";
					} else {
						queryString += " and level like '" + level + "' ";
					}
				}
				if (!"不限".equals(fazheng)) {
					if (first) {
						queryString += "  YEAR(fazhengtime) like '" + fazheng
								+ "' ";
					} else {
						queryString += " and YEAR(fazhengtime) like '"
								+ fazheng + "' ";
					}
				}
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			if (!"不限".equals(age)) {
				List<Object> results = queryObject.list();
				List<Object> ages1 = new ArrayList<Object>();
				List<Object> ages2 = new ArrayList<Object>();
				List<Object> ages3 = new ArrayList<Object>();
				List<Object> ages4 = new ArrayList<Object>();
				List<Object> ages5 = new ArrayList<Object>();
				List<Object> ages6 = new ArrayList<Object>();
				Iterator<Object> iter = results.iterator();
				while (iter.hasNext()) {
					Object[] data = (Object[]) iter.next();
					int a =getAge((Timestamp) data[3]);
					if (a < 20) {
						ages1.add(data);
					} else if (a >= 20 && a < 30) {
						ages2.add(data);
					} else if (a >= 30 && a < 40) {
						ages3.add(data);
					} else if (a >= 40 && a < 50) {
						ages4.add(data);
					} else if (a >= 50 && a < 60) {
						ages5.add(data);
					} else if (a >= 60) {
						ages6.add(data);
					}
				}
				if ("20以下".equals(age)) {
					return ages1;
				} else if ("20-30".equals(age)) {
					return ages2;
				} else if ("30-40".equals(age)) {
					return ages3;
				} else if ("40-50".equals(age)) {
					return ages4;
				} else if ("50-60".equals(age)) {
					return ages5;
				} else if ("60以上".equals(age)) {
					return ages6;
				}
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int findAllUser() {
		try {
			String queryString = "select count(distinct id)  from Results";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}
	// 全国数据统计查询
	public int getProvince() {
		try {
			String queryString = "select count(distinct user.JPositionProvice)  from Results";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int getCity() {
		try {
			String queryString = "select count(distinct user.JPositionCity)  from Results";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int getCounty() {
		try {
			String queryString = "select count(distinct user.JPositionCounty)  from Results";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByProvince() {
		try {
			String queryString = "select user.JPositionProvice.proviceName as province, count(user.JPositionProvice) as count from Results group by user.JPositionProvice ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByGender() {
		try {
			String queryString = "select user.gender, count(user.gender) from Results group by user.gender ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByProf() {
		try {
			String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results group by user.prof2.prof1 ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByAge() {
		try {
			String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results where user.id = results.userid";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByYear() {
		try {
			String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results where user.id = results.userid group by YEAR(fazhengtime)";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByLevel() {
		try {
			String queryString = "select level,count(level) from Results group by level ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countByEducation() {
		try {
			String queryString = "select user.education, count(user.education) from Results group by user.education ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 分省数据统计查询
	public int provinceGetTotal(String province) {
		try {
			/*String queryString = "select count(*)  from Results where user.JPositionProvice.proviceName='"
					+ province + "'";*/
			String queryString = "select count(*)  from Results where user.JPositionProvice.proviceName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int provinceGetCity(String province) {
		try {
			/*String queryString = "select count(distinct user.JPositionCity)  from Results where user.JPositionProvice.proviceName='"
					+ province + "'";*/
			String queryString = "select count(distinct user.JPositionCity)  from Results where user.JPositionProvice.proviceName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int provinceGetCounty(String province) {
		try {
			/*String queryString = "select count(distinct user.JPositionCounty)  from Results where user.JPositionProvice.proviceName='"
					+ province + "'";*/
			String queryString = "select count(distinct user.JPositionCounty)  from Results where user.JPositionProvice.proviceName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByCity(String province) {
		try {
			/*String queryString = "select user.JPositionCity.cityName, count(user.JPositionCity) from Results where user.JPositionProvice.proviceName='"
					+ province + "' group by user.JPositionCity";*/
			String queryString = "select user.JPositionCity.cityName, count(user.JPositionCity) from Results where user.JPositionProvice.proviceName = ?group by user.JPositionCity";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByCounty(String province) {
		try {
			/*String queryString = "select user.JPositionCounty.cityName, count(user.JPositionCounty) from Results where user.JPositionProvice.proviceName='"
					+ province + "' group by user.JPositionCounty";*/
			String queryString = "select user.JPositionCounty.cityName, count(user.JPositionCounty) from Results where user.JPositionProvice.proviceName = ? group by user.JPositionCounty";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByGender(String province) {
		try {
			/*String queryString = "select user.gender, count(user.gender) from Results where user.JPositionProvice.proviceName='"
					+ province + "' group by user.gender ";*/
			String queryString = "select user.gender, count(user.gender) from Results where user.JPositionProvice.proviceName = ? group by user.gender ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByProf(String province) {
		try {
			/*String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results where user.JPositionProvice.proviceName='"
					+ province + "' group by user.prof2.prof1 ";*/
			String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results where user.JPositionProvice.proviceName = ? group by user.prof2.prof1 ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByAge(String province) {
		try {
			/*String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results,j_position_provice "
					+ "where user.id = results.userid and user.province=j_position_provice.id "
					+ "and j_position_provice.provice_name='" + province + "'";*/
			String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results,j_position_provice "
					+ "where user.id = results.userid and user.province=j_position_provice.id "
					+ "and j_position_provice.provice_name = ?";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByYear(String province) {
		try {
			/*String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results,j_position_provice "
					+ "where user.id = results.userid and user.province=j_position_provice.id "
					+ "and j_position_provice.provice_name='"
					+ province
					+ "' group by YEAR(fazhengtime) ";*/
			String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results,j_position_provice "
					+ "where user.id = results.userid and user.province=j_position_provice.id "
					+ "and j_position_provice.provice_name= ? group by YEAR(fazhengtime) ";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByLevel(String province) {
		try {
			/*String queryString = "select level, count(level) from Results  where user.JPositionProvice.proviceName='"
					+ province + "' group by level ";*/
			String queryString = "select level, count(level) from Results  where user.JPositionProvice.proviceName = ? group by level ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List provinceCountByEducation(String province) {
		try {
			/*String queryString = "select user.education, count(user.education) from Results where user.JPositionProvice.proviceName='"
					+ province + "' group by user.education ";*/
			String queryString = "select user.education, count(user.education) from Results where user.JPositionProvice.proviceName = ? group by user.education ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, province);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void save(Results transientInstance) {
		log.debug("saving Results instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Results persistentInstance) {
		log.debug("deleting Results instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Results findById(java.lang.Integer id) {
		log.debug("getting Results instance with id: " + id);
		try {
			Results instance = (Results) getCurrentSession().get(
					"com.ftms.entity.Results", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Results instance) {
		log.debug("finding Results instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ftms.entity.Results")
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
		log.debug("finding Results instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Results as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAchievement(Object achievement) {
		return findByProperty(ACHIEVEMENT, achievement);
	}

	public List findByTotal(Object total) {
		return findByProperty(TOTAL, total);
	}

	public List findByReal(Object real) {
		return findByProperty(REAL, real);
	}

	public List findByApproval(Object approval) {
		return findByProperty(APPROVAL, approval);
	}

	public List findByOpposition(Object opposition) {
		return findByProperty(OPPOSITION, opposition);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByWritescore(Object writescore) {
		return findByProperty(WRITESCORE, writescore);
	}

	public List findByInterviewscore(Object interviewscore) {
		return findByProperty(INTERVIEWSCORE, interviewscore);
	}

	public List findByTotalscore(Object totalscore) {
		return findByProperty(TOTALSCORE, totalscore);
	}

	public List findAll() {
		log.debug("finding all Results instances");
		try {
			String queryString = "from Results";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Results merge(Results detachedInstance) {
		log.debug("merging Results instance");
		try {
			Results result = (Results) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Results instance) {
		log.debug("attaching dirty Results instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Results instance) {
		log.debug("attaching clean Results instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResultsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ResultsDAO) ctx.getBean("ResultsDAO");
	}

	// 分市统计

	public int cityGetTotal(String city) {
		try {
			/*String queryString = "select count(*)  from Results where user.JPositionCity.cityName='"
					+ city + "'";*/
			String queryString = "select count(*)  from Results where user.JPositionCity.cityName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int cityGetCounty(String city) {
		try {
			/*String queryString = "select count(distinct user.JPositionCounty)  from Results where user.JPositionCity.cityName='"
					+ city + "'";*/
			String queryString = "select count(distinct user.JPositionCounty)  from Results where user.JPositionCity.cityName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByAge(String city) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results,j_position_city "
					+ "where user.id = results.userid and user.city=j_position_city.id "
					+ "and j_position_city.city_name='" + city + "'";*/
			String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results,j_position_city "
					+ "where user.id = results.userid and user.city=j_position_city.id "
					+ "and j_position_city.city_name = ?";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByYear(String city) {
		try {
			/*String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results,j_position_city "
					+ "where user.id = results.userid and user.city=j_position_city.id "
					+ "and j_position_city.city_name='"
					+ city
					+ "' group by YEAR(fazhengtime) ";*/
			String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results,j_position_city "
					+ "where user.id = results.userid and user.city=j_position_city.id "
					+ "and j_position_city.city_name = ? group by YEAR(fazhengtime) ";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByEducation(String city) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.education, count(user.education) from Results where user.JPositionCity.cityName='"
					+ city + "' group by user.education ";*/
			String queryString = "select user.education, count(user.education) from Results where user.JPositionCity.cityName = ? group by user.education ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByLevel(String city) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select level, count(level) from Results  where user.JPositionCity.cityName='"
					+ city + "' group by level ";*/
			String queryString = "select level, count(level) from Results  where user.JPositionCity.cityName = ? group by level ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByProf(String city) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results where user.JPositionCity.cityName='"
					+ city + "' group by user.prof2.prof1 ";*/
			String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results where user.JPositionCity.cityName = ? group by user.prof2.prof1 ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByGender(String city) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.gender, count(user.gender) from Results where user.JPositionCity.cityName='"
					+ city + "' group by user.gender ";*/
			String queryString = "select user.gender, count(user.gender) from Results where user.JPositionCity.cityName = ? group by user.gender ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List cityCountByCounty(String city) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.JPositionCounty.countyName, count(user.JPositionCounty) from Results where user.JPositionCity.cityName='"
					+ city + "' group by user.JPositionCounty";*/
			String queryString = "select user.JPositionCounty.countyName, count(user.JPositionCounty) from Results where user.JPositionCity.cityName = ? group by user.JPositionCounty";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, city);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List searchByCity(String county, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
		try {
			boolean flag = "不限".equals(county) && "不限".equals(prof1)
					&& "不限".equals(prof2) && "不限".equals(gender)
					&& "不限".equals(education) && "不限".equals(level)
					&& "不限".equals(fazheng);
			String queryString = "select user.username,user.name,user.gender,user.birthday,user.password,user.phone,user.education,user.idnumber,user.prof2.prof1.name,user.prof2.name,user.JPositionProvice.proviceName,user.JPositionCity.cityName,user.JPositionCounty.countyName,user.JPositionTown.townName,fazhengtime,level,writescore,interviewscore,totalscore,number from Results ";
			if (!flag) {
				queryString += "where";
				boolean first = true;
				if (!"不限".equals(county)) {
					if (first) {
						queryString += " user.JPositionCounty.countyName like '"
								+ county + "' ";
					} else {
						queryString += " user.JPositionCounty.countyName like '"
								+ county + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof1)) {
					if (first) {
						queryString += " user.prof2.prof1.name like '" + prof1
								+ "' ";
					} else {
						queryString += " and user.prof2.prof1.name like '"
								+ prof1 + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof2)) {
					if (first) {
						queryString += " user.prof2.name like '" + prof2 + "' ";
					} else {
						queryString += " and user.prof2.name like '" + prof2
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(gender)) {
					if (first) {
						queryString += "  user.gender like '" + gender + "' ";
					} else {
						queryString += " and  user.gender like '" + gender
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(education)) {
					if (first) {
						queryString += "  user.education like '" + education
								+ "' ";
					} else {
						queryString += " and user.education like '" + education
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(level)) {
					if (first) {
						queryString += "  level like '" + level + "' ";
					} else {
						queryString += " and level like '" + level + "' ";
					}
				}
				if (!"不限".equals(fazheng)) {
					if (first) {
						queryString += "  YEAR(fazhengtime) like '" + fazheng
								+ "' ";
					} else {
						queryString += " and YEAR(fazhengtime) like '"
								+ fazheng + "' ";
					}
				}
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			if (!"不限".equals(age)) {
				List<Object> results = queryObject.list();
				List<Object> ages1 = new ArrayList<Object>();
				List<Object> ages2 = new ArrayList<Object>();
				List<Object> ages3 = new ArrayList<Object>();
				List<Object> ages4 = new ArrayList<Object>();
				List<Object> ages5 = new ArrayList<Object>();
				List<Object> ages6 = new ArrayList<Object>();
				Iterator<Object> iter = results.iterator();
				while (iter.hasNext()) {
					Object[] data = (Object[]) iter.next();
					int a =getAge((Timestamp) data[3]);
					if (a < 20) {
						ages1.add(data);
					} else if (a >= 20 && a < 30) {
						ages2.add(data);
					} else if (a >= 30 && a < 40) {
						ages3.add(data);
					} else if (a >= 40 && a < 50) {
						ages4.add(data);
					} else if (a >= 50 && a < 60) {
						ages5.add(data);
					} else if (a >= 60) {
						ages6.add(data);
					}
				}
				if ("20以下".equals(age)) {
					return ages1;
				} else if ("20-30".equals(age)) {
					return ages2;
				} else if ("30-40".equals(age)) {
					return ages3;
				} else if ("40-50".equals(age)) {
					return ages4;
				} else if ("50-60".equals(age)) {
					return ages5;
				} else if ("60以上".equals(age)) {
					return ages6;
				}
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List getUserResult(String username, String level) {
		try {
			/*String queryString = "select achievement,user.prof2.prof1.name,user.prof2.name,writescore,interviewscore,total,canjia,approval,opposition,number,user.name,user.gender,user.birthday,user.phone,user.idnumber,user.JPositionProvice.proviceName,user.JPositionCity.cityName,user.JPositionCounty.countyName,user.JPositionTown.townName,user.education,user.picpath from Results where user.username like '"
					+ username + "' and level like '" + level + "' ";*/
			String queryString = "select achievement,user.prof2.prof1.name,user.prof2.name,writescore,interviewscore,total,canjia,approval,opposition,number,user.name,user.gender,user.birthday,user.phone,user.idnumber,user.JPositionProvice.proviceName,user.JPositionCity.cityName,user.JPositionCounty.countyName,user.JPositionTown.townName,user.education,user.picpath from Results where user.username like :username and level like :level";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString("username", username);
			queryObject.setString("level", level);
			return queryObject.list();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public List<Results> searchCheck(String name, String level) {
		try {
			boolean flag = "".equals(name) && "无".equals(level);
			String queryString = "from Results ";
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

	// 分县

	public int countyGetTotal(String county) {
		try {
			/*String queryString = "select count(*)  from Results where user.JPositionCounty.countyName='"
					+ county + "'";*/
			String queryString = "select count(*)  from Results where user.JPositionCounty.countyName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int countyGetTown(String county) {
		try {
			/*String queryString = "select count(distinct user.JPositionTown)  from Results where user.JPositionCounty.countyName='"
					+ county + "'";*/
			String queryString = "select count(distinct user.JPositionTown)  from Results where user.JPositionCounty.countyName = ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return Integer.parseInt(queryObject.list().get(0).toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByTown(String county) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.JPositionTown.townName, count(user.JPositionTown) from Results where user.JPositionCounty.countyName='"
					+ county + "' group by user.JPositionTown";*/
			String queryString = "select user.JPositionTown.townName, count(user.JPositionTown) from Results where user.JPositionCounty.countyName = ? group by user.JPositionTown";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByAge(String county) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results,j_position_county "
					+ "where user.id = results.userid and user.country=j_position_county.id "
					+ "and j_position_county.county_name='" + county + "'";*/
			String queryString = "select (YEAR(NOW())-YEAR(birthday)-1) + ( DATE_FORMAT(birthday, '%m%d') <= DATE_FORMAT(NOW(), '%m%d') ) from user,results,j_position_county "
					+ "where user.id = results.userid and user.country=j_position_county.id "
					+ "and j_position_county.county_name = ?";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByYear(String county) {
		try {
			/*String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results,j_position_county "
					+ "where user.id = results.userid and user.country=j_position_county.id "
					+ "and j_position_county.county_name='"
					+ county
					+ "' group by YEAR(fazhengtime) ";*/
			String queryString = "select YEAR(fazhengtime), count(YEAR(fazhengtime)) from user,results,j_position_county "
					+ "where user.id = results.userid and user.country=j_position_county.id "
					+ "and j_position_county.county_name = ? group by YEAR(fazhengtime) ";
			Query queryObject = getCurrentSession().createSQLQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByEducation(String county) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.education, count(user.education) from Results where user.JPositionCounty.countyName='"
					+ county + "' group by user.education ";*/
			String queryString = "select user.education, count(user.education) from Results where user.JPositionCounty.countyName = ? group by user.education ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByLevel(String county) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select level, count(level) from Results  where user.JPositionCounty.countyName='"
					+ county + "' group by level ";*/
			String queryString = "select level, count(level) from Results  where user.JPositionCounty.countyName = ? group by level ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByProf(String county) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results where user.JPositionCounty.countyName='"
					+ county + "' group by user.prof2.prof1 ";*/
			String queryString = "select user.prof2.prof1.name, count(user.prof2.prof1) from Results where user.JPositionCounty.countyName = ? group by user.prof2.prof1 ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List countyCountByGender(String county) {
		// TODO Auto-generated method stub
		try {
			/*String queryString = "select user.gender, count(user.gender) from Results where user.JPositionCounty.countyName='"
					+ county + "' group by user.gender ";*/
			String queryString = "select user.gender, count(user.gender) from Results where user.JPositionCounty.countyName = ? group by user.gender ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setString(0, county);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List searchByCounty(String town, String prof1, String prof2,
			String gender, String age, String education, String level,
			String fazheng) {
		// TODO Auto-generated method stub
		try {
			boolean flag = "不限".equals(town) && "不限".equals(prof1)
					&& "不限".equals(prof2) && "不限".equals(gender)
					&& "不限".equals(education) && "不限".equals(level)
					&& "不限".equals(fazheng);
			String queryString = "select user.username,user.name,user.gender,user.birthday,user.password,user.phone,user.education,user.idnumber,user.prof2.prof1.name,user.prof2.name,user.JPositionProvice.proviceName,user.JPositionCity.cityName,user.JPositionCounty.countyName,user.JPositionTown.townName,fazhengtime,level,writescore,interviewscore,totalscore,number from Results ";
			if (!flag) {
				queryString += "where";
				boolean first = true;
				if (!"不限".equals(town)) {
					if (first) {
						queryString += " user.JPositionTown.townName like '"
								+ town + "' ";
					} else {
						queryString += " user.JPositionTown.townName like '"
								+ town + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof1)) {
					if (first) {
						queryString += " user.prof2.prof1.name like '" + prof1
								+ "' ";
					} else {
						queryString += " and user.prof2.prof1.name like '"
								+ prof1 + "' ";
					}
					first = false;
				}
				if (!"不限".equals(prof2)) {
					if (first) {
						queryString += " user.prof2.name like '" + prof2 + "' ";
					} else {
						queryString += " and user.prof2.name like '" + prof2
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(gender)) {
					if (first) {
						queryString += "  user.gender like '" + gender + "' ";
					} else {
						queryString += " and user.gender like '" + gender
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(education)) {
					if (first) {
						queryString += "  user.education like '" + education
								+ "' ";
					} else {
						queryString += " and user.education like '" + education
								+ "' ";
					}
					first = false;
				}
				if (!"不限".equals(level)) {
					if (first) {
						queryString += "  level like '" + level + "' ";
					} else {
						queryString += " and level like '" + level + "' ";
					}
				}
				if (!"不限".equals(fazheng)) {
					if (first) {
						queryString += "  YEAR(fazhengtime) like '" + fazheng
								+ "' ";
					} else {
						queryString += " and YEAR(fazhengtime) like '"
								+ fazheng + "' ";
					}
				}
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			if (!"不限".equals(age)) {
				List<Object> results = queryObject.list();
				List<Object> ages1 = new ArrayList<Object>();
				List<Object> ages2 = new ArrayList<Object>();
				List<Object> ages3 = new ArrayList<Object>();
				List<Object> ages4 = new ArrayList<Object>();
				List<Object> ages5 = new ArrayList<Object>();
				List<Object> ages6 = new ArrayList<Object>();
				Iterator<Object> iter = results.iterator();
				while (iter.hasNext()) {
					Object[] data = (Object[]) iter.next();
					int a =getAge((Timestamp) data[3]);
					if (a < 20) {
						ages1.add(data);
					} else if (a >= 20 && a < 30) {
						ages2.add(data);
					} else if (a >= 30 && a < 40) {
						ages3.add(data);
					} else if (a >= 40 && a < 50) {
						ages4.add(data);
					} else if (a >= 50 && a < 60) {
						ages5.add(data);
					} else if (a >= 60) {
						ages6.add(data);
					}
				}
				if ("20以下".equals(age)) {
					return ages1;
				} else if ("20-30".equals(age)) {
					return ages2;
				} else if ("30-40".equals(age)) {
					return ages3;
				} else if ("40-50".equals(age)) {
					return ages4;
				} else if ("50-60".equals(age)) {
					return ages5;
				} else if ("60以上".equals(age)) {
					return ages6;
				}
			}
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAllresults() {
		try {
			String queryString = "select user.name,level,totalscore,number from Results";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List shenyanSearch(String name, String level) {
		try {
			boolean flag = "".equals(name) && "无".equals(level);
			String queryString = "select user.name,level,user.picpath,user.gender,user.birthday,user.idnumber,user.phone,user.JPositionProvice.proviceName,user.JPositionCity.cityName,user.JPositionCounty.countyName,user.JPositionTown.townName,user.education,user.prof2.prof1.name,user.prof2.name,id,user.username from Results ";
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
	
	public List idSearch(String username, String level){
		try {
			boolean flag = "".equals(username) && "无".equals(level);
			String queryString = "select id from Results ";
			if (!flag) {
				queryString += "where ";
				boolean first = true;
				if (!"".equals(username)) {
					if (first) {
						queryString += "user.username like '" + username + "'";
					} else {
						queryString += "and user.username like '" + username + "'";
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
}