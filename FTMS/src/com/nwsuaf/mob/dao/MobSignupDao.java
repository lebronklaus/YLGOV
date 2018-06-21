package com.nwsuaf.mob.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.ftms.entity.Exam;
import com.nwsuaf.mob.domain.SignupInfo;
/*
 * �ֻ�˱�����Ϣ
 */
public class MobSignupDao{
	//ע��sessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<SignupInfo> getSignupInfo(String username){
		List<SignupInfo> list = new ArrayList<SignupInfo>();
		
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Exam.class);
		String sql = "from exam where idnumber = ?";
		List<Exam> find = criteria.add(Restrictions.eq("idnumber", username)).list();
		System.out.println("---------------------------------------------------------");
		System.out.println(find);
		for (Exam exam : find) {
			String myaddress = exam.getJPositionProvice().getProviceName()+exam.getJPositionCity().getCityName()+exam.getJPositionCounty().getCountyName()+exam.getJPositionTown().getTownName();
			list.add(new SignupInfo(exam.getName(), exam.getGender(), exam
					.getBirthday().toString().split(" ")[0], myaddress,
					exam.getIdnumber(), exam.getPhone(), exam.getEducation(), exam.getProf2().getName(), exam.getLevel(), exam.getTime()+"", exam.getAddress(), exam.getStatus()));
		}
		return list;
	}
}
