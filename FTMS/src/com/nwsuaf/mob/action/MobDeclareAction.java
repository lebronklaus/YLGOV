package com.nwsuaf.mob.action;

import java.util.List;

import com.nwsuaf.mob.domain.DeclareInfo;
import com.nwsuaf.mob.service.MobDeclareService;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ����ѯ
 */
public class MobDeclareAction extends ActionSupport {
	/*
	 * ע��web���resultsService
	 */
	private MobDeclareService mobDeclareService;

	public void setMobDeclareService(MobDeclareService mobDeclareService) {
		this.mobDeclareService = mobDeclareService;
	}
	/*
	 * ����ת��json�ַ�
	 */
	private List<DeclareInfo> list;
	
	public List<DeclareInfo> getList() {
		return list;
	}
	public void setList(List<DeclareInfo> list) {
		this.list = list;
	}
	/*
	 * ������
	 */
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * �����û����ѯ֤����Ϣ
	 */
	public String getUserResult() {
		list = mobDeclareService.getUserResult(username, "农技员");
		list.addAll(mobDeclareService.getUserResult(username, "农技师"));
		list.addAll(mobDeclareService.getUserResult(username, "高级农技师"));
		return SUCCESS;
	}
	
}
