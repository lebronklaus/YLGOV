package com.nwsuaf.mob.action;

import java.util.ArrayList;
import java.util.List;

import com.ftms.entity.Achievement;
import com.ftms.entity.Certificate;
import com.ftms.service.AchievementService;
import com.ftms.service.CertificateService;
import com.nwsuaf.mob.domain.AchCerInfo;
import com.opensymphony.xwork2.ActionSupport;

public class MobAchAndCerAction extends ActionSupport {
	//ע��ҵ�����Service
	private AchievementService achievementService;

	public void setAchievementService(AchievementService achievementService) {
		this.achievementService = achievementService;
	}
	//ע��֤��Service
	private CertificateService certificateService;

	public void setCertificateService(CertificateService certificateService) {
		this.certificateService = certificateService;
	}
	//������õ��û���
	private String username;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//�������json�ַ�
	private List<AchCerInfo> list;
	
	public List<AchCerInfo> getList() {
		return list;
	}
	public void setList(List<AchCerInfo> list) {
		this.list = list;
	}
	/*
	 * ��ȡҵ�������֤��
	 */
	public String getAchAndCer(){
		list = new ArrayList<AchCerInfo>();
		//��ȡҵ��
		List<Achievement> achievement = achievementService.getCertificate(username);
		for (Achievement ach : achievement) {
			list.add(new AchCerInfo("ach", ach.getStart(), ach.getEnd(), ach.getCompletion(), ach.getWiness()));
		}
		//��ȡ֤��
		List<Certificate> certificate = certificateService.getCertificate(username);
		for (Certificate cer : certificate) {
			list.add(new AchCerInfo("cer", cer.getTime(), cer.getMajor(), cer.getCertificatename()));
		}
		return SUCCESS;
	}
	
}
