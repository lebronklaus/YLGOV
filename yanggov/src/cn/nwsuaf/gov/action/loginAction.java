package cn.nwsuaf.gov.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.nwsuaf.gov.DAO.nongminUserDAO;
import cn.nwsuaf.gov.DAO.qiyeUserDAO;
import cn.nwsuaf.gov.bean.nongminUser;
import cn.nwsuaf.gov.bean.qiyeUser;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
	// private yuanquUser yuanquUser;
	private nongminUser nongminUser;
	private qiyeUser qiyeuser;

	private qiyeUser yuanquUser;

	public qiyeUser getYuanquUser() {
		return yuanquUser;
	}

	public void setYuanquUser(qiyeUser yuanquUser) {
		this.yuanquUser = yuanquUser;
	}

	public qiyeUser getQiyeuser() {
		return qiyeuser;
	}

	public void setQiyeuser(qiyeUser qiyeuser) {
		this.qiyeuser = qiyeuser;
	}

	/*
	 * public yuanquUser getYuanquUser() { return yuanquUser; } public void
	 * setYuanquUser(yuanquUser yuanquUser) { this.yuanquUser = yuanquUser; }
	 */

	public nongminUser getNongminUser() {
		return nongminUser;
	}

	public void setNongminUser(nongminUser nongminUser) {
		this.nongminUser = nongminUser;
	}

	public String faxuqiu() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("username") == null
				|| session.getAttribute("username").equals("")) {
			return LOGIN;
		} else {
			return SUCCESS;
		}

	}

	public String login() {
		System.out.println("login.....");
		HttpSession session = ServletActionContext.getRequest().getSession();
		String identity = ServletActionContext.getRequest().getParameter(
				"identity");
		System.out.println("idenj____-------" + identity);
		String id = ServletActionContext.getRequest().getParameter("id");
		System.out.println(id);
		String password = ServletActionContext.getRequest().getParameter(
				"password");
		if (identity.equals("yuanqu")) {
			/*
			 * yuanquUserDAO yuanquUserDAO = new yuanquUserDAO(); yuanquUser
			 * yuanquUser_temp = yuanquUserDAO.findByUser(id);
			 * if(password.equals(yuanquUser_temp.getPassword())){
			 * setYuanquUser(yuanquUser_temp); session.setAttribute("mark", 1);
			 * return SUCCESS; }else{ return LOGIN; }
			 */
			qiyeUserDAO qiyeuserdao = new qiyeUserDAO();
			qiyeUser qiyeuser_temp = qiyeuserdao.findByUser(id);
			if (password.equals(qiyeuser_temp.getPassword())) {
				setYuanquUser(qiyeuser_temp);
				session.setAttribute("mark", 1);
				return SUCCESS;
			} else {
				return LOGIN;
			}

		} else {
			if (identity.equals("nongmin")) {
				nongminUserDAO nongminUserDAO = new nongminUserDAO();
				nongminUser nongminUser_temp = nongminUserDAO.findByUser(id);
				System.out.println(nongminUser_temp.getPassword());
				if (password.equals(nongminUser_temp.getPassword())) {
					setNongminUser(nongminUser_temp);
					session.setAttribute("mark", 0);
					return SUCCESS;
				} else {
					return LOGIN;
				}
			} else {
				qiyeUserDAO qiyeuserdao = new qiyeUserDAO();
				qiyeUser qiyeuser_temp = qiyeuserdao.findByUser(id);
				System.out.println(qiyeuser_temp.getUsername());
				if (password.equals(qiyeuser_temp.getPassword())) {
					setQiyeuser(qiyeuser_temp);
					session.setAttribute("mark", 2);
					return SUCCESS;
				} else {
					return LOGIN;
				}
			}
		}

	}

	public String regist() {
		String identity = ServletActionContext.getRequest().getParameter(
				"identity");
		String username = ServletActionContext.getRequest().getParameter(
				"username");
		String password = ServletActionContext.getRequest().getParameter(
				"password");

		if (identity.equals("yuanqu")) {
			/*
			 * yuanquUserDAO yuanquUserDAO = new yuanquUserDAO(); yuanquUser yq
			 * = new yuanquUser(); yq.setUsername(username);
			 * yq.setPassword(password); yuanquUserDAO.addUser(yq);
			 */
			qiyeUserDAO qiyeuserdao = new qiyeUserDAO();
			qiyeUser yq = new qiyeUser();
			yq.setUsername(username);
			yq.setPassword(password);
			qiyeuserdao.addUser(yq);
		} else {
			qiyeUserDAO qiyeuserdao = new qiyeUserDAO();
			qiyeUser qy = new qiyeUser();
			qy.setUsername(username);
			qy.setPassword(password);
			qiyeuserdao.addUser(qy);
		}

		return SUCCESS;
	}

	public String quit() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("username");
		return SUCCESS;
	}
}
