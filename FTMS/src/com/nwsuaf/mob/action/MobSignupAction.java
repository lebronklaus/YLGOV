package com.nwsuaf.mob.action;


import java.util.List;
import com.nwsuaf.mob.domain.SignupInfo;
import com.nwsuaf.mob.service.MobSignupService;
import com.opensymphony.xwork2.ActionSupport;

public class MobSignupAction extends ActionSupport {
	//ע��Service����
	private MobSignupService mobSignupService;

	public void setMobSignupService(MobSignupService mobSignupService) {
		this.mobSignupService = mobSignupService;
	}
	//������õ�username
	private String username;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//�������json�ַ�
	private List<SignupInfo> list;

	public List<SignupInfo> getList() {
		return list;
	}
	public void setList(List<SignupInfo> list) {
		this.list = list;
	}
	
	/*
	 * ��ȡSignup��Ϣ
	 */
	public String getSignupInfo(){
		list = mobSignupService.searchExam(username);
		return SUCCESS;
	}
}
