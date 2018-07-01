package com.ftms.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/***
 * 
 * @author xiuhao.yan
 *
 */
public class LogoutAction {
	private String ref;
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("mark");
		session.invalidate();
		if(this.ref.equals("user")){
			return "user";
		}else{
			return "admin";
		}
	}

}
