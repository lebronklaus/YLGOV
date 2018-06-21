package com.ftms.service;

import java.util.List;

import com.ftms.entity.Certificate;

public interface CertificateService {
	public List<Certificate> getCertificate(String username);
	public void addCertificate(String username,Certificate c);
	public void modifyCertificate(String username,Certificate c);
	public void deleteCertificate(int id);
}
