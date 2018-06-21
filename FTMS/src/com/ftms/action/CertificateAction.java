package com.ftms.action;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.ftms.entity.Certificate;
import com.ftms.service.CertificateService;
import com.opensymphony.xwork2.ActionSupport;

public class CertificateAction extends ActionSupport {
private CertificateService certificateService;
private Certificate certificate;
private int id;
private String username;
private JSONArray certificateJson;
public JSONArray getCertificateJson() {
	return certificateJson;
}
public void setCertificateJson(JSONArray certificateJson) {
	this.certificateJson = certificateJson;
}
public CertificateService getCertificateService() {
	return certificateService;
}
public void setCertificateService(CertificateService certificateService) {
	this.certificateService = certificateService;
}
public Certificate getCertificate() {
	return certificate;
}
public void setCertificate(Certificate certificate) {
	this.certificate = certificate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String saveCertificate(){
	certificateService.addCertificate(username, certificate);
	return "Certificate";
}
public String modifyCertificate(){
	certificateService.modifyCertificate(username, certificate);
	return "Certificate";
}
public String deleteCertificate(){
	certificateService.deleteCertificate(id);
	return "Certificate";
}
public String certificate(){
	JsonConfig jsonConfig= new JsonConfig();
	jsonConfig.setExcludes(new String[]{"user"});
	this.certificateJson=JSONArray.fromObject(certificateService.getCertificate(username),jsonConfig);
	return "certificate";
}
}
