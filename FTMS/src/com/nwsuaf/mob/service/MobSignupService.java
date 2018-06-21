package com.nwsuaf.mob.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nwsuaf.mob.dao.MobSignupDao;
import com.nwsuaf.mob.domain.SignupInfo;
@Transactional
public class MobSignupService {
	//ע��ExamDAO����
	private MobSignupDao mobSignupDao;

	public void setMobSignupDao(MobSignupDao mobSignupDao) {
		this.mobSignupDao = mobSignupDao;
	}


	/*
	 * ��ѯexam��Ϣ
	 */
	public List<SignupInfo> searchExam(String idnumber) {
		List<SignupInfo> signup = mobSignupDao.getSignupInfo(idnumber);
		
		return signup;
	}
}
