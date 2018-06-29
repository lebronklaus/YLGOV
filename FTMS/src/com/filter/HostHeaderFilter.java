package com.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftms.service.AdminService;
import com.ftms.service.SuperadminService;
import com.ftms.serviceImpl.AdminServiceImpl;
import com.ftms.serviceImpl.SuperadminServiceImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class HostHeaderFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		String adminname=request.getParameter("adminname");
		String username=request.getParameter("username");			
		String myhost=request.getHeader("host");
		BufferedReader bReader=new BufferedReader(new FileReader("D://Documents//Desktop//git//YLGOV//db.xml"));
		//db.xml文件要放在tomacat以外的相对路径下，方便管理人员管理IP地址，这样就不用修改代码了
		String lineString=null;
		while((lineString=bReader.readLine())!=null){
			if(!myhost.equals(lineString)&&(adminname!=null)){//如果host不是,管理员登录则退回到管理员界面，用户登录则退回到用户界面
				arg0.getRequestDispatcher("pages/login/adminlogin.jsp").forward(arg0, response);
			}else if(!myhost.equals(lineString)&&(username!=null)){
				arg0.getRequestDispatcher("pages/login/userlogin.jsp").forward(arg0, response);
			}else{
				arg2.doFilter(arg0, arg1);
				break;
			}
		}
		bReader.close();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
