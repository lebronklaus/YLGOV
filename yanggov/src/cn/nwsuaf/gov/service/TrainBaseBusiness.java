package cn.nwsuaf.gov.service;

import java.util.List;

import org.hibernate.HibernateException;

import cn.nwsuaf.gov.model.Train_Base;

public interface TrainBaseBusiness {
	public void add(String base_name, String base_profile, String base_contact,
			String base_path1, String base_path2) throws Exception;

	public void delete(int no) throws Exception;

	public List<Train_Base> getList() throws Exception;

	public Train_Base getTrainBase(int no) throws Exception;

	public List<Train_Base> findByPage(int pageSize, int pageNow)
			throws Exception;

	public int getTotalRows(int pageSize) throws HibernateException, Exception;
}
