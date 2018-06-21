package com.lee.action;

import org.hibernate.HibernateException;

import com.lee.mode.User;
import com.lee.service.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private User user;
	private String point;

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String Login() throws Exception {
		System.out.println("+++++++++++++==============wangke");
		UserDAO userdao = new UserDAO();
		System.out.println("-------------------------------->hhhh");
		User pass = userdao.passw(user.getUsername());

		if (user.getPassword().equals(pass.getPassword())) {
			System.out.println("fgfgdfg");
			return "success";
		} else
			return "error";
	}

	public String registfind() throws HibernateException, Exception {
		UserDAO userdao = new UserDAO();
		User user1 = userdao.passw(user.getUsername());
		System.out.println("hsadus:" + user.username);
		System.out.println("hsadus:" + user.password);

		if (user1 != null) {
			setPoint("�û����Ѵ��ڣ�");
			return ERROR;
		} else {
			userdao.usew(user);

			return SUCCESS;
		}
	}

}
