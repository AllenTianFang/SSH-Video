package com.zhiyou100.ssh_video.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhiyou100.ssh_video.model.Admin;

public class AdminInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String str = null;
		Admin admin = (Admin) ActionContext.getContext().getSession().get("admin");
		if(admin != null){
			str = invocation.invoke();
		}else{
			str = "index";
		}
		return str;
	}
	
	

}
