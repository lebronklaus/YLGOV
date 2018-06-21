package com.ftms.serviceImpl;

import java.util.List;

import com.ftms.dao.AdminDAO;
import com.ftms.entity.Admin;
import com.ftms.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public boolean adminExist(String adminname) {
		// TODO Auto-generated method stub
		List<Admin> admin = adminDAO.findByAdminname(adminname);
		if (admin.size() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean adminLogin(String adminname, String adminpassword) {
		// TODO Auto-generated method stub
		System.out.println(adminDAO==null);
		if(adminDAO.findByAdminname(adminname).isEmpty()){
			return false;
		}
		Admin admin = (Admin) adminDAO.findByAdminname(adminname).get(0);
		if (admin.getAdminpassword().equals(adminpassword)) {
			return true;
		}
		return false;
	}

	@Override
	public void adminUpdate(String adminname, String adminpassword) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) adminDAO.findByAdminname(adminname).get(0);
		admin.setAdminpassword(adminpassword);
		adminDAO.merge(admin);
	}

}
