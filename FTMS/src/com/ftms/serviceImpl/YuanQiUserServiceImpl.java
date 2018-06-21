package com.ftms.serviceImpl;

import java.util.List;
import com.ftms.dao.YuanQiUserDAO;
import com.ftms.entity.YuanQiUser;

public class YuanQiUserServiceImpl {
	private YuanQiUserDAO yuanqiuserdao;

	public YuanQiUserDAO getYuanqiuserdao() {
		return yuanqiuserdao;
	}

	public void setYuanqiuserdao(YuanQiUserDAO yuanqiuserdao) {
		this.yuanqiuserdao = yuanqiuserdao;
	}

	public boolean YuanQiUserlogin(String username,String password){
		if(yuanqiuserdao.findByUsername(username).isEmpty()){
			return false;
		}
		YuanQiUser yqu = (YuanQiUser)yuanqiuserdao.findByUsername(username).get(0);
		if(yqu.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	
	public YuanQiUser getYuanQiUserInfo(String username){
		return (YuanQiUser)((yuanqiuserdao.findByUsername(username)).get(0));
	}
	
	public void register(YuanQiUser yqu){
		yuanqiuserdao.save(yqu);
	}
	
	public boolean yuanqiuserExist(String username){
		List<YuanQiUser> list = yuanqiuserdao.findByUsername(username);
		if(list.size()==1){
			return true;
		}else{
			return false;
		}
			
	}
	/**
	 * 重置密码
	 * @param username
	 */
	public void passwordReset(String username) {
		// TODO Auto-generated method stub
		String password="123";
		YuanQiUser yqu=(YuanQiUser) yuanqiuserdao.findByUsername(username).get(0);
		yqu.setPassword(password);
		yuanqiuserdao.merge(yqu);
	}
}
