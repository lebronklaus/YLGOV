package com.ftms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.ftms.dao.CertificateDAO;
import com.ftms.dao.UserDAO;
import com.ftms.entity.Certificate;
import com.ftms.entity.User;
import com.ftms.service.CertificateService;

public class CertificateServiceImpl implements CertificateService {
	private CertificateDAO certificateDAO;
	private UserDAO userDAO;

	public CertificateDAO getCertificateDAO() {
		return certificateDAO;
	}

	public void setCertificateDAO(CertificateDAO certificateDAO) {
		this.certificateDAO = certificateDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<Certificate> getCertificate(String username) {
		// TODO Auto-generated method stub
		return new ArrayList<Certificate>(((User) userDAO.findByUsername(
				username).get(0)).getCertificates());
	}

	@Override
	public void addCertificate(String username, Certificate c) {
		// TODO Auto-generated method stub
		c.setUser((User) userDAO.findByUsername(username).get(0));
		certificateDAO.save(c);
	}

	@Override
	public void modifyCertificate(String username, Certificate c) {
		// TODO Auto-generated method stub
		c.setUser((User) userDAO.findByUsername(username).get(0));
		certificateDAO.merge(c);
	}

	@Override
	public void deleteCertificate(int id) {
		// TODO Auto-generated method stub
		certificateDAO.delete(certificateDAO.findById(id));
	}

}
