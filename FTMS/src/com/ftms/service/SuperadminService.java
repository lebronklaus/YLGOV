package com.ftms.service;

import java.util.List;

import com.ftms.entity.Admin;

public interface SuperadminService {
public boolean mergeAdmin(String adminname,String adminpassword);
public boolean deleteAdmin(int id);
public Admin searchAdmin(String adminname);
public List<Admin> findAll();
public boolean updateSuperadmin(String superadmin,String password);
public boolean superLogin(String adminname,String adminpassword);
}
