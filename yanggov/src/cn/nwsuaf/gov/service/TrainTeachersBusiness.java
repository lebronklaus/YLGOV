package cn.nwsuaf.gov.service;

import java.util.List;

import org.hibernate.HibernateException;

import cn.nwsuaf.gov.model.Train_Teachers;

public interface TrainTeachersBusiness {
	public void add(String teacher_name, String teacher_sex,
			String teacher_workplace, String teacher_inwork,
			String teacher_university, String teacher_major,
			String teacher_professional, String teacher_address,
			String teacher_email, String teacher_profile,
			String teacher_phonenum, String teacher_path) throws Exception;

	public void delete(int no) throws Exception;

	public List<Train_Teachers> getList() throws Exception;

	public Train_Teachers getTrainTeacher(int no) throws Exception;

	public List<Train_Teachers> findByPage(int pageSize, int pageNow)
			throws Exception;

	public int getTotalRows(int pageSize) throws HibernateException, Exception;
}
