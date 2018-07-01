package com.interceptor;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;
/***
 * 
 * @author xiuhao.yan
 *
 */
public class AdminLoginInterceptor extends MethodFilterInterceptor {
	
	@Override
	protected String doIntercept(ActionInvocation actionInvocation)throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Object obj = null;
		HttpSession session = request.getSession(false);
		if(session != null){
			obj = session.getAttribute("mark");
		}
		if(obj != null){
			if(((Integer)obj) == -1)
				return actionInvocation.invoke();
		}
		return "false";
	}
}
