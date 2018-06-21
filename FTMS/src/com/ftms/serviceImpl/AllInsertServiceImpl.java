package com.ftms.serviceImpl;

import java.util.Calendar;
import java.util.List;

import com.ftms.dao.AchievementDAO;
import com.ftms.dao.AddressDAO;
import com.ftms.dao.CertificateDAO;
import com.ftms.dao.ExamDAO;
import com.ftms.dao.ResultsDAO;
import com.ftms.dao.ShenyanDAO;
import com.ftms.dao.UserDAO;
import com.ftms.entity.Achievement;
import com.ftms.entity.Certificate;
import com.ftms.entity.Exam;
import com.ftms.entity.Results;
import com.ftms.entity.Shenyan;
import com.ftms.entity.User;
import com.ftms.service.AllInsertService;

public class AllInsertServiceImpl implements AllInsertService {
	private UserDAO userDAO;
	private AchievementDAO achievementDAO;
	private ResultsDAO resultsDAO;
	private ShenyanDAO shenyanDAO;
	private ExamDAO examDAO;
	private CertificateDAO certificateDAO;
	private AddressDAO addressDAO;
	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public AchievementDAO getAchievementDAO() {
		return achievementDAO;
	}

	public void setAchievementDAO(AchievementDAO achievementDAO) {
		this.achievementDAO = achievementDAO;
	}

	public ResultsDAO getResultsDAO() {
		return resultsDAO;
	}

	public void setResultsDAO(ResultsDAO resultsDAO) {
		this.resultsDAO = resultsDAO;
	}


	public ShenyanDAO getShenyanDAO() {
		return shenyanDAO;
	}

	public void setShenyanDAO(ShenyanDAO shenyanDAO) {
		this.shenyanDAO = shenyanDAO;
	}

	public ExamDAO getExamDAO() {
		return examDAO;
	}

	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}

	public CertificateDAO getCertificateDAO() {
		return certificateDAO;
	}

	public void setCertificateDAO(CertificateDAO certificateDAO) {
		this.certificateDAO = certificateDAO;
	}

	@Override
	public boolean userExist(String username) {
		List<User> user = userDAO.findByUsername(username);
		System.out.println(user.size());
		if (user.size() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public void register(User u) {
		List<User> user = userDAO.findByUsername(u.getUsername());
		if(user.size()>0){
			u.setId(user.get(0).getId());
			userDAO.merge(u);
		}else{
			userDAO.save(u);
		}
	}

	@Override
	public void updateExam(String username, Exam exam) {
		User u = (User) userDAO.findByUsername(username).get(0);
		String name=u.getName();
		String level=exam.getLevel();
		List<Exam> ee=examDAO.updateExam(name, 0, level, "��", "��");
		if(ee.isEmpty()){
			exam.setName(u.getName());
			exam.setGender(u.getGender());
			exam.setBirthday(u.getBirthday());
			exam.setPhone(u.getPhone());
			exam.setIdnumber(u.getIdnumber());
			exam.setJPositionProvice(u.getJPositionProvice());
			exam.setJPositionCity(u.getJPositionCity());
			exam.setJPositionCounty(u.getJPositionCounty());
			exam.setJPositionTown(u.getJPositionTown());
			exam.setEducation(u.getEducation());
			exam.setProf2(u.getProf2());
			exam.setPicpath(u.getPicpath());
			examDAO.save(exam);
		}else{
			Exam e=ee.get(0);
			e.setAddress(exam.getAddress());
			e.setTime(exam.getTime());
			e.setGender(u.getGender());
			e.setBirthday(u.getBirthday());
			e.setPhone(u.getPhone());
			e.setIdnumber(u.getIdnumber());
			e.setJPositionProvice(u.getJPositionProvice());
			e.setJPositionCity(u.getJPositionCity());
			e.setJPositionCounty(u.getJPositionCounty());
			e.setJPositionTown(u.getJPositionTown());
			e.setEducation(u.getEducation());
			e.setPicpath(u.getPicpath());
			e.setProf2(u.getProf2());
			e.setStatus(exam.getStatus());
			examDAO.merge(e);
		}
		
	}

	@Override
	public void SaveResult(String username, Results r) {
		r.setUser((User) userDAO.findByUsername(username).get(0));
		List rr= resultsDAO.idSearch(username, r.getLevel());
		if(rr.isEmpty()){
			resultsDAO.save(r);
		}else{
			Results res=resultsDAO.findById((int)rr.get(0));
			System.out.println("fffffffffffffffffffffffffffffffffffffffffff");
			System.out.println(rr.get(0));
			res.setAchievement(r.getAchievement());
			res.setApproval(r.getApproval());
			res.setChecktime(r.getChecktime());
			res.setFazhengtime(r.getFazhengtime());
			res.setInterviewscore(r.getInterviewscore());
			res.setNumber(r.getNumber());
			res.setOpposition(r.getOpposition());
			res.setCanjia(r.getCanjia());
			res.setTotal(r.getTotal());
			res.setTotalscore(r.getTotalscore());
			res.setWritescore(r.getWritescore());
			resultsDAO.merge(res);
		}
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		Shenyan c = new Shenyan();
		c.setUser((User) userDAO.findByUsername(username).get(0));
		c.setLevel(r.getLevel());
		c.setStatus("��");
		c.setYear(year);
		shenyanDAO.save(c);

	}

	@Override
	public void addCertificate(String username, Certificate c) {
		c.setUser((User) userDAO.findByUsername(username).get(0));
		certificateDAO.merge(c);
	}

	@Override
	public void addAchievement(String username, Achievement a) {
		a.setUser((User) userDAO.findByUsername(username).get(0));
		achievementDAO.merge(a);
	}

	@Override
	public void check(String username, Shenyan c) {
		// TODO Auto-generated method stub
		c.setUser((User) userDAO.findByUsername(username).get(0));
		shenyanDAO.merge(c);
	}


}
