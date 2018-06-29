package com.ftms.service;

import net.sf.json.JSONArray;

import com.ftms.entity.User;

public interface UserService {
	public boolean userExist(String username);
	public boolean userLogin(String username,String password);
	public void register(User u);
	public User getUserInfo(String username);
	public void modifyUserInfo(User u);
	public void modifyUserInfoManage(User u);
	public void deleteUser(int id);
	public void passwordReset(String username);
	public JSONArray searchUser(String name);
	
	//by xiuhao.yan
	public String queryPsd(String username);
	public boolean resetPsd(String username);
	public boolean resetAllPsd();
}
