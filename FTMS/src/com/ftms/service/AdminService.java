package com.ftms.service;

public interface AdminService {
	public boolean adminExist(String adminname);
	public boolean adminLogin(String adminname,String adminpassword);
	public void adminUpdate(String adminname,String adminpassword);
}