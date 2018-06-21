package com.nwsuaf.mob.action;

import com.ftms.entity.User;
import com.ftms.service.UserService;
import com.nwsuaf.mob.domain.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

public class MobUserAction extends ActionSupport {
	/*
	 * ʹ��web�汾�е�service
	 */
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/*
	 * ������
	 */
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/*
	 * ��ѯ�û���Ϣ����json�ַ�
	 */
	private UserInfo userinfo = new UserInfo();
	
	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	/*
	 * ���ڷ���json�ַ�
	 */
	private String successinfo="Login success";
	private String errorinfo="Login error";
	

	public String getSuccessinfo() {
		return successinfo;
	}

	public void setSuccessinfo(String successinfo) {
		this.successinfo = successinfo;
	}

	public String getErrorinfo() {
		return errorinfo;
	}

	public void setErrorinfo(String errorinfo) {
		this.errorinfo = errorinfo;
	}

	/*
	 * ��¼
	 */
	public String login(){
		if(username.isEmpty()||password.isEmpty())
			return "error";
		if(userService.userLogin(username, password))
			return "login";
		return "error";
	}
	/*
	 * �û���Ϣ
	 */
	public String getUserInfo(){
		User user = userService.getUserInfo(username);
		userinfo.setName(user.getName());
		userinfo.setGender(user.getGender());
		userinfo.setBirthday(user.getBirthday().toString().split(" ")[0]);
		userinfo.setAddress(user.getJPositionProvice().getProviceName()+user.getJPositionCity().getCityName()+user.getJPositionCounty().getCountyName()+user.getJPositionTown().getTownName());
		userinfo.setIdnumber(user.getIdnumber());
		userinfo.setPhone(user.getPhone());
		userinfo.setEducation(user.getEducation());
		userinfo.setProf(user.getProf2().getName());
		return SUCCESS;
	}
}
