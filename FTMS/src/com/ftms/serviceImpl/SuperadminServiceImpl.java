package com.ftms.serviceImpl;

import java.util.List;

import com.ftms.dao.AdminDAO;
import com.ftms.dao.SuperadminDAO;
import com.ftms.entity.Admin;
import com.ftms.entity.Superadmin;
import com.ftms.service.SuperadminService;

public class SuperadminServiceImpl implements SuperadminService {

	private AdminDAO adminDAO;
	private SuperadminDAO superadminDAO;
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}


	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	public SuperadminDAO getSuperadminDAO() {
		return superadminDAO;
	}


	public void setSuperadminDAO(SuperadminDAO superadminDAO) {
		this.superadminDAO = superadminDAO;
	}


	@Override
	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Admin admin=adminDAO.findById(id);
		adminDAO.delete(admin);
		return true;
	}


	@Override
	public Admin searchAdmin(String adminname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminDAO.findAll();
	}

	@Override
	public boolean updateSuperadmin(String superadmin,String password) {
		// TODO Auto-generated method stub
		Superadmin sadmin=(Superadmin) superadminDAO.findBySupername(superadmin).get(0);
		sadmin.setSuperpassword(password);
		superadminDAO.merge(sadmin);
		return true;
	}


	@Override
	public boolean mergeAdmin(String adminname,String adminpassword) {
		// TODO Auto-generated method stub
		Admin ad;
		if(adminDAO.findByAdminname(adminname).isEmpty()){
			ad=new Admin();
			ad.setAdminpassword(adminpassword);
			ad.setAdminname(adminname);
		}else{
			ad=(Admin) adminDAO.findByAdminname(adminname).get(0);
			ad.setAdminpassword(adminpassword);
			ad.setAdminname(adminname);

		}
		adminDAO.merge(ad);
		return false;
	}


	@Override
	public boolean superLogin(String adminname, String adminpassword) {
		// TODO Auto-generated method stub
		if(superadminDAO.findBySupername(adminname).isEmpty()){
			return false;
		}
		Superadmin admin = (Superadmin) superadminDAO.findBySupername(adminname).get(0);
		if (admin.getSuperpassword().equals(adminpassword)) {
			return true;
		}
		return false;
	}

}
