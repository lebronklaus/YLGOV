package cn.nwsuaf.gov.service;

import java.util.List;

import org.hibernate.HibernateException;

import cn.nwsuaf.gov.model.Train_Resource;

public interface TrainResourceBusiness {

	public void add(String resources_title, String resources_colum,
			String resources_from, String resources_author,
			String resources_profile, String resources_path) throws Exception;

	public void delete(int no) throws Exception;

	public List<Train_Resource> getList() throws Exception;

	public Train_Resource getTrainResource(int no) throws Exception;

	public List<Train_Resource> findByPage(int pageSize, int pageNow)
			throws Exception;

	public List<Train_Resource> findByPageSp(int pageSize, int pageNow)
			throws Exception;

	public List<Train_Resource> findByPageWg(int pageSize, int pageNow)
			throws Exception;

	public List<Train_Resource> findByPageGb(int pageSize, int pageNow)
			throws Exception;

	public int getTotalRows(int pageSize) throws HibernateException, Exception;

	public int getTotalRowsSp(int pageSize) throws HibernateException,
			Exception;

	public int getTotalRowsGb(int pageSize) throws HibernateException,
			Exception;

	public int getTotalRowsWg(int pageSize) throws HibernateException,
			Exception;

}
