package com.ftms.serviceImpl;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ftms.dao.UserDAO;
import com.ftms.entity.Admin;
import com.ftms.entity.User;
import com.ftms.service.UserService;

import com.util.Base64Tool;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	private YuanQiUserServiceImpl yuanqiuserService;
	
	public YuanQiUserServiceImpl getYuanqiuserService() {
		return yuanqiuserService;
	}

	public void setYuanqiuserService(YuanQiUserServiceImpl yuanqiuserService) {
		this.yuanqiuserService = yuanqiuserService;
	}
	

	@Override
	public boolean userExist(String username) {
		// TODO Auto-generated method stub
		List<User> user = userDAO.findByUsername(username);
		if (user.size() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userLogin(String username, String password) {
		// TODO Auto-generated method stub
		if(userDAO.findByUsername(username).isEmpty()){
			return false;
		}
		User user = (User) userDAO.findByUsername(username).get(0);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		userDAO.save(u);
	}

	@Override
	public User getUserInfo(String username) {
		// TODO Auto-generated method stub
		return (User) userDAO.findByUsername(username).get(0);
	}

	@Override
	public void modifyUserInfoManage(User u) {
		// TODO Auto-generated method stub
		u.setId(((User)userDAO.findByUsername(u.getUsername()).get(0)).getId());
		u.setPicpath(((User)userDAO.findByUsername(u.getUsername()).get(0)).getPicpath());
		userDAO.merge(u);
	}
	@Override
	public void modifyUserInfo(User u) {
		// TODO Auto-generated method stub
		u.setId(((User)userDAO.findByUsername(u.getUsername()).get(0)).getId());
		userDAO.merge(u);
	}
	/**
	 * @author Zhitao.Chen
	 * 园企用户重置密码
	 */
	@Override
	public void passwordReset(String username) {
		// TODO Auto-generated method stub
		String password="123";
		List list = userDAO.findByUsername(username);
		if(list.size()<1){
			yuanqiuserService.passwordReset(username);
		}else{
			User u=(User) userDAO.findByUsername(username).get(0);
			System.out.println(u+"+++++++++++++++++++password");
			u.setPassword(password);
			userDAO.merge(u);
		}
		
		
	}
	
	

	@Override
	public JSONArray searchUser(String name) {
		//return JSONArray.fromObject(userDAO.searchUser(name));
		List re = userDAO.searchUser(name);

		JSONArray json = new JSONArray();
		JSONObject jo = null;
		Iterator iter = re.iterator();
		while (iter.hasNext()) {
			Object[] data = (Object[]) iter.next();
			jo = new JSONObject();
			jo.put("name", data[0]);
			jo.put("picpath", data[1]);
			jo.put("gender", data[2]);
			jo.put("birthday", data[3]);
			jo.put("idnumber", data[4]);
			jo.put("phone", data[5]);
			jo.put("proviceName", data[6]);
			jo.put("cityName", data[7]);
			jo.put("countyName", data[8]);
			jo.put("townName", data[9]);
			jo.put("education", data[10]);
			jo.put("prof1name", data[11]);
			jo.put("prof2name", data[12]);
			jo.put("id", data[13]);
			jo.put("username", data[14]);
			jo.put("password", data[15]);
			json.add(jo);
		}
		return json;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User u =userDAO.findById(id);
		userDAO.delete(u);
	}
	
	
	//follow 3 by xiuhao.yan
		@Override
		public String queryPsd(String username){
			String psd;
			try{
				psd = ((User) userDAO.findByUsername(username).get(0)).getPassword();
				return psd;
				//return Base64Tool.base64decode(psd);
			}catch (Exception e){
				e.printStackTrace();
				return "false";
			}
		}
		@Override
		public boolean resetPsd(String username){
			String IDNum;
			String psd;
			try{
				User user = (User) userDAO.findByUsername(username).get(0);
				IDNum = user.getUsername();
				if(IDNum.length()>6){
					psd = IDNum.substring(IDNum.length()-6, IDNum.length());
				}else{
					psd = "123456";
				}
				user.setPassword(Base64Tool.base64encode(psd));
				userDAO.merge(user);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return false;
		}
		@Override
		public boolean resetAllPsd(){
			try{
				List<User> users = userDAO.findAll();
				for (User user: users) {
					String IDNum=user.getIdnumber();
					String psd;
					if(IDNum.length()>6){
						psd = IDNum.substring(IDNum.length()-6, IDNum.length());
					}else{
						psd = "123456";
					}
					
					user.setPassword(Base64Tool.base64encode(psd));
					userDAO.merge(user);
				}
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}

}
